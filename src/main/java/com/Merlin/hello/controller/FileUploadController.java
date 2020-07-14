package com.Merlin.hello.controller;


import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

//注意名字不要打错MultipartFile，不需要额外导入spring MVC？？？不能确定是哪个导入的5.2.3版本
/*
    文件上传
 */

//仅仅返回字符串，不返回网页
@RestController
public class FileUploadController {

    @PostMapping("/fileUploadController")
    //此处的MultipartFile file变量名，必须和form表单中提交文件的name相同一致
    public String fileUpload(MultipartFile file) throws IOException {
        //获取真实文件的地址,getURL("src/main/resources/static/img"),参数最好为文件中的全路径，不然可能无法访问
        //在springboot 中 可能只有这一种方法管用 ResourceUtils.getURL("src/main/resources/static/img").getPath();
        //其余的getRealPath方法可能是容器运行地址，c/appdata/tomcat··· ，可能为这种样子的地址
        String basePath = ResourceUtils.getURL("src/main/resources/static/img").getPath();
        System.out.println(basePath);
        System.out.println("This is FileUploadController");
        System.out.println("FileUploadController.fileUpload");
        System.out.println("multipartFile = " + file.getName());
        System.out.println("multipartFile = " + file.getOriginalFilename());
        file.transferTo(new File(basePath+file.getOriginalFilename()));
        return "OK";
    }
}
