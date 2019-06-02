package cn.cs.mapper;

import cn.cs.pojo.Product;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    List<Product> getProductList();

    List<Product> getBestProductList();

    Product getProductById(Integer id);

    Long count();

    List<Product> pageQuery(RowBounds rowBounds);

    Product getProduct(int id);

    void updateProduct(Product product);

    void addProduct(Product product);

    void updateProductById(Integer id);
}
