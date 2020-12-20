package com.t2s.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;
import com.t2s.enums.CategoryContainer;
import com.t2s.enums.StatusContainer;
import com.t2s.enums.TypeContainer;
import com.t2s.exceptions.InvalidParameterException;

@Entity
@Table(name="tb_container")
public class Container {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	

	@NotNull
	@Column(nullable = false)
	private String client;
	@NotNull
	@Column(nullable = false,length = 11)
	private String cntr;
	@NotNull
	@Column(nullable = false)
	private TypeContainer typeContainer;
	@NotNull
	@Column(nullable = false)
	private StatusContainer status_container;
	@NotNull
	@Column(nullable = false)
	private CategoryContainer category;
	
	public Container() {}

	public Container(String client,String cntr,TypeContainer type, StatusContainer status, CategoryContainer category) {
		if(!validateCntr(cntr)) {
			throw new InvalidParameterException("the CNTR must have 11 characters, 4 leters and 7 numbers");
		}
		this.client = client;
		this.cntr = cntr;
		this.typeContainer = type;
		this.status_container = status;
		this.category = category;
	}
	
	public Long getId() {
		return id;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getCntr() {
		return cntr;
	}

	public void setCntr(String cntr) {
		if(!validateCntr(cntr)) {
			throw new InvalidParameterException("the CNTR must have 11 characters, 4 leters and 7 numbers");
		}
		this.cntr = cntr;
	}


	public TypeContainer getTypeContainer() {
		return typeContainer;
	}

	public void setTypeContainer(TypeContainer typeContainer) {
		this.typeContainer = typeContainer;
	}

	public StatusContainer getStatus() {
		return status_container;
	}

	public void setStatus(StatusContainer status) {
		this.status_container = status;
	}

	public CategoryContainer getCategory() {
		return category;
	}

	public void setCategory(CategoryContainer category) {
		this.category = category;
	}
	
	public static boolean validateCntr(String cntr) {
		cntr = cntr.toUpperCase();
		if(cntr.length()<11) { return false;}
		if(!cntr.substring(0, 4).matches("[A-Z]*")){ return false;}
		return cntr.substring(4).matches("[0-9]*");
		
	}
	
	@Override
	public String toString() {
		return "Container [id=" + id + ", client=" + client + ", cntr=" + cntr + ", typeContainer=" + typeContainer
				+ ", status_container=" + status_container + ", category=" + category + "]";
	}
	
	

	
	
	
	
	
}

