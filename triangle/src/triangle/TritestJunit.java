package triangle;

import static org.junit.Assert.*;

import org.junit.Test;

public class TritestJunit {
	private tritest tritest;

	@Test
	//测试等边
	public void testequilateral() {
		tritest = new tritest();
		float a = (float) 2.0;
		//assertEquals((float)1,tritest.equilateral(a,a,a));  //此为assertEquals于int的格式
		assertEquals(1,tritest.equilateral(a,a,a), 0.1);//最后一个参数delta为精度
		//fail("Not yet implemented");
	}
	
	@Test
	//测试等腰
	public void testisosceles() {
		tritest = new tritest();
		float a = (float) 2.0;
		float b = (float) 2.2;
		float c = (float) 2.2;
		assertEquals(1,tritest.isosceles(a,b,c), 0.1);//最后一个参数delta为精度
	}
	
	@Test
	//测试不等边等腰
	public void testscalene() {
		tritest = new tritest();
		float a = (float) 2.0;
		float b = (float) 2.1;
		float c = (float) 2.2;
		//assertEquals((float)1,tritest.equilateral(a,a,a));  //此为assertEquals于int的格式
		assertEquals(1,tritest.scalene(a,b,c), 0.1);//最后一个参数delta为精度
		float d = (float) 2.0;
		float e = (float) 2.0;
		float f = (float) 2.2;
		assertEquals(-1,tritest.scalene(d,e,f), 0.1);//最后一个参数delta为精度
		
		//fail("Not yet implemented");
	}

}
