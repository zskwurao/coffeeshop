package cn.cs.controller;

import cn.cs.pojo.Product;
import cn.cs.pojo.Shopcar;
import cn.cs.pojo.User;
import cn.cs.service.ProductService;
import cn.cs.service.ShopcarService;
import cn.cs.utils.CSResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/shopcar")
public class ShopcarController {

    @Autowired
    private ShopcarService shopcarService;


    @RequestMapping(value = "/joincar", method = RequestMethod.POST)
    @ResponseBody
    public CSResult joincar(@RequestBody Shopcar shopcar, HttpServletRequest request, HttpServletResponse response) {
        String user_id = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {

                    user_id = cookie.getValue();
                }
            }
        }
        //System.out.println(user);
        shopcar.setuId(Integer.valueOf(user_id));
        CSResult result = shopcarService.joincar(shopcar);
        return result;

    }

    @RequestMapping(value = "/deleteCar",method = RequestMethod.GET)
    @ResponseBody
    public CSResult deleteCar(Integer id,HttpServletRequest request){
        //User user = (User) request.getSession().getAttribute("user");
        String user_id = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {

                    user_id = cookie.getValue();
                }
            }
        }
        return shopcarService.deleteCar(id, Integer.valueOf(user_id));
    }
    @RequestMapping(value = "/getShopcarList",method = RequestMethod.GET)
    @ResponseBody
    public CSResult getShopcarList(Integer uId,HttpServletRequest request, HttpServletResponse response){

        String user_id = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {

                    user_id = cookie.getValue();
                }
            }
        }
            CSResult result = shopcarService.getShopcarList(Integer.valueOf(user_id));
            return result;

    }

}
