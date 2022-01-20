#!/bin/bash

injected_dir=$1
source /usr/local/s2i/install-common.sh
# Using install_modules ${injected_dir}/modules
# copies ALL data in the modules dir including licences and README.md.
# Only using the MySQL driver here.
mkdir -p $JBOSS_HOME/modules/com/mysql
cp -rf ${injected_dir}/modules/com/mysql/* $JBOSS_HOME/modules/com/mysql
configure_drivers ${injected_dir}/drivers.env
