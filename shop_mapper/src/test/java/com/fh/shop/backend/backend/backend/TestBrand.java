package com.fh.shop.backend.backend.backend;

import com.fh.shop.admin.mapper.brand.IBrandMapper;
import com.fh.shop.backend.po.brand.Brand;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class TestBrand {

    @Autowired
    private IBrandMapper brandMapper;


    public void testAdd(){
        Brand brand = new Brand();
        brand.setBrandName("Hello");
    }
}
