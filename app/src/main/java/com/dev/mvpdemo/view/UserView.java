package com.dev.mvpdemo.view;

import com.dev.mvpdemo.model.bean.User;

/**
 * 作者：Michael
 * <p>
 * 时间：2017/2/23 09:31
 *
 * 第四步建立一个接口进行登陆
 */

public interface UserView {
    String getUserName();
    String getPassword();

    void clearUserName();
    void clearPassword();

    void login(User user);
    void fail();

    void show();
    void hide();
}
