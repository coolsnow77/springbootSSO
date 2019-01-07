测试思路：
## 1. 创建数据库ssodemo2，修改数据库连接信息及redis 连接信息.

## 2. 注册用户，执行itdragon-sso 项目下SpringbootStudyApplicationTests.java 单元测试类中的 registerUser() 方法添加用户。
## 3. 开启itdragon-sso服务，打成war 包放在tomcat 容器下运行.
## 4. 再开启两个itdragon-service-test-sso服务。
## 5. 在itdragon-service-test-sso服务页面点击“ITDragon”按钮进入权限页面测试。
## 6. 思路来源拷贝: https://www.cnblogs.com/zzp0320/p/8109327.html 项目来源，并补充部分实现， 参考https://www.cnblogs.com/ywlaker/p/6113927.html 实现部分逻辑.
## 7. 部分host 配置
> # 8081
> 127.0.0.1  sso.server.com
> # 8082
> 127.0.0.1  sso.client1.com
> # 8083
> 127.0.0.1 sso.client2.com
## 8. 环境配置
> java8 环境.
