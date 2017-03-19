package eatcake.model;

public class Goods {

	private Integer goodsId;
	private String goodsName;
	private String goodsType;
	private String goodsImgPath;
	private String goodsBrief;
	private String goodsDetail;
	private Double goodsPrice;
	
	
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
	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName
				+ ", goodsType=" + goodsType + ", goodsImgPath=" + goodsImgPath
				+ ", goodsBrief=" + goodsBrief + ", goodsDetail=" + goodsDetail
				+ ", goodsPrice=" + goodsPrice + "]";
	}
	
	
	
}
