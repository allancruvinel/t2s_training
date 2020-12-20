package com.t2s.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;
import com.t2s.enums.Handling;
@Entity
@Table(name="tb_movement")
public class Movement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@OneToOne
	@JoinColumn(name="container_id",nullable = false)
	private Container container;
	
	@NotNull
	@Column(nullable = false)
	private String ship;
	
	@NotNull
	@Column(nullable = false)
	private Handling handling;
	private Date timestart;
	private Date timeend;
	
	public Movement() {
		
	}

	public Movement(Container container, String ship, Handling handling) {
		super();
		this.container = container;
		this.ship = ship;
		this.handling = handling;
		this.timestart = new Date();
	}
	
	public Movement(Container container, String ship, Handling handling,Date timestart) {
		super();
		this.container = container;
		this.ship = ship;
		this.handling = handling;
		this.timestart = timestart;
	}

	public Movement(Container container, String ship, Handling handling, Date timestart, Date timeend) {
		super();
		this.container = container;
		this.ship = ship;
		this.handling = handling;
		this.timestart = timestart;
		this.timeend = timeend;
	}

	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

	public String getShip() {
		return ship;
	}

	public void setShip(String ship) {
		this.ship = ship;
	}

	public Handling getHandling() {
		return handling;
	}

	public void setHandling(Handling handling) {
		this.handling = handling;
	}

	public Date getTimestart() {
		return timestart;
	}

	public void setTimestart(Date timestart) {
		this.timestart = timestart;
	}

	public Date getTimeend() {
		return timeend;
	}

	public void setTimeend(Date timeend) {
		this.timeend = timeend;
	}

	public Long getId() {
		return id;
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
		Movement other = (Movement) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
