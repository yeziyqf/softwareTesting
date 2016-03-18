package cn.tjuscs.st.yqf;

public class tritest {
	//Three sides all equals to each other.
	public float equilateral(float d,float e,float f)
	{
		if (d==e && e==f)
			return 1;
		else 
			return -1;
	}
	
	//Exists two sides are equals to each other, but there is not a third one equas.
	public float isosceles(float a,float b,float c)
	{
		if ((a==b && b!=c)||(b==c && a!=b)||(a==c && b!=c))
			return 1;
		else 
			return -1;
	}
	
	//Three sides are not equal to each other at all.
	public float scalene(float a,float b,float c)
	{
		if ((a!=b) && (b!=c) && (a!=c))
			return 1;
		else 
			return -1;
	}
}
