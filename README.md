# 打包并跳过测试
- mvn clean package -Dmaven.test.skip=true
- 打好的包在target目录下，sell.jar(pom.xml里修改了)

# 上传到服务器
- scp target/sell.jar root@192.168.199.139:/opt/javaapps

# 指定端口和环境启动
- java -jar -Dserver.port=8090 -Dspring.profiles.active=prod sell.jar

# 后台启动
- nohup java -jar sell.jar > /dev/null 2>&1 &

# 查看进程
- ps -ef |grep sell.jar

# 访问
- 192.168.199.139:8090/sell/buyer/product/list