package cn.cs.controller;

import cn.cs.pojo.Order;
import cn.cs.pojo.User;
import cn.cs.service.OrderService;
import cn.cs.utils.CSResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    @ResponseBody
    public CSResult addOrder(@RequestBody Order order, HttpServletRequest request){
       // User user = (User) request.getSession().getAttribute("user");
        String user_id = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {

                    user_id = cookie.getValue();
                }
            }
        }
            order.setuId(Integer.valueOf(user_id));
            return orderService.addOrder(order);

    }

    @RequestMapping(value = "/commitOrder", method = RequestMethod.GET)
    @ResponseBody
    public CSResult commitOrder(String id,HttpServletRequest request){

            return orderService.commitOrder(id);

    }
    @RequestMapping(value = "/deleteOrder", method = RequestMethod.GET)
    @ResponseBody
    public CSResult deleteOrder(String id,HttpServletRequest request){

            return orderService.deleteOrder(id);

    }
    @RequestMapping(value = "/getOrderList", method = RequestMethod.GET)
    @ResponseBody
    public CSResult getOrderList(HttpServletRequest request){
        /*User user = (User) request.getSession().getAttribute("user");
        if(user==null){
            return CSResult.build(0,"暂未登录！！！");
        }else {*/
        String user_id = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {

                    user_id = cookie.getValue();
                }
            }
        }
            return orderService.getOrderList(Integer.valueOf(user_id));

    }
}
