package com.dev.mvpdemo.model.biz;

import com.dev.mvpdemo.model.bean.User;

/**
 * 作者：Michael
 * <p>
 * 时间：2017/2/23 09:13
 *
 * 第三部：实现第二步的接口
 */

public class UserBiz implements IuserBiz {
    @Override
    public void login(final String username, final String password, final LoginListener loginListener) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(username.equals("gxq")&&password.equals("123456")){
                    User user=new User();
                    user.setPassword(password);
                    user.setUsernanme(username);
                    loginListener.loginSuccess(user);
                }else{
                    loginListener.loginFail();
                }
            }
        }).start();
    }
}
