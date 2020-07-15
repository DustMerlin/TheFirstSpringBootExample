# My first spring project

## MySQL 问题
    时区 set global time_zone = '+8:00';
    
    
    properties参数设置
    连接  serverTimezone=UTC
    字符  characterEncoding=utf8
          useUnicode=true
        
        
          
     password expire:用来设置用户口令过期，失效，强制用户登录数据库时候必须修改口令.
     
     create user zhou7–用户名 
     identified by zhou7777–口令 
     default tablespace users–默认表空间 
     temporary tablespace temp–临时表空间 
     password expire;
     ————————————————
     版权声明：本文为CSDN博主「单身贵族男」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     原文链接：https://blog.csdn.net/zhou920786312/java/article/details/72770645
    
> 使用ALTER USER命令修改用户的密码、密码过期，锁定，解锁          
          
    使用ALTER USER命令可以用来修改用户的口令,设置口令过期,锁定以及解锁用户等等。
    1、修改用户的口令，将用户的口令修改为新的密码
    ALTER USER SCOTT IDENTIFIED BY NEWPASSWORD;
    
    
    
    SQL> ALTER USER SCOTT IDENTIFIED BY SOCTT;
    用户已更改。
    
    2、设置用户口令过期，通过设置用户过期，这样该用户在下次登录的时候就必须要修改密码。
    ALTER USER SCOTT PASSWORD EXPIRE;
    
    SQL> ALTER USER SCOTT PASSWORD EXPIRE;
    用户已更改。
    
    
    3、锁定用户，将用户锁定之后，被锁定的用户是不能够再次登录到系统中。
    ALTER USER SCOTT ACCOUNT LOCK;
    
    
    
    SQL> ALTER USER SCOTT ACCOUNT LOCK;
    用户已更改。
    
    
    
    
    4、解锁用户，解锁用户的锁定状态。
    ALTER USER SCOTT ACCOUNT UNLOCK;
    
    
    
    SQL> ALTER USER SCOTT ACCOUNT UNLOCK;
    ————————————————
    版权声明：本文为CSDN博主「陈字文」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
    原文链接：https://blog.csdn.net/ziwen00/java/article/details/8460754

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

[thymeleaf](https://www.thymeleaf.org/)


## tool 
[Git](https://git-scm.com/download)

[Visual Paradigm](https://www.visual-paradigm.com) 




# 2020.7.15 日所学内容
> 整合Servlet（不推荐），Thymeleaf的使用（重点）

## 整合Servlet
> 1.修改POM.xml文件，添加JSP引擎和JSTL标签库

    spring boot 内置的tomcat中没有JSP依赖,需要引入JSP引擎依赖
    
		<dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
		</dependency>
		
	添加JSTL坐标依赖
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
        </dependency>	
        

> 2.创建webapp目录

    webapp目录需要创建在main的根目录下，存放JSP,main/webapp/*.jsp
    main/webapp/WEB-INF  存放一些其他内容，不允许直接访问
> 3.标记为web目录
    
    在IDEA正版的Project Structure中设置即可
    
> 4.创建JSP

    #JSP配置视图解析器，spring boot默认为thymeleaf页面
    #页面默认前缀目录
    spring.mvc.view.prefix=/WEB-INF/jsp/
    #页面默认后缀目录
    spring.mvc.view.suffix=.jsp
    #这个是关闭thymeleaf缓存
    spring.thymeleaf.cache=false　　　　
    #关闭thymeleaf模板
    spring.thymeleaf.enabled = false　
    
> 如果想上方这样设置，就不能正常访问rescources里的内容，而只能访问定义在/WEB-INF/jsp/里的内容

    web.xml
    <?xml version="1.0" encoding="UTF-8"?>
    <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
             version="4.0">
    </web-app>


    /*
        JSP页面跳转Controller
     */
    
    //页面跳转，需要视图解析器
    @Controller
    public class JspPageController {
    //    页面跳转
    
        @GetMapping("/{page}")
        public String showPage(@PathVariable String page){
            return page;
        }
    }

> 如果在IDEA中，项目结构为聚合工程，那么在运行jsp是需要指定项目路径的
    （sourses->java-idea->hello（本项目））这个地址，在运行按钮旁边的选中中，找到启动类，即可选择

    本项目可能不需要设置，因为不为聚合项目
    值得注意的是，在配置文件中的设置，导致rescoueces中的文件不能访问，只能访问当前jsp目录
    如果需要更改，记得要注释掉jsp整合时的文件


> 在IDEA中配置spring boot 对jsp页面的支持
    
    （1）pom增加依赖：
    
    <!--springboot tomcat jsp 支持开启-->
    <dependency>
           <groupId>org.apache.tomcat.embed</groupId>
           <artifactId>tomcat-embed-jasper</artifactId>
    </dependency>
    
    <dependency>
           <groupId>javax.servlet</groupId>
           <artifactId>jstl</artifactId>
           <scope>compile</scope>  //这块需要吗？大多数地方看到都是不需要的
    </dependency>
    
    （2）配置jsp的放置位置
    
    a.如果用的是yml配置，如下配置：
    
    spring:
        mvc:
           view:  
               prefix: /WEB-INF/jsp/ 
               suffix: .jsp
    
    b.如果用的是properties配置，如下配置：
    spring.mvc.view.prefix=/WEB-INF/jsp/
    spring.mvc.view.suffix=.jsp 
    spring.thymeleaf.cache=false　　　　//这个是关闭thymeleaf缓存
    spring.thymeleaf.enabled = false　 //关闭thymeleaf模板
    （3）springboot 利用工具搭建时，是没有webAPP等目录的，需要手动创建以下目录：
    （4）如上，已经是完成了。第四步，写个controller访问。注意别加注解@ResponeBody 或者@RestController

    @Controller
    public class IndexController {
        @RequestMapping("/index")
         public String index(){ 
          return "index";
          }
     }

    
    补充说明：由于本次配置使用的开发工具是IDEA，而该开发工具默认没有开启创建jsp页面的功能，所以需要使用者手动配置一下。配置步骤整理如下：
    左上角，file中点击project Structure项，在Modules选项卡中，找到本项目，在本项目下添加web。

    然后你会发现在创建的时候，可以直接创建JSP模版了


## spring boot 整合 Freemarker   （模板视图和thymeleaf类似） 
    
    <!--导入不了原因未知-->
    
## thymeleaf 
[thymeleaf](https://www.thymeleaf.org/)
    
    thymeleaf一个用于Web和独立环境的现代服务器端Java模板引擎。
    
    Thymeleaf的主要目标是带来优雅自然模板对于您的开发工作流程，
    -HTML可以在浏览器中正确显示，也可以作为静态原型工作，允许在开发团队中进行更强的协作。
    
    thymeleaf可以处理html,xml.js,css,甚至纯文本
    
    有了Spring框架的模块、与您最喜欢的工具的大量集成以及插入您自己的功能的能力，
    Thymeleaf是现代HTML 5 JVM Web开发的理想选择，尽管它可以做更多的事情。

> thymeleaf是原生的，不依赖于标签库，可以接受为html模板进行编辑和数据渲染，
           thymeleaf和servlet没有规范耦合，所以可以涉及jsp无法涉及的领域

    Thymeleaf为模板引擎，为html模板实现数据渲染，单体项目中需要视图层的较为适用
    
    前后端分离的项目，后端只需返回数据接口即可，对视图层的要求不高，
        Thymeleaf作用区别不大，在这种情况下

> Thymeleaf 导入启动器，使用标记进行数据渲染

    Thymeleaf启动器依赖添加
    
    <dependency>
    	<groupId>org.springframework.boot</groupId>
    	<artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>

    //！！！！！！如果在配置文件中，修改过默认配置为jsp文件件，一定要注释掉，切记！！！！！！
    
    templates 文件夹中的内容，不允许直接访问，只能使用Controller来跳转
    /*
       ThymeleafPageController
     */
    @Controller
    public class ThymeleafPageController {
    
        @GetMapping
        public String showPage(Model model){
            //此处的函数名一定不要打错了！！！ ！！！
            model.addAttribute("msg","Hello ThymeleafPageController");
            return "index";
        }
    }
    
    在html页面中，使用el表达式，将数据填入到页面当中
    <span th:text="${msg}"></span></br>


> Thymeleaf中页面的类el表达式，但是使用的限制较多——仅限于标签内，使用th:~~,其他格式都不能渲染相应的数据

    在html标签中该有以下的 命名空间xmlns:th="http://www.thymeleaf.org"
    <html xmlns:th="http://www.thymeleaf.org">
    
    th:text 在页面中输出值(渲染数据),标签内的值会替换一对标签之间的值
    <span th:text="${msg}">啊啊啊</span></br>    这里只显示${msg}的内容！！！
        
    
    th:value 可以将一个值放入到input标签的value中，且仅能使用th:value才能渲染数据
    <input th:value="${msg}">

> Thymeleaf 提供一些内置对象，课直接在模板中使用，这些对象是以#引用的

    使用内置对象的语法
    
    引用内置对象使用“#”
    大部分内置对象名称都以s结尾，如：strings字符串,numbers数字,dates日期
 
> strings   ${#strings.~(key)}
   
    ${#strings.isEmpty(key)} 返回key所对应的value是否为空，返回true或false
    
    ${#strings.contains(msg,'T')} 判断字符串中是否含有字符'T'
    
    ${#strings.startWith(msg,'T')} 是否以某子串开头，是返回true，否则返回false
    
    ${#strings.endWith(msg,'T')} 是否以某子串结尾，是返回true，否则返回false
    
    ${#strings.length(msg)} 返回字符串的长度
    
    ${#strings.substring(msg,2)} 从字符串2的位置截取到末尾
    
    ${#strings.substring(msg,2，5)} 从字符串2的位置截取到字符串5的位置
    
    ${#strings.toUpperCase(msg)} 转换为大写
    
    ${#strings.toLowerCase(msg)} 转换为小写
     
    
> dates  ${dates.~(key)}

    ${dates.format(key)}  日期数据格式化为浏览器默认语言格式
    ${dates.format(ket,'yyyy/mm/dd')}  以某种指定格式格式化日期数据
    ${dates.year(ket)}
    ${dates.month(ket)}
    ${dates.day(ket)}
    其余自行测试
    
> th:if 条件判断 
    
    example：
    <span th:if="${sex} == 'M'">男</span>
    <span th:if="${sex} == 'F'">女</span>
    
    
> th:switch/th:case  匹配显示内容，如果有多个内容匹配，则只显示第一个
> th:case="*" 则意为default 

    <div th:switch="${id}">
        <span th:case="1">id=1</span>
        <span th:case="2">id=2</span>
        <span th:case="3">id=3</span>
        <span th:case="*">id=default</span>
    </div>

> 在thymeleaf中所有数据都是使用字符串比较

> th:each="迭代器:迭代集合" 迭代器，用于循环遍历   th:text="${迭代器.属性名}" 可以去出相应的内容
    
    
    <table border="1" width="50%">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
        </tr>


        <tr th:each="t : ${list}">
            <th th:text="${t.id}"></th>
            <th th:text="${t.name}"></th>
            <th th:text="${t.age}"></th>
         </tr>
    </table>

> 迭代的状态变量 th:each="迭代器,迭代器状态对象:迭代集合"

        index:当前迭代器的索引从0开始
        count:当前迭代器的技术从1开始
        size:别迭代对象的长度
        odd/even:布尔值，当前循环是否是偶数/奇数 从0开始
        first:布尔值，当前循环是否是第一条，如果是返回true
        last:布尔值，当前循环是否是最后一条，如果是返回true
        
        <th th:text="${迭代器状态变量获取对象.上述属性}"></th>
    
> th:each="m:map" 迭代map ,迭代出来的m为对象的地址，使用.取到想要的内容
   
    th:text="${m.key} : ${m.value.id} : ${m.value.name}: ${m.value.age}"
    
> 操作域对象

   注入request对象 HttpServletRequest request
   
       @GetMapping("/index")
       public String hello(Model model,HttpServletRequest request){
       //request
           request.setAttribute("req","req");
       //session
           request.getSession.setAttribute("reqs","reqs");
       //context
           request.getSession().getServletCOntext().setAttribute("reqsc","reqsc");
           
           return "index.html";
       }
       
       
> 注意request均为#，session和context可以有两种方式，记得仔细辨别，加以区分

   HttpServletRequest req
   
        th:text="${#request.getAttribute('req')}"
        th:text="${#httpServletRequest.getAttribute('req')}"


   HttpSession reqs
    
        th:text="${session.reqs}"
        th:text="${#httpSession.getAttribute('reqs')}"


   HttpContext reqsc

        th:text="${application.reqsc}"
        th:text="${#servletContext.getAttribute('reqsc')}"


> URL 表达式  @{}  

    绝对路径，要带有协议
    th:href="@{http://www.baidu.com}"
    
    > 超链接controller使用GetMapping("/show")
    > 需要进行测试，此处暂无
   
    相对路径
        相对于当前项目的根目录
        th:href="@{/show}"
    
        相对于服务器路径的根目录
        th:href="@{~/访问项目的名称/项目名称下的资源}"

--- 

> URL中参数传递

    > 超链接controller使用GetMapping("/show")
    
    在普通格式的URL中传递参数
    @GetMapping("/show")
    public String show(String id,String name){
        System.out.println(id+":"+name);
        return "index";
    }
    
    //常规方式？ & 连接
    th:href="@{/show？id=1&name=merlin}"
    //最后的单引号该放在哪？？？？？？？
    th:href="@{'/show？id=' + ${id} + ’&name=merlin‘}"
     th:href="@{'/show？id=' + ${id} + '&name='+${name} }"
    //() ,使用逗号分隔
    th:href="@{/show(id=1,name=merlin)}"
    th:href="@{/show(id=${id},name=merlin)}"
    th:href="@{/show(id=1,name=${name})}"
    th:href="@{/show(id=${id},name=${name})}"
    
    
    
    
    restful 格式的URL中传递参数
    
    th:href="@{/show/{id}(id=1)}"
    @GetMapping("/show/{id}")
        public String show(@PathVariable String id){
            System.out.println(id+":"+name);
            return "index";
        }
        
    th:href="@{/show/{id}/{name}(id=1,name=merlin)}"
    @GetMapping("/show/{id}/{name}")
        public String show(@PathVariable String id,@PathVariable String name){
            System.out.println(id+":"+name);
            return "index";
        }
        
        
    //混合使用，id使用restful格式传递，name用常规方式传递
    //在括号中传递的，就可以直接使用el表达式来取值，在常规的地址中只能使用字符串拼接方式
    th:href="@{/show/{id}(id=1,name=merlin)}"
    th:href="@{/show/{id}(id=${id},name=merlin)}"
    th:href="@{/show/{id}(id=${id},name=${name})}"
    
    th:href="@{/show/{id}/{name}(id=1,name=merlin)}"
    th:href="@{/show/{id}/{name}(id=${id},name=merlin)}"
    th:href="@{/show/{id}/{name}(id=${id},name=${name})}"
    
    
> tymeleaf 配置文件
    
    //配置文件等号之间不要有空格，切记！！！ ！！！
    spring.thymeleaf.prefix=classpath:/templates/ 前缀路劲  此处默认templates目录下
    spring.thymeleaf.suffix=.html  后缀名    默认后缀名为.html
    spring.thymeleaf.mode=HTML5  配置视图模板类型，默认为HTML4？？？？？？
    spring.thymeleaf.encoding=utf-8 配置编码格式，默认utf-8
    spring.thymeleaf.servlet.content-type=text/html 响应视图类型默认为text/html
    //默认是true，开发时最好关闭缓存
    spring.thymeleaf.cache=false 配置页面缓存，默认为true
    
    


---




# 2020.7.14 日所学内容

> filter,listener,SpringBoot 访问静态资源,文件上传，配置上传容量

## filter
> 整合方式一：使用注解整合@WebFilter，@ServletComponentScan

    //@WebFilter(filterName = "firstFilter",urlPatterns = {"*.do","*.jsp"})
    @WebFilter(filterName = "firstFilter",urlPatterns = "/first")
    public class FirstFilter implements Filter{
    
        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            System.out.println("enter the first filter");
            filterChain.doFilter(servletRequest,servletResponse);
            System.out.println("left the first filter");
        }
    }
    
    filter 数据 servlet 的一个子技术，在启动类中有下方的注解
        @ServletComponentScan //在spring boot 启东时会扫描@WebServlet注解，并将该类实例化
        时可以处理filter
        
        
> 整合方式二：使用组件注册的方式

    /*
        整合方式二：使用组件注册的方式
     */
    
    public class SecondFilter implements Filter {
    
    
        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            System.out.println("enter the second filter");
            filterChain.doFilter(servletRequest,servletResponse);
            System.out.println("left the second filter");
        }
    }
    
    @Configuration
    public class FilterConfig {
    
        @Bean
        public FilterRegistrationBean getFilterRegistrationBean(){
            FilterRegistrationBean bean = new FilterRegistrationBean(new SecondFilter());
    //        bean.addUrlPatterns(new String[]{"*.jsp","*.do"});
    //        下方的url一定不要忘记加/
            bean.addUrlPatterns("/second");
            return bean;
        }
    }


## listener

> 整合方法一：注解@ServletComponentScan 
             //在spring boot 启东时会扫描@WebServlet,@WebFilter,@WebListener注解，并将该类实例化

    /*
        整合listener：注解@ServletComponentScan
        
     */
    @WebListener
    public class FirstListener implements ServletContextListener {
        @Override
        public void contextInitialized(ServletContextEvent sce) {
            System.out.println("Listener···Init···");
        }
    
        @Override
        public void contextDestroyed(ServletContextEvent sce) {
            System.out.println("Listener···Destory···");
        }
    } 
    
> 整合方法二：组件注册
    
    /*
        整合listener：组件注册方式
     */
    public class SecondListener implements ServletContextListener{
    
            @Override
            public void contextInitialized(ServletContextEvent sce) {
                System.out.println("ListenerSecond···Init···");
            }
    
            @Override
            public void contextDestroyed(ServletContextEvent sce) {
                System.out.println("ListenerSecond···Destory···");
            }
    }
    
    
    //注册类必须带有该注解@Configuration
    @Configuration
    public class ListenerConfig {
        //慎重使用自动补全的功能，很大程度会出现和函数重名或者不易察觉的不是自己预想中的名字
        //一定要谨慎，不然该错误很难排查，
        //如果重名了不可重载的函数或者重载了可重载的函数，都可能造成无法想象的错误
        @Bean
        public ServletListenerRegistrationBean getServletRegistrationBean(){
            ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean(new SecondListener());
    
            return bean;
        }
    }
    
    
## SpringBoot 访问静态资源

> src>resourses>static|templates

    static 目录存放静态页面，图片资源，静态资源必须存放在static目录下,可直接访问页面和内容
    templates 中只能存放Thymeleaf动态页面，不推荐使用jsp视图技术，默认使用Thymeleaf来做动态页面
            且需要Controller做跳转才可访问该文件下的页面！！！！
    
    
    在static 创建sb.html,http://localhost:8899/sb.html可直接访问
    也可在Controller中写明跳转地址，和访问什么跳转
    
    

> 此处可能直接定位到templates 文件夹，所以需要相对路径找到对应的static 切记！！！

> 而且return 时一定要带上后缀名，不然也无法跳转（可能是因为没有视图层解析的缘故） 切记！！！
    @Controller
    public class PageController {
    
        //GetMapping和RequestMapping  有什么区别
        @RequestMapping("/page")
        public String showPage(){
            System.out.println("this is sb");
            //此处可能直接定位到templates 文件夹，所以需要相对路径找到对应的static 切记！！！
            return "../static/sb.html";
        }
    }
    
    
> @GetMapping 和 @RequestMapping  注解的探索
    
    @GetMapping
    用于将HTTP GET请求映射到特定处理程序方法的注释。具体来说，@GetMapping是一个作为快捷方式的组合注释
    @RequestMapping(method = RequestMethod.GET)。
    
    @PostMapping
    用于将HTTP POST请求映射到特定处理程序方法的注释。具体来说，
    @PostMapping是一个作为快捷方式的组合注释@RequestMapping(method = RequestMethod.POST)。
    
    @RequestMapping:
    一般情况下都是用@RequestMapping（method=RequestMethod.），因为@RequestMapping可以直接替代以上两个注解，
    但是以上两个注解并不能替代@RequestMapping，@RequestMapping相当于以上两个注解的父类！
    
    类似的组合注解还有：
    @PutMapping、@DeleteMapping、@PatchMapping
    总结下来就是@PostMapping和@GetMapping都可以用@RequestMapping代替，
    如果读者怕在映射的时候出错，可以统一写@RequestMapping，当然这样写的话也有弊端，
    笼统的全用@RequestMapping, 不便于其他人对代码的阅读和理解！还是建议区分开来写！养成良好的代码习惯！
    ————————————————
    版权声明：本文为CSDN博主「private_static」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
    原文链接：https://blog.csdn.net/qq_41973208/java/article/details/85008962
    
    
## springboot 其他可存放静态资源地址

> 以下位置均可存放（未测试）,以下为默认访问及其顺序

    src/main/java/resources/META-INF/resources/
    src/main/java/resources/resourses/
    src/main/java/resources/static/
    src/main/java/resources/public/

> springboot 自定义目录访问

    在配置文件中，使用spring.rescources.static-locations=classpath:/suibian/
    这里修改了配置，则默认值则没有了，如果需要，
    则需要添加classpath:/suibian/,classpath:/static/  使用逗号分隔
    suibian/此目录为在src/main/java/resources/下创建的
    
    
## springboot 文件上传

> HTML   重点！！！！！！！！！！！！！

    action 为要访问的controller，可以没有"/",直接给出对应controller 中
    @PostMapping("/fileUploadController")中的名字，这里必须要有"/",
    method 为访问的方式，文件上传必须要有enctype="multipart/form-data"
     <input type="file" name="file"/> 这里的imput name必须和
     public String fileUpload(MultipartFile file)参数的名字一致！！！ ！！！
    <form action="fileUploadController" method="post" enctype="multipart/form-data">
            <input type="file" name="file"/>
            <input type="submit" value="submit" />
    </form>  

> java fileUploadController  
    
    这里可能spring boot直接包含了spring mvc 所以不需要去pom.xml文件中添加MVC的依赖文件
    //仅仅返回字符串，不返回网页,如果返回网页，使用@Controller，
        并且return 字符串必须为带后缀名的页面（templates中或者static中的）
    @RestController
    
    public class FileUploadController {
        //使用post 请求，所以使用@PostMapping("/fileUploadController")
            这里和HTML中的action一致，注意要有"/",action中可以没有
        @PostMapping("/fileUploadController")
        
        //此处的MultipartFile file变量名，必须和form表单中提交文件的name相同一致
            <input type="file" name="file"/> 这里的imput name必须和
            public String fileUpload(MultipartFile file)参数的名字一致！！！ ！！！     
        public String fileUpload(MultipartFile file) throws IOException {
            //获取真实文件的地址,getURL("src/main/resources/static/img"),参数最好为文件中的全路径，不然可能无法访问
            //在springboot 中 可能只有这一种方法管用 ResourceUtils.getURL("src/main/resources/static/img").getPath();
            //其余的getRealPath方法可能是容器运行地址，c/appdata/tomcat··· ，可能为这种样子的地址
            String basePath = ResourceUtils.getURL("src/main/resources/static/img").getPath();
            System.out.println(basePath);
            //E:/sources/Java_idea/hello/src/main/resources/static/img/
            //此处的路径最后是有"/",所以在文件创建前不用再添加
            //transferTo在页面中只能执行一次，如需多次上传不用位置，可以copy，再操作
            file.transferTo(new File(basePath+file.getOriginalFilename()));
            //@RestController 才能返回字符串
            return "OK";
        }
    }
> 修改文件上传的大小

    默认单个文件上传的大小为 1MB
    spring.servlet.multipart.max-file-size=2MB  去配置文件中这是传输文件大小
    默认一次请求中文件上传的总大小为 10MB
    spring.servlet.multipart.max-request-size=10MB（默认），文件的总大小
    
    
> 关于路径获取的详细回答

    以前spring mvc项目由于使用的是外部容器跑项目，所以使用request.getRealPath("./")方法是可以获取到静态资源路径的。
    但是spring boot获取的是内部容器的地址，如C:\Users\cjj\AppData\Local\Temp\tomcat-docbase.2424851108757135007.8088\
    
    我们无法使用request.getRealPath("./")获取静态页面资源。
    但是可以使用ResourceUtils.getFile方法，这样就可以读取模板文件
    ————————————————
    版权声明：本文为CSDN博主「canon_in_csdn」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
    原文链接：https://blog.csdn.net/canon_in_csdn/java/article/details/86685739

> java File 类型 转换成 MultipartFile(尚未测试)

    File file = new File("src/test/resources/input.txt");
    FileInputStream input = new FileInputStream(file);
    MultipartFile multipartFile = new MockMultipartFile("file",
    file.getName(), "text/plain", IOUtils.toByteArray(input));
    
    从国外网站上搜到的，IOUtils.toByteArray(input)不识别时，可直接使用上面  FileInputStream 类型的input做第四个参数也是可以的。
    亲测有效！
    
> 文件同时上传到两个路径下保存，使用了MultipartFile的transferTo()方法两次，第二次就报错了，应该怎么去解决
    
    未测试
    
    因为http post文件流只可以接收读取一次，传输完毕则关闭流。
    可以把流保存为文件1，然后对文件1进行复制，移动等操作。
    
    
    
# 2020.7.12 日所学内容

> 启动类，@Controller，注册整合Servlet

## 创建启动类
> src>java>包名>根目录下创建启动类
    
    @SpringBootApplication
    public class HelloApplication {
    
    	@Autowired
    	private static UserMapper userMapper;
    
    
    	public static void main(String[] args) {
    //		System.out.println("main");
    //		启动类中可能或者不能包含一些其他的内容，仅为启动内容？
    		SpringApplication.run(HelloApplication.class, args);
    	}
    
    }

> 创建controller
    
    @Controller 

    @RestController = @controller + @ResponseBody 所有页面不做任何跳转，只返回json格式的字符串
        @ResponseBody 以json格式的字符串为返回数据，
        
    官方文档：
    @RestController is a stereotype annotation that combines @ResponseBody and @Controller.
    意思是：
    @RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。
    1)如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面，
        配置的视图解析器InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。
        例如：本来应该到success.jsp页面的，则其显示success.
    2)如果需要返回到指定页面，则需要用 @Controller配合视图解析器InternalResourceViewResolver才行。
    3)如果需要返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解。

    ```java
    package com.Merlin.hello.controller;
    
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;
    
    //处理请求的Controller
    @RestController
    public class RequestController {
    
        @RequestMapping("/helloworld")
        public String showHelloWorld(){
            return "HelloWOrld!";
        }
    }
    ```
    
> controller得常用注解
    
    @RestController = @Controller + @ResponseBody 
        所有页面不做任何跳转（不返回页面，也无法传输数据到另一个页面），
        相当于在@Controller上加了@ResponseBody注解，
        所以InternalResource ViewResolver不起作用，
        只返回json格式的字符串（即return 中的内容）
        
        @ResponseBody 只返回json格式字符串数据
        
    @GetMapping 
        该注解是@RequestMapping(method=RequestMethod.Get)的缩写
        仅处理Get请求
        以下同理
        
    @PostMapping 
        该注解是@RequestMapping(method=RequestMethod.Post)的缩写    
        
    @PutMapping 
        该注解是@RequestMapping(method=RequestMethod.Put)的缩写
    
    @DeleteMapping 
        该注解是@RequestMapping(method=RequestMethod.Delete)的缩写
        
        
> Spring Boot整合Web层的技术
    
    整合Servlet方式一：通过注解扫描完成Servlet组件的注册（推荐使用）

    创建Servlet
    //urlPatterns = "/first"  此处的地址则为访问地址
    @WebServlet(name = "FirstServlet",urlPatterns = "/first")
    public class FirstServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            System.out.println("First Servet······");
        }
    }
    必要!!!在启动类中添加如下注解
    @ServletComponentScan //在spring boot 启东时会扫描@WebServlet注解，并将该类实例化
    如果不添加该注解，则无法访问
    
    
    
    
    整合Servlet方式二：通过方法完成Servlet组件的注册
    
    //该注册方法也可以放置在启动类中，就不需要单独写了，17 Spring Boot整合Servlet方法二
    @Configuration
    public class ServletConfig {
        /*
                完成Servlet组件的注册
        */
        @Bean  //相当于xml中Bean标签,ServletRegistrationBean必须返回这个对象
        public ServletRegistrationBean getServletRegistrationBean(){
            //注册Servlet，实例化
            ServletRegistrationBean bean = new ServletRegistrationBean(new SecondServlet());
            //添加URL访问路径
            bean.addUrlMappings("/seconde");
            return bean;
        }
    }
    

    

# 很久之前的内容

> 以下为上一次的内容，每次添加的内容写在最前边，方便查看，提交前在今日内容前写个简短的说明
 
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
    git config --global --list//
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
    
## javaBean规范(此项目中可能用不到？)
    如果我们想在JSP页面中使用标签来操作java类，那么我们所写的java类就必须遵守JavaBean规范，
    一个JavaBean，是由其属性和方法组成的。
    
     
    
    1. JavaBean 类必须是一个公共类，即使用关键字 public 声明类。
    
     
    
    2. JavaBean 类中必须有一个声明为公共的无参构造函数。
    
    　　JavaBean 本质还是一个java类，在不声明任何构造器的情况下，系统会给它添加一个默认的无参构造器；
    
    　　如果手动声明了一个构造器，则系统不会添加默认的无参构造器，这时如果不手动添加无参构造器，
        当创建无参对象时，就会报错，因为找不到无参构造器。
    
     
    
    3. JavaBean 类中的实例变量必须为私有的，即所有的实例变量都使用关键字 private 声明。
    
     
    
    4. 必须为 JavaBean 类中的实例变量提供公共的 getter / setter 方法。
    
    　　只提供 getter 方法的属性，称为只读属性；只提供 setter 方法的属性，称为只写属性。
    
    　　使用 private 修饰实例变量，可以保证数据安全，其他类无法直接访问这些变量。
        在 getter / setter 方法中，可以做一些权限控制，数据校验等工作，以保证数据的安全，合法性。
    
     
    
    5. JavaBean 类中实例属性的命名规则： 实例属性名前两个字母要么都小写，要么都大写。
    
    　　（1） 属性名前两个字母都小写：将属性名的首字母大写，然后用作 getter / setter 方法中 
            get / set 的后部分，如属性名为 name, 它的 getter / setter 方法为 getName / setName。
    
    　　（2） 属性名的第二个字母大写： 将属性名直接用作 getter / setter 方法中 get / set 的后部分，
            即属性名大小写不变。如属性名为 uName，它的 getter / setter 方法为 getuName / setuName。
    
    　　（3） 属性名前两个字母都大写：将属性名直接用作 getter / setter 方法中 get / set 的后部分，
            即属性名大小写不变。如属性名为 IDcode， 它的 getter / setter 方法为 getIDcode / setIDcode。
    
    　　（4） 属性名首字母大写：将属性名直接用作 getter / setter 方法中 get / set 的后部分，
            即属性名大小写不变。如属性名为 Ucode， 它的 getter / setter 方法为 getUcode / setUcode。
            但是这种情况，在应用中会出现找不到属性的错误。
            
## 数据库连接池

[数据库连接池](http://www.jianshu.com/p/ad0ff2961597)