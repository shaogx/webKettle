

#  **JingWeiETL** 

    精卫ETL平台，创造性的将平台构建为B/S架构的ETL模型设计以及集成用户专业调度管理的分布式ETL建模运维系统。
    系统分为七大模块:模型、平台、任务、定时调度、日志、节点、用户.
    模型模块进行ETL模型开发，在B/S系统中用拖拽的方式设计数据流逻辑。
    接下来的其他六个模块为用户专业调度管理系统,更多是面向业务运维人员，关注于整个流程的执行情况和数据的导入导出细节信息,以及对任务的综合调度。完全支持集群和单机两种运行模式。并通过用户权限的管控让平台的资源分配变得更加专业。

# 说明
1. 本系统采用单资源库模式，数据源连接在dispatch-servlet.xml中配置，系统启动后就会读取该资源库
2. 数据库脚本都在kettle-scheduler项目的scripts目录下
3. 数据库暂时只支持MySQL，本系统在MySQL5.5.20版本上测试，其他版本尚未测试
4. 本例使用Maven3.2.3构建，启动服务器后访问http://localhost:8080/
5. 支持IE9及以上、FireFox等浏览器，IE6-IE8需要做特殊化处理，其他浏览器未测试

# 许可证
    test