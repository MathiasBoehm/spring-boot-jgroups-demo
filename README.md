# Simple Spring Boot JGroups Demo
- Check which node is the leader in a cluster

# Steps

- Build Project
```sh
$ mvn clean package
```

- Run Node 1
```sh
$ java -jar -Dserver.port=8081 target/jgoupsdemo-0.0.1-SNAPSHOT.jar
```
- Run Node 2
```sh
$ java -jar -Dserver.port=8082 target/jgoupsdemo-0.0.1-SNAPSHOT.jar
```
- Check if Node 1 is the leader
```sh
$ curl -X GET http://localhost:8081/info
```

- Check if Node 2 is the leader
```sh
$ curl -X GET http://localhost:8082/info
```

- Stop Node 1 and verify that Node 2 is now the leader