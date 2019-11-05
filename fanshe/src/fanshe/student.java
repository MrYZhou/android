package fanshe;

/**
 * @author Administrator
 *@version 1.0
 */
public class student {
/**
 * name,age
 * */	
	private String name;
	protected int age;
	char sex;
	public String phonenum;
	public student() {
		super();
	}
	 student(String name) {
		super();
		this.name = name;
	}
	protected  student(String name,String phonenum) {
		super();
		this.name=name;
		this.phonenum=phonenum;
	}
	private student(String name, int age, char sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
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
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the sex
	 */
	public char getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(char sex) {
		this.sex = sex;
	}
	/**
	 * @return the phonenum
	 */
	public String getPhonenum() {
		return phonenum;
	}
	/**
	 * @param phonenum the phonenum to set
	 */
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "student [name=" + name + ", age=" + age + ", sex=" + sex + ", phonenum=" + phonenum + "]";
	}
	public void show() {
		this.name=name;
		System.out.println(name+",不一样的自我！");
	}
	
}
