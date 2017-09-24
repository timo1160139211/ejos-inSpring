# ejos-inSpring
ejos instance in spring+springMVC+MyBatis

## EJOS-JudgeOnlineSystem - inSpring 

实验在线评估系统：
    (大)学生实验/课程设计 在线评估。  

## 环境
- Spring **4.3.5**
- Mybatis **3.4.5**
- Maven **3.5.0**
- PostgreSQL **9.4** 
- Tomcat **7**
 

## 如何运行

#### 一：
  需要首先在wildfly中建立postgresql数据源，参考：
  
- http://dz.sdut.edu.cn/blog/subaochen/2016/11/wildfly%E9%85%8D%E7%BD%AEpostgresql%E6%95%B0%E6%8D%AE%E6%BA%90/
         
- http://blog.csdn.net/timo1160139211/article/details/70490210

#### 二：

finally tpye command in console：
  mvn clean package tomcat7:deploy

## 如何参与

PR
