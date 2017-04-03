package eatcake.vo;

import java.io.File;

import eatcake.model.Goods;

public class GoodsVo {
	private Integer goodsId;
	private String goodsName;
	private String goodsType;
	private String goodsImgPath;
	private String goodsBrief;
	private String goodsDetail;
	private Double goodsPrice;
	
//	文件上传属性
	private File img;
	private String imgContentType;
	private String imgFileName;
	
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public String getGoodsImgPath() {
		return goodsImgPath;
	}
	public void setGoodsImgPath(String goodsImgPath) {
		this.goodsImgPath = goodsImgPath;
	}
	public String getGoodsBrief() {
		return goodsBrief;
	}
	public void setGoodsBrief(String goodsBrief) {
		this.goodsBrief = goodsBrief;
	}
	public String getGoodsDetail() {
		return goodsDetail;
	}
	public void setGoodsDetail(String goodsDetail) {
		this.goodsDetail = goodsDetail;
	}
	public Double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public File getImg() {
		return img;
	}
	public void setImg(File img) {
		this.img = img;
	}
	public String getImgContentType() {
		return imgContentType;
	}
	public void setImgContentType(String imgContentType) {
		this.imgContentType = imgContentType;
	}
	public String getImgFileName() {
		return imgFileName;
	}
	public void setImgFileName(String imgName) {
		this.imgFileName = imgName;
	}
	public GoodsVo() {
		super();
	}
	
//	根据 Goods Model 构造值对象
	public GoodsVo(Goods goods) {
		super();
		this.goodsId = goods.getGoodsId();
		this.goodsName = goods.getGoodsName();
		this.goodsType = goods.getGoodsType();
		this.goodsImgPath = goods.getGoodsImgPath();
		this.goodsBrief = goods.getGoodsBrief();
		this.goodsDetail = goods.getGoodsDetail();
		this.goodsPrice = goods.getGoodsPrice();
	}
	
	
}
