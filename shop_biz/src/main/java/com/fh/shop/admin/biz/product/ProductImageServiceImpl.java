package com.fh.shop.admin.biz.product;

import com.fh.shop.admin.mapper.product.IProductImageMapper;
import com.fh.shop.admin.po.product.ProductImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productImageService")
public class ProductImageServiceImpl implements IProductImageService {
    @Autowired
    private IProductImageMapper productImageMapper;

    /**
     * 根据产品id查看对应的子图
     * @param id
     * @return
     */
    @Override
    public List<ProductImage> findProductListByProductId(Integer id) {
        List<ProductImage> productImageList=productImageMapper.findProductListByProductId(id);
        return productImageList;
    }

    /**
     * 根据id集合获取相关的图片信息
     * @param idList
     * @return
     */
    @Override
    public List<ProductImage> findProductListById(List<Integer> idList) {
        List<ProductImage> productList = productImageMapper.findProductListById(idList);
        return productList;
    }

    /**
     * 根据id集合删除数据库字图片信息
     * @param idList
     */
    @Override
    public void deleteProductImage(List<Integer> idList) {
        productImageMapper.deleteProductImage(idList);
    }

    /**
     * 将子图片信息添加到数据库表中
     * @param productImageList
     */
    @Override
    public void addProductImage(List<ProductImage> productImageList) {
        productImageMapper.addProductImage(productImageList);
    }
}
