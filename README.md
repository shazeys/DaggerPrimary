# DaggerPrimary
���ݸ��������д��dagger2��һ��demo
��ǩ���ո�ָ����� dagger2 ����

---
### ����
>Dagger2 ��һ��Android����ע���ܣ��ɹȸ迪��������İ汾Dagger1 ��Square��˾����������ע������Ҫ����ģ�������ߴ���Ľ�׳�ԺͿ�ά���ԡ�
>Dagger���ֲ���������������˼������ذ��;Dagger �� DAG-er������� DAG �����ݽṹ�е� DAG���������޻�ͼ(Directed Acyclic Graph)��Ҳ����˵��Dagger ��һ�����������޻�ͼ�ṹ������ע��⣬���Dagger��ʹ�ù����в��ܳ���ѭ��������

Daggerͨ��ע�������ɴ��룬�������ע�ⲻ��Ϥ�������ȿ���javaע���ά���ٿƣ�[javaע��](https://zh.wikipedia.org/wiki/Java%E6%B3%A8%E8%A7%A3)

����һ�仰���ᵽ�ˡ����ɴ��롱���Ҿ�����һ��Գ�ѧdaggerͦ��Ҫ�ġ�����dagger��ʱ����ʵ��д�Ľṹ�����ϵ��Ȼ���ɹ�����ʵ�־���Ĵ��루ͨ��Build������Ϊ�ոտ�ʼ��ʱ�򣬲������������ｫ�����������Ĺ���������

### ע��
����ֻ˵����Ҫ���ĸ�ע�⣺
>- @Provide������ע�ⷽ������עĳ���������͵�get���������������Ϳ��ò��ں���ᱻ�õ���
>- @Module������ע���ࣩ��������@Provide�ṩ�����ͣ���һ����װ�����ã�
>- @Component������ע���ࣩ��@Module�İ�װ������������ĳ����ʹ�ã�
>- @Inject������ע��������ڼ��������а�����@Provide����������ͬ���͡�

�Ҹ�������ϲ�����׵ı�����������԰��ӣ���������ɣ����ʲô�ڣ�@Inject���Լ���֪���ġ������ӵ�����ڣ�@Provider����Ҫ�Ž����ӣ�@Module���ģ���������ô������ģ���ݣ�Build�õ���DaggerXXComponent���Ѹ��ְ��ӵİ�����@Component���͹����ġ��������Ժü��ֿ�ζ�ü�����(���@Inject)�����ܾ���Ҫ�������ӣ�@Component=(modules={aModule.class,bModule.class��})���ˣ�

### ����
Project��build.gradle������£�
    
    dependencies {
        classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8'
    }
��module(app)��build.gradle�������������

    apply plugin: 'com.neenbedankt.android-apt'  
    
    dependencies {
        compile 'com.google.dagger:dagger:2.5'
        apt 'com.google.dagger:dagger-compiler:2.5'
        provided 'org.glassfish:javax.annotation:10.0-b28' //���androidȱʧ�Ĳ���javaxע��
    }

�������������Sync�󣬾Ϳ�������дdagger�Ĵ�����
### ʾ��

>*�����һ�����ز������Ĳ�����Ե��App���㷨�ǣ������ֶ�Ӧhashcode��ָ����������õ�һ��ֵ��˫��ֵ��Ӻ�ģ100�õ�Ե��ֵ����ֱ�ӵ���һ��bug��û��100�ֵ������ˡ���Ϊ������+1����ν�Ｋ�ط���0����100,100����0��*

���demoһ����6���࣬�ǳ������䣬�Ҿ��������һ����
**People**�������࣬һ������ĵ÷ֵı�����int������ratio����һ�����ݱ����͹�ϣֵ����÷ֵķ�����getScore(String name)����
**Man**���̳�People�࣬һ���вι��췽�����޲�Ĭ�ϱ������췽����
**Woman**���̳�People�࣬һ���вι��췽�����޲�Ĭ�ϱ������췽����
**PeopleModule**��һ�������ӡ�������������֡��ڡ���"����"��ע��@Module�����ڡ���ע��@Provides��
**PeopleComponent**��һ������������������Ҫ�Եġ��ڡ�����������ӡ�������һ��inject(MainActivity m)ָ����������������ڶ���
**MainActivity**��ֱ�ӿ� [����](https://github.com/shazeys/DaggerPrimary/blob/master/app/src/main/java/com/shazeys/yinyuan/MainActivity.java)

