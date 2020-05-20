package com.Merlin.hello.dto;

//psvm 快速生成main函数
//dto   数据传输模型
//快捷键 Alt+Inser 创建
//@Data注解和lombok????

public class AccesstokenDto {

    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_url;
    private String state;

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setRedirect_url(String redirect_url) {
        this.redirect_url = redirect_url;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getClient_id() {
        return client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public String getCode() {
        return code;
    }

    public String getRedirect_url() {
        return redirect_url;
    }

    public String getState() {
        return state;
    }
}
