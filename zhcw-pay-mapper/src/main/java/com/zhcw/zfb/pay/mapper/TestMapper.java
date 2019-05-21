package com.zhcw.zfb.pay.mapper;

import com.zhcw.zfb.pay.pojo.TestPojo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface TestMapper extends Mapper<TestPojo>  {
    List<TestPojo> selectAllInfo();
}
