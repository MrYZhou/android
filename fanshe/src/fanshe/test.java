package fanshe;

/**
 * @author Administrator
 *����student���Ե����ַ���
 *�����Ŀ���ǲ�֪��Դ������ʹ��Դ��ķ��������ԡ�
 */
public class test {
	public static void main(String[] args) throws ClassNotFoundException {
		student student=new student();
		//����һ��getclass,������ȥ��ø����class ��̬����
		Class<? extends student> class1 = student.getClass();
		System.out.println(class1.getName());
		//��������ͨ��һ��class ����
		Class stuclass=student.class;
		//�ص��Ƿ�������forname
		Class<?> forName = Class.forName("fanshe.student");
		System.out.println(forName==stuclass);
	}
}
