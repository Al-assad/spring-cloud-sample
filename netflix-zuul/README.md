**Spring Cloud Zuul 服务网关示例**

* netflix-eureka：Eureka 注册中心服务
* spring-cloud-producer：API 调用提供服务
* spring-cloud-zuul：Zuul 网关服务

提供 Zuul 过滤器、路由熔断、路由重试功能测试

<br>

**验证过程**

1. 启动 netflix-eureka 、spring-cloud-producer、spring-cloud-zuul

2. 验证静态配置路由 

   http://localhost:8888/github/spring-cloud-sample

   http://localhost:8888/producer/hello?name=assad

3. 验证自动获取服务命名路由

   http://localhost:8888/spring-cloud-producer/hello?name=assad

**zuul 过滤器验证**

1. 正常响应：http://localhost:8888/spring-cloud-producer/hello?name=assad

2. 正常响应：http://localhost:8888/spring-cloud-producer/info?token=2333

3. 请求断路：http://localhost:8888/spring-cloud-producer/info

**zuul 熔断验证**

1. 终止 spring-cloud-producer 服务
2. 请求 http://localhost:8888/spring-cloud-producer/hello?name=assad，获取 200 预期 fallback
3. 启动 spring-cloud-producer 服务
4. 请求 http://localhost:8888/spring-cloud-producer/hello?name=assad，正常获取 spring-cloud-producer 服务响应