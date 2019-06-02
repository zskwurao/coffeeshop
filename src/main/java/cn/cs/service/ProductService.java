package cn.cs.service;

import cn.cs.pojo.Product;
import cn.cs.utils.CSResult;
import cn.cs.utils.PageBean;

public interface ProductService {
    CSResult getProductList();

    CSResult getBestProductList();

    Product getProductById(Integer id);

    void pageQuery(PageBean pageBean);

    CSResult getProduct(int id);

    CSResult addProduct(Product product);

    CSResult updateProduct(Integer id);
}
