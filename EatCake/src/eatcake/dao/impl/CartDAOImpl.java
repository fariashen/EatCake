package eatcake.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

import eatcake.dao.CartDAO;
import eatcake.model.Cart;

@Repository
public class CartDAOImpl extends BassDAOImpl implements CartDAO {

	@Override
	public Cart getCartByUserName(String userName) {
		
		String hql="FROM Cart cart "
				+ "WHERE cart.creator.userName = ?";
		Query query = getSession().createQuery(hql)
				.setString(0, userName);
		
		return (Cart) query.uniqueResult();
	}

	@Override
	public Cart getCartByGoodsIdAndUserNama(Integer goodsId, String userName) {
		
		String hql = "FROM Cart cart "
				+ "WHERE cart.goods.goodsId = ? "
				+ "AND cart.creator.userName = ?";
		Query query = getSession().createQuery(hql)
				.setInteger(0, goodsId)
				.setString(1, userName);
		
		return (Cart) query.uniqueResult();
	}

	@Override
	public Integer saveCartRecord(Cart cart) {

		return (Integer) getSession().save(cart);
	}

}
