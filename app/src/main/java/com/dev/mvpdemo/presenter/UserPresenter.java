package com.dev.mvpdemo.presenter;

import android.os.Handler;

import com.dev.mvpdemo.model.bean.User;
import com.dev.mvpdemo.model.biz.LoginListener;
import com.dev.mvpdemo.model.biz.UserBiz;
import com.dev.mvpdemo.view.UserView;

/**
 * 作者：Michael
 * <p>
 * 时间：2017/2/23 09:36
 *
 * 第四步建立链接model和View的中枢
 */

public class UserPresenter {
    public UserView userView;
    public UserBiz userBiz;
    private Handler handler=new Handler();

    public UserPresenter(UserView userView) {
        this.userView = userView;
        this.userBiz = new UserBiz();
    }

    public void login(){
        userView.show();
        userBiz.login(userView.getUserName(), userView.getPassword(), new LoginListener() {
            @Override
            public void loginSuccess(final User user) {
              handler.post(new Runnable() {
                  @Override
                  public void run() {
                      userView.hide();
                      userView.login(user);
                  }
              });
            }

            @Override
            public void loginFail() {
             handler.post(new Runnable() {
                 @Override
                 public void run() {
                     userView.hide();
                     userView.fail();
                 }
             });
            }
        });
    }

    public void clear(){
        userView.clearPassword();
        userView.clearUserName();
    }
}
