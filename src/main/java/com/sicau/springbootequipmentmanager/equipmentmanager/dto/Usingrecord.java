package com.sicau.springbootequipmentmanager.equipmentmanager.dto;

import lombok.Data;

@Data
public class Usingrecord {
	private Integer usi_id;
	private String user_id;
	private Integer equ_id;
	private String adm_id;
	private String usi_reason;
	private String usi_number;
	private String usi_date;
	private String usi_returndate;
	private String usi_applystatus;
	private String adm_feedbackapply;
	private String usi_returnstatus;
	private String adm_feedbackreturn;
	private Integer user_del;
	private Integer adm_del;
	private String equ_name;
}