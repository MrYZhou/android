package fanshe;

/**
 * @author Administrator
 *调用student测试的三种方法
 *反射的目的是不知道源码的情况使用源码的方法和属性。
 */
public class test {
	public static void main(String[] args) throws ClassNotFoundException {
		student student=new student();
		//方法一：getclass,本质是去获得该类的class 静态属性
		Class<? extends student> class1 = student.getClass();
		System.out.println(class1.getName());
		//方法二，通过一个class 属性
		Class stuclass=student.class;
		//重点是方法三，forname
		Class<?> forName = Class.forName("fanshe.student");
		System.out.println(forName==stuclass);
	}
}
