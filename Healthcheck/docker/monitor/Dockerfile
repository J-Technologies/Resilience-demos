FROM sillenttroll/wildfly-java-8
MAINTAINER Robbert vd Zon <robbert@vdzon.com>

RUN /opt/wildfly/bin/add-user.sh admin admin --silent
USER root

# for mysql client
RUN apt-get update && \
    apt-get -y install 


RUN mkdir /data
COPY *.war /data/
COPY config.sh /data/config.sh
RUN chmod a+x /data/config.sh

EXPOSE 8787
EXPOSE 8080
EXPOSE 9990

CMD ["/data/config.sh"]