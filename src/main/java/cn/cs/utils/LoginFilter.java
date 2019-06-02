package cn.cs.utils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @create by zhangsk on 2018-12-08 14:55
 **/

public class LoginFilter implements Filter {

    private FilterConfig config;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Cookie[] cookies = request.getCookies();

        String noLoginPaths = config.getInitParameter("noLoginPaths");
        boolean flag = false;
        String charset = config.getInitParameter("charset");
        if(charset==null){
            charset = "UTF-8";
        }
        request.setCharacterEncoding(charset);

        if(noLoginPaths!=null){
            String[] strArray = noLoginPaths.split(";");
            for (int i = 0; i < strArray.length; i++) {

                if(strArray[i]==null || "".equals(strArray[i]))
                    continue;

                //System.out.println(request.getRequestURI().indexOf(strArray[i]));
                if(request.getRequestURI().indexOf(strArray[i])!=-1 ){
                   /* filterChain.doFilter(servletRequest, servletResponse);
                    return;*/
                   flag = true;

                }
            }


        }
        String user_id = "";
        if(flag){
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("user")) {

                        filterChain.doFilter(servletRequest, servletResponse);
                        return;
                    }
                }
            }else {
                response.sendRedirect("../index.html");
            }
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
