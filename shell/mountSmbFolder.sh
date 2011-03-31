#!/bin/sh
#mount a smb file system to your linux system
#you should input the password after running this script
SHAREIP=192.168.1.1
USERNAME=test
DOMAINNAME=domain
mount -t cifs //$SHAREIP/folder /floder --verbose -o user=$USERNAME,domain=$DOMAINNAME
