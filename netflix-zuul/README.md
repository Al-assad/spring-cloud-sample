**Spring Cloud Zuul 服务网关示例**

* netflix-eureka：Eureka 注册中心服务
* spring-cloud-producer：API 调用提供服务
* spring-cloud-zuul：Zuul 网关服务

<br>

**验证过程**

1. 启动 netflix-eureka 、spring-cloud-producer、spring-cloud-zuul

2. 验证静态配置路由 

   http://localhost:8888/github/spring-cloud-sample

   http://localhost:8888/producer/hello?name=assad

3. 验证自动获取服务命名路由

   http://localhost:8888/spring-cloud-producer/hello?name=assad

