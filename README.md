# My first spring project

## 资料
    
[Spring文档](https://spring.io/guides)

[github](https://github.com)

[git文档](http://git-scm.com/download)

[git_help文档](https://help.github.com/en/github/authenticating-to-github/checking-for-existing-ssh-keys)

[boolstrap组件](https://v3.bootcss.com/components/#navbar-default)

[github 授权登录流程](https://developer.github.com/apps/building-oauth-apps/)

[github 授权登录流程 doc](https://developer.github.com/apps/building-oauth-apps/authorizing-oauth-apps/)

[H2 database in Maven](https://mvnrepository.com/artifact/com.h2database/h2/1.4.199)

[h2 quickstart](http://www.h2database.com/html/quickstart.html)

[MySQL 菜鸟教程](https://www.runoob.com/mysql/mysql-tutorial.html)

[Java 注解（Annotation)](https://www.runoob.com/w3cnote/java-annotation.html)

[Spring boot mybaies](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#boot-features-embedded-database-support)   

## tool 
[Git](https://git-scm.com/download)

[Visual Paradigm](https://www.visual-paradigm.com) 
  
## IDEA 快捷键
      //ctrl alt v 自动生成变量定义
      //shift F6 批量修改全部选中的变量名
      //shift enter 从任意位直接换到下一行
      //alt insert 快速生成
      
## spring boot 必要的pom.xml 文件内容
    <porject>
        必须继承springboot 的父级依赖，该项目才为spring boot项目
        <parent>
                <groupId>org.springframework.boot</groupId>
                一个特殊的启动器，提供默认的Maven依赖，常用包依赖的version 可以省去
                使用starter 添加jar 包，非常方便
                <artifactId>spring-boot-starter-parent</artifactId> 
                <version>2.2.3.BUILD-SNAPSHOT</version>  选择版本
                <relativePath/> <!-- lookup parent from repository -->
        </parent>
        
        <dependencies>
                web 启动器依赖,提供支持开发web
                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-web</artifactId>
                </dependency>
                
                ？？单元测试
                <dependency>
                            <groupId>org.springframework.boot</groupId>
                            <artifactId>spring-boot-starter-test</artifactId>
                <!--			<scope>test</scope>-->
                            <exclusions>
                                <exclusion>
                                    <groupId>org.junit.vintage</groupId>
                                    <artifactId>junit-vintage-engine</artifactId>
                                </exclusion>
                            </exclusions>
                </dependency>
        </dependencies>
         <!-- spring boot 打包 插件 -->   必须添加
             可以将spring boot应用程序打包成jar 包的插件,将所有启动应用所需的jar包都包含经历啊，从逻辑上具备了独立运行的条件
              mvn package 命令打包
              java -jar 命令运行
         
            <build>
                <plugins>
                    <plugin>
                        <groupId>org.springframework.boot</groupId>
                        <artifactId>spring-boot-maven-plugin</artifactId>
                    </plugin>
                </plugins>
            </build>
                    
     </porject>   	
      

## 如何启动spring boot 项目
> 启动类：放置在项目Java文件的更目录下，如HelloApplication 的位置

    spring boot的启动类的作用是启动项目，基于Main方法运行
    启动类在启动时做注解臊面，扫描位置为同包或者子包的注解，启动类应该防御包的根目录下
    
    启动类上必须有 @SpringBootApplication的注解
    @SpringBootApplication
    public class HelloApplication {
    	public static void main(String[] args) {
    		SpringApplication.run(HelloApplication.class, args);
    	}
    
    }
    
> 启动类是项目的启动入口

> 启动器是表示 jar 包的坐标

    spring-boot-starter 官方提供了44个启动器
    spring Boot将功能场景抽取出来做成starter(启动器)，使用时导入非常方便
    spring-boot-starter   springboot 的核心启动器，包含了自动配置，日志和YAML
    
    spring-boot-starter-actuator  帮助监控和管理应用
    
    spring-boot-starter-web    支持全栈的Web开发，包括Tomcat和spring-webmve
    
    spring-boot-starter-amqp  通过spring-rabbit来支持AMQP协议
    
    spring-boot-starter-aop 支持面向切面的编程（AOP），包括spring-aop 和AspectJava
    
> 配置文件 application.properties 或 application.yml(常用)/application.yaml

    同意目录下有两种配置文件先读取.properties，同一属性都配置了，只读取第一次读到的，后读的配置数据不覆盖第一个
    
    配置文件存放路径：4种   优先级由高到低，config的相对较高
    当前项目的根目录的/config文件下(如项目根目录所示)
    当前项目的根目录下
    项目的resources 目录的/config文件下(如项目resources 目录所示)
    项目的resources 目录下（一般情况下）
    
    
    spring-boot-starter 识别配置文件，yaml,而且其他的形如spring-boot-starter-的均包含改启动器不用再次引入
    application.properties    resources 目录下
    
    server.port=8888  tocat 监听端口
    server.host=8877 
    
    .yml 文件中  大小写敏感，缩进表示层级关系，相同部分只出现一次，例如server；较常用？？？
            server:
                port: 8888     冒号后必须有空格
                host: 8877
    使用配置文件中的数据时，需要用@Value 注解注入
     @Value("${github.client.secret}")
        private String clientSecret;
        
     占位符
     语法 ${}
     random.int 随机生成int   
     
     ${random.int}
     ${random.long}
     ${random.value} 类似UUID的随机数，没有‘-’连接
     ${random.uuid}  UUID的随机数，没有‘-’连接
     ${random.int(10)} 10以内的
     ${random.int(100,200)} 一百到两百之间的
    
> bootstrap 配置文件，文件位置与application的相同，一般放在rescoues文件下

     spring boot有两种上下文对象，bootstrap和application，上下文共用同样的环境
     bootstrap是应用程序的父 上下文，sorin优先于application加载
     bootstrap 主要用于加载从额外的资源加载配置，还可以在本地文件中解密属性，外部属性来源
     ！！！bootstrap 的属性优先加载，默认不能被本地的相同配置覆盖
     
    配置文件特征
    bootstrap 由父ApplicationContext加载，比application优先
    bootstrap 默认不能被本地的相同配置覆盖
    
    应用场景
    application主要用于springboot项目的自动化配置
    bootstrap:
        Spring Cloud Config 配置中心时，加载外部配置中心的配置信息
        一些固定的不能被覆盖的属性
        加密解密的场景
    
> springboot 核心注解

    @SpringBootApplication == @SpringBootConfiguration 
                            + @EnableAutoConfiguration
                            + @ConponentScan 的组合
                            + @ConfigurationPropertiesScan 2.2.0版本以后加入的
    
    @SpringBootConfiguration    @Configuration 注解的派生注解，和@Configuration
                                的注解功能一直，标注这个类为一个配置类
                                @SpringBootConfiguration 是 springBoot 的注解
                                @Configuration   是 spring 的注解
                                
    @Configuration 通过对bean    对象的的操作代替 spring 中的XML文件
    
    @EnableAutoConfiguration    spring boot 自动配资（auto-configuration）:根据jar
                                依赖配置spring 应用
                             
                                是@AutoConfigurationPackage和
                                @Import(AutoConfigurationImportSelector.class)注解的组合
                                
    @AutoConfigurationPackage   自动注入主类包下所有的加了注解的类（@Controller，@Service等），
                                以及配置类（@Configuration），其余的不能扫描到
                                
    
    @Import(AutoConfigurationImportSelector.class)   //括号内为一个例子，符合第二条
                                直接导入普通的类
                                或实现了ImportSelector 接口的类
                                或实现了ImportBeanDefinitionRegistrar 接口的类
                             
    @ComponentScan              组件扫描，可以制动发现和装配一些Bean
    
    @ConfigurationPropertiesScan    扫描配置(对象）属性(不是配置文件)
                                    包含@EnableConfigurationProperties 作用是使
                                    @ConfigurationProperties 注解类生效
                                    （加载配置文件，通过前缀定义，配置文件信息封装到Bean对象当中？？？疑问）

## admit 具体提交信息
> 2020.5.30 21.51

     一些问题，main可能会执行两边，里边的UserMapper 无法正常使用，报空指针异常，DB Browser刷新数据显示不及时
    集成了mybaties ,连接了mysql,成功写入数据，增加了mysql pom.xml文件，测试通过！

> 2020.5.31
       

## use git
### 创建本地仓库
#### git的最小配置
    设置用户名和邮箱
    git config --global user.name "your_name"
    git config --global user.email "your_email"
    //user.name "your_name" 这个之间没有等号，只为空格
    
    git config --local //
    git config --gloabl //
    git config --system //
    
    git config --local --list//
    git config --gloabl --list//
    git config --system --list//
    
    pwd
    
    alice.name = cmd
    
    //创建本地的git仓库
    
    cd 已有项目所在的文件夹
    git init
    
    cd 某个文件夹
    git init your_project
    cd your_project
    
    //为某个仓库设置,局部设置屏蔽全局设置
    git config --local user.name "your_name"       
    git config --local user.email "your_email"
    
    cp 被拷贝文件路径 拷贝文件路径
    
    git add 文件名 //将文件提交到缓存区，由git管理
    git add -u //git 管理的全部提交到暂存区
    git rm  文件名//删除文件
    git commit -m"提交理由（可省略）" 
    git commit --amend --no-edit  //追加
    
    //工作目录-git add files>暂存区-git commit> 历史版本
    
    git status //git的管理状态
    
    //rename example readme -> readme.md
    git mv readme readme.md//√
    
    mv readme readme.md//×
    git add readme.md
    git rm readme
    
    git reset --hard //清理掉工作路径和暂存区中的内容
    
    git log
    git log --oneline
    git log --n4 //最近的四次提交
    git log //查看当前分支
    git checkout -b temp 提交文件可识别的哈希值//创建分支
    git log --all
    git log --all --graph
    
    git log --oneline --all -n4 --graph
        
    git branch -av //查看git分支
    gitk //打开图形界面
    
    
    dir .git 查看文件，类似于ls
#### 探索.git 目录 
    git cat-file -t 哈希值//查看类型 commit tree blob
    git cat-file -p 哈希值//查看内容
    HEAD 所在的分支
    config 配置信息
    refs 应用和tags
    objects 对象
    
 > 文件内容相同即为相同的blob 
    
 ### git对象的存储关系
    commit:一个commit对应一颗树，为所有文件的快照
        tree
        parent
        author
        committter    
        
    tree：可以看做为文件夹，文件夹也为树
        tree 
        blob:tree 中包含 blob
        
    blob：具体的文件；文件内容相同，blob只有一个，与文件名无关
    
    find .git/objects -type -f
    FIND: 参数格式不正确

> 分离头指针：要做变更就要与某个分支（branch）挂钩，否则不安全
> 12分离头指针的情况下的注意事项

    工作在没有分支的情况下，git对commit产生变更，切换分支后，commit没有对应的branch和他挂钩，
    这些变更可能会被git当做垃圾清除掉
    尝试性的变更，可以不用挂钩branch，不需要就切换分支，丢掉不用的
    
    git checkout -b 分支名 分支来源  // 可以创建分支，切换分支
    
    git diff commit_1 commit_2 //比较commit_1 和commit_2 的差异
    git diff HEAD HEAD~1(^1)[/HEAD~2(^^)]
    git diff //工作区与暂存区比较
    git diff --cached//暂存区与HEAD比较
    
    git branch -d 分支名 // 删除分支
    git branch -D 分支名 // 
    
    git branch -av//显示所有分支
   
    git commit --amend --no-edit 追加到上次的
    git push
    
    git commit --amend //变更最近一次提交的commit的message
    git rebase -i commit号//   协同不要轻易使用,选择父亲的commit号
    
    git rebase -i      //交互式，内部有相应的选项，变基操作

    git reset HEAD//取消暂存,恢复和HEAD一样
    git reset HEAD -- 文件名//某文件恢复和HEAD对应的文件一样
    git checkout -- 文件名//从暂存区恢复某文件到工作区
    
    git reset --hard 恢复到某commit//恢复的commit，删除该commit之后的commit,暂存区，工作区同时
    
    git stash//暂存工作区
    git stash list//查看stash
    git stash apply//恢复工作区
    
## 备份
    git push //推
    git fetch //拉
    git pull //fetch merge合并
    git merge --allow-unrelated-histories// 允许不相干的树合并 
    
    
    git clone --bare  路径//克隆裸仓库，file://路径，智能协议
    git push --set-upstream 分支名 变更人
    git remote -v //协议版本    remote 远端
    git remote add github git@github.com:DustMerlin/TheFirstSpringBootExample.git
   
    git checkout -b 本地分支 远端依赖分支//创建切换到新分支

    
        
    
    
    
    
    生成SSH公钥和秘钥，方便通过git提交到github的仓库中
    
