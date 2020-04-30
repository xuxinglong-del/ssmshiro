package cn.xxl.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuxinglong
 * @date 2020/4/21 16:44
 * @Description 测试用的的controller
 */
@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping("query")
    @RequiresPermissions("user:query")
    public Map<String,Object> query(){
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "query");
        return map;
    }
    @RequestMapping("add")
    @RequiresPermissions("user:add")
    public Map<String,Object> add(){
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "add");
        return map;
    }

    @RequestMapping("update")
    @RequiresPermissions("user:update")
    public Map<String,Object> update(){
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "update");
        return map;
    }

    @RequestMapping("delete")
    @RequiresPermissions("user:delete")
    public Map<String,Object> delete(){
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "delete");
        return map;
    }

    @RequestMapping("export")
    @RequiresPermissions("user:export")
    public Map<String,Object> export(){
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "export");
        return map;
    }
}
