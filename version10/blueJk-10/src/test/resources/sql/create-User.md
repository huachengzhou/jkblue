> mysql.version=5.7 (必须注意版本)
+ 1 创建bob用户 密码:07fa533360d9
* 2
CREATE USER 'bob'@'%' IDENTIFIED BY '07fa533360d9';

+ 1 创建test用户　密码123456
* 2 CREATE USER "test"@"localhost" IDENTIFIED BY '123456'
> 说明:'%' - 所有情况都能访问'localhost' - 本机才能访问'111.222.33.44' - 指定 ip 才能访问

## 授权test用户拥有testDB数据库的所有权限
```
create database testDB;
grant all privileges on testDB.* to "test"@"localhost" identified by '123456'

```

## 修改用户密码
```
update mysql.user set authentication_string=password('123456') where User='blake' and Host='localhost';
```
> 关于修改密码也可以这样
> 1:select password('1234'); 得到string 如1234==>*A4B6157319038724E3560894F7F932C8886EBFCF
```
update mysql.user set authentication_string="*A4B6157319038724E3560894F7F932C8886EBFCF" where User='bob' and Host='localhost';
```

## 删除用户bob
```
delete from user WHERE User='bob'
```

## 指定部分权限给用户
```
grant select,update on testDB.* to "blake"@"localhost" identified by '123456';
```
## 刷新系统权限表
```
flush privileges; 
```
