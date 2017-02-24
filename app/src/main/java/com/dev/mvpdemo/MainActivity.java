package com.dev.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dev.mvpdemo.model.bean.User;
import com.dev.mvpdemo.model.biz.UserBiz;
import com.dev.mvpdemo.presenter.UserPresenter;
import com.dev.mvpdemo.view.UserView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * MVP
 * 设计一个登陆界面，通过MVP模式进行设计，
 * m--Model--负责存储检索操作数据
 * v--View--负责绘制UI元素，与用户进行交互，主要体现为Activity
 * ViewINterface--需要view实现的接口，View通过ViewInterface 与presenter进行交互
 * p--Presenter--View和model的纽带，处理用户的逻辑
 */
public class MainActivity extends AppCompatActivity implements UserView {
    private UserView userView;
    private UserBiz userBiz;
    private UserPresenter userPresenter=new UserPresenter(this);

    @Bind(R.id.et_username)
    EditText etUsername;
    @Bind(R.id.et_password)
    EditText etPassword;
    @Bind(R.id.login)
    Button login;
    @Bind(R.id.clear)
    Button clear;
    @Bind(R.id.pr)
    ProgressBar pr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.login, R.id.clear})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                userPresenter.login();
                break;
            case R.id.clear:
                userPresenter.clear();
                break;
        }
    }

    @Override
    public String getUserName() {
        return etUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }

    @Override
    public void clearUserName() {
      etUsername.setText("");
    }

    @Override
    public void clearPassword() {
        etPassword.setText("");
    }

    @Override
    public void login(User user) {
        Toast.makeText(this,getString(R.string.success)+user.getUsernanme(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void fail() {
        Toast.makeText(this, getString(R.string.error), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void show() {
  pr.setVisibility(View.VISIBLE);
    }

    @Override
    public void hide() {
        pr.setVisibility(View.GONE);
    }
}
