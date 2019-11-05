package com.example.androidde;

public class Expenditure {
	private int id;	
	private String outcome_source;
	private String outcome_num;
	private String remarks;
	private String date;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the outcome_source
	 */
	public String getOutcome_source() {
		return outcome_source;
	}
	/**
	 * @param outcome_source the outcome_source to set
	 */
	public void setOutcome_source(String outcome_source) {
		this.outcome_source = outcome_source;
	}
	/**
	 * @return the outcome_num
	 */
	public String getOutcome_num() {
		return outcome_num;
	}
	/**
	 * @param outcome_num the outcome_num to set
	 */
	public void setOutcome_num(String outcome_num) {
		this.outcome_num = outcome_num;
	}
	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
}
