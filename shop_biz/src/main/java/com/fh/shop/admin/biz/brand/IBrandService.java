/** 
 * <pre>项目名称:shop-admin-v2 
 * 文件名称:IBrandService.java 
 * 包名:com.fh.shop.backend.biz.brand 
 * 创建日期:2018年12月27日下午10:28:05 
 * Copyright (c) 2018, 3222476127@qq.com  All Rights Reserved.</pre> 
 */  
package com.fh.shop.admin.biz.brand;

import java.util.List;
import java.util.Map;

import com.fh.shop.admin.po.brand.Brand;
import com.fh.shop.backend.backend.backend.po.backend.common.DataTableResult;

/** 
 * <pre>项目名称：shop-admin-v2    
 * 类名称：IBrandService    
 * 类描述：    
 * 创建人：lihaiyan 3222476127@qq.com     
 * 创建时间：2018年12月27日 下午10:28:05    
 * 修改人：lihaiyan 3222476127@qq.com      
 * 修改时间：2018年12月27日 下午10:28:05    
 * 修改备注：       
 * @version </pre>    
 */
public interface IBrandService {

	/** <pre>findBrandCount(获取总条数)   
	 * 创建人：lihaiyan 3222476127@qq.com    
	 * 创建时间：2018年12月27日 下午10:59:25    
	 * 修改人：lihaiyan 3222476127@qq.com      
	 * 修改时间：2018年12月27日 下午10:59:25    
	 * 修改备注： 
	 * @param brand
	 * @return</pre>    
	 */
	Long findBrandCount(Brand brand);

	/** <pre>findBrand(查询所有数据)   
	 * 创建人：lihaiyan 3222476127@qq.com    
	 * 创建时间：2018年12月27日 下午11:20:54    
	 * 修改人：lihaiyan 3222476127@qq.com      
	 * 修改时间：2018年12月27日 下午11:20:54    
	 * 修改备注： 
	 * @param brand
	 * @return</pre>    
	 */
	List<Brand> findBrand(Brand brand);

	 DataTableResult buildBrandDataTable(Brand brand, int draw, int start, int length, Map<String, String[]> parameterMap);

	/** <pre>toUpdateBrand(修改回显)   
	 * 创建人：lihaiyan 3222476127@qq.com    
	 * 创建时间：2018年12月28日 上午12:18:56    
	 * 修改人：lihaiyan 3222476127@qq.com      
	 * 修改时间：2018年12月28日 上午12:18:56    
	 * 修改备注： 
	 * @param id
	 * @return</pre>    
	 */
	Brand toUpdateBrand(Integer id);

	/** <pre>updateBrand(修改)   
	 * 创建人：lihaiyan 3222476127@qq.com    
	 * 创建时间：2018年12月28日 上午12:24:28    
	 * 修改人：lihaiyan 3222476127@qq.com      
	 * 修改时间：2018年12月28日 上午12:24:28    
	 * 修改备注： 
	 * @param brand</pre>    
	 */
	void updateBrand(Brand brand);

	/** <pre>addBrand(添加)   
	 * 创建人：lihaiyan 3222476127@qq.com    
	 * 创建时间：2018年12月28日 上午10:07:45    
	 * 修改人：lihaiyan 3222476127@qq.com      
	 * 修改时间：2018年12月28日 上午10:07:45    
	 * 修改备注： 
	 * @param brand</pre>    
	 */
	void addBrand(Brand brand);

	/** <pre>deleteBrand(删除)   
	 * 创建人：lihaiyan 3222476127@qq.com    
	 * 创建时间：2018年12月28日 上午10:28:31    
	 * 修改人：lihaiyan 3222476127@qq.com      
	 * 修改时间：2018年12月28日 上午10:28:31    
	 * 修改备注： 
	 * @param id</pre>    
	 */
	void deleteBrand(Integer id);

	/** <pre>deleteBatchBrand(批量删除)   
	 * 创建人：lihaiyan 3222476127@qq.com    
	 * 创建时间：2018年12月28日 上午10:37:30    
	 * 修改人：lihaiyan 3222476127@qq.com      
	 * 修改时间：2018年12月28日 上午10:37:30    
	 * 修改备注： 
	 * @param ids</pre>    
	 */
	void deleteBatchBrand(String ids);

	/** <pre>findBrandList(获取品牌信息)   
	 * 创建人：lihaiyan 3222476127@qq.com    
	 * 创建时间：2019年1月2日 下午6:33:58    
	 * 修改人：lihaiyan 3222476127@qq.com      
	 * 修改时间：2019年1月2日 下午6:33:58    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<Brand> findBrandList();

}
