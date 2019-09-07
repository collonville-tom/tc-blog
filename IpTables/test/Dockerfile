FROM alpine:latest
RUN apk add iptables
RUN echo "nc -l -p $listenport"
CMD /bin/sh -c "nc -l -p $listenport"
