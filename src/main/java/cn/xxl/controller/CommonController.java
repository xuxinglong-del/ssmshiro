package cn.xxl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuxinglong
 * @date 2020/4/22 10:27
 * @Description
 */
@RestController
@RequestMapping("common")
public class CommonController {

    /**
     * 未登录
     * @return
     */
    @RequestMapping("unLogin")
    public Object unLogin(){
        Map<String,Object> map = new HashMap<>();
        map.put("code", -1);
        map.put("msg", "未登录");
        return map;
    }
}
