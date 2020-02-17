FROM alpine:latest
RUN apk add iptables
#CMD /bin/sh -c 'while sleep 3600; do :; done'
RUN echo "nc -l -p 5555"
CMD /bin/sh -c "nc -l -p 5555"
