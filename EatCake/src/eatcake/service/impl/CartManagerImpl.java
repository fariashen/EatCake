package eatcake.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eatcake.dao.CartDAO;
import eatcake.dao.GoodsDAO;
import eatcake.dao.UserDAO;
import eatcake.model.Cart;
import eatcake.model.Goods;
import eatcake.model.User;
import eatcake.service.CartManager;
import eatcake.vo.CartVO;

@Service
public class CartManagerImpl implements CartManager {

	@Autowired
	private CartDAO cartDao;
	@Autowired
	private UserDAO userDao;
	@Autowired
	private GoodsDAO goodsDao;

	@Override
	public Boolean addGoodsToCart(Map<String, Object> request, Integer goodsId,
			String userName) {

		try {
			if (userName.length()>0) {
					request.put("logStatus", "In");
					Cart exist = cartDao
							.getCartByGoodsIdAndUserNama(goodsId,userName);
					if (exist == null) {
						Cart cart = new Cart();
						cart.setCreator(userDao.getUserByUserName(userName));
						cart.setGoods(goodsDao.getGoodsByGoodsId(goodsId));
						cart.setNum(1);
						cartDao.saveCartRecord(cart);
					} else {
						exist.setNum(exist.getNum() + 1);
					}
				
			} else {
				request.put("logStatus", "Out");
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Boolean checkCartRecord(Map<String, Object> session, String userName) {

		if(userName.length()>0){
			try {
				List<CartVO> cartVoList = new ArrayList<CartVO>() ;
				List<Cart> cartList = cartDao.getCartByUserName(userName);
				for(Cart cart : cartList){
					CartVO cartVo = new CartVO();
					Goods goods = cart.getGoods();
					User user = cart.getCreator();
					
					cartVo.setGoodsId(goods.getGoodsId());
					cartVo.setGoodsName(goods.getGoodsName());
					cartVo.setGoodsPrice(goods.getGoodsPrice());
					cartVo.setNum(cart.getNum());
					cartVo.setUserId(user.getId());
					cartVo.setUserName(user.getUserName());
					
					cartVoList.add(cartVo);
				}
				session.put("cartVoList", cartVoList);
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

}
