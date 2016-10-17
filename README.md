# DaggerPrimary
根据个人理解所写的dagger2的一个demo
标签（空格分隔）： dagger2 初级

---
### 概念
>Dagger2 是一个Android依赖注入框架，由谷歌开发，最早的版本Dagger1 由Square公司开发。依赖注入框架主要用于模块间解耦，提高代码的健壮性和可维护性。
>Dagger名字不光是像它字面意思那样：匕首;Dagger 即 DAG-er，这里的 DAG 即数据结构中的 DAG——有向无环图(Directed Acyclic Graph)。也就是说，Dagger 是一个基于有向无环图结构的依赖注入库，因此Dagger的使用过程中不能出现循环依赖。

Dagger通过注解来生成代码，如果对于注解不熟悉，可以先看看java注解的维基百科：[java注解](https://zh.wikipedia.org/wiki/Java%E6%B3%A8%E8%A7%A3)

上面一句话中提到了“生成代码”，我觉得这一点对初学dagger挺重要的。运用dagger的时候，其实是写的结构，搭建关系，然后由工具来实现具体的代码（通过Build）。因为刚刚开始的时候，并不能在脑子里将各个类清晰的关联起来。

### 注解
这里只说最主要的四个注解：
>- @Provide（用于注解方法）标注某个返回类型的get方法，声明该类型可用并在后面会被用到；
>- @Module（用于注解类）用来包含@Provide提供的类型，起到一个包装的作用；
>- @Component（用于注解类）把@Module的包装集合起来，供某个类使用；
>- @Inject（用于注解变量）在集合中所有包含的@Provide进来的找相同类型。

我个人总是喜欢粗俗的比喻，饿了想吃包子，点个外卖吧：想吃什么馅（@Inject）自己是知道的。而包子店里的馅（@Provider）是要放进包子（@Module）的，包子是怎么到手里的？快递（Build得到的DaggerXXComponent）把各种包子的包裹（@Component）送过来的。如果你想吃好几种口味好几种馅(多个@Inject)，可能就需要买多个包子（@Component=(modules={aModule.class,bModule.class…})）了；

### 配置
Project的build.gradle添加如下：
    
    dependencies {
        classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8'
    }
在module(app)的build.gradle添加如下两处：

    apply plugin: 'com.neenbedankt.android-apt'  
    
    dependencies {
        compile 'com.google.dagger:dagger:2.5'
        apt 'com.google.dagger:dagger-compiler:2.5'
        provided 'org.glassfish:javax.annotation:10.0-b28' //添加android缺失的部分javax注解
    }

添加以上配置且Sync后，就可以着手写dagger的代码了
### 示例

>*这个是一个严重不正经的测试姻缘的App，算法是：将名字对应hashcode按指定比例计算得到一个值，双方值相加后模100得到缘分值，这直接导致一个bug：没有100分的两个人。因为我懒得+1，所谓物极必反，0就是100,100就是0。*

这个demo一共就6个类，非常的袖珍，我就逐个介绍一下了
**People**：数据类，一个计算的得分的比例的int变量（ratio）；一个根据比例和哈希值计算得分的方法（getScore(String name)）；
**Man**：继承People类，一个有参构造方法和无参默认比例构造方法；
**Woman**：继承People类，一个有参构造方法和无参默认比例构造方法；
**PeopleModule**：一个“包子”，里面包了四种“馅”，"包子"标注了@Module，“馅”标注了@Provides；
**PeopleComponent**：一个“包裹”，根据需要吃的“馅”来打包“包子”，包含一个inject(MainActivity m)指定所伴随的生命周期对象。
**MainActivity**：直接看 [代码](https://github.com/shazeys/DaggerPrimary/blob/master/app/src/main/java/com/shazeys/yinyuan/MainActivity.java)

