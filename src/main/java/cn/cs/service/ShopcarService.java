package cn.cs.service;

import cn.cs.pojo.Shopcar;
import cn.cs.utils.CSResult;

public interface ShopcarService {
    CSResult joincar(Shopcar shopcar);

    CSResult deleteCar(Integer id, Integer uId);

    CSResult getShopcarList(Integer id);
}
