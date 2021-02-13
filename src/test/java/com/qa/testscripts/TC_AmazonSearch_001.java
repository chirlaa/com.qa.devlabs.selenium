package com.qa.testscripts;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.qa.pages.AmazonPages;

import junit.framework.Assert;

public class TC_AmazonSearch_001 extends TestBase {

	AmazonPages AmazonOR;
	@BeforeMethod
	public void loadPages()
	{
		AmazonOR = new AmazonPages(Driver);
	}
	@Test
	public void searchItem()
	{
		AmazonOR.SetCategoryList("Books");
		AmazonOR.setSearchInput("Da Vinci Code");
		AmazonOR.setMagnifierBtn();
		String title=Driver.getTitle();
		boolean res=title.contains("Da Vinci Code");
		if (res)
		{
			Assert.assertTrue(true);
			Reporter.log("Title is correct" ,true);
		}
		else {
			Assert.assertTrue(false);
			Reporter.log("Title is not correct" ,false);
		}
		
	}
	
	
}
