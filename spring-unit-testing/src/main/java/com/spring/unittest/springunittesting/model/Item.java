package com.spring.unittest.springunittesting.model;

public class Item {
	
	private int id;
	
	private String name;
	
	private String desc;
	
	private int quantity;

	public Item(int id, String name, String desc, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
