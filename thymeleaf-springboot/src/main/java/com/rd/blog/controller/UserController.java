package com.rd.blog.controller;

import com.rd.blog.domain.User;
import com.rd.blog.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * All rights Reserved, Designed By www.rongdasoft.com
 *
 * @version V1.0
 * @Title: UserController
 * @Description:
 * @author:jichao
 * @date: 2018/3/16
 * @Copyright: 2018/3/16 www.rongdasoft.com
 * Inc. All rights reserved.
 */
@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户列表
     * @param model
     * @return
     */
    @GetMapping()
    public String findAll(Model model){
        List<User> userList = userService.findAll();
        model.addAttribute("userList", userList);
        model.addAttribute("titile", "用户列表");
        return "/user/list";
    }

    /**
     * 根据id查询用户信息
     * @param id
     * @param model
     * @return
     */
    @GetMapping("{id}")
    public String findById(@PathVariable("id") long id, Model model){
        User userInfo = userService.findById(id);
        model.addAttribute("userInfo", userInfo);
        model.addAttribute("titile", "用户信息");
        return "/user/view";
    }

    /**
     * 新增用户
     * @param model
     * @return
     */
    @GetMapping("/form")
    public String addUser(Model model){
        model.addAttribute("titile", "新增用户");
        return "/user/form";
    }

    /**
     * 保存或新增用户
     * @param user
     * @return
     */
    @PostMapping()
    public String saveOrUpdate(User user){
        User result = userService.saveOrUpdate(user);
        return "redirect:/list";
    }
}
