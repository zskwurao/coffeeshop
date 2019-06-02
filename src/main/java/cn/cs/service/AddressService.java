package cn.cs.service;

import cn.cs.pojo.Address;
import cn.cs.utils.CSResult;

public interface AddressService {
    CSResult getAddressList(Integer id);

    CSResult addAddress(Address address);
    CSResult deleteAddress(Integer id);
}
