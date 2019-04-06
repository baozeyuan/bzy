package com.fh.shop.admin.po.product;

import com.fh.shop.admin.po.Page;
import com.fh.shop.backend.po.Page;

import java.io.Serializable;

public class ProductImage extends Page implements Serializable {

    private static final long serialVersionUID = 6875344704566921676L;

    private Integer id;
    //图片路径
    private String imagePath;
    //商品
    private Integer productId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
