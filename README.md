# isi
## 信息系统集成大作业

### 技术栈
Maven 3.6.1 
java 11 
tomcat 7
ajax
MySQL 8.0.16

### 模块
1. dao : 数据库层
2. commons ： 通用层
3. web ： 网络接口
4. third：onenet http接口
5. devices ：终端设备

数据库文件为isi.sql

### 运行
1. 在isi目录下运行`mvn clean install`，下载项目依赖包
2. 在web目录下运行`mvn tomcat7:run`,运行web项目，访问<http:localhost:8090/main>
3. device下是仿真设备，需要将isi导入Idea后运行device下的APP文件

