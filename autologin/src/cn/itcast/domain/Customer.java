package cn.itcast.domain;

public class Customer{
	private Integer id;
	private String name;
	private Integer age;
	private String sex;
	private String city;
	private String password;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", city=" + city
				+ ", password=" + password + "]";
	}
	/**
	 * @param id
	 * @param name
	 * @param age
	 * @param sex
	 * @param city
	 * @param password
	 */
	public Customer(Integer id, String name, Integer age, String sex, String city, String password) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.city = city;
		this.password = password;
	}
	/**
	 * @param name
	 * @param password
	 */
	public Customer(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	

	
}
