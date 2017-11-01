Enterprise Service Bus
----------------------

The ESB provides a generic method to integrate with legacy database
systems as well as the diverse number of databases and unstructured data
repositories on the market and in use today. ACE Direct ESB integrates
with a COTS CRM service (e.g., Zendesk) as a ticketing system for the
CSR to document service cases.

### Background

Apache ServiceMix 6.1.2 is used as the service broker. Apache ServiceMix
is an enterprise-class, open-source, distributed ESB based on the
service-oriented architecture (SOA) model. It is a project of the Apache
Software Foundation and was built on the semantics and APIs of the Java
Business Integration (JBI) specification JSR 208. The software is
distributed under the Apache License.

The current version of ServiceMix fully supports the OSGi framework.
ServiceMix is lightweight and easily embeddable, and has integrated
Spring Framework support. It can be run at the edge of the network
(inside a client or server), as a standalone ESB provider, or as a
service within another ESB. ServiceMix is compatible with Java SE or a
Java Enterprise Edition (EE) application server. ServiceMix uses
ActiveMQ to provide remoting, clustering, reliability, and distributed
failover. The basic frameworks used by ServiceMix are Spring and XBean.

ServiceMix comprises the latest versions of Apache ActiveMQ, Apache
Camel, Apache CXF, and Apache Karaf. Additional installation features
include:

-   BPM engine via Activiti

-   JPA support via Apache OpenJPA

-   XA transaction management via JTA via Apache Aries

The ServiceMix ESB provides:

-   Federation, clustering, and container-provided failover

-   Hot deployment and life-cycle management of business objects

-   Vendor independence from vendor-licensed products

-   Compliance with the JBI specification JSR 208

-   Compliance with the OSGi 4.2 specification through Apache Felix

<!-- -->

-   Support for OSGi Enterprise through Apache Aries

### Installation Overview

First install and configure ServiceMix and its prerequisites on the host
machine.

#### ServiceMix System Requirements

To run Apache ServiceMix itself, you will need Java Runtime Environment
(JRE) 1.8.x (Java 8), and about 100 MB of free disk space for the
default assembly.

If you are developing your own integration applications and OSGi
bundles, you will also need:

-   Java Developer Kit (JDK) 1.8.x (Java 8)

-   MySQL

<!-- -->

-   Apache Maven 3.0.4 or higher

The ACRDEMO broker application depends on MySQL for a database and Maven
for building the application.

#### Installing the JDK

Issue the following commands to install the Java 8 JDK:

Redhat/Fedora/CentOS Systems (SystemV):

sudo yum install java-1.8.0-openjdk

Set the JAVA\_HOME environment variable in the bash startup:

> vi \~/.bashrc

Add the following lines to the end of the .bashrc script:

> JAVA\_HOME= /opt/jdk1.8.0\_111
>
> export JAVA\_HOME
>
> JRE\_HOME=/opt/jdk1.8.0\_111/jre
>
> export JRE\_HOME
>
> PATH=\$PATH:/opt/jdk1.8.0\_111/bin:/opt/jdk1.8.0\_111/jre/bin
>
> export PATH

#### Installing Apache Maven

To install Apache Maven, issue the following command:

Redhat/Fedora/Centos Systems (SystemV):

sudo yum install maven

#### Installing MySQL

You will be able to set the password for the root account. ***Note*:**
There is a current issue with the ESB that also requires setting the
privileges for anonymous local users; accordingly, do not disable access
for anonymous users. To install MySQL, issue the following commands:

Redhat/Fedora/Centos Systems (SystemV):

sudo yum install unixODBC unixODBC-devel libtool-ltdl libtool-ltdl-devel
mysql-connector-odbc

wget http://repo.mysql.com/mysql-community-release-el7-5.noarch.rpm

sudo rpm -ivh mysql-community-release-el7-5.noarch.rpm

sudo yum install mysql-server

sudo systemctl start mysqld

sudo yum update

#### Configuring MySQL

The ServiceMix broker application for the ACR demo connects to the MySQL
database; therefore, first create and configure the demo database.

To start the mysql in Redhat/Fedora/Centos Systems (SystemV):

> sudo /usr/bin/mysql\_secure\_installation

Login to the MySQL command-line tool using the root account with the
password you set earlier:

> mysql -u root -p=somepassword

Create a database named “broker” for the ACR demo:

> mysql&gt; CREATE DATABASE broker;
>
> mysql&gt; USE broker;

Create the database user named “broker” for the ACR demo and set the
password:

> mysql&gt; CREATE USER 'broker'@'localhost' IDENTIFIED BY
> 'somepassword';

Set the permissions for the database user “broker”. ***Note*:** This
should be tuned to only grant the necessary privileges:

> mysql&gt; GRANT ALL PRIVILEGES ON broker.\* TO 'broker'@'%' WITH GRANT
> OPTION;

***Note*:** There is a current issue with the ESB that also requires
setting the privileges for anonymous local users. Privileges must be set
for anonymous users:

> mysql&gt; GRANT ALL PRIVILEGES ON broker.\* TO ''@'localhost' WITH
> GRANT OPTION;

Create the “users” table:

> mysql&gt; CREATE TABLE \`users\` (
>
> \`user\_id\` bigint(20) NOT NULL,
>
> \`user\_name\` varchar(50) DEFAULT NULL,
>
> \`user\_description\` varchar(45) DEFAULT NULL,
>
> \`user\_phone\` varchar(20) DEFAULT NULL,
>
> \`user\_address\` varchar(50) DEFAULT NULL,
>
> \`user\_account\` varchar(50) DEFAULT NULL,
>
> PRIMARY KEY (\`user\_id\`));

Populate the “users” table with test records. ***Note*:** The user\_id
values need to correspond to IDs of Zendesk users:

> mysql&gt; INSERT INTO \`users\` VALUES
>
> (3770168798,'John Doe ','Some Details','555-555-1111',NULL,'121212'),
>
> (4060741111,'Jane Doe','No Description','222-111-1111','12341 Main
> Street','12345671'),
>
> (4758821111,'Tim','No Description','555-666-7777','','5656565');

#### Downloading and Building Broker Application

Set up SSH keys to access the git repository according to these
instructions:

-   [Adding a new SSH key to your GitHub
    account](https://help.github.com/articles/adding-a-new-ssh-key-to-your-github-account/)

Create a folder for cloning the broker source code and navigate to that
folder:

> mkdir \~/code && cd \~/code

Clone the broker git repository from esb.git

Navigate to the broker code folder:

> cd camel-rest-proxy-blueprint/

Modify the applications blueprint file for your environment. The
blueprint is configured to process messages intended for Zendesk. You
will need to modify the blueprint to specify your Zendesk hostname and
any proxy settings if you are accessing Zendesk from the ESB through a
proxy.

Build the broker application with Maven:

> mvn clean install

#### Downloading and Installing Apache ServiceMix

Apache ServiceMix 6.1.2 is available under the Apache License v2 and can
be downloaded from
<http://servicemix.apache.org/downloads/servicemix-6.1.2.html>.

Create and navigate to a folder where the downloaded zip file will be
placed:

> mkdir \~/dev-tools && cd \~/dev-tools

Download and uncompress the zip file. For example:

> wget
> <http://mirror.cc.columbia.edu/pub/software/apache/servicemix/servicemix-6/6.1.2/apache-servicemix-6.1.2.zip>
>
> unzip apache-servicemix-6.1.2.zip

#### Running and Configuring ServiceMix

In a command shell, navigate to the ServiceMix bin directory (e.g.,
\~/dev-tools/apache-servicemix-6.1.2):

> cd \~/dev-tools/apache-servicemix-6.1.2/bin

Start ServiceMix:

> ./servicemix

Install the following features:

> karaf@root&gt;feature:install jdbc
>
> karaf@root&gt;feature:install pax-jdbc-mysql
>
> karaf@root&gt;feature:install camel-jsonpath
>
> karaf@root&gt;feature:install camel-jetty
>
> karaf@root&gt;feature:install camel-jdbc
>
> karaf@root&gt;feature:install camel-http4

You may need to download the pax-jdbc artifact from the Maven repository
if the pax-jdbc-mysql install does not work:

> karaf@root&gt;feature:repo-add pax-jdbc 0.6.0

Create the JDBC connection to the MySQL database:

***Note*:** Depending on your version of jdbc, you will need either the
command “jdbc:ds-create” or “jdbc:create”. Type &lt;tab&gt; to print a
list of available commands and find the one you need:

> karaf@root&gt;jdbc:ds-create -dn mysql -url
> jdbc:mysql://localhost:3306/demo?user=broker&password=somepassword
> mySqlDataSource
>
> karaf@root&gt;jdbc:create -d mysql -t MySQL -url
> jdbc:mysql://localhost:3306/broker -u broker -p somepassword
> mySqlDataSource

Check that the JDBC connection was created:

> karaf@root&gt;jdbc:datasources

Another way to check the database connection is to issue a query:

> karaf@root&gt;jdbc:query jdbc/mySqlDataSource "select \* from users"

Install the broker application. The application will be installed as an
OSGI bundle:

> karaf@root&gt;bundle:install -s
> mvn:org.apache.camel/camel-rest-proxy-blueprint/2.16.3

Check that the broker was installed. The bundle should be the last
bundle in the list and its status should be ACTIVE:

> karaf@root&gt;bundle:list

#### Install and Start ServiceMix as a Service

Start the ServiceMix if is not already started. Issue the following
commands:

> karaf@root&gt;feature:install wrapper

karaf@root&gt;wrapper:install -s AUTO\_START -n KARAF -d Karaf -D “Karaf
Service”

A message similar to the following will be displayed:

Setup complete. You may wish to tweak the JVM properties in the wrapper
configuration file before installing and starting the service:

> \~/dev-tools/apache-servicemix-6.1.2/etc/KARAF-wrapper.conf

Redhat/Fedora/Centos Systems (SystemV):

  To install the service:

>     \$ ln -s \~//dev-tools/apache-servicemix-6.1.0/bin/KARAF-service
> /etc/init.d/
>
>    \$ chkconfig KARAF-service --add

 

  To start the service when the machine is rebooted:

>    \$ chkconfig KARAF-service on

 

  To disable starting the service when the machine is rebooted:

>     \$ chkconfig KARAF-service off

 

  To start the service:

>   \$ service KARAF-service start

 

  To stop the service:

>    \$ service KARAF-service stop

To uninstall the service :

>     \$ chkconfig KARAF-service --del
>
>     \$ rm /etc/init.d/KARAF-service

For systemd compliant Linux:

To install the service (and enable at system boot):

> \$ systemctl
> enable\~/dev-tools/apache-servicemix-6.1.2/bin/KARAF.service

To start the service:

> \$ systemctl start KARAF

To stop the service:

> \$ systemctl stop KARAF

To check the current service status:

> \$ systemctl status KARAF

To see service activity journal:

> \$ journalctl -u KARAF

To uninstall the service (and disable at system boot):

> \$ systemctl disable KARAF

Exit the ServiceMix/Karaf shell, by shutting down ServiceMix:

> karaf@root&gt;shutdown

[]{#_Hlk495311057 .anchor}Install the ServiceMix service:

> sudo ln -s \~/dev-tools/apache-servicemix-6.1.2/bin/KARAF-service
> /etc/init.d/

Set the service to start when the machine is rebooted:

> sudo update-rc.d KARAF-service defaults

Start the ServiceMix service:

> sudo /etc/init.d/KARAF-service start

To log back into ServiceMix once the service is started, issue the
following commands:

> cd \~/dev-tools/apache-servicemix-6.1.2/bin
>
> ./client

To exit the ServiceMix shell without shutting down the service, type \^D
(i.e., Ctrl-D). ***Note*:** If you type shutdown in ServiceMix shell,
the entire service will be shut down.

### Editing blueprint.xml Application File

The blueprint.xml file is provided with placehoders which will needed to
be edited for your specific environment.

#### Update Zendesk hostname 

The blueprint.xml file has placehoders for the Zendesk hostame. You will
need to provide your Zendesk hostname wherever you see the placehoder
“&lt;insert CRM hostname&gt;”

#### Enable/Disable proxy

If there is a proxy between the ESB and Zendesk, you may need add the
following parameters to set of parameters specificed for each instance
of the Zendesk endpoint. For example, you may need to replace

/api?bridgeEndpoint=true&amp;throwExceptionOnFailure=false

with:

/api?bridgeEndpoint=true&amp;proxyAuthHost=&lt;replace with proxy
ip&gt;&amp;proxyAuthPort=&lt;replace with proxy
port&gt;&amp;proxyAuthScheme=http4&amp; throwExceptionOnFailure=false

substituting your proxy host and port settings for the placeholders.

After editing the blueprint file, rebuild the application using maven:

cd \~/code/camel-rest-proxy-blue-print/

mvn clean install

cd \~/dev-tools/apache-servicemix-6.1.2/bin

./client

karaf@root&gt;bundle:install -s
mvn:org.apache.camel/camel-rest-proxy-blueprint/2.16.3

Make sure the bundle is successfully installed with no errors and
active.

### Testing the Broker Application

At this point, all of the code for the Broker application is contained
in the OSGI Blueprint file (i.e., blueprint.xml) that can be viewed in
<https://github.com/FCC/ACEDirect> in the acrdemo-provider folder.

If the Broker application is running in ServiceMix running, you can
check the application by using curl at the command line. For example:

> \$ curl -u
> username@hostname/token:hLLUnPzJtpvMZ5WnntN3wCneKHkl20kP0Hhn5NrD
> http://localhost:9090/api/v2/users/me.json --insecure
>
> where username is a Zendesk user account amd hostname is your Zendesk
> host name.

You can check the status and statistics of the main Broker route in the
ServiceMix/Karaf shell:

> karaf@root&gt;camel:route-info rest-http-zendesk-mysql-demo

Here is example output from the camel:route-info command:

Camel Route rest-http-zendesk-mysql-demo\
Camel Context: camel-1\
State: Started\
State: Started\
\
Statistics\
Exchanges Total: 2\
Exchanges Completed: 2\
Exchanges Failed: 0\
Exchanges Inflight: 0\
Min Processing Time: 240 ms\
Max Processing Time: 494 ms\
Mean Processing Time: 367 ms\
Total Processing Time: 734 ms\
Last Processing Time: 240 ms\
Delta Processing Time: -254 ms\
Start Statistics Date: 2016-07-19 14:43:44\
Reset Statistics Date: 2016-07-19 14:43:44\
First Exchange Date: 2016-07-19 15:12:15\
Last Exchange Date: 2016-07-19 15:12:3
