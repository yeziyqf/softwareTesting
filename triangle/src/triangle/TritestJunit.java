package triangle;

import static org.junit.Assert.*;

import org.junit.Test;

public class TritestJunit {
	private tritest tritest;

	@Test
	//���Եȱ�
	public void testequilateral() {
		tritest = new tritest();
		float a = (float) 2.0;
		//assertEquals((float)1,tritest.equilateral(a,a,a));  //��ΪassertEquals��int�ĸ�ʽ
		assertEquals(1,tritest.equilateral(a,a,a), 0.1);//���һ������deltaΪ����
		//fail("Not yet implemented");
	}
	
	@Test
	//���Ե���
	public void testisosceles() {
		tritest = new tritest();
		float a = (float) 2.0;
		float b = (float) 2.2;
		float c = (float) 2.2;
		assertEquals(1,tritest.isosceles(a,b,c), 0.1);//���һ������deltaΪ����
	}
	
	@Test
	//���Բ��ȱߵ���
	public void testscalene() {
		tritest = new tritest();
		float a = (float) 2.0;
		float b = (float) 2.1;
		float c = (float) 2.2;
		//assertEquals((float)1,tritest.equilateral(a,a,a));  //��ΪassertEquals��int�ĸ�ʽ
		assertEquals(1,tritest.scalene(a,b,c), 0.1);//���һ������deltaΪ����
		float d = (float) 2.0;
		float e = (float) 2.0;
		float f = (float) 2.2;
		assertEquals(-1,tritest.scalene(d,e,f), 0.1);//���һ������deltaΪ����
		
		//fail("Not yet implemented");
	}

}
