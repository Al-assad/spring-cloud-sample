**Spring Cloud Hystrix 服务提供与调用示例**

* netflix-eureka：Eureka 注册中心服务
* spring-cloud-producer：远程调用提供服务
* spring-cloud-consumer：远程调用消费服务

<br>

**验证过程**

1. 启动 netflix-eureka EurekaApplication
2. 启动 spring-cloud-producer ProducerApplication
3. 启动 spring-cloud-consumer ConsumerApplication
4. 调用 GET http://localhost:9001/hello/assad

**Hystrix 熔断降级测试**

1. 终止 spring-cloud-producer ProducerApplication
2. 调用 GET http://localhost:9001/hello/assad，返回 Hystrix fallback HelloRemoteFallback 代理；
3. 启动  spring-cloud-producer ProducerApplication；
4. 调用 GET http://localhost:9001/hello/assad，恢复 HelloRemote 远程调用；

