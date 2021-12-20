@echo off 
call mvn clean install -Dmaven.test.skip=true
ssh root@192.168.239.134 -i "C:\Users\PaiGu\.ssh\local_id_rsa" scp ./target/interview.jar  root@192.168.239.134:/root/interview.jar
ssh root@192.168.239.134 -i "C:\Users\PaiGu\.ssh\local_id_rsa" "/root/start.sh"