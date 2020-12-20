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
@Entity
@Table(name="tb_container")
public class Container {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private StatusContainer status;
	
	@NotNull
	@Column(nullable = false)
	private CategoryContainer category;
	
	public Container() {}
	
	public Container(String client, String cntr, TypeContainer typeContainer, StatusContainer status,
			CategoryContainer category) throws Exception {
		if(!validateCntr(cntr)) {
			throw new Exception("entrada invalida");
		}
		this.client = client;
		this.cntr = cntr;
		this.typeContainer = typeContainer;
		this.status = status;
		this.category = category;
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

	public void setCntr(String cntr) throws Exception {
		if(!validateCntr(cntr)) {
			throw new Exception("entrada invalida");
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
		return status;
	}

	public void setStatus(StatusContainer status) {
		this.status = status;
	}

	public CategoryContainer getCategory() {
		return category;
	}

	public void setCategory(CategoryContainer category) {
		this.category = category;
	}

	public Long getId() {
		return id;
	}
	
	public static boolean validateCntr(String cntr) {
		cntr = cntr.toUpperCase();
		if(cntr.length()<11) {return false;}
		if(!cntr.substring(0,4).matches("[A-Z]*")) {return false;}
		return cntr.substring(4).matches("[0-9]*");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Container other = (Container) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
}
