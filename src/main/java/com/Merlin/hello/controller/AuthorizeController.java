package com.Merlin.hello.controller;

import com.Merlin.hello.dto.AccesstokenDto;
import com.Merlin.hello.dto.GithubUser;
import com.Merlin.hello.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

//cookie,session，持续保持为登录态

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.url}")
    private String redirectUrl;
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state")String state,
                            HttpServletRequest request) {//自动填入上下文中的request

        AccesstokenDto accessTokenDto = new AccesstokenDto();
        //application.properties 以下的配置信息存储到专门的位置,不同环境使用不同的配置
        // accessTokenDto.setClient_id("864c0f41d69ccea62113");
        //application.properties   ->    github.client.id=864c0f41d69ccea62113   其余同样的方法配置
        accessTokenDto.setClient_id(clientId);
//        accessTokenDto.setClient_secret("6f65cd2845854a9a89fcbe1a0f5143c640038893");
        accessTokenDto.setClient_secret(clientSecret);
        accessTokenDto.setCode(code);
//        accessTokenDto.setRedirect_url("http://localhost:8899/callback");
        accessTokenDto.setRedirect_url(redirectUrl);
        accessTokenDto.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDto);
        GithubUser user = githubProvider.getUser(accessToken);
        if(user != null){
            //登陆成功
            request.getSession().setAttribute("user",user);
            return "redirect:/"; //重定向到根目录
        }else{
            //登录失败
            return "redirect:/";
        }
        //return "index";

    }
}
