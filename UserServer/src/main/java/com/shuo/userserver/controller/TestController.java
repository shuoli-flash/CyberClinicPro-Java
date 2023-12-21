package com.shuo.userserver.controller;

import com.shuo.userserver.utils.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 测试控制器
 *
 * @author 李朔
 */
@Controller
@CrossOrigin
@RequestMapping("/Test")
public class TestController {

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public R login() {
        return R.ok("HelloWorld");
    }

}
