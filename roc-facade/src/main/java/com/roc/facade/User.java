package com.roc.facade;/**
 * Created by wpc on 2017/6/27.
 */

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 用户登录信息
 *
 * @author wpc
 * @create 2017-06-27-17:32
 **/
@TableName("user")
public class User implements Serializable {

    private int id;
    private String username;
    private String password;

    private String nick_name;
    private String sex;
    private String register_date;

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRegister_date() {
        return register_date;
    }

    public void setRegister_date(String register_date) {
        this.register_date = register_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
