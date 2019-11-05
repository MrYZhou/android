package com.example.androidde;

public class Category {
	private Integer id;
	private String category_name;
	private String category_detail;
	private String category_type;
	
	/**
	 * 
	 */
	public Category() {
		super();
	}
	/**
	 * @param category_name
	 * @param category_detail
	 * @param category_type
	 */
	public Category(String category_name, String category_detail, String category_type) {
		super();
		this.category_name = category_name;
		this.category_detail = category_detail;
		this.category_type = category_type;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the category_name
	 */
	public String getCategory_name() {
		return category_name;
	}
	/**
	 * @param category_name the category_name to set
	 */
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	/**
	 * @return the category_detail
	 */
	public String getCategory_detail() {
		return category_detail;
	}
	/**
	 * @param category_detail the category_detail to set
	 */
	public void setCategory_detail(String category_detail) {
		this.category_detail = category_detail;
	}
	/**
	 * @return the category_type
	 */
	public String getCategory_type() {
		return category_type;
	}
	/**
	 * @param category_type the category_type to set
	 */
	public void setCategory_type(String category_type) {
		this.category_type = category_type;
	}
	
}
