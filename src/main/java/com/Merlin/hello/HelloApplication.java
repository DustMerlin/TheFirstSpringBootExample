package com.Merlin.hello;

import com.Merlin.hello.mapper.UserMapper;
import com.Merlin.hello.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan //在spring boot 启东时会扫描@WebServlet,@WebFilter,@WebListener注解，并将该类实例化
public class HelloApplication {

	@Autowired
	private static UserMapper userMapper;


	public static void main(String[] args) {
		System.out.println("main");

		System.out.println("this is user!");
//		启动类中可能或者不能包含一些其他的内容，仅为启动内容？
//		User user = new User();
//		user.setSno("95005");
//		user.setAname("SML");
//		user.setSsex('F');
//		user.setSage(20);
//		user.setAdept("SC");
//		userMapper.insert(new User("95005",20,"SC","SML",'F'));
		System.out.println("insert over!");
		SpringApplication.run(HelloApplication.class, args);
	}

}




