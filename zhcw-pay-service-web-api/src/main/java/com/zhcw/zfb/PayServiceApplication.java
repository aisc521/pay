package com.zhcw.zfb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.zhcw.zfb.api"})
@ComponentScan(basePackages = {"com.zhcw.zfb.pay.mapper"})
@ComponentScan(basePackages = {"com.zhcw.zfb.pay.service"})
@ComponentScan(basePackages = {"com.zhcw.zfb.pay.service.Impl"})
@ComponentScan(basePackages = {"com.zhcw.zfb.pay.pojo"})
public class PayServiceApplication {
    public static void main(String[] args){
        SpringApplication.run(PayServiceApplication.class,args);
    }
}
