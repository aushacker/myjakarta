#!/bin/bash

injected_dir=$1
source /usr/local/s2i/install-common.sh
#cp -rf ${install_dir}/* $JBOSS_HOME/modules
#ls ${injected_dir}/modules
#install_modules ${injected_dir}/modules
mkdir -p $JBOSS_HOME/modules/com/mysql
cp -rf ${injected_dir}/modules/com/mysql/* $JBOSS_HOME/modules/com/mysql
configure_drivers ${injected_dir}/drivers.env
