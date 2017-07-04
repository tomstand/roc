package com.roc.service;/**
 * Created by WanPengCheng on 2017/7/3.
 */

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.roc.facade.User;
import com.roc.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * 用户
 *
 * @author WanPengCheng
 * @create 2017-07-03-17:06
 **/
@Service("userService")
public class UserService extends ServiceImpl<UserMapper, User>{

    public Page<User> selectUserPage(Page<User> page) {
        page.setRecords(baseMapper.selectPage(page,null));
        return page;
    }

    public long login() {
        return (long)12;
    }
}
