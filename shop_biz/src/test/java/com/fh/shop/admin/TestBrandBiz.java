package com.fh.shop.admin;

import com.fh.shop.admin.biz.brand.IBrandService;
import com.fh.shop.admin.po.brand.Brand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:spring/spring-biz.xml"})
public class TestBrandBiz extends AbstractJUnit4SpringContextTests {

    @Resource(name="brandService")
    private IBrandService brandService;

    @Test
    public void testList() {
        List<Brand> brandList = brandService.findBrandList();
        System.out.println(brandList);
    }
}
