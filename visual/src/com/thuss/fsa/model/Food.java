package com.thuss.fsa.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Food entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "food", schema = "dbo", catalog = "hotel")
public class Food implements java.io.Serializable {

	// Fields

	private Long foodId;
	private Long hotelId;
	private String foodName;
	private Integer unitMoney;
	private Long cateCode;
	private String cateName;

	// Constructors

	/** default constructor */
	public Food() {
	}

	/** minimal constructor */
	public Food(Long foodId) {
		this.foodId = foodId;
	}

	/** full constructor */
	public Food(Long foodId, Long hotelId, String foodName, Integer unitMoney,
			Long cateCode, String cateName) {
		this.foodId = foodId;
		this.hotelId = hotelId;
		this.foodName = foodName;
		this.unitMoney = unitMoney;
		this.cateCode = cateCode;
		this.cateName = cateName;
	}

	// Property accessors
	@Id
	@Column(name = "food_id", unique = true, nullable = false)
	public Long getFoodId() {
		return this.foodId;
	}

	public void setFoodId(Long foodId) {
		this.foodId = foodId;
	}

	@Column(name = "hotel_id")
	public Long getHotelId() {
		return this.hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	@Column(name = "food_name")
	public String getFoodName() {
		return this.foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	@Column(name = "unit_money")
	public Integer getUnitMoney() {
		return this.unitMoney;
	}

	public void setUnitMoney(Integer unitMoney) {
		this.unitMoney = unitMoney;
	}

	@Column(name = "cate_code")
	public Long getCateCode() {
		return this.cateCode;
	}

	public void setCateCode(Long cateCode) {
		this.cateCode = cateCode;
	}

	@Column(name = "cate_name")
	public String getCateName() {
		return this.cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
}