package fanshe;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.ClosedFileSystemException;

public class reflaction {
	public static void main(String[] args)  {

		Class<?> forName = null;
		Constructor<?> constructor2 = null;
		try {
			forName = Class.forName("fanshe.student");//全包名
			//char a="a";
			 constructor2=forName.getDeclaredConstructor(String.class);
			 Constructor<?> con2=forName.getDeclaredConstructor(String.class,int.class,char.class);
			 con2.setAccessible(true);//暴力访问。
			 Object newInstance = con2.newInstance("tzstudy",20,'n');
			 System.out.println(newInstance);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		catch(NoSuchMethodException e){
//			e.printStackTrace();
//		}
		Constructor<?>[] constructor = forName.getConstructors();
		Constructor<?>[] declaredConstructors = forName.getDeclaredConstructors();
		for(Constructor c:constructor) {
			System.out.println(c);
		}
		for(Constructor<?> c:declaredConstructors) {
			
			System.out.println(c);
		}
		try {
			Object newInstance = constructor2.newInstance("学习");
			System.out.println(newInstance);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
