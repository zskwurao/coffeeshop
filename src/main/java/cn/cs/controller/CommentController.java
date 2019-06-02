package cn.cs.controller;

import cn.cs.pojo.User;
import cn.cs.service.CommentService;
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
import javax.servlet.http.HttpSession;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/addComment", method = RequestMethod.GET)
    @ResponseBody
    public CSResult addComment(String comment,Integer pId, HttpServletRequest request, HttpServletResponse response){
        String user_id = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {

                    user_id = cookie.getValue();
                }
            }
        }

            CSResult result = commentService.addComment(comment, pId, Integer.valueOf(user_id));
            return result;

    }
    @RequestMapping(value = "/getCommentList", method = RequestMethod.POST)
    @ResponseBody
    public CSResult getCommentList(Integer id, HttpServletRequest request, HttpServletResponse response){
        String user_id = "";

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {

                    user_id = cookie.getValue();
                }
            }
        }
        System.out.println(id);
        CSResult result = commentService.getCommentList( id, Integer.valueOf(user_id));
        return result;

    }
}
