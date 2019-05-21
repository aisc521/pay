package com.zhcw.zfb.pay.service.Impl;
import com.zhcw.zfb.pay.mapper.TestMapper;
import com.zhcw.zfb.pay.pojo.TestPojo;

import com.zhcw.zfb.pay.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Resource
    @Autowired
    private TestMapper testMapper;
    @Override
    public List<TestPojo> selectAll() {
        return testMapper.selectAllInfo();
    }
}
