FROM glassfish:4.1

COPY hystrixdemo.war /usr/local/glassfish4/glassfish/domains/domain1/autodeploy/
COPY domain.xml /usr/local/glassfish4/glassfish/domains/domain1/config/
CMD  asadmin start-domain --verbose