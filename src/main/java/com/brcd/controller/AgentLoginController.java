
package com.brcd.controller;

import com.brcd.bean.TbAgent;
import com.brcd.service.AgentLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


/**
 * Created by 任彩雨 on 2017/9/5.
 * 代理商登录模块
 */

@Controller
public class AgentLoginController {
    @Autowired
    private AgentLoginService agentLoginService;

    @RequestMapping("toAgentLogin")
    public String toAgentLogin() {
        System.out.println("-------到登陆的界面------");
        return "login";
    }

    @RequestMapping("AgentLogin")
    public String agentLogin(TbAgent tbAgent, HttpSession session, Model model) {
        TbAgent agentLogin = agentLoginService.AgentLogin(tbAgent);
        System.out.println("登陆的用户：" + agentLogin);
        if (agentLogin != null) {
            session.setAttribute("agentLogin", agentLogin);
            return "home/home";
        }
        model.addAttribute("errorMsg", "用户名或密码错误");
        return "login";
    }

    @RequestMapping("/{url}")//当请求找不到对应额Url的时候就会执行这个方法
    public String url(@PathVariable("url") String url) {
        System.out.print(url + "---");
        return "home/" + url;
    }

}

