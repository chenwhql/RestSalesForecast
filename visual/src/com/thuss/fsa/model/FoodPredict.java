package com.thuss.fsa.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * FoodPredict entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "food_predict", schema = "dbo", catalog = "hotel")
public class FoodPredict implements java.io.Serializable {

	// Fields

	private Long id;
	private Long hotelId;
	private Long foodId;
	private String foodName;
	private Long cateCode;
	private String cateName;
	private Integer unitMoney;
	private String checkDate;
	private String dayofweek;
	private Integer totalNum;
	private Integer totalOrders;
	private Long orderNum;
	private Date predictDate;
	private Long soldNum;
	private Double totalMoney;

	// Constructors

	/** default constructor */
	public FoodPredict() {
	}

	/** minimal constructor */
	public FoodPredict(Long id) {
		this.id = id;
	}

	/** full constructor */
	public FoodPredict(Long id, Long hotelId, Long foodId, String foodName,
			Long cateCode, String cateName, Integer unitMoney,
			String checkDate, String dayofweek, Integer totalNum,
			Integer totalOrders, Long orderNum, Date predictDate, Long soldNum,
			Double totalMoney) {
		this.id = id;
		this.hotelId = hotelId;
		this.foodId = foodId;
		this.foodName = foodName;
		this.cateCode = cateCode;
		this.cateName = cateName;
		this.unitMoney = unitMoney;
		this.checkDate = checkDate;
		this.dayofweek = dayofweek;
		this.totalNum = totalNum;
		this.totalOrders = totalOrders;
		this.orderNum = orderNum;
		this.predictDate = predictDate;
		this.soldNum = soldNum;
		this.totalMoney = totalMoney;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "hotel_id")
	public Long getHotelId() {
		return this.hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	@Column(name = "food_id")
	public Long getFoodId() {
		return this.foodId;
	}

	public void setFoodId(Long foodId) {
		this.foodId = foodId;
	}

	@Column(name = "food_name")
	public String getFoodName() {
		return this.foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
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

	@Column(name = "unit_money")
	public Integer getUnitMoney() {
		return this.unitMoney;
	}

	public void setUnitMoney(Integer unitMoney) {
		this.unitMoney = unitMoney;
	}

	@Column(name = "check_date")
	public String getCheckDate() {
		return this.checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

	@Column(name = "dayofweek")
	public String getDayofweek() {
		return this.dayofweek;
	}

	public void setDayofweek(String dayofweek) {
		this.dayofweek = dayofweek;
	}

	@Column(name = "total_num")
	public Integer getTotalNum() {
		return this.totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	@Column(name = "total_orders")
	public Integer getTotalOrders() {
		return this.totalOrders;
	}

	public void setTotalOrders(Integer totalOrders) {
		this.totalOrders = totalOrders;
	}

	@Column(name = "order_num")
	public Long getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "predict_date", length = 10)
	public Date getPredictDate() {
		return this.predictDate;
	}

	public void setPredictDate(Date predictDate) {
		this.predictDate = predictDate;
	}

	@Column(name = "sold_num")
	public Long getSoldNum() {
		return this.soldNum;
	}

	public void setSoldNum(Long soldNum) {
		this.soldNum = soldNum;
	}

	@Column(name = "total_money", precision = 53, scale = 0)
	public Double getTotalMoney() {
		return this.totalMoney;
	}

	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}

}