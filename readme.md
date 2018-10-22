## <-----yankunのdemo----->

1.springboot2.0 + mybatis + pageHelper + 通用mapper + swagger (http://127.0.0.1:8887/swagger-ui.html)

2.typeHandle -- 将bean中的枚举转化为int存入数据库

3.redis -->RedisTemplate StringRedisTemplate fastJson序列化解析器


## 结构说明：
``` java
common 模块是公用的实现和工具代码。
centermanage-facade 模块是提供服务 一般是 dbbo提供方服务等。
service 模块是service服务和具体实现。
web 模块是提供http的具体实现。
dal 模块是数据访问层公用的mapper以及model。
```
## 注意事项：
``` java
1.保存使用save开头 修改 update 查询 select 删除delete  获取单个对象的方法用get做前缀  获取多个对象的方法用list做前缀 获取统计值的方法用count做前缀。<br>
2.Controller 里面的东西必须try catch  避免导致前端无法接受到数据返回<br>
3.错误信息 必须是 返回  Result.error(XXX)， XXX是ErrorCodeConstants 里面定义的东西代码有问题 前端统一编码和错误信息;<br>
4.To实体如果有存在分页功能要继承 common 里面的 page类<br>
5.service模块入参同意 to 返回参数 数据库实体 VO实体在Controller 转换<br>
6.在类和方法上面增加注释说明<br>
```