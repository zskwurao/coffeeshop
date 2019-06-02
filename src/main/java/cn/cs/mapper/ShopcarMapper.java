package cn.cs.mapper;

import cn.cs.pojo.Shopcar;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopcarMapper {
    List<Shopcar> getShopcarListByUid(Integer getuId);

    void insertShopcar(Shopcar shopcar);

    void updateShopcarById(Shopcar shopcar1);

    int deleteCar(@Param("id") Integer id, @Param("uId") Integer uId);

    void deleteShopcar(@Param("pId") Integer getpId, @Param("uId") Integer integer);
}
