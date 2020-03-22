package com.jiyun.mapper;

import com.jiyun.pojo.TbItemCat;
import com.jiyun.pojo.TbItemCatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbItemCatMapper {
  
    //根据Id关联查询 
    List<TbItemCat> queryByParentId(Long parentId);

  
}