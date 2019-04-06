/** 
 * <pre>项目名称:shop-admin-v2 
 * 文件名称:BrandServiceImpl.java 
 * 包名:com.fh.shop.backend.biz.brand 
 * 创建日期:2018年12月27日下午10:28:28 
 * Copyright (c) 2018, 3222476127@qq.com  All Rights Reserved.</pre> 
 */  
package com.fh.shop.admin.biz.brand;

import com.fh.core.util.DateUtil;
import com.fh.core.util.RedisUtil;
import com.fh.core.util.SystemConstants;
import com.fh.shop.admin.biz.BaseService;
import com.fh.shop.admin.po.brand.Brand;
import com.fh.shop.admin.mapper.brand.IBrandMapper;
import com.fh.shop.admin.vo.BrandVO;
import com.fh.shop.backend.backend.backend.po.backend.common.DataTableResult;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("brandService")
public class BrandServiceImpl extends BaseService implements IBrandService{
	@Autowired
	private IBrandMapper brandMapper;



	/**
	 * 查询
	 * @param
	 * @return
	 */
	public List<Brand> findBrandList(){
		//调用
		String brandListInfo = RedisUtil.get("brandList");
		Gson gson = new Gson();
		if (StringUtils.isEmpty(brandListInfo)){
			List<Brand> brandList = brandMapper.findBrandList();
			String brandListJson = gson.toJson(brandList);
			RedisUtil.set("brandList",brandListJson);
 			return brandList;
		}else {
			Type type = new TypeToken<List<Brand>>(){}.getType();
			List<Brand> brandList = gson.fromJson(brandListInfo, type);
			return brandList;
		}
	}



	/**
	 * 获取总条数
	 */	
	@Override
	public Long findBrandCount(Brand brand) {
		Long brandCount = brandMapper.findBrandCount(brand);
		return brandCount;
	}

	/**
	 * 查询所有数据
	 */
	@Override
	public List<Brand> findBrand(Brand brand) {
		List<Brand> brandList = brandMapper.findBrand(brand);
		return brandList;
	}

	//构建DataTable品牌数据
	public DataTableResult buildBrandDataTable(Brand brand, int draw, int start, int length, Map<String, String[]> parameterMap) {
		//构建排序字段 并给前台展示的字段映射成数据库字段
		buildOrder(brand, parameterMap);
		/*//遍历map
		Iterator<Map.Entry<String, String[]>> iterator = parameterMap.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<String, String[]> entry = iterator.next();
			//获取entry对象的键值
			String key = entry.getKey();
			//StringUtils.join(entry.getValue(),",")转换成string类型
			//System.out.println(key+":"+StringUtils.join(entry.getValue(),","));
			if(key.equals("order[0][column]")){
				String value = parameterMap.get(key)[0];
				ordetFilder=value;
				break;
			}
		}*/
		//开始位置的下标
		brand.setStartPos(start);
		//每页的条数
		brand.setPageSize(length);
		//获取总条数
		Long totalCount=findBrandCount(brand);
		//查询所有数据
		List<Brand> brandList=findBrand(brand);
		//包装品牌VO
		List<BrandVO> brandVOList = wrapperBrandVO(brandList);
		return DataTableResult.dataTableResultData(brandVOList, draw, totalCount, totalCount);
	}
	//包装品牌VO
	private List<BrandVO> wrapperBrandVO(List<Brand> brandList) {
		List<BrandVO> brandVOList=new ArrayList<>();
		for (Brand brandInfo : brandList) {
			BrandVO brandVO=new BrandVO();
			brandVO.setId(brandInfo.getId());
			brandVO.setBrandName(brandInfo.getBrandName());
			brandVO.setBrandEntryTimeStr(DateUtil.date2Str(brandInfo.getBrandEntryTime(),DateUtil.Y_M_D_h_M_S));
			brandVO.setBrandUpdateTimeStr(DateUtil.date2Str(brandInfo.getBrandUpdateTime(),DateUtil.Y_M_D_h_M_S));
			brandVOList.add(brandVO);
		}
		return brandVOList;
	}

	//构建排序字段 并给前台展示的字段映射成数据库字段
	private void buildOrder(Brand brand, Map<String, String[]> parameterMap) {
		//提取排序的字段和排序的方向
		String orderFilder="";
		String orderDirection="";
		Gson gson = new Gson();
		Map fieldMapping = gson.fromJson(SystemConstants.FILELDMAPPING, Map.class);
		//获取排序的列
		if(parameterMap.get(SystemConstants.GET_ORDER_COLUMN)!=null){
			String orderColumn = parameterMap.get(SystemConstants.GET_ORDER_COLUMN)[0];
			//获取排序的字段  getColumnData是调用baseService的方法
			String orderFilderTemp=parameterMap.get(getColumnData(orderColumn))[0];
			//通过map获取映射后的字段名 通过key来获取value值
			//String  mapValue = (String) SystemConstants.FILELDMAPPING.get(orderFilderTemp);
			String  mapValue = (String)fieldMapping.get(orderFilderTemp);
			//三目运算符 如果获取到的value值为空的话就
			// 说明要排序的属性名和数据库的字段名是一致的所以才没有做映射 直接用获取到的字段
			//否则的话就用映射后的字段
			orderFilder=StringUtils.isEmpty(mapValue) ? orderFilderTemp:mapValue;
		}
		//获取排序的方向
		if(parameterMap.get(SystemConstants.GET_ORDER_DIRECTION)!=null){
			orderDirection = parameterMap.get(SystemConstants.GET_ORDER_DIRECTION)[0];
		}

		brand.setSortFiled(orderFilder);
		brand.setSort(orderDirection);
	}


	/**
	 * 修改回显
	 */
	@Override
	public Brand toUpdateBrand(Integer id) {
		Brand brand = brandMapper.toUpdateBrand(id);
		return brand;
	}

	/**
	 * 修改
	 */
	@Override
	public void updateBrand(Brand brand) {
		brand.setBrandUpdateTime(new Date());
		brandMapper.updateBrand(brand);
		
	}


	/**
	 * 添加
	 */
	@Override
	public void addBrand(Brand brand) {
		Date date=new Date();
		brand.setBrandEntryTime(date);
		brand.setBrandUpdateTime(date);
		brandMapper.addBrand(brand);
	}

	/**
	 * 删除
	 */
	@Override
	public void deleteBrand(Integer id) {
		brandMapper.deleteBrand(id);
	}


	/**
	 * 批量删除
	 */
	@Override
	public void deleteBatchBrand(String ids) {
		if(StringUtils.isNotEmpty(ids)){
			List<Integer> idList=new ArrayList<Integer>();
			String[] idArr = ids.split(",");
			for (String id : idArr) {
				idList.add(Integer.valueOf(id));
			}
			brandMapper.deleteBatchBrand(idList);
		}
	}


}
