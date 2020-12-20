package com.t2s.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.t2s.enums.CategoryContainer;
import com.t2s.enums.Handling;

public class MovementReport {
	
	private String client;
	private CategoryContainer category;
	private Handling typemovement;
	private String ship;
	private Date startmovement;
	private Date endmovement;
	
	public MovementReport() {}

	public MovementReport(String client, int category, int typemovement,String ship, String startmovement,
			String endmovement) throws ParseException {
		super();
		this.client = client;
		this.category = CategoryContainer.values()[category];
		this.typemovement = Handling.values()[typemovement];
		this.ship = ship;
		
		if(!startmovement.equals("null")) {this.startmovement = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(startmovement);}
		if(!endmovement.equals("null")) {this.endmovement = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(endmovement);}	
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public CategoryContainer getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = CategoryContainer.valueOf(category);
	}

	public Handling getTypemovement() {
		return typemovement;
	}

	public void setTypemovement(String typemovement) {
		this.typemovement = Handling.valueOf(typemovement);
	}

	public String getShip() {
		return ship;
	}

	public void setShip(String ship) {
		this.ship = ship;
	}

	public Date getStartmovement() {
		return startmovement;
	}

	public void setStartmovement(String startmovement) throws ParseException {
		if(!startmovement.equals("null")) {this.startmovement = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(startmovement);}
	}

	public Date getEndmovement() {
		return endmovement;
	}

	public void setEndmovement(String endmovement) throws ParseException {
		if(!endmovement.equals("null")) {this.endmovement = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(endmovement);}
	}

	@Override
	public String toString() {
		return "MovementReport [client=" + client + ", category=" + category + ", typemovement=" + typemovement
				+ ", ship=" + ship + ", startmovement=" + startmovement + ", endmovement=" + endmovement + "]";
	}
	
	
	
	
	
	
	
}
