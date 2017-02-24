package com.dev.mvpdemo.model.biz;

/**
 * 作者：Michael
 * <p>
 * 时间：2017/2/23 09:11
 */

public interface IuserBiz {
    void login(String username,String password,LoginListener loginListener);
}
