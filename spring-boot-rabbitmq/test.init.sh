#!/bin/sh

USER=$RABBITMQ_USERNAME
PWD=$RABBITMQ_PASSWORD
RMQ_HOST=rabbitmq


waiting_rabbitmq_started()
{
  local state="nok"
  while [ "$state" != "ok" ]
  do
    echo "http://$USER:$PWD@$RMQ_HOST:15672/api/healthchecks/node"
    state=$(expr $(curl -G "http://$USER:$PWD@$RMQ_HOST:15672/api/healthchecks/node") : ".*:.\(..\).*")
    echo "$state"
    sleep 1s
  done
}

config_flux()
{
    local exchange_name=$1
    local queue_name=$2
    local exchange_type=$3 
    local args=""
    if [ "$4" != "" ]
    then 
      args="routing_key=$4"
    fi
    echo "Declare exchange $exchange_name with type=$exchange_type and queue $queue_name with $args"
    rabbitmqadmin declare exchange --host=$RMQ_HOST -u $USER -p $PWD name=$exchange_name durable=true type=$exchange_type
    rabbitmqadmin declare queue --host=$RMQ_HOST -u $USER -p $PWD name=$queue_name durable=true 
    rabbitmqadmin declare binding --host=$RMQ_HOST -u $USER -p $PWD source=$exchange_name destination=$queue_name $args
}

waiting_rabbitmq_started

config_flux  "myExchangeA" "myQueueA" "direct" "flux1"
config_flux  "myExchangeA" "myQueueB" "direct" "flux2"

config_flux  "myExchangeB" "myQueueA" "topic" "flux1.*"
config_flux  "myExchangeB" "myQueueB" "topic" "*.flux2"