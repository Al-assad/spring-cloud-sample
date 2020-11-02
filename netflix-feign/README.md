**Spring Cloud 服务提供与调用示例**

* netflix-eureka-single：Eureka 注册中心服务
* spring-cloud-producer：远程调用提供服务
* spring-cloud-consumer：远程调用消费服务

<br>

**验证过程**

1. 启动 netflix-eureka-single SpringCluodNetflixApplication
2. 启动 spring-cloud-producer SpringCluodNetflixApplication
3. 启动 spring-cloud-consumer SpringCluodNetflixApplication
4. 调用 GET http://localhost:9001/hello/assad

**负载均衡测试**

1. 启动 netflix-eureka-single

2. 启动 2 个 spring-cloud-producer，分别的 application.properties 配置如下：

   ```properties
   spring.application.name=spring-cloud-producer
   server.port=9002
   eureka.client.serviceUrl.defaultZone=http://localhost:8000/eureka/
   ```

   ```properties
   spring.application.name=spring-cloud-producer
   server.port=9003
   eureka.client.serviceUrl.defaultZone=http://localhost:8000/eureka/
   ```

3. 启动 spring-cloud-consumer

4. 多次调用 GET http://localhost:9001/hello/assad

5. 可以发现该请求到 spring-cloud-producer 服务会随机落到 2 个服务实例上