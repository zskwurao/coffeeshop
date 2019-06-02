package cn.cs.service.Impl;

import cn.cs.mapper.AddressMapper;
import cn.cs.pojo.Address;
import cn.cs.service.AddressService;
import cn.cs.utils.CSResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;
    @Override
    public CSResult getAddressList(Integer id) {
        List<Address> list = addressMapper.getAddressList(id);
        return CSResult.ok(list);
    }

    @Override
    public CSResult addAddress(Address address) {
        int count = addressMapper.addAddress(address);
        if(count==1){
            return CSResult.ok();
        }else {
            return CSResult.build(0,"添加失败");
        }
    }

    @Override
    public CSResult deleteAddress(Integer id) {
        int count = addressMapper.deleteAddress(id);
        if(count==1){
            return CSResult.ok();
        }else {
            return CSResult.build(0,"删除失败");
        }
    }
}
