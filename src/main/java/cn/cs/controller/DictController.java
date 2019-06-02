package cn.cs.controller;

import cn.cs.mapper.DictMapper;
import cn.cs.pojo.Dict;
import cn.cs.utils.CSResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DictController {


    @Autowired
    private DictMapper dictMapper;

    @RequestMapping(value = "/getDictList", method = RequestMethod.GET)
    @ResponseBody
    public CSResult getDictList(){
        List<Dict> list = dictMapper.getDictList();
        return CSResult.ok(list);
    }
}
