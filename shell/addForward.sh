#!/bin/sh
#you should run this script in your server with ip "192.168.1.1", if not , change the correst ip address
#it will forward all the requests from the port 80 to 8080 and 443 to 8443
#after reboot your server, these config will be losts
iptables -t nat -A PREROUTING -d 192.168.1.1 -p tcp -m tcp --dport 80 -j DNAT --to-destination 192.168.1.1:8080
iptables -t nat -A PREROUTING -d 192.168.1.1 -p tcp -m tcp --dport 443 -j DNAT --to-destination 192.168.1.1:8443