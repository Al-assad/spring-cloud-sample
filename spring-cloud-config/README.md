**Spring Cloud Config 使用示例**

* spring-cloud-config-server：Config 服务提供
* spring-cloud-config-client：Config 服务消费

**验证方式**

1. 启动 spring-cloud-config-server、spring-cloud-config-client

2. 请求 spring-cloud-config-server http api 获取配置

   GET http://localhost:8001/assad-config/local
   GET http://localhost:8001/assad-config/dev
   GET http://localhost:8001/assad-config-release.properties

3. ```
   
   ```

3. 请求 spring-cloud-config-client 测试客户端获取配置

   GET http://localhost:8002/hello

4. 修改 Git 远程 assad-config-dev.properties 中 assad.hello 键内容，refresh 客户端配置：

   POST http://localhost:8002/actuator/refresh

   请求客户端配置查看配置变更：

   GET http://localhost:8002/hello

5. Github 配置仓库 Push Webhook 到 client refresh api，推送后请求 http://localhost:8002/hello 查看键值自动刷新

