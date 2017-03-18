package eatcake.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import eatcake.dao.GoodsDAO;
import eatcake.model.Goods;

@Repository
public class GoodsDAOImpl extends BassDAOImpl implements GoodsDAO {

	@Override
	public Goods getGoodsByGoodsId(Integer goodsId) {

		String hql = "FROM Goods goods "
				+ "WHERE goods.goodsId = ? ";
		Query query = getSession().createQuery(hql)
				.setInteger(0, goodsId);
		return (Goods) query.uniqueResult();
	}

	@Override
	public Boolean saveOrUpdateGoodsInfo(Goods goods) {

		try {
			getSession().saveOrUpdate(goods);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Boolean deleteGoods(Goods goods) {
		try {
			
			getSession().delete(goods);
			
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public List<Goods> getGoodsByCategory(String goodsType) {

		String hql = "FROM Goods goods WHERE goods.goodsType = ?";
		Query query = getSession().createQuery(hql).setString(0, goodsType);
		
		return query.list();
	}

	@Override
	public List<Goods> getAllGoods() {

		String hql = "FROM Goods goods";
		Query query = getSession().createQuery(hql);
		return query.list();
	}

}
