Spring Cloud 服务提供与调用示例

* netflix-eureka-single：Eureka 注册中心服务
* spring-cloud-producer：远程调用提供服务
* spring-cloud-consumer：远程调用消费服务

<br>

启动过程

1. 启动 netflix-eureka-single SpringCluodNetflixApplication
2. 启动 spring-cloud-producer SpringCluodNetflixApplication
3. 启动 spring-cloud-consumer SpringCluodNetflixApplication
4. 调用 GET http://localhost:9001/hello/assad

