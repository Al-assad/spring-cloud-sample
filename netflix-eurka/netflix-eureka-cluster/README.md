### Spring Cloud Eureka 集群实例

<br>

**启动过程**

1. host 添加

   ```
   127.0.0.1 peer1  
   127.0.0.1 peer2  
   127.0.0.1 peer3
   ```

2. 打包启动，分别以 peer1、peer2、peer3 的配置参数启动 eureka 注册中心

   ```
   mvn clean package
   java -jar netflix-eureka-cluster-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1
   java -jar netflix-eureka-cluster-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer2
   java -jar netflix-eureka-cluster-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer3
   ```

3. 浏览器进入 http://localhost:8000/

