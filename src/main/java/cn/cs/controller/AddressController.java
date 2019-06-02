package cn.cs.controller;

import cn.cs.pojo.Address;
import cn.cs.pojo.User;
import cn.cs.service.AddressService;
import cn.cs.utils.CSResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;
    @RequestMapping(value = "/getAddressList", method = RequestMethod.GET)
    @ResponseBody
    public CSResult getAddressList(HttpServletRequest request, HttpServletResponse response){
        String user_id = "";

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {

                    user_id = cookie.getValue();
                }
            }
        }

            return addressService.getAddressList(Integer.valueOf(user_id));

    }
    @RequestMapping(value = "/addAddress", method = RequestMethod.POST)
    @ResponseBody
    public CSResult addAddress(@RequestBody Address address, HttpServletRequest request, HttpServletResponse response){
        User user = (User) request.getSession().getAttribute("user");
        String user_id = "";

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {

                    user_id = cookie.getValue();
                }
            }
        }
            address.setUserId(Integer.valueOf(user_id));
            return addressService.addAddress(address);

    }
    @RequestMapping(value = "/deleteAddress", method = RequestMethod.GET)
    @ResponseBody
    public CSResult deleteAddress(Integer id, HttpServletRequest request, HttpServletResponse response){
        return addressService.deleteAddress(id);
    }
}
