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
