package cn.cs.service.Impl;

import cn.cs.mapper.ShopcarMapper;
import cn.cs.pojo.Shopcar;
import cn.cs.service.ShopcarService;
import cn.cs.utils.CSResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ShopcarServiceImpl implements ShopcarService {

    @Autowired
    private ShopcarMapper shopcarMapper;

    @Override
    public CSResult joincar(Shopcar shopcar) {
        boolean flag = false;
        List<Shopcar> list = shopcarMapper.getShopcarListByUid(shopcar.getuId());
        if(list==null){
            shopcarMapper.insertShopcar(shopcar);
            return CSResult.ok();
        }
        System.out.println(shopcar.getpId());
        for(Shopcar shopcar1 : list){
            System.out.println(shopcar1.getpId());
            if(shopcar1.getpId().equals(shopcar.getpId())){
                shopcar1.setNum(shopcar1.getNum()+shopcar.getNum());
                System.err.println(shopcar1.getNum());
                flag = true;
                shopcarMapper.updateShopcarById(shopcar1);
                return CSResult.ok();
            }
        }
        if(!flag){
            shopcarMapper.insertShopcar(shopcar);

        }
        return CSResult.ok();
    }

    @Override
    public CSResult deleteCar(Integer id, Integer uId) {
        int count = shopcarMapper.deleteCar(id,uId);
        if(count==1) {
            return CSResult.ok();
        }else {
            return CSResult.build(0,"暂无数据");
        }
    }

    @Override
    public CSResult getShopcarList(Integer id) {
        List<Shopcar> list = shopcarMapper.getShopcarListByUid(id);
        return CSResult.ok(list);
    }


}
