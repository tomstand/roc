package com.roc.web.controller;
/**
 * Created by wpc on 2017/6/27.
 */

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.plugins.Page;
import com.roc.provider.AbstractController;
import com.roc.provider.ISysProvider;
import com.roc.provider.Parameter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录控制
 *
 * @author wpc
 * @create 2017-06-27-17:26
 **/

@RestController
@Api(value = "登录接口", description = "登录接口")
public class UserController extends AbstractController<ISysProvider> {

    @GetMapping("/login")
    @ApiOperation(value = "通过ID查询USER信息", notes = "暂无")
    public Map<String,Object> login(){
        Map<String, Object> map = new HashMap<String, Object>();
        Parameter parameter = sysProvider.execute(new Parameter("userService","login"));
        map.put("username",parameter.getId());
        map.put("password","123456");
        return map;
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页查询user信息", notes="列表")
    public Object selectPage() {
        Page page=new Page(1,10);
        Parameter parameter = sysProvider.execute(new Parameter("userService","selectUserPage").setPage(page));
        return parameter.getPage();
    }

}
