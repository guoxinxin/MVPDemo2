package com.dev.mvpdemo.model.bean;

/**
 * 作者：Michael
 * <p>
 * 时间：2017/2/23 09:05
 *
 * 第一步建立一个bean类
 */

public class User {
    private String usernanme;
    private String password;

    public String getUsernanme() {
        return usernanme;
    }

    public void setUsernanme(String usernanme) {
        this.usernanme = usernanme;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
