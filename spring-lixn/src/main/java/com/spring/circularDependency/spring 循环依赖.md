# 1 什么是循环依赖？

从字面上来理解就是A依赖B的同时B也依赖了A，就像下面这样：

![image-20200811213745992](C:\Users\86187\AppData\Roaming\Typora\typora-user-images\image-20200811213745992.png)

代码实现如下：

```java
@Component
public class BeanA {

   @Autowired
   private BeanB beanB;
}

@Component
public class BeanB {

	@Autowired
	private BeanA beanA;
}

或
    
    
@Component
public class BeanA {
	@Autowired
	private BeanA beanA;
}
```

# 2 什么情况下循环依赖可以被处理？

Spring 解决循环依赖是有前置条件的：

1. 出现循环依赖的Bean必须要是单例的
2. 依赖注入的方式不能全是构造器注入的方式（很多博客上说，只能解决setter方法的循环依赖，这是错误的）

```java
@Component
public class BeanA {
	public BeanA(BeanB beanB){}
}


@Component
public class BeanB {
	public BeanB(BeanA beanA){}
}

Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'beanA': Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'beanB': Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.BeanCurrentlyInCreationException: Error creating bean with name 'beanA': Requested bean is currently in creation: Is there an unresolvable circular reference?
Exception in thread "main" org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'beanA': Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'beanB': Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.BeanCurrentlyInCreationException: Error creating bean with name 'beanA': Requested bean is currently in creation: Is there an unresolvable circular reference?
```

为了测试循环依赖的解决情况跟注入方式的关系，我们做如下四种情况的测试:

| 依赖情况               | 依赖注入方式                                       | 循环依赖是否被解决 |
| ---------------------- | -------------------------------------------------- | ------------------ |
| AB相互依赖（循环依赖） | 均采用setter方法注入                               | 是                 |
| AB相互依赖（循环依赖） | 均采用构造器注入                                   | 否                 |
| AB相互依赖（循环依赖） | A中注入B的方式为setter方法，B中注入A的方式为构造器 | 是                 |
| AB相互依赖（循环依赖） | B中注入A的方式为setter方法，A中注入B的方式为构造器 | 否                 |

从上面的测试结果我们可以看到，不是只有在setter方法注入的情况下循环依赖才能被解决，即使存在构造器注入的场景下，循环依赖依然被可以被正常处理掉。