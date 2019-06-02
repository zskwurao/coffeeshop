package cn.cs.controller;

import cn.cs.pojo.Product;
import cn.cs.service.ProductService;
import cn.cs.utils.CSResult;
import cn.cs.utils.CSResult1;
import cn.cs.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/getProductList", method = RequestMethod.GET)
    @ResponseBody
    public CSResult getProductList( HttpServletRequest request,HttpServletResponse response){
        CSResult result = productService.getProductList();
        return result;
    }

    @RequestMapping(value = "/getBestProductList", method = RequestMethod.GET)
    @ResponseBody
    public CSResult getBestProductList( HttpServletRequest request,HttpServletResponse response){
        CSResult result = productService.getBestProductList();
        return result;
    }
    @RequestMapping(value = "/pageBean", method = RequestMethod.GET)
    @ResponseBody
    public CSResult1 pageQuery(String page,String limit, HttpServletRequest reques,HttpServletResponse response){
        PageBean pageBean = new PageBean();
        if(page!=null&&page.length()!=0) {
            pageBean.setPage(Integer.valueOf(page));
        }
        if(limit!=null&&limit.length()!=0) {
            pageBean.setPageSize(Integer.valueOf(limit));
        }
        productService.pageQuery(pageBean);

        return CSResult1.ok(pageBean.getRows(),pageBean.getTotal());
    }

    @RequestMapping(value = "/getProduct", method = RequestMethod.GET)
    @ResponseBody
    public CSResult getProduct(int id, HttpServletRequest request,HttpServletResponse response){
        return productService.getProduct(id);
    }
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    @ResponseBody
    public CSResult addProduct(@RequestBody Product product, HttpServletRequest request, HttpServletResponse response){
        return productService.addProduct(product);
    }
    @RequestMapping(value = "/updateProduct", method = RequestMethod.GET)
    @ResponseBody
    public CSResult updateProduct(Integer id, HttpServletRequest request, HttpServletResponse response){
        return productService.updateProduct(id);
    }

}
