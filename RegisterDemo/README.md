#### 数据库创建结构

```
CREATE TABLE `user`  (
  `uid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `birthday` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
```

#### 接口列表
|接口|描述|
|-|-|
|/login|用户登录|
|/registerServlet|用户注册接口|

```
 <servlet>
        <servlet-name>RegisterServlet</servlet-name>
        <servlet-class>register.RegisterServlet</servlet-class>
    </servlet>
    <servlet>
        <servlet-name>LoginServlet</servlet-name>
        <servlet-class>login.LoginServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>RegisterServlet</servlet-name>
        <url-pattern>/registerServlet</url-pattern>
    </servlet-mapping>
    <servlet-mapping>
        <servlet-name>LoginServlet</servlet-name>
        <url-pattern>/login</url-pattern>
    </servlet-mapping>
```