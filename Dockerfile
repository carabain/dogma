FROM payara/micro


USER root
RUN apk update
RUN apk add geth

COPY dogma-web/target/dogma-web-1.0.0-SNAPSHOT.war /opt/payara/deployments
