# Installing Jenkins #

This guide is meant to walk an administrator through the process of installing the continuous integration system *Jenkins* as a service. Specifically, the guide focuses on installing Jenkins on CentOS, but should work on any RedHat Linux derivative (e.g., Fedora). Please note that `sudo` access is required on the target machine.

## Prerequisites ##

Jenkins requires Java to run and typically works best with a Sun implementation of Java. However, this implementation is not included by default in CentOS for licensing reasons. To check whether you have the correct version of java installed, run `java -version`. If you get output similar to the following, a new version of Java needs to be installed:

```
java version "1.5.0"
gij (GNU libgcj) version 4.4.6 20110731 (Red Hat 4.4.6-3)
```

To uninstall Java, run the following command:

```
yum remove java
```

Then after you've uninstalled Java (or if you didn't have Java installed at all to begin with). You need to install a Sun-compatible version of Java. The easiest approach is using OpenJDK, which is available through the EPEL repository (alternatively you may install an official RPM directly from Oracle). To install OpenJDK run the following:

```
yum install java-1.7.0-openjdk
```

To check whether Java was installed correctly, run `java -version` again. If you see output similar to the following, Java should be installed correctly:

```
java version "1.7.0_79"
OpenJDK Runtime Environment (rhel-2.5.5.1.el6_6-x86_64 u79-b14)
OpenJDK 64-Bit Server VM (build 24.79-b02, mixed mode)
```

Depending on your version of CentOS, the package name for OpenJDK may differ. Use yum search openjdk to check for the name of the package. If OpenJDK is not found at all through yum, you probably need to [install the EPEL yum repository](https://www.rackspace.com/knowledge_center/article/install-epel-and-additional-repositories-on-centos-and-red-hat).

## Installing Jenkins ##

Jenkins can be easily installed using the RedHat package manager *yum*. To install Jenkins using yum, first add the Jenkins repository to the yum repos by running the following two commands:

```
sudo wget -O /etc/yum.repos.d/jenkins.repo http://pkg.jenkins-ci.org/redhat/jenkins.repo
sudo rpm --import https://jenkins-ci.org/redhat/jenkins-ci.org.key
```

Now, install Jenkins:

```
sudo yum install jenkins
```

## Modifying Jenkins Installation ##

*This step is optional*

The configuration file for Jenkins is (by defaut, on CentOS) `/etc/sysconfig/jenkins`. This file captures the configuration parameters for the launch.

### Setting Up Listening Port ###

By default, Jenkins will listen on port 8080. This port can be changed in the configuration file:

```
# Jenkins system configuration
...
JENKINS_PORT=<new-port-here>
...
```

Note that typically ports under 1024 (such as port 80 that is used by web servers by default) may not be possible to configure for JPL network security reasons.

### Changing Default Jenkins User ###

During the installation, the user 'jenkins' is created to run this service. If you would like to change this to a different user via the config file, you must change the owner of `/var/log/jenkins`, `/var/lib/jenkins`, and `/var/cache/jenkins`. To change the user that Jenkins will start under, modify the following line in the configuration file:

```
# Jenkins system configuration
...
JENKINS_USER=<new-user-name-here>
...
```

## Configuring System ##

Note that the built-in firewall may have to be opened to access the port configured in the last section from other computers. To open the port on the system, please call your system administrator. JPL does not allow self-configuration of the firewall for security reasons. For the IMCE build server, the system administrator is Johnathan Mastron ([Johnathan.D.Mastron@jpl.nasa.gov](Johnathan.D.Mastron@jpl.nasa.gov)).

## First Time Run ##

To start Jenkins for the first time, and set up Jenkins as a service that will start at boot time, run the following command:

```
sudo service jenkins start
```

To stop Jenkins, replace `start` with `stop`. Jenkins can be restarted with the parameter `restart`.

To set up Jenkins as a service, run the following command:

```
sudo chkconfig jenkins on
```

If you get an error message during this process, ensure that Java is installed. If not, Jenkins will be launched as a daemon on system startup. See /etc/init.d/jenkins for more details.

## Configuring Jenkins ##

To configure the newly set up Jenkins instance and install any plugins, point your browser to the address of the machine that Jenkins was set up on (with the correct port specified). For instance, if Jenkins is set up to listen on port `8080`, and runs on a machine with IP `1.1.1.1`, point your browser to `http://1.1.1.1:8080`.

Please see [this guide](JENKINS-SETUP.md) for more information on how Jenkins is set up within the context of the IMCE core infrastructure effort.

## Troubleshooting ##

Note that Jenkins will place a log file in /var/log/jenkins/jenkins.log. Check this file if you are troubleshooting Jenkins.

Upon startup errors, ensure the OpenJDK is installed and not GJC.
