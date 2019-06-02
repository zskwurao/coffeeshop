package cn.cs.controller;

import cn.cs.pojo.User;
import cn.cs.service.UserService;
import cn.cs.utils.CSResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loading(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        //response.sendRedirect("./index.html");
        //request.getRequestDispatcher("/index.html").forward(request,response);
        return "redirect:/index.html";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CSResult register(@RequestBody User user){
        CSResult result = userService.insertUser(user);
        return result;
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CSResult login(@RequestBody User user, HttpServletRequest request,HttpServletResponse response){
        User u = userService.isUser(user);
        if(u==null){
            return CSResult.build(0,"登陆失败");
        }else{
            Cookie cookie = new Cookie("user", u.getId().toString());
            cookie.setPath("/");
            response.addCookie(cookie);

            return CSResult.ok(u);
        }
    }
    @RequestMapping(value = "/isEmail", method = RequestMethod.GET)
    @ResponseBody
    public CSResult isEmail(String email, HttpServletRequest request,HttpServletResponse response){
        CSResult result = userService.isEmail(email);
        return result;
    }
    @RequestMapping(value = "/isTele", method = RequestMethod.GET)
    @ResponseBody
    public CSResult isTele(String telephone, HttpServletRequest request,HttpServletResponse response){
        CSResult result = userService.isTele(telephone);
        return result;
    }
    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    @ResponseBody
    public CSResult loginOut( HttpServletRequest request,HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if(cookies!=null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    cookie.setMaxAge(0);//设置为0为立即删除该Cookie
                    cookie.setPath("/");//删除指定路径的cookie,不设置该路径，默认为删除当前路径Cookie
                    response.addCookie(cookie);
                }
            }
        }else {
            return CSResult.build(0,"请先登录");
        }

        return CSResult.ok();
    }
    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    @ResponseBody
    public CSResult getUserList(){
        return userService.getUserList();
    }
    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    @ResponseBody
    public CSResult deleteUser(Integer id){
        return userService.deleteUser(id);
    }
}
