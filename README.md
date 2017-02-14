###Java高并发秒杀系统API

个人博客：http://www.jianshu.com/u/0cb624d78376
####参考
慕课网秒杀系统的视频教程重新总结了自己使用SSM开发项目的经历,并从写实现。

####开发环境
IDEA+Maven+SSm框架

####功能简述
一个高并发秒杀商品,用户需安装提示窗口输入手机号，并在开发秒杀的时间内可以进行秒杀，如未到开始秒杀时间则显示时间倒计时，如已过了秒杀时间则显示秒杀结束。

####使用到的技术
- Maven
- Spring（IOC DI 声明式事务处理）
- SpringMVC（支持Restful风格）
- Mybatis（使用mapper实现Dao接口）
- Redis缓存（Protobuf序列化）
- c3p0（连接池)
- 统一的异常处理
- bootstrap(页面框架)
- jquery

####架构图：
![](https://github.com/joshul/image/blob/master/seckill/seckill01.png)

####实现过程

- 1.[Java高并发秒杀APi之业务分析与DAO层](http://www.jianshu.com/p/46ad8e8742aa) 
- 2.[2.Java高并发秒杀APi之Service层](http://www.jianshu.com/p/c0d468f1e66d) 
- 3.[3.Java高并发秒杀APi之web层](http://www.jianshu.com/p/712263a89d52) 
- 4.[4.Java高并发秒杀APi之高并发优化](http://www.jianshu.com/p/bc9fd7a2649a) 


####页面展示：

#####秒杀列表页面
![](https://github.com/joshul/image/blob/master/seckill/seckill02.png)
#####输入电话页面
![](https://github.com/joshul/image/blob/master/seckill/seckill07.png)
#####秒杀成功页面
![](https://github.com/joshul/image/blob/master/seckill/seckill04.png)
#####秒杀结束页面
![](https://github.com/joshul/image/blob/master/seckill/seckill05.png)
#####等待秒杀成功
![](https://github.com/joshul/image/blob/master/seckill/seckill06.png)
