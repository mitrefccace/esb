![](./images/adsmall.png)

# SERVICE BROKER

Why did we introduce an ESB? One reason: to provide a generic method to update legacy database systems as well as a way to update the diverse number of databases and unstructured data repositories on the market and in use today. 

# Background

Apache ServiceMix 6.1.2 is used as the service broker.  

Apache ServiceMix is an enterprise-class open-source distributed enterprise service bus (ESB) based on the service-oriented architecture (SOA) model. It is a project of the Apache Software Foundation and was built on the semantics and application programming interfaces of the Java Business Integration (JBI) specification JSR 208. The software is distributed under the Apache License.

The productized and supported release of ServiceMix 4 is from Red Hat JBoss and called JBoss Fuse ESB. Fabric8 is a free Apache 2.0 Licensed upstream community for the JBoss Fuse product from Red Hat.

The current version of ServiceMix fully supports the OSGi framework. ServiceMix is lightweight and easily embeddable, has integrated Spring Framework support and can be run at the edge of the network (inside a client or server), as a standalone ESB provider or as a service within another ESB. ServiceMix is compatible with Java SE or a Java EE application server. ServiceMix uses ActiveMQ to provide remoting, clustering, reliability and distributed failover. The basic frameworks used by ServiceMix are Spring and XBean.
ServiceMix is composed the latest versions of Apache ActiveMQ, Apache Camel, Apache CXF, and Apache Karaf.

Additional installation features include:
* BPM engine via Activiti
* JPA support via Apache OpenJPA
* XA transaction management via JTA via Apache Aries

ServiceMix is an enterprise service bus that provides:
* Federation, clustering and container provided failover
* Hot deployment and lifecycle management of business objects
* Vendor independence from vendor-licensed products
* Compliance with the JBI specification JSR 208
* Compliance with the OSGi 4.2 specification through Apache Felix
* Support for OSGi Enterprise through Apache Aries

# Installation Overview
Before you can start working with Apache ServiceMix, you have to get ServiceMix and its prerequisites installed and running on the host machine. 

## ServiceMix system requirements
For running Apache ServiceMix itself, you'll need
* Java Runtime Environment (JRE) 1.7.x (Java 7) or
* Java Runtime Environment (JRE) 1.8.x (Java 8)
* About 100 MB of free disk space for the default assembly

If you're developing your own integration applications and OSGi bundles, you'll also need
* Java Developer Kit (JDK) 1.7.x (Java 7) or
* Java Developer Kit (JDK) 1.8.x (Java 8)
* MySQL
* Apache Maven 3.0.4 or higher

The ACRDEMO broker application also depends on MySQL for a database and Maven for building the application. 

## Installing the JDK
Issue the following commands to install the Java 8 JDK:
~~~~
sudo apt-add-repository ppa:webupd8team/java
sudo apt-get update
sudo apt-get install oracle-java8-installer
~~~~
Set the JAVA_HOME environment variable in the bash startup.
~~~~
vi ~/.bashrc
~~~~
Add the following lines to the end of the .bashrc script
~~~~
JAVA_HOME=/usr/lib/jvm/java-8-oracle/
export JAVA_HOME
PATH=$PATH:$JAVA_HOME/bin
export PATH
~~~~
## Installing Apache Maven
To install Apache Maven, issue the following command:
~~~~
sudo apt-get install maven
~~~~
## Installing MySQL
To install MySQL, issue the following commands.  You will be able to set the password for the root account.  NOTE: There is a current issue with the ESB which requires the privileges also be set for anonymous local users, so don't disable access for anonymous users.
~~~~
sudo apt-get update
sudo apt-get install mysql-server
sudo mysql_secure_installation
sudo mysql_install_db
~~~~
## Configuring MySQL
The ServiceMix broker application for the ACR demo connects to the MySQL database, so the demo database needs to be first created and configured.
Login to the MySQL command-line tool using the root account with the password you set earlier.
~~~~
mysql --user=root --password=somepassword
~~~~
Create and use the database 'broker' for the ACR demo
~~~~
mysql> CREATE DATABASE broker;
mysql> USE broker;
~~~~
Create the user 'broker' for the ACR demo and set the password.
~~~~
mysql> CREATE USER 'broker'@'localhost' IDENTIFIED BY 'somepassword';
~~~~
Set the permissions for the user 'broker'.  NOTE: This should be tuned to only grant the necessary privileges. 
~~~~
mysql> GRANT ALL PRIVILEGES ON broker.* TO 'broker'@'%' WITH GRANT OPTION;
~~~~
Note: There is a current issue with the ESB which requires the privileges also be set for anonymous local users, so privileges need to be set for anonymous users.
~~~~
mysql> GRANT ALL PRIVILEGES ON broker.* TO ''@'localhost' WITH GRANT OPTION;
~~~~
Create the 'users' table.
~~~~
mysql> CREATE TABLE `users` ( `user_id` bigint(20) NOT NULL,   `user_name` varchar(50) DEFAULT NULL,   `user_description` varchar(45) DEFAULT NULL,   `user_phone` varchar(20) DEFAULT NULL,   `user_address` varchar(50) DEFAULT NULL,   `user_account` varchar(50) DEFAULT NULL,   PRIMARY KEY (`user_id`));
~~~~
Populate the 'users' table with test records.  NOTE: The user_id values need to correspond toIDs of ZenDesk users.
~~~~
mysql> INSERT INTO `users` VALUES (3770168798,'Jack Sprat 4','Some Details','555-555-1213',NULL,'121212'),(4060748677,'Wally Chang','No Description','222-111-1111','12341 Main Street','12345671'),(4758827738,'Tim','No Description','555-555-7777','','5656565');
~~~~
## Downloading and Building Broker Application
Set up SSH keys to access the git repository.

Create a folder in which to clone the broker source code and navigate to that folder:
~~~~
mkdir ~/code && cd ~/code
~~~~
Clone the broker git repository.

Navigate to the broker code folder:
~~~~
cd camel-rest-proxy-blueprint/
~~~~ 
Build the broker application with Maven:
~~~~
mvn clean install
~~~~
## Downloading and Installing Apache ServiceMix
Apache ServiceMix 6.1.2 is available under the Apache License v2 and can be downloaded from http://servicemix.apache.org/downloads/servicemix-6.1.2.html.
Create and navigate to a folder where the downloaded zip file will be placed:
~~~~
mkdir ~/dev-tools && cd ~/dev-tools
~~~~
Download and uncompress the zip file. For example:
~~~~
wget http://mirror.cc.columbia.edu/pub/software/apache/servicemix/servicemix-6/6.1.2/apache-servicemix-6.1.2.zip
unzip apache-servicemix-6.1.2.zip
~~~~
## Running and Configuring ServiceMix
In a command shell, navigate to the ServiceMix bin directory  (e.g., ~/dev-tools/apache-servicemix-6.1.2).
~~~~
cd ~/dev-tools/apache-servicemix-6.1.2/bin
~~~~
Start ServiceMix
~~~~
./servicemix
~~~~
Install the following features:
~~~~
karaf@root>feature:install jdbc
karaf@root>feature:install pax-jdbc-mysql
karaf@root>feature:install camel-jsonpath
karaf@root>feature:install camel-jetty
karaf@root>feature:install camel-jdbc
~~~~
You may need to download the pax-jdbc artifact from the Maven repository if the pax-jdbc-mysql install does not work:
~~~~
karaf@root>feature:repo-add pax-jdbc 0.6.0
~~~~
Create the JDBC connection to the MySQL database

Note: depending on your version of jdbc, the command you will need to use will either be "jdbc:ds-create" or "jdbc:create". Type <tab> to print a list of available commands and find the one you need.
~~~~
karaf@root>jdbc:ds-create -dn  mysql -url jdbc:mysql://localhost:3306/demo?user=broker&password=somepassword mySqlDataSource
karaf@root>jdbc:create -d  mysql -t MySQL -url jdbc:mysql://localhost:3306/broker -u broker -p somepassword mySqlDataSource
~~~~
Check the JDBC connection was created:
~~~~
karaf@root>jdbc:datasources
~~~~
Another way to check the database connection is to issue a query:
~~~~
karaf@root>jdbc:query jdbc/mySqlDataSource "select * from users"
~~~~
Install the broker application.  The application will be installed as an OSGI bundle.
~~~~
karaf@root>bundle:install -s mvn:org.apache.camel/camel-rest-proxy-blueprint/2.16.3
~~~~
Check that the broker was installed.  The bundle should be the last bundle in the list and its status should be ACTIVE:
~~~~
karaf@root>bundle:list
~~~~
## Install and Start ServiceMix as a Service
Start ServiceMix if is not already started.  Issue the following commands:
~~~~
karaf@root>feature:install wrapper
karaf@root>wrapper:install -s AUTO_START -n KARAF -d Karaf -D "Karaf Service"
~~~~
A message similar to the following will be displayed:
~~~~
Setup complete.  You may wish to tweak the JVM properties in the wrapper configuration file:
        /home/ubuntu/dev-tools/apache-servicemix-6.1.2/etc/KARAF-wrapper.conf
before installing and starting the service.
 
Ubuntu/Debian Linux system detected (SystemV):
  To install the service:
    $ ln -s /home/ubuntu/dev-tools/apache-servicemix-6.1.2/bin/KARAF-service /etc/init.d/
  To start the service when the machine is rebooted:
    $ update-rc.d KARAF-service defaults
  To disable starting the service when the machine is rebooted:
    $ update-rc.d -f KARAF-service remove
  To start the service:
    $ /etc/init.d/KARAF-service start
  To stop the service:
    $ /etc/init.d/KARAF-service stop
  To uninstall the service :
    $ rm /etc/init.d/KARAF-service
For systemd compliant Linux:
  To install the service (and enable at system boot):
   $ systemctl enable /home/ubuntu/dev-tools/apache-servicemix-6.1.2/bin/KARAF.service
  To start the service:
   $ systemctl start KARAF
  To stop the service:
   $ systemctl stop KARAF
  To check the current service status:
   $ systemctl status KARAF
  To see service activity journal:
   $ journalctl -u KARAF
  To uninstall the service (and disable at system boot):
   $ systemctl disable KARAF
~~~~
Exit the ServiceMix/Karaf shell, by shutting down ServiceMix:
~~~~
karaf@root>shutdown
~~~~
Install the ServiceMix service:
~~~~
sudo ln -s /home/ubuntu/dev-tools/apache-servicemix-6.1.2/bin/KARAF-service /etc/init.d/
~~~~
Set the service to start when the machine is rebooted.
~~~~
sudo update-rc.d KARAF-service defaults
~~~~
Start the ServiceMix service:
~~~~
sudo /etc/init.d/KARAF-service start
~~~~
To log back into ServiceMix once the service is started, issue the following commands:
~~~~
cd ~/dev-tools/apache-servicemix-6.1.2/bin
./client
~~~~ 
To exit the ServiceMix shell without shutting down the service, type ^D (i.e, Ctrl-D).  NOTE: If you type shutdown in ServiceMix shell, the entire service will be shut down.
# Testing the Broker Application
At this point, all of the code for the Broker application is contained in the OSGI Blueprint file which can be viewed here: /camel-rest-proxy-blueprint/src/main/resources/OSGI-INF/blueprint/blueprint.xml 

If the Broker application is running in ServiceMix running, you can check the application with using curl at the command line.  For example:
~~~~
$ curl -u wkchang@mitre.org/token:hLLUnPzJtpvMZ5WnntN3wCneKHkl20kP0Hhn5NrD http://localhost:9090/api/v2/users/me.json  --insecure
~~~~
You can check the status and statics of the main Broker route in the ServiceMix/Karaf shell:
~~~~
karaf@root>camel:route-info rest-http-zendesk-mysql-demo
~~~~
Here is example output from the camel:route-info command:
~~~~
Camel Route rest-http-zendesk-mysql-demo
        Camel Context: camel-1
        State: Started
        State: Started
 
Statistics
        Exchanges Total: 2
        Exchanges Completed: 2
        Exchanges Failed: 0
        Exchanges Inflight: 0
        Min Processing Time: 240 ms
        Max Processing Time: 494 ms
        Mean Processing Time: 367 ms
        Total Processing Time: 734 ms
        Last Processing Time: 240 ms
        Delta Processing Time: -254 ms
        Start Statistics Date: 2016-07-19 14:43:44
        Reset Statistics Date: 2016-07-19 14:43:44
        First Exchange Date: 2016-07-19 15:12:15
        Last Exchange Date: 2016-07-19 15:12:34
 ~~~~
