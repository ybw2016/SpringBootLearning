# TransmittableThreadLocal示例
### 1. 测试接口（线程池类型）
- http://127.0.0.1:2001/thread-local
- http://127.0.0.1:2001/thread-local/async
- http://127.0.0.1:2001/inherit-thread-local/async
- http://127.0.0.1:2001/inherit-thread-local/thread-pool
- http://127.0.0.1:2001/transmit-thread-local/thread-pool

### 2. 测试接口（常用类型）
- http://127.0.0.1:2001/runnable
- http://127.0.0.1:2001/runnable-ttl
- http://127.0.0.1:2001/callable
- http://127.0.0.1:2001/callable-ttl

### 3. 测试接口（logback支持）
- http://127.0.0.1:2001/logback
- http://127.0.0.1:2001/logback/thread-pool

### 4. JavaAgent方式启动
##### 4.1 运行命令
java -Xbootclasspath/a:transmittable-thread-local-2.11.4.jar -javaagent:transmittable-thread-local-2.11.4.jar -jar spring-boot-inheritablethreadlocal-1.0.0.jar
java -javaagent:transmittable-thread-local-2.11.4.jar -jar spring-boot-inheritablethreadlocal-1.0.0.jar

##### 4.2 运行测试接口
http://127.0.0.1:2001/callable

注：此种方式需要将transmittable-thread-local-2.11.4.jar放到当前jar包同一目录;

### 5. 运行结果示例
### 5.1 运行结果示例（http://127.0.0.1:2001/callable）
testCallable ------- 当前线程：http-nio-2001-exec-1，ThreadLocal值：testCallable_Value
testCallable ------- 当前线程：pool-1-thread-1，ThreadLocal值：testCallable_Value

testCallable ------- 当前线程：http-nio-2001-exec-2，ThreadLocal值：testCallable_Value
testCallable ------- 当前线程：pool-1-thread-2，ThreadLocal值：testCallable_Value

testCallable ------- 当前线程：http-nio-2001-exec-3，ThreadLocal值：testCallable_Value
testCallable ------- 当前线程：pool-1-thread-1，ThreadLocal值：null

testCallable ------- 当前线程：http-nio-2001-exec-4，ThreadLocal值：testCallable_Value
testCallable ------- 当前线程：pool-1-thread-2，ThreadLocal值：null

### 5.2 运行结果示例（http://127.0.0.1:2001/callable Agent方式启动）
testCallable ------- 当前线程：http-nio-2001-exec-1，ThreadLocal值：testCallable_Value
testCallable ------- 当前线程：pool-1-thread-1，ThreadLocal值：testCallable_Value

testCallable ------- 当前线程：http-nio-2001-exec-2，ThreadLocal值：testCallable_Value
testCallable ------- 当前线程：pool-1-thread-2，ThreadLocal值：testCallable_Value

testCallable ------- 当前线程：http-nio-2001-exec-3，ThreadLocal值：testCallable_Value
testCallable ------- 当前线程：pool-1-thread-1，ThreadLocal值：testCallable_Value

testCallable ------- 当前线程：http-nio-2001-exec-4，ThreadLocal值：testCallable_Value
testCallable ------- 当前线程：pool-1-thread-1，ThreadLocal值：testCallable_Value

### 6. 参考链接
@CallMe兵哥  简书
https://www.jianshu.com/p/d542d2773f7b
