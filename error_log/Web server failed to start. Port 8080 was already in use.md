## Description

* Web server failed start. Port 8080 was already in use...


## Solved

1. lsof -i :8080
2. kill -9 ${PID}