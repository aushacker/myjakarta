#!/bin/bash

injected_dir=$1
source /usr/local/s2i/install-common.sh
source ${injected_dir}/modules/install-common-ext.sh
install_modules_ext ${injected_dir}/modules "com/mysql"
configure_drivers ${injected_dir}/drivers.env
