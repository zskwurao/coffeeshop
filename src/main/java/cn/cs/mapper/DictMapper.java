package cn.cs.mapper;

import cn.cs.pojo.Dict;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DictMapper {
    List<Dict> getDictList();

    List<Dict> getDictType();
}
