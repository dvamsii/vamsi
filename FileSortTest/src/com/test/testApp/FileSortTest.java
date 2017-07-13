package com.test.testApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.model.TestClass;

import com.test.FileSortApp.StockTest;
import com.test.stockbeans.Stock;

public class FileSortTest {
	@Test
	public void testSortedFile() throws IOException {
		final String inputFile = "E:\\portfolio.txt";
		final File expected = new File("E:\\expected.txt");
	    final String actual = "E:\\actual.txt";
		
		StockTest test = new StockTest();
	    test.performStocks(inputFile);
	    test.displayOutPut(actual);
	    
	   
	    BufferedReader reader1 = new BufferedReader(new FileReader("E:\\expected.txt"));
        
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
