package com.sicau.springbootequipmentmanager.equipmentmanager.dto;

import lombok.Data;

@Data
public class Equipment {
	private Integer equId;
	private Integer facId;
	private String equName;
	private String equType;
	private String equPurchasedate;
	private String equPurchaser;
	private Float equSingleprice;
	private String equUnit;
	private String equSpec;
	private Integer equTotal;
	private Integer equCurr;
	private String equPosition;
	private Integer del;
}
