package com.it.dao;

import com.it.entity.Card;
import com.kaishengit.tools.BeanRowMapper;
import com.kaishengit.tools.DBHelper;

public class CardDAO {
	DBHelper<Card> db = new DBHelper<>(Config.DB_URL);
	BeanRowMapper<Card> be = new BeanRowMapper<>(Card.class);

	public boolean add(Card card) {
		String sql = "insert into card(code,name,tel) values(?,?,?)";
		int result = db.doUpdate(sql, card.getCode(), card.getName(), card.getTel());
		return result == 1;
	}

	public Card findOne(String code){
		String sql = "select * from card where code=?";
		return db.queryOne(sql, be, code);
	}
}
