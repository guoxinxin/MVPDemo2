package com.dev.mvpdemo.model.biz;

import com.dev.mvpdemo.model.bean.User;

/**
 * 作者：Michael
 * <p>
 * 时间：2017/2/23 09:12
 *
 * 登陆的监听者
 */

public interface LoginListener {
    void loginSuccess(User user);
    void loginFail();
}
