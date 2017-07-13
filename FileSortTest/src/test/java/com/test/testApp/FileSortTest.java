package com.test.testApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.test.FileSortApp.StockTest;

public class FileSortTest {
	@Test
	public void testSortedFile() throws IOException {
		final String inputFile = "portfolio.txt";
		final File expected = new File("expected.txt");
	    final String actual = "actual.txt";
		
	    
	    
	    
	    
		StockTest test = new StockTest();
	    test.performStocks(inputFile);
	    test.displayOutPut(actual);
	    
	   
	    BufferedReader reader1 = new BufferedReader(new FileReader(expected));
        
        BufferedReader reader2 = new BufferedReader(new FileReader(actual));
         
        String line1 = reader1.readLine();
         
        String line2 = reader2.readLine();
         
        boolean areEqual = true;
         
        int lineNum = 1;
         
        while (line1 != null || line2 != null)
        {
            if(line1 == null || line2 == null)
            {
                areEqual = false;
                 
                break;
            }
            else if(! line1.equalsIgnoreCase(line2))
            {
                areEqual = false;
                 
                break;
            }
             
            line1 = reader1.readLine();
             
            line2 = reader2.readLine();
             
            lineNum++;
        }
         
        if(areEqual)
        {
        	Assert.assertTrue(true);
        }
        else
        {
        	Assert.fail();
        }
         
        reader1.close();
         
        reader2.close();
	    
	    
	}
}
