/** 
 * <pre>项目名称:shop-admin-v2 
 * 文件名称:IProductService.java 
 * 包名:com.fh.shop.backend.biz.product 
 * 创建日期:2018年12月23日下午8:04:46 
 * Copyright (c) 2018, 3222476127@qq.com  All Rights Reserved.</pre> 
 */  
package com.fh.shop.admin.biz.product;

import java.util.List;

import com.fh.shop.admin.po.product.Product;
import com.fh.shop.admin.po.product.ProductImage;
import com.fh.shop.backend.backend.backend.po.backend.api.product.ProductVo;
import com.fh.shop.backend.backend.backend.po.backend.common.DataTableResult;
import com.fh.shop.backend.backend.backend.po.backend.common.FileInfo;


/** 
 * <pre>项目名称：shop-admin-v2    
 * 类名称：IProductService    
 * 类描述：    
 * 创建人：lihaiyan 3222476127@qq.com     
 * 创建时间：2018年12月23日 下午8:04:46    
 * 修改人：lihaiyan 3222476127@qq.com      
 * 修改时间：2018年12月23日 下午8:04:46    
 * 修改备注：       
 * @version </pre>    
 */
public interface IProductService {

	/** <pre>addProduct(这里用一句话描述这个方法的作用)   
	 * 创建人：lihaiyan 3222476127@qq.com    
	 * 创建时间：2018年12月23日 下午8:28:42    
	 * 修改人：lihaiyan 3222476127@qq.com      
	 * 修改时间：2018年12月23日 下午8:28:42    
	 * 修改备注： 
	 * @param product</pre>    
	 */
	/*public void addProduct(Product product,FileInfo fileInfo,List<FileInfo> fileInfoList,String realPath);*/
	public void addProduct(Product product);
	/** <pre>selectProduct(查看)   
	 * 创建人：lihaiyan 3222476127@qq.com    
	 * 创建时间：2018年12月25日 下午3:28:18    
	 * 修改人：lihaiyan 3222476127@qq.com      
	 * 修改时间：2018年12月25日 下午3:28:18    
	 * 修改备注： 
	 * @return</pre>    
	 */
	public DataTableResult selectProduct(Product product);

	/** <pre>deleteProdute(这里用一句话描述这个方法的作用)   
	 * 创建人：lihaiyan 3222476127@qq.com    
	 * 创建时间：2018年12月25日 下午6:23:29    
	 * 修改人：lihaiyan 3222476127@qq.com      
	 * 修改时间：2018年12月25日 下午6:23:29    
	 * 修改备注： 
	 * @param id</pre>    
	 */
	public void deleteProdute(Integer id);

	/** <pre>deleteMany(批量删除)   
	 * 创建人：lihaiyan 3222476127@qq.com    
	 * 创建时间：2018年12月25日 下午6:54:40    
	 * 修改人：lihaiyan 3222476127@qq.com      
	 * 修改时间：2018年12月25日 下午6:54:40    
	 * 修改备注： 
	 * @param ids</pre>    
	 */
	public void deleteMany(String ids);

	/** <pre>toUpdateProduct(修改回显)   
	 * 创建人：lihaiyan 3222476127@qq.com    
	 * 创建时间：2018年12月26日 下午3:35:42    
	 * 修改人：lihaiyan 3222476127@qq.com      
	 * 修改时间：2018年12月26日 下午3:35:42    
	 * 修改备注： 
	 * @param id</pre>    
	 */
	public Product toUpdateProduct(Integer id);

	/** <pre>updateProduct(修改)   
	 * 创建人：lihaiyan 3222476127@qq.com    
	 * 创建时间：2018年12月26日 下午9:50:28    
	 * 修改人：lihaiyan 3222476127@qq.com      
	 * 修改时间：2018年12月26日 下午9:50:28    
	 * 修改备注： 
	 * @param product</pre>    
	 */
	/*public void updateProduct(Product product,FileInfo fileInto,List<FileInfo> fileInfoList,String realPath);*/
	 void updateProduct(Product product, String realPath);
	/** <pre>findProductCount(获取总条数)   
	 * 创建人：lihaiyan 3222476127@qq.com    
	 * 创建时间：2018年12月26日 下午10:28:12    
	 * 修改人：lihaiyan 3222476127@qq.com      
	 * 修改时间：2018年12月26日 下午10:28:12    
	 * 修改备注： 
	 * @param product
	 * @return</pre>    
	 */
	public Long findProductCount(Product product);
	//查询商品表所有的数据 分页
    List<Product> findProductList(Product product);
	//将上传的多个图片的相对路径添加数据库图片表中
    void addProductChildImage(ProductImage productImage);
	//查看产品子图片图片
    List<ProductImage> findProductImage(Integer id);
	//查看商品所有数据
    List<ProductVo> productList();
//上传主图片
    String uploadProductImage(FileInfo fileInfo, String rootPath);
}
