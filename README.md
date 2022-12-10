## mysql 준비
- https://poiemaweb.com/docker-mysql

```bash
docker pull mysql
docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=password -d -p 3306:3306 mysql:latest
docker ps -a

# MySQL Docker 컨테이너 중지
$ docker stop mysql-container

# MySQL Docker 컨테이너 시작
$ docker start mysql-container

# MySQL Docker 컨테이너 재시작
$ docker restart mysql-container

# 컨테이너 접속 및 초기 설정
docker exec -it mysql-container bash
# > mysql -uroot -p
# mysql> show databases;
# mysql> create database sns;
# mysql> use sns;
```

## schema 설정
src/main/java/com/example/fastcampusmysql/schema/ddl.sql