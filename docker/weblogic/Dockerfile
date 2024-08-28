FROM finvmharborp01.finbel.intra/trv-weblogic/ccff-wl12-2-light:21-10-11.1633952626
MAINTAINER Centran SPRL

ENV CCFF_START_MODE="DEV"

#JMS modules
ADD ./config/jms/RecJMSModule.xml /tmp/recoverymodule-jms.xml
RUN /helpers/cold/add-jms-module.sh \
    --NAME=RecJMSModule \
    --XML_FILE_PATH=/tmp/recoverymodule-jms.xml \
    --SUBDEPLOYMENT_NAME=all.deployment \
    --SECOND_SUBDEPLOYMENT_NAME=recovery.deployment

#Ensure we have last CCFF truststore
RUN /helpers/cold/install-truststore.sh

#Add file containing Weblogic users and groups
ADD ./config/users/users.properties /tmp/users.properties

#Configure LOGGERS
ADD ./config/logger/insert_logger_configuration.sql /tmp/insert_logger_configuration.sql
RUN /helpers/hot/run-h2-script.sh /tmp/insert_logger_configuration.sql

RUN chmod 777 -R /weblogic/*

#Create Weblogic users and groups and start weblogic
CMD /helpers/hot/add-user.sh --FILE=/tmp/users.properties & /helpers/cold/start-weblogic.sh