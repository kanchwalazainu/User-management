package com.user;

import com.user.controller.HomeController;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class AppTest {
    @Test
    public void testApp()    {
    	
    	HomeController hc=new HomeController();
    	String result=hc.home();
    	
    	assertEquals(result,"My Home Page");
        
    }
}
