# VR-Train backend

### 1. 修改Mysql配置

- 新建数据库vrtrain，修改
`src/main/resources/application.yml`中的相关配置：
```
url: jdbc:mysql://localhost:3306/vrtrain?serverTimezone=GMT%2b8 #数据库名为vrtrain
username: root          # 数据库用户名
password: 123456        # 数据库密码
```
- 在数据库中导入`sql/sys_user.sql`、`sql/question.sql`、`sql/answer.sql`三张表。


### 2. 启动springboot项目
- 默认端口号`9090`
- 用户名`admin`， 密码`123456`
