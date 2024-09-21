# 易错

1、在 `com.example.videocall.VideoCallApplication` 启动文件中，记得要加上这条代码
	   主要是为了 与数据库进行交互的组件 ， 一般存放的都是接口

```java
// 扫描DAO层
@MapperScan("com.example.videocall.dao")
```

![](./pic/1.png)