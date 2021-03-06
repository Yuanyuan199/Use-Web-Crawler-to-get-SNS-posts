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
package com.citydigitalpulse.collector.RealTimeInstagramGetter.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Full message after re-formating
 *
 */

public class MessageModel {
	// primary key
	private long num_id = 0;
	// message id
	private String raw_id_str = "";
	// user name
	private String user_name = "";
	// user image
	private String profile_img = "";
	// time stamp
	private long creat_at = 0;
	// message context
	private String text = "";
	// media type
	private List<String> media_types = new ArrayList<String>();
	// media urls
	private List<String> media_urls = new ArrayList<String>();
	private List<String> media_urls_local = new ArrayList<String>();
	// city, province, country,etc.
	private String place_type = "";
	private String place_name = "";
	private String place_fullname = "";
	private String country = "";
	private String province = "";
	private String city = "";
	// latitude and langtitude of queried city.
	private double query_location_latitude = 0;
	private double query_location_langtitude = 0;
	// The lat and lon set in spider is calculate value from polygons provided
	// by twitter, not the real lat and lon.
	private String is_real_location;
	// hashtags
	private List<String> hashtags = new ArrayList<String>();
	// Original id if it's retweet
	private String replay_to = "";
	// language
	private String lang = "";
	// machine labeled emotion on text
	private String emotion_text = "";
	// machine labeled emotion on media
	private List<String> emotion_medias = new ArrayList<String>();
	// machine labeled emotion on the tweet
	private String emotion_all = "";
	// source
	private String message_from = "";

	public MessageModel() {
		super();
	}

	public long getNum_id() {
		return num_id;
	}

	public void setNum_id(long num_id) {
		this.num_id = num_id;
	}

	public String getRaw_id_str() {
		return raw_id_str;
	}

	public void setRaw_id_str(String raw_id_str) {
		this.raw_id_str = raw_id_str;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public long getCreat_at() {
		return creat_at;
	}

	public void setCreat_at(long creat_at) {
		this.creat_at = creat_at;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<String> getMedia_types() {
		return media_types;
	}

	public void setMedia_types(List<String> media_types) {
		this.media_types = media_types;
	}

	public List<String> getMedia_urls() {
		return media_urls;
	}

	public void setMedia_urls(List<String> media_urls) {
		this.media_urls = media_urls;
	}

	public List<String> getMedia_urls_local() {
		return media_urls_local;
	}

	public void setMedia_urls_local(List<String> media_urls_local) {
		this.media_urls_local = media_urls_local;
	}

	public String getPlace_type() {
		return place_type;
	}

	public void setPlace_type(String place_type) {
		this.place_type = place_type;
	}

	public String getPlace_name() {
		return place_name;
	}

	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}

	public String getPlace_fullname() {
		return place_fullname;
	}

	public void setPlace_fullname(String place_fullname) {
		this.place_fullname = place_fullname;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getQuery_location_latitude() {
		return query_location_latitude;
	}

	public void setQuery_location_latitude(double query_location_latitude) {
		this.query_location_latitude = query_location_latitude;
	}

	public double getQuery_location_langtitude() {
		return query_location_langtitude;
	}

	public void setQuery_location_langtitude(double query_location_longtitude) {
		this.query_location_langtitude = query_location_longtitude;
	}

	public String getisreal() {
		return is_real_location;
	}

	public void setisreal(String is_real_location) {
		this.is_real_location = is_real_location;
	}

	public List<String> getHashtags() {
		return hashtags;
	}

	public void setHashtags(List<String> hashtags) {
		this.hashtags = hashtags;
	}

	public String getReplay_to() {
		return replay_to;
	}

	public void setReplay_to(String replay_to) {
		this.replay_to = replay_to;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getEmotion_text() {
		return emotion_text;
	}

	public void setEmotion_text(String emotion_text) {
		this.emotion_text = emotion_text;
	}

	public List<String> getEmotion_medias() {
		return emotion_medias;
	}

	public void setEmotion_medias(List<String> emotion_medias) {
		this.emotion_medias = emotion_medias;
	}

	public String getEmotion_all() {
		return emotion_all;
	}

	public void setEmotion_all(String emotion_all) {
		this.emotion_all = emotion_all;
	}

	public String getMessage_from() {
		return message_from;
	}

	public void setMessage_from(String message_from) {
		this.message_from = message_from;
	}

	public String getProfile_img() {
		return profile_img;
	}

	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}

	@Override
	public String toString() {
		return "StructuredFullMessage [num_id=" + num_id + ", raw_id_str=" + raw_id_str + ", user_name=" + user_name
				+ ", profile_img=" + profile_img + ", creat_at=" + creat_at + ", text=" + text + ", media_type="
				+ media_types + ", media_urls=" + media_urls + ", media_urls_local=" + media_urls_local
				+ ", place_type=" + place_type + ", place_name=" + place_name + ", place_fullname=" + place_fullname
				+ ", query_location_latitude=" + query_location_latitude + ", query_location_langtitude="
				+ query_location_langtitude + ", is_real_location=" + is_real_location + ", hashtags=" + hashtags
				+ ", replay_to=" + replay_to + ", lang=" + lang + ", emotion_text=" + emotion_text + ", emotion_medias="
				+ emotion_medias + ", emotion_all=" + emotion_all + ", message_from=" + message_from + "]";
	}

}
