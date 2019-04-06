/** 
 * <pre>项目名称:shop-admin-v2 
 * 文件名称:IProductMapper.java 
 * 包名:com.fh.shop.backend.mapper.product 
 * 创建日期:2018年12月24日下午9:08:41 
 * Copyright (c) 2018, 3222476127@qq.com  All Rights Reserved.</pre> 
 */  
package com.fh.shop.admin.mapper.product;

import java.util.List;

import com.fh.shop.backend.po.product.ProductImage;
import com.fh.shop.backend.po.product.Product;

/** 
 * <pre>项目名称：shop-admin-v2    
 * 类名称：IProductMapper    
 * 类描述：    
 * 创建人：lihaiyan 3222476127@qq.com     
 * 创建时间：2018年12月24日 下午9:08:41    
 * 修改人：lihaiyan 3222476127@qq.com      
 * 修改时间：2018年12月24日 下午9:08:41    
 * 修改备注：       
 * @version </pre>    
 */

public interface IProductMapper {
	
	public void addProduct(Product product);

	/** <pre>selectProduct( 查看)   
	 * 创建人：lihaiyan 3222476127@qq.com    
	 * 创建时间：2018年12月25日 下午3:31:33    
	 * 修改人：lihaiyan 3222476127@qq.com      
	 * 修改时间：2018年12月25日 下午3:31:33    
	 * 修改备注： 
	 * @return</pre>    
	 */
	public List<Product> selectProduct(Product product);

	/** <pre>deleteProdute(删除)   
	 * 创建人：lihaiyan 3222476127@qq.com    
	 * 创建时间：2018年12月25日 下午6:24:11    
	 * 修改人：lihaiyan 3222476127@qq.com      
	 * 修改时间：2018年12月25日 下午6:24:11    
	 * 修改备注： 
	 * @param id</pre>    
	 */
	public void deleteProdute(Integer id);

	/** <pre>deleteMany(批量删除)   
	 * 创建人：lihaiyan 3222476127@qq.com    
	 * 创建时间：2018年12月25日 下午6:56:59    
	 * 修改人：lihaiyan 3222476127@qq.com      
	 * 修改时间：2018年12月25日 下午6:56:59    
	 * 修改备注： 
	 * @param idsList</pre>    
	 */
	public void deleteMany(List<Integer> idsList);

	/** <pre>toUpdateProduct(修改回显)   
	 * 创建人：lihaiyan 3222476127@qq.com    
	 * 创建时间：2018年12月26日 下午3:36:25    
	 * 修改人：lihaiyan 3222476127@qq.com      
	 * 修改时间：2018年12月26日 下午3:36:25    
	 * 修改备注： 
	 * @param id</pre>    
	 */
	public Product toUpdateProduct(Integer id);

	/** <pre>updateProduct(修改)   
	 * 创建人：lihaiyan 3222476127@qq.com    
	 * 创建时间：2018年12月26日 下午9:51:20    
	 * 修改人：lihaiyan 3222476127@qq.com      
	 * 修改时间：2018年12月26日 下午9:51:20    
	 * 修改备注： 
	 * @param product</pre>    
	 */
	public void updateProduct(Product product);

	/** <pre>findProductCount(获取总条数)   
	 * 创建人：lihaiyan 3222476127@qq.com    
	 * 创建时间：2018年12月26日 下午10:30:18    
	 * 修改人：lihaiyan 3222476127@qq.com      
	 * 修改时间：2018年12月26日 下午10:30:18    
	 * 修改备注： 
	 * @param product
	 * @return</pre>    
	 */
	public Long findProductCount(Product product);

	/**
	 * 查询商品表所有的数据不分页
	 * @param product
	 * @return
	 */
    List<Product> findProductList(Product product);
	//将上传的多个图片的相对路径添加数据库图片表中
    void addProductChildImage(ProductImage productImages);
	//查看产品子图片图片
    List<ProductImage> findProductImage(Integer id);
	//查看商品所有数据
    List<Product> productList();
}
