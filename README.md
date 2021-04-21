# 原神玩家信息查询

可以通过 UID 查询玩家的一些基本资料。

### 目的
后端技术选的 Spring Boot。

该项目的[前端](https://github.com/BDZGanzi/GI-frontend)。

### 部署

#### application.yml

```yml
spring: 
  application: 
    name: ${APP_NAME:Genshin Impact Project}
  datasource:
    url: jdbc:hsqdb:file:testdb
    username: sa
    password:
    driver-class-name: org.hsqldb.jdbc.JDBCDriver
    # HikariCP
    hikari:
      auto-commit: false
      connection-timeout: 3000
      validation-timeout: 3000
      max-lifetime: 60000
      maximum-pool-size: 20
      minimum-idle: 1

server:
  port: ${APP_PORT:8080}

# your cookies
genshin:
    bbsheader:
      # ds: 米游社主要是通过请求头里的这个字段进行验证
      # cookies: 米游社APP请求的 cookies
      x-rpc-app-version: "2.2.1"
      x-rpc-client-type: 5
      x-requested-with: "com.mihoyo.hyperion"
      sec-fetch-site: "same-site"
      sec-fetch-mode: "cors"
      sec-fetch-dest: "empty"
      referer: "https://webstatic.mihoyo.com/"
      accept-encoding: "gzip, deflate"
      accept-language: "zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7"
      origin: "https://webstatic.mihoyo.com"
      accept: "application/json, text/plain, */*"
      user-agent: "Mozilla/5.0 (Linux; Android 9; ONEPLUS A5000 Build/PKQ1.180716.001; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/85.0.4183.127 Mobile Safari/537.36 miHoYoBBS/2.5.1"
```

### 截图

玩家基本信息：
![基本信息](https://files.catbox.moe/lbf36z.png)

玩家所拥有的角色：
![角色人物](https://files.catbox.moe/5mjwjg.png)

