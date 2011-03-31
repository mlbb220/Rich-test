#!/bin/sh
SHAREIP=10.104.151.161
USERNAME=rli
DOMAINNAME=springthings
mount -t cifs //$SHAREIP/icc /icc --verbose -o user=$USERNAME,domain=$DOMAINNAME
