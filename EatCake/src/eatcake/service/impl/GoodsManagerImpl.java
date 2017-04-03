package eatcake.service.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eatcake.dao.GoodsDAO;
import eatcake.model.Goods;
import eatcake.service.GoodsManager;
import eatcake.vo.GoodsVo;

@Service
public class GoodsManagerImpl implements GoodsManager {

	@Autowired
	private GoodsDAO goodsDao;
	
	@Override
	public Boolean addGoodsRecord(GoodsVo goodsVo) {

		try {
//			定义保存图片的输入输出流
			FileOutputStream out = new FileOutputStream(goodsVo.getGoodsImgPath());
			FileInputStream in = new FileInputStream(goodsVo.getImg());
			
//			将输入流写到指定的位置
			byte [] buffer = new byte[1024];
			int len = 0;
			
			while((len = in.read(buffer)) != -1){
				out.write(buffer, 0, len);
			}
			
			out.close();
			in.close();
			
			Goods goods = new Goods(goodsVo);
			Goods existGoods = goodsDao.getGoodsByGoodsId(goods.getGoodsId());
			if(existGoods == null){
				goodsDao.saveOrUpdateGoodsInfo(goods);
			}
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean deleteGoodsRecord(Integer goodsId) {
		try {
			goodsDao.deleteGoods(goodsDao.getGoodsByGoodsId(goodsId));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Boolean changeGoodsInfo(Goods goods) {

		try {
			goodsDao.saveOrUpdateGoodsInfo(goods);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Goods searchGoods(Integer goodsId) {

		return goodsDao.getGoodsByGoodsId(goodsId);
	}

	@Override
	public List<Goods> searchGoods(String goodsType) {

		return goodsDao.getGoodsByCategory(goodsType);
	}

	@Override
	public boolean getAllGoodsInfo(Map<String, Object> requset) {

		try {
			requset.put("goodsList", goodsDao.getAllGoods());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
