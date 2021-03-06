/** 
 * Copyright (C) 2016 City Digital Pulse - All Rights Reserved
 *  
 * Author: Yuanyuan Li
 *  
 * Design: Zhongli Li and Shiai Zhu
 *  
 * Concept and supervision Abdulmotaleb El Saddik
 *
 */
package com.citydigitalpulse.collector.RealTimeInstagramGetter.dao.ipml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.citydigitalpulse.collector.RealTimeInstagramGetter.dao.MessageInterface;
import com.citydigitalpulse.collector.RealTimeInstagramGetter.model.MessageModel;
import com.citydigitalpulse.collector.RealTimeInstagramGetter.tool.Tools;

/**
 * Save formated message object to DB
 * 
 * @author zhongli
 */
public class MessageInterface_MySQL implements MessageInterface {
	MessageConnector savingDB;

	public MessageInterface_MySQL() {
		savingDB = new MessageConnector();
	}

	public long insert(MessageModel msg) {
		PreparedStatement ps = null;
		Connection conn = null;
		long key = 0;
		try {
			conn = savingDB.getConnection();
			String sqlString = "INSERT INTO full_message_ig_realtime (raw_id_str, user_name, profile_img, creat_at, text, emotion_text, media_types, media_urls, media_urls_local, emotion_medias, emotion_all, place_type, place_name, place_fullname, country, province, city, query_location_latitude, query_location_langtitude, is_real_location, hashtags, replay_to, lang, message_from) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			ps = conn.prepareStatement(sqlString, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, msg.getRaw_id_str());
			ps.setString(2, msg.getUser_name());
			ps.setString(3, msg.getProfile_img());
			ps.setLong(4, msg.getCreat_at());
			ps.setString(5, msg.getText());
			ps.setString(6, msg.getEmotion_text());
			ps.setString(7, Tools.buildStringFromList(msg.getMedia_types()));
			ps.setString(8, Tools.buildStringFromList(msg.getMedia_urls()));
			ps.setString(9, Tools.buildStringFromList(msg.getMedia_urls_local()));
			ps.setString(10, Tools.buildStringFromList(msg.getEmotion_medias()));
			ps.setString(11, msg.getEmotion_all());
			ps.setString(12, msg.getPlace_type());
			ps.setString(13, msg.getPlace_name());
			ps.setString(14, msg.getPlace_fullname());
			ps.setString(15, msg.getCountry());
			ps.setString(16, msg.getProvince());
			ps.setString(17, msg.getCity());
			ps.setDouble(18, msg.getQuery_location_latitude());
			ps.setDouble(19, msg.getQuery_location_langtitude());
			ps.setString(20, msg.getisreal());
			ps.setString(21, Tools.buildStringFromList(msg.getHashtags()));
			ps.setString(22, msg.getReplay_to());
			ps.setString(23, msg.getLang());
			ps.setString(24, msg.getMessage_from());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				key = rs.getLong(1);
				System.out.println("key:" + key);
			} else {
				// 插入失败
			}
			// 获得插入数据库的编号
			return key;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	@Override
	public void insert(List<MessageModel> msgs) {
		Connection conn = null;
		Statement statement = null;
		MessageModel msg;
		try {
			conn = savingDB.getConnection();
			// 指定在事物中提交
			conn.setAutoCommit(false);
			statement = conn.createStatement();
			// 循环添加新消息
			for (int i = 0; i < msgs.size(); i++) {
				msg = msgs.get(i);
				String sqlString = "INSERT INTO full_message_ig_realtime (raw_id_str, user_name, profile_img, creat_at, text, emotion_text, media_types, media_urls, media_urls_local, emotion_medias, emotion_all, place_type, place_name, place_fullname, country, province, city, query_location_latitude, query_location_langtitude, is_real_location, hashtags, replay_to, lang, message_from) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
				PreparedStatement ps = conn.prepareStatement(sqlString);
				ps.setString(1, msg.getRaw_id_str());
				ps.setString(2, msg.getUser_name());
				ps.setString(3, msg.getProfile_img());
				ps.setLong(4, msg.getCreat_at());
				ps.setString(5, msg.getText());
				ps.setString(6, msg.getEmotion_text());
				ps.setString(7, Tools.buildStringFromList(msg.getMedia_types()));
				ps.setString(8, Tools.buildStringFromList(msg.getMedia_urls()));
				ps.setString(9, Tools.buildStringFromList(msg.getMedia_urls_local()));
				ps.setString(10, Tools.buildStringFromList(msg.getEmotion_medias()));
				ps.setString(11, msg.getEmotion_all());
				ps.setString(12, msg.getPlace_type());
				ps.setString(13, msg.getPlace_name());
				ps.setString(14, msg.getPlace_fullname());
				ps.setString(15, msg.getCountry());
				ps.setString(16, msg.getProvince());
				ps.setString(17, msg.getCity());
				ps.setDouble(18, msg.getQuery_location_latitude());
				ps.setDouble(19, msg.getQuery_location_langtitude());
				ps.setString(20, msg.getisreal());
				ps.setString(21, Tools.buildStringFromList(msg.getHashtags()));
				ps.setString(22, msg.getReplay_to());
				ps.setString(23, msg.getLang());
				ps.setString(24, msg.getMessage_from());
				ps.executeUpdate();
			}
			// 提交更改
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			// // 有错误发生回滚修改
			// try {
			// conn.rollback();
			// } catch (SQLException e1) {
			// e1.printStackTrace();
			// throw new RuntimeException(e1);
			// }
			// throw new RuntimeException(e);
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

}
