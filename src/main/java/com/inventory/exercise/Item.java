package com.inventory.exercise;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Objects;

public class Item {
	@JsonProperty("name")
	private String name;
	@JsonProperty("serialNumber")
    private String serialNumber;
	@JsonProperty("value")
    private BigDecimal value;

	public Item(){}
    public Item (String name, String serialNumber, BigDecimal value) {
    	this.name = name;
    	this.serialNumber = serialNumber;
    	this.value = value;
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
    
  @Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\"Item [name "+ name + ", serialNumber = " + serialNumber + ", value = " + value + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Item)) return false;
		Item item = (Item) o;
		return Objects.equals(getName(), item.getName()) && Objects.equals(getSerialNumber(), item.getSerialNumber()) && Objects.equals(getValue(), item.getValue());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName(), getSerialNumber(), getValue());
	}
}
