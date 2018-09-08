package com.thuss.fsa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Hotel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "hotel", schema = "dbo", catalog = "hotel")
public class Hotel implements java.io.Serializable {

	// Fields

	private Long hotelId;
	private String hotelName;
	private String caixi;
	private String format;
	private String fastHotel;
	private Integer numOfTable;
	private Integer numOfSeat;
	private Integer numOfWaiter;
	private Integer numOfFoodcate;
	private Integer numOfFood;
	private Integer numOfMember;
	private Integer numOfPrinter;
	private Integer numOfPrinterNet;
	private Integer numOfPrinterDrv;

	// Constructors

	/** default constructor */
	public Hotel() {
	}

	/** minimal constructor */
	public Hotel(Long hotelId) {
		this.hotelId = hotelId;
	}

	/** full constructor */
	public Hotel(Long hotelId, String hotelName, String caixi, String format,
			String fastHotel, Integer numOfTable, Integer numOfSeat,
			Integer numOfWaiter, Integer numOfFoodcate, Integer numOfFood,
			Integer numOfMember, Integer numOfPrinter, Integer numOfPrinterNet,
			Integer numOfPrinterDrv) {
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.caixi = caixi;
		this.format = format;
		this.fastHotel = fastHotel;
		this.numOfTable = numOfTable;
		this.numOfSeat = numOfSeat;
		this.numOfWaiter = numOfWaiter;
		this.numOfFoodcate = numOfFoodcate;
		this.numOfFood = numOfFood;
		this.numOfMember = numOfMember;
		this.numOfPrinter = numOfPrinter;
		this.numOfPrinterNet = numOfPrinterNet;
		this.numOfPrinterDrv = numOfPrinterDrv;
	}

	// Property accessors
	@Id
	@Column(name = "hotel_id", unique = true, nullable = false)
	public Long getHotelId() {
		return this.hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	@Column(name = "hotel_name")
	public String getHotelName() {
		return this.hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	@Column(name = "caixi")
	public String getCaixi() {
		return this.caixi;
	}

	public void setCaixi(String caixi) {
		this.caixi = caixi;
	}

	@Column(name = "format")
	public String getFormat() {
		return this.format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Column(name = "fast_hotel")
	public String getFastHotel() {
		return this.fastHotel;
	}

	public void setFastHotel(String fastHotel) {
		this.fastHotel = fastHotel;
	}

	@Column(name = "num_of_table")
	public Integer getNumOfTable() {
		return this.numOfTable;
	}

	public void setNumOfTable(Integer numOfTable) {
		this.numOfTable = numOfTable;
	}

	@Column(name = "num_of_seat")
	public Integer getNumOfSeat() {
		return this.numOfSeat;
	}

	public void setNumOfSeat(Integer numOfSeat) {
		this.numOfSeat = numOfSeat;
	}

	@Column(name = "num_of_waiter")
	public Integer getNumOfWaiter() {
		return this.numOfWaiter;
	}

	public void setNumOfWaiter(Integer numOfWaiter) {
		this.numOfWaiter = numOfWaiter;
	}

	@Column(name = "num_of_foodcate")
	public Integer getNumOfFoodcate() {
		return this.numOfFoodcate;
	}

	public void setNumOfFoodcate(Integer numOfFoodcate) {
		this.numOfFoodcate = numOfFoodcate;
	}

	@Column(name = "num_of_food")
	public Integer getNumOfFood() {
		return this.numOfFood;
	}

	public void setNumOfFood(Integer numOfFood) {
		this.numOfFood = numOfFood;
	}

	@Column(name = "num_of_member")
	public Integer getNumOfMember() {
		return this.numOfMember;
	}

	public void setNumOfMember(Integer numOfMember) {
		this.numOfMember = numOfMember;
	}

	@Column(name = "num_of_printer")
	public Integer getNumOfPrinter() {
		return this.numOfPrinter;
	}

	public void setNumOfPrinter(Integer numOfPrinter) {
		this.numOfPrinter = numOfPrinter;
	}

	@Column(name = "num_of_printer_net")
	public Integer getNumOfPrinterNet() {
		return this.numOfPrinterNet;
	}

	public void setNumOfPrinterNet(Integer numOfPrinterNet) {
		this.numOfPrinterNet = numOfPrinterNet;
	}

	@Column(name = "num_of_printer_drv")
	public Integer getNumOfPrinterDrv() {
		return this.numOfPrinterDrv;
	}

	public void setNumOfPrinterDrv(Integer numOfPrinterDrv) {
		this.numOfPrinterDrv = numOfPrinterDrv;
	}

}