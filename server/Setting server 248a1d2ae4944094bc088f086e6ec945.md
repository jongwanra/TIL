# Setting server

## Filezilla의 역할

- 내 컴퓨터에 있는 file을 업로드하고 다운로드 하는 프로그램

## 1. Filezilla 세팅

![Untitled](Setting%20server%20248a1d2ae4944094bc088f086e6ec945/Untitled.png)

## 2. 해당 파일을 서버에 넣어준다.

[initial_ec2.sh](Setting%20server%20248a1d2ae4944094bc088f086e6ec945/initial_ec2.sh)

```python
# UTC to KST
sudo ln -sf /usr/share/zoneinfo/Asia/Seoul /etc/localtime

# python3 -> python
sudo update-alternatives --install /usr/bin/python python /usr/bin/python3 10

# pip3 -> pip
sudo apt-get update
sudo apt-get install -y python3-pip
pip3 --version
sudo update-alternatives --install /usr/bin/pip pip /usr/bin/pip3 1

# port forwarding
sudo iptables -t nat -A PREROUTING -i eth0 -p tcp --dport 80 -j REDIRECT --to-port 5000

# MongoDB - install
wget -qO - https://www.mongodb.org/static/pgp/server-4.4.asc | sudo apt-key add -
echo "deb [ arch=amd64,arm64 ] https://repo.mongodb.org/apt/ubuntu bionic/mongodb-org/4.4 multiverse" | sudo tee /etc/apt/sources.list.d/mongodb-org-4.4.list
sudo apt-get update
sudo apt-get install -y mongodb-org

sudo mkdir -p /data/db

# MongoDB - run
sudo service mongod start
sleep 7
netstat -tnlp

# MongoDB set user, set conf file
mongo admin --eval 'db.createUser({user: "test", pwd: "test", roles:["root"]});'
sudo sh -c 'echo "security:\n  authorization: enabled" >> /etc/mongod.conf'
sudo sed -i "s,\\(^[[:blank:]]*bindIp:\\) .*,\\1 0.0.0.0," /etc/mongod.conf

sudo service mongod stop
sudo service mongod start
sleep 5
netstat -tnlp
```

→ 입력할 명령어를 모아둔 파일.

## 3. initial_ec2.sh 파일 권한 조정 및 실행

```python
# 파일 안에 있는 명령어들이 잘 실행될  수 있도록 권한을 줌.
$sudo chmod 755 initial_ec2.sh

# 파일 실행
$ ./initial_ec2.sh
```