package com.warning.warning_system.dto;
import lombok.Data;

@Data

//   客户端数据请求的数据载体，封装请求的数据，需与控制器接收请求
//    需与服务器配合，服务器处理后返回结果
public class LoginRequest {
    private Integer username; // 对应各表的 ID (学号/工号)
    private String password;
    private String role; // 1:管理员, 2:学生, 3:辅导员, 4:教师

    public Integer getUsername() {
        return username;
    }

    public void setUsername(Integer username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}