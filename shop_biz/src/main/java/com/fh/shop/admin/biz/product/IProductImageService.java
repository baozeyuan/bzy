package com.fh.shop.admin.biz.product;

import com.fh.shop.admin.po.product.ProductImage;

import java.util.List;

public interface IProductImageService {
//根据产品id查看对应的子图
    List<ProductImage> findProductListByProductId(Integer id);
//根据id集合获取相关的图片信息
    List<ProductImage> findProductListById(List<Integer> idList);
//根据id集合删除数据库字图片信息
    void deleteProductImage(List<Integer> idList);
//将子图片信息添加到数据库表中
    void addProductImage(List<ProductImage> productImageList);
}
