package com.thuss.fsa.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * HotelDaily entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "hotel_daily", schema = "dbo", catalog = "hotel")
public class HotelDaily implements java.io.Serializable {

	// Fields

	private Long id;
	private Long hotelId;
	private Integer version;
	private Date theDate;
	private String dayofweek;
	private Integer totalOrders;
	private Double totalNeedMoney;
	private Integer totalPeople;
	private Double turningRate;
	private Double avgNeedMoneyP;
	private Double avgNeedMoney;
	private Double maxNeedMoney;
	private Double maxUsedTime;
	private Double avgUsedTime;
	private Double maxPeople;
	private Double avgPeople;

	// Constructors

	/** default constructor */
	public HotelDaily() {
	}

	/** minimal constructor */
	public HotelDaily(Long id) {
		this.id = id;
	}

	/** full constructor */
	public HotelDaily(Long id, Long hotelId, Integer version, Date theDate,
			String dayofweek, Integer totalOrders, Double totalNeedMoney,
			Integer totalPeople, Double turningRate, Double avgNeedMoneyP,
			Double avgNeedMoney, Double maxNeedMoney, Double maxUsedTime,
			Double avgUsedTime, Double maxPeople, Double avgPeople) {
		this.id = id;
		this.hotelId = hotelId;
		this.version = version;
		this.theDate = theDate;
		this.dayofweek = dayofweek;
		this.totalOrders = totalOrders;
		this.totalNeedMoney = totalNeedMoney;
		this.totalPeople = totalPeople;
		this.turningRate = turningRate;
		this.avgNeedMoneyP = avgNeedMoneyP;
		this.avgNeedMoney = avgNeedMoney;
		this.maxNeedMoney = maxNeedMoney;
		this.maxUsedTime = maxUsedTime;
		this.avgUsedTime = avgUsedTime;
		this.maxPeople = maxPeople;
		this.avgPeople = avgPeople;
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

	@Column(name = "version")
	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "the_date", length = 10)
	public Date getTheDate() {
		return this.theDate;
	}

	public void setTheDate(Date theDate) {
		this.theDate = theDate;
	}

	@Column(name = "dayofweek")
	public String getDayofweek() {
		return this.dayofweek;
	}

	public void setDayofweek(String dayofweek) {
		this.dayofweek = dayofweek;
	}

	@Column(name = "total_orders")
	public Integer getTotalOrders() {
		return this.totalOrders;
	}

	public void setTotalOrders(Integer totalOrders) {
		this.totalOrders = totalOrders;
	}

	@Column(name = "total_need_money", precision = 53, scale = 0)
	public Double getTotalNeedMoney() {
		return this.totalNeedMoney;
	}

	public void setTotalNeedMoney(Double totalNeedMoney) {
		this.totalNeedMoney = totalNeedMoney;
	}

	@Column(name = "total_people")
	public Integer getTotalPeople() {
		return this.totalPeople;
	}

	public void setTotalPeople(Integer totalPeople) {
		this.totalPeople = totalPeople;
	}

	@Column(name = "turning_rate", precision = 53, scale = 0)
	public Double getTurningRate() {
		return this.turningRate;
	}

	public void setTurningRate(Double turningRate) {
		this.turningRate = turningRate;
	}

	@Column(name = "avg_need_money_p", precision = 53, scale = 0)
	public Double getAvgNeedMoneyP() {
		return this.avgNeedMoneyP;
	}

	public void setAvgNeedMoneyP(Double avgNeedMoneyP) {
		this.avgNeedMoneyP = avgNeedMoneyP;
	}

	@Column(name = "avg_need_money", precision = 53, scale = 0)
	public Double getAvgNeedMoney() {
		return this.avgNeedMoney;
	}

	public void setAvgNeedMoney(Double avgNeedMoney) {
		this.avgNeedMoney = avgNeedMoney;
	}

	@Column(name = "max_need_money", precision = 53, scale = 0)
	public Double getMaxNeedMoney() {
		return this.maxNeedMoney;
	}

	public void setMaxNeedMoney(Double maxNeedMoney) {
		this.maxNeedMoney = maxNeedMoney;
	}

	@Column(name = "max_used_time", precision = 53, scale = 0)
	public Double getMaxUsedTime() {
		return this.maxUsedTime;
	}

	public void setMaxUsedTime(Double maxUsedTime) {
		this.maxUsedTime = maxUsedTime;
	}

	@Column(name = "avg_used_time", precision = 53, scale = 0)
	public Double getAvgUsedTime() {
		return this.avgUsedTime;
	}

	public void setAvgUsedTime(Double avgUsedTime) {
		this.avgUsedTime = avgUsedTime;
	}

	@Column(name = "max_people", precision = 53, scale = 0)
	public Double getMaxPeople() {
		return this.maxPeople;
	}

	public void setMaxPeople(Double maxPeople) {
		this.maxPeople = maxPeople;
	}

	@Column(name = "avg_people", precision = 53, scale = 0)
	public Double getAvgPeople() {
		return this.avgPeople;
	}

	public void setAvgPeople(Double avgPeople) {
		this.avgPeople = avgPeople;
	}

}