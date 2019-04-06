/** 
 * <pre>项目名称:shop-admin-v2 
 * 文件名称:ProductServiceImpl.java 
 * 包名:com.fh.shop.backend.biz.product 
 * 创建日期:2018年12月23日下午8:05:12 
 * Copyright (c) 2018, 3222476127@qq.com  All Rights Reserved.</pre> 
 */  
package com.fh.shop.admin.biz.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fh.core.util.FileUtil;
import com.fh.core.util.SystemConstants;
import com.fh.shop.admin.po.product.Product;
import com.fh.shop.admin.po.product.ProductImage;
import com.fh.shop.admin.vo.ProductVO;
import com.fh.shop.admin.mapper.product.IProductImageMapper;
import com.fh.shop.backend.backend.backend.po.backend.api.product.ProductVo;
import com.fh.shop.backend.backend.backend.po.backend.common.FileInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.shop.admin.mapper.product.IProductMapper;
import com.fh.shop.backend.po.product.Product;

/** 
 * <pre>项目名称：shop-admin-v2    
 * 类名称：ProductServiceImpl    
 * 类描述：    
 * 创建人：lihaiyan 3222476127@qq.com     
 * 创建时间：2018年12月23日 下午8:05:12    
 * 修改人：lihaiyan 3222476127@qq.com      
 * 修改时间：2018年12月23日 下午8:05:12    
 * 修改备注：       
 * @version </pre>    
 */
@Service("productService")
public class ProductServiceImpl implements IProductService{
	@Autowired	
	private IProductMapper productMapper;
	@Autowired
	private IProductImageMapper productImageMapper;
	/**
	 * 添加
	 */

	/*@Override
	public void addProduct(Product product,FileInfo fileInfo,List<FileInfo> fileInfoList,String realPath) {
		//添加主图片
		addProductImage(product, fileInfo, realPath);
		//添加商品信息
		Date now=new Date();
		product.setEntryTime(now);
		product.setUpdateTime(now);
		productMapper.addProduct(product);
		//添加子图片
		//上传子图片并添加到数据库字图片
		addChildImage(product, fileInfoList, realPath);
	}*/

	@Override
	public void addProduct(Product product) {
		//添加商品信息
		Date now=new Date();
		product.setEntryTime(now);
		product.setUpdateTime(now);
		productMapper.addProduct(product);
		//添加子图片
		List<ProductImage> productImageList = new ArrayList<>();
		String[] imagePathArr = product.getProductImagePathChildren().split(",");
		for (String imagePath : imagePathArr) {
			ProductImage productImage = new ProductImage();
			productImage.setImagePath(imagePath);
			productImage.setProductId(product.getId());
			productImageList.add(productImage);

		}
		if(productImageList.size()>0 && productImageList!=null){
			//将子图片信息添加到数据库表中
			productImageMapper.addProductImage(productImageList);
		}

	}

	/**
	 * 查看
	 */
	@Override
	public DataTableResult selectProduct(Product product) {
		//开始位置的下标
		product.setStartPos(product.getStart());
		//每页的条数
		product.setPageSize(product.getLength());
		//获取总条数
		Long totalCount=productMapper.findProductCount(product);
		//获取商品信息
		List<Product> productList=productMapper.selectProduct(product);
		//包装产品vo
		List<ProductVO> ProductVoList = wrapperProductVO(productList);

		//重组数据
		return DataTableResult.dataTableResultData(ProductVoList, product.getDraw(), totalCount, totalCount);
	}
	//包装产品vo
	private List<ProductVO> wrapperProductVO(List<Product> productList) {
		List<ProductVO> ProductVoList = new ArrayList<ProductVO>();
		for (Product productInfo : productList) {
			ProductVO productVo=new ProductVO();
			productVo.setId(productInfo.getId());
			productVo.setProductName(productInfo.getProductName());
			productVo.setEntryTime(productInfo.getEntryTime());
			productVo.setUpdateTime(productInfo.getUpdateTime());
			productVo.setProductImagePath(productInfo.getProductImagePath());
			productVo.setBrandName(productInfo.getBrand().getBrandName());
			productVo.setProductPrice(productInfo.getProductPrice());
			ProductVoList.add(productVo);
		}
		return ProductVoList;
	}

	/**
	 * 删除
	 */
	@Override
	public void deleteProdute(Integer id) {
		productMapper.deleteProdute(id);
	}
	/**
	 * 批量删除
	 */
	@Override
	public void deleteMany(String ids) {
		if(StringUtils.isNotEmpty(ids)){
			String[] idsArr = ids.split(",");
			List<Integer> idsList=new ArrayList<Integer>();
			for (int i = 0; i < idsArr.length; i++) {
				idsList.add(Integer.valueOf(idsArr[i]));
			}		
			productMapper.deleteMany(idsList);
		}
		
	}
	/**
	 * 修改回显
	 */
	@Override
	public Product toUpdateProduct(Integer id) {
		Product product=productMapper.toUpdateProduct(id);
		return product;
	}
	/**
	 * 修改
	 */
	@Override
	public void updateProduct(Product product,String realPath){

		if(StringUtils.isNotEmpty(product.getProductImagePath())){
			//删除主图片
			FileUtil.deleteFile(realPath+product.getProductImagePathHuiXian());
		}else{
			//product.getProductImagePath()不为空则证明主图不需要修改 所以就把回显的路径赋值给上传的路径
			product.setProductImagePath(product.getProductImagePathHuiXian());
		}
		//删除服务器上的子图片 并删除数据库的相关信息
		deleteChildImage(product,realPath);
		if(StringUtils.isNotEmpty(product.getProductImagePathChildren())){
			//添加子图片
			List<ProductImage> productImageList = new ArrayList<>();
			String[] imagePathArr = product.getProductImagePathChildren().split(",");
			for (String imagePath : imagePathArr) {
				ProductImage productImage = new ProductImage();
				productImage.setImagePath(imagePath);
				productImage.setProductId(product.getId());
				productImageList.add(productImage);

			}
			if(productImageList.size()>0 && productImageList!=null){
				//将子图片信息添加到数据库表中
				productImageMapper.addProductImage(productImageList);
			}
		}
		//修改商品
		product.setUpdateTime(new Date());

		productMapper.updateProduct(product);
	}
	/*@Override
	public void updateProduct(Product product, FileInfo fileInfo, List<FileInfo> fileIntoList, String realPath) {
		if(fileInfo!=null){
			if( fileInfo.getSize()!=null && fileInfo.getSize()>0){
				//根据相对路径获取该文件的绝对路径
				String rootPath = realPath+product.getProductImagePath();
				//修改主图片
				updateMainProductImage(product, fileInfo, realPath, rootPath);
			}
		}

		//删除服务器上的子图片 并删除数据库的相关信息
		deleteChildImage(product,realPath);
		//上传子图片并添加到数据库字图片
		addChildImage(product, fileIntoList, realPath);
		product.setUpdateTime(new Date());
		productMapper.updateProduct(product);
	}*/

	/**
	 * 修改  上传子图片并添加到数据库字图片
	 * @param product
	 * @param fileIntoList
	 * @param realPath
	 */
	private void addChildImage(Product product, List<FileInfo> fileIntoList, String realPath) {
		List<ProductImage> productImageList=new ArrayList<ProductImage>();
		for (FileInfo info : fileIntoList) {
			if(info.getSize()!=null && info.getSize()>0){
				//根据相对路径获取该文件的绝对路径
				String imageRealPath=realPath+SystemConstants.PRODUCT_IMAGES_PATH;
				//获取上传后的文件名
				String uploadedFileName = FileUtil.copyFile(info.getInputStream(), info.getFileName(), imageRealPath);
				//项目的相对路径更新到数据库
				String productImagePath = SystemConstants.PRODUCT_IMAGES_PATH + uploadedFileName;
				ProductImage productImage1=new ProductImage();
				productImage1.setImagePath(productImagePath);
				productImage1.setProductId(product.getId());
				productImageList.add(productImage1);
			}
		}
		if(productImageList.size()>0 && productImageList!=null){
			//将子图片信息添加到数据库表中
			productImageMapper.addProductImage(productImageList);
		}
	}

	/**
	 * 删除服务器上的子图片 并删除数据库的相关信息
	 * @param product
	 */
	private void deleteChildImage(Product product,String realPath) {
		if(StringUtils.isNotEmpty(product.getIds())){
			//处理删除子图片时传过来的字符串 并将其转换成list集合
			List<Integer> idList = getIdList(product);
			//根据id集合获取相关的图片信息
			List<ProductImage> productImageList=productImageMapper.findProductListById(idList);
			for (ProductImage image : productImageList) {
				String rootPath = realPath+image.getImagePath();
				//删除服务器上的子图片
				FileUtil.deleteFile(rootPath);
			}
			//根据id集合删除数据库字图片信息
			productImageMapper.deleteProductImage(idList);
		}
	}

	/**
	 * 处理删除子图片时传过来的字符串 并将其转换成list集合
	 * @param product
	 * @return
	 */
	private List<Integer> getIdList(Product product) {
		String[] productImageIdArr = product.getIds().substring(1).split(",");
		List<Integer> idList=new ArrayList<Integer>();
		for (String productImageId : productImageIdArr) {
			idList.add(Integer.parseInt(productImageId));
		}
		return idList;
	}

	/**
	 * 修改主图片
	 * @param product
	 * @param fileInfo
	 * @param realPath
	 * @param rootPath
	 */
	private void updateMainProductImage(Product product, FileInfo fileInfo, String realPath, String rootPath) {
		//删除主图片
		FileUtil.deleteFile(rootPath);
		//添加主图片
		addProductImage(product, fileInfo, realPath);
	}

	/**
	 * 上传主图
	 * @param product
	 * @param fileInfo
	 * @param realPath
	 */
	private void addProductImage(Product product, FileInfo fileInfo, String realPath) {
		String imageRealPath = realPath+SystemConstants.PRODUCT_IMAGES_PATH;
		////获取上传后的文件名
		if(fileInfo!=null) {
			String uploadedFileName = FileUtil.copyFile(fileInfo.getInputStream(), fileInfo.getFileName(), imageRealPath);
			//项目的相对路径更新到数据库
			String productImagePath = SystemConstants.PRODUCT_IMAGES_PATH + uploadedFileName;
			product.setProductImagePath(productImagePath);
		}


	}

	/**
	 * 获取总条数
	 */
	@Override
	public Long findProductCount(Product product) {
		Long totalCount = productMapper.findProductCount(product);
		return totalCount;
	}

	/**
	 * 查询商品表所有的数据不分页
	 * @param product
	 * @return
	 */
	@Override
	public List<Product> findProductList(Product product) {
		List<Product> productList=productMapper.findProductList(product);
		return productList;
	}

	/**
	 * 将上传的多个图片的相对路径添加数据库图片表中
	 */
    @Override
    public void addProductChildImage(ProductImage productImages) {
		productMapper.addProductChildImage(productImages);
    }

	/**
	 * 查看产品子图片图片
	 * @return
	 */
    @Override
    public List<ProductImage> findProductImage(Integer id) {
		List<ProductImage> productImageList=productMapper.findProductImage(id);
        return productImageList;
    }

	/**
	 * 查看商品所有数据
	 * @return
	 */
    @Override
    public List<ProductVo> productList() {
		List<Product> productList = productMapper.productList();
		List<ProductVo> productVoList=new ArrayList<>();
		for (Product product : productList) {
			ProductVo productVo=new ProductVo();
			productVo.setId(product.getId());
			productVo.setProductName(product.getProductName());
			productVo.setProductPrice(product.getProductPrice());
			productVo.setBrandName(product.getBrand().getBrandName());
			productVo.setProductImagePath(product.getProductImagePath());
			productVoList.add(productVo);
		}
		return productVoList;
    }

	/**
	 * 上传主图片
	 * @param fileInfo
	 * @param rootPath
	 * @return
	 */
	@Override
	public String uploadProductImage(FileInfo fileInfo,String rootPath) {
		String copyFile = "";
		if (fileInfo.getSize()>0){
			copyFile = FileUtil.copyFile(fileInfo.getInputStream(),fileInfo.getFileName(),rootPath+SystemConstants.PRODUCT_IMAGES_PATH);
		}
		return copyFile;
	}

}
