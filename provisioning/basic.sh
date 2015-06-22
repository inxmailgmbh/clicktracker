#!/bin/bash

# configure timezone
echo "Europe/Berlin" > /etc/timezone
dpkg-reconfigure --frontend=noninteractive tzdata

# add and install postgresql packages
wget --quiet -O - http://apt.postgresql.org/pub/repos/apt/ACCC4CF8.asc | sudo apt-key add -
echo "deb http://apt.postgresql.org/pub/repos/apt/ wheezy-pgdg main" >> /etc/apt/sources.list.d/postgresql.list
apt-get update

apt-get install postgresql-9.4 -y

# install jdk
JDK_DOWNLOAD=/vagrant/provisioning/cache/jdk-8u45-linux-x64.tar.gz
mkdir -p /vagrant/provisioning/cache/
# download only if non-existing
if [ ! -e ${JDK_DOWNLOAD} ]
then
  wget --no-verbose -O ${JDK_DOWNLOAD} http://build.srv.inxmail.de/resources/jdk/jdk-8u45-linux-x64.tar.gz
fi

md5sum --check --status /vagrant/provisioning/md5_jdk.txt
if [ $? -ne 0 ]
then
  echo 'Incorrect JDK (md5 checksum failed)'
  exit 1
fi

tar -xf ${JDK_DOWNLOAD} -C /opt/
chown -R root:root /opt/jdk1.8.0_45

ln -s /opt/jdk1.8.0_45 /opt/java

echo 'export PATH=$PATH:/opt/java/bin' >> /etc/profile.d/10_java.sh
echo 'export JAVA_HOME=/opt/java' >> /etc/profile.d/10_java.sh

# install supporting tools
apt-get install vim silversearcher-ag tmux -y
