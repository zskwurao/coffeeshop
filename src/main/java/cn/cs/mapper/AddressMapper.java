package cn.cs.mapper;

import cn.cs.pojo.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @create by zhangsk on 2018-12-05 13:07
 **/
@Repository
public interface AddressMapper {
    public List<Address> getAddressList(Integer id);

    int addAddress(Address address);

    int deleteAddress(Integer id);
}
