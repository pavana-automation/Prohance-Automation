package test;

import org.junit.Assert;
import org.testng.annotations.Test;

public class demo {
	
	@Test
	public void test1()
	{
		Assert.assertEquals("FALSE","TRUE");
	}
	
	@Test
	public void test2()
	{
		Assert.assertEquals("FALSE","FALSE");
	}
	
	@Test
	public void test3()
	{
		Assert.assertEquals("TRUE","TRUE");
	}

}
