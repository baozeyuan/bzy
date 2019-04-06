/** 
 * <pre>项目名称:shop-admin-v2 
 * 文件名称:IBrandMapper.java 
 * 包名:com.fh.shop.backend.mapper.brand 
 * 创建日期:2018年12月27日下午10:27:25 
 * Copyright (c) 2018, 3222476127@qq.com  All Rights Reserved.</pre> 
 */  
package com.fh.shop.admin.mapper.brand;

import java.util.List;

import com.fh.shop.admin.po.brand.Brand;
import com.fh.shop.backend.po.brand.Brand;

/** 
 * <pre>项目名称：shop-admin-v2    
 * 类名称：IBrandMapper    
 * 类描述：    
 * 创建人：lihaiyan 3222476127@qq.com     
 * 创建时间：2018年12月27日 下午10:27:25    
 * 修改人：lihaiyan 3222476127@qq.com      
 * 修改时间：2018年12月27日 下午10:27:25    
 * 修改备注：       
 * @version </pre>    
 */
public interface IBrandMapper {

	/** <pre>findBrandCount(获取总条数)   
	 * 创建人：lihaiyan 3222476127@qq.com    
	 * 创建时间：2018年12月27日 下午11:00:22    
	 * 修改人：lihaiyan 3222476127@qq.com      
	 * 修改时间：2018年12月27日 下午11:00:22    
	 * 修改备注： 
	 * @param brand
	 * @return</pre>    
	 */
	public Long findBrandCount(Brand brand);

	/** <pre>findBrand(查询所有数据)   
	 * 创建人：lihaiyan 3222476127@qq.com    
	 * 创建时间：2018年12月27日 下午11:21:49    
	 * 修改人：lihaiyan 3222476127@qq.com      
	 * 修改时间：2018年12月27日 下午11:21:49    
	 * 修改备注： 
	 * @param brand
	 * @return</pre>    
	 */
	public List<Brand> findBrand(Brand brand);

	/** <pre>toUpdateBrand(修改回显)   
	 * 创建人：lihaiyan 3222476127@qq.com    
	 * 创建时间：2018年12月28日 上午12:19:50    
	 * 修改人：lihaiyan 3222476127@qq.com      
	 * 修改时间：2018年12月28日 上午12:19:50    
	 * 修改备注： 
	 * @param id
	 * @return</pre>
	 */
	public Brand toUpdateBrand(Integer id);

	/** <pre>updateBrand(修改)   
	 * 创建人：lihaiyan 3222476127@qq.com    
	 * 创建时间：2018年12月28日 上午12:25:07    
	 * 修改人：lihaiyan 3222476127@qq.com      
	 * 修改时间：2018年12月28日 上午12:25:07    
	 * 修改备注： 
	 * @param brand</pre>    
	 */
	public void updateBrand(Brand brand);

	/** <pre>addBrand( 添加)   
	 * 创建人：lihaiyan 3222476127@qq.com    
	 * 创建时间：2018年12月28日 上午10:08:55    
	 * 修改人：lihaiyan 3222476127@qq.com      
	 * 修改时间：2018年12月28日 上午10:08:55    
	 * 修改备注： 
	 * @param brand</pre>    
	 */
	public void addBrand(Brand brand);

	/** <pre>deleteBrand(删除)   
	 * 创建人：lihaiyan 3222476127@qq.com    
	 * 创建时间：2018年12月28日 上午10:29:27    
	 * 修改人：lihaiyan 3222476127@qq.com      
	 * 修改时间：2018年12月28日 上午10:29:27    
	 * 修改备注： 
	 * @param id</pre>    
	 */
	public void deleteBrand(Integer id);

	/** <pre>deleteBatchBrand(批量删除)   
	 * 创建人：lihaiyan 3222476127@qq.com    
	 * 创建时间：2018年12月28日 上午10:40:32    
	 * 修改人：lihaiyan 3222476127@qq.com      
	 * 修改时间：2018年12月28日 上午10:40:32    
	 * 修改备注： 
	 * @param idList</pre>    
	 */
	public void deleteBatchBrand(List<Integer> idList);

	/** <pre>findBrandList(获取品牌信息)   
	 * 创建人：lihaiyan 3222476127@qq.com    
	 * 创建时间：2019年1月2日 下午6:34:50    
	 * 修改人：lihaiyan 3222476127@qq.com      
	 * 修改时间：2019年1月2日 下午6:34:50    
	 * 修改备注： 
	 * @return</pre>    
	 */
	public List<Brand> findBrandList();

}
