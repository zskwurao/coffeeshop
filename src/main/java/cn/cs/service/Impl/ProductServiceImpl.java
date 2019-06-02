package cn.cs.service.Impl;

import cn.cs.mapper.DictMapper;
import cn.cs.mapper.ProductMapper;
import cn.cs.pojo.Dict;
import cn.cs.pojo.Product;
import cn.cs.service.ProductService;
import cn.cs.utils.CSResult;
import cn.cs.utils.PageBean;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private DictMapper dictMapper;

    @Override
    public CSResult getProductList() {
        List<Dict> type = dictMapper.getDictList();
        List<Product> list = productMapper.getProductList();
        List<Map<String,List<Product>>> mapList = new ArrayList<>();
        for(int i = 0;i < type.size();i++){
            Map<String,List<Product>> map = new HashMap<>();
            List<Product> list1 = new ArrayList<>();
            for(Product product:list){
                if(type.get(i).getId()==product.getDictId()){
                    list1.add(product);
                }
            }
            map.put(type.get(i).getType(),list1);
            mapList.add(map);
        }
        return CSResult.ok(mapList);
    }

    @Override
    public CSResult getBestProductList() {
        List<Product> list = productMapper.getBestProductList();
        return CSResult.ok(list);
    }

    @Override
    public Product getProductById(Integer id) {
        Product product = productMapper.getProductById(id);
        return null;
    }

    @Override
    public void pageQuery(PageBean pageBean) {
        Integer currentPage = pageBean.getPage();
        Integer pageSize = pageBean.getPageSize();
        int maxResults = pageSize;
        int firstResult = (currentPage-1)*pageSize;
        RowBounds rowBounds = new RowBounds(firstResult,maxResults);
        Long count = productMapper.count();
        int totalPage = (int) (count/pageSize);
        totalPage = (count%pageSize==0)?totalPage:totalPage+1;
        List<Product> list = productMapper.pageQuery(rowBounds);
        pageBean.setTotal(count.intValue());
        pageBean.setTotalPage(totalPage);
        pageBean.setRows(list);
    }

    @Override
    public CSResult getProduct(int id) {
        Product product = productMapper.getProduct(id);
        return CSResult.ok(product);
    }

    @Override
    public CSResult addProduct(Product product) {
        productMapper.addProduct(product);
        return CSResult.ok();
    }

    @Override
    public CSResult updateProduct(Integer id) {
        productMapper.updateProductById(id);
        return CSResult.ok();
    }
}
