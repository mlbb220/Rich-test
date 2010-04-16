#!/bin/sh
function replaceBuildProperties(){
filename=$1
if [ -e $filename ]
then
 echo "Will remove $filename"
 rm -f $filename
fi
echo "Copy $filename from templates/$filename"
cp templates/$filename .
chmod +w $filename
echo "Will sed build properties"
sed -f sedlist.rich $filename > 1
cat 1 > $filename
#cat $filename
echo "replaceBuildProperties Success!"
}


function replaceDBandLogInfo(){
##########################
## get confi info form config file
##########################

dbinfoline=`grep $1 dbinfo.rich`
if [ "$dbinfoline" = "" ] 
then
  echo "can not find the dbinfoline(dbinfo.rich) for $1"
  exit 0
fi
echo "find dbinfoline for $1 is $dbinfoline"
username=`echo "$dbinfoline"|gawk -F: '{print $2}'`
password=`echo "$dbinfoline"|gawk -F: '{print $3}'`
ip=`echo "$dbinfoline"|gawk -F: '{print $4}'`
dbname=`echo "$dbinfoline"|gawk -F: '{print $5}'`
logdir=`echo "$dbinfoline"|gawk -F: '{print $6}'`
statedir=`echo "$dbinfoline"|gawk -F: '{print $7}'`
echo "dbinfo is :$dbinfoline"
echo "username is :$username"
echo "password is :$password"
echo "ip is :$ip"
echo "dbname is :$dbname"
echo "logdir is :$logdir"
if [ "$statedir" = "" ]
then
  statedir=`grep "DIR_NAME=" $1`
fi
statedir=${statedir#*=}
echo "statedir is :$statedir"
destdir="../$statedir/dist/config/com/tps/config/"
dbconfigfile=${destdir}com_tps_dbplugin_DBManagerImpl_properties
logconfigfile=${destdir}com_tps_logging_properties

successflag="success"
##########################
## replace log config
##########################
if [ -e $logconfigfile ]
then
echo "$logconfigfile exists"
sed "s/=.\/log/=c:\/log\/${logdir}/" $logconfigfile > 2
cat 2 > $logconfigfile
else
echo "$logconfigfile dos NOT exist"
successflag="fail"
fi

##########################
## replace db config
##########################
if [ -e $dbconfigfile ]
then
echo "$dbconfigfile exists"
sed "s/DB1.db.000.userid=eppicdemo/DB1.db.000.userid=${username}/;s/DB1.db.000.password=eppicdemo/DB1.db.000.password=${password}/;s/DB1.db.000.hostname=localhost/DB1.db.000.hostname=${ip}/;s/DB1.db.000.dbname=sid/DB1.db.000.dbname=${dbname}/" $dbconfigfile > 3
cat 3 > $dbconfigfile
else
echo "$dbconfigfile does NOT exist"
successflag="fail"
fi
if [ "$successflag" = "success" ]
then 
   echo "replace DB Success!"
else
   echo "replace DB FAIL!"
fi
}
