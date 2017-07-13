package com.test.FileSortApp;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.test.stockbeans.Stock;
import com.test.stockbeans.TotalStocks;
public class StockTest  {


	private List<TotalStocks> list = new ArrayList<TotalStocks>();
	public TotalStocks convertToStock(String line) {
		
		TotalStocks totalStocks = new TotalStocks();
		String[] stocks = line.split(",");
		if(stocks.length > 0) {
			for(String stockLine : stocks) {
				String[] stock = stockLine.split("-");
				if(stock.length > 0) {
					Stock s = new Stock(stock[0], Integer.parseInt(stock[1].trim()));
					totalStocks.getStocks().add(s);
				}
				
			}
		}else {
			return null;
		}
		return totalStocks;
	}


	public void performStocks(String path) throws IOException  {

		FileInputStream fstream = new FileInputStream(new File(path));
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String currentLine = null;
		while ((currentLine = br.readLine()) != null )   {
			if(currentLine !=null && currentLine.equals(""))
				continue;
			TotalStocks totalStocks = convertToStock(currentLine);
			if(totalStocks !=null ){
				list.add(totalStocks);
			}
				
		}
		Collections.sort(list);
		
		displayOutPut("E:\\expected.txt");
		
	}

	
	public void displayOutPut(String file) throws IOException {
		
		
		FileWriter writer = new FileWriter(file);
		for(TotalStocks ts : list) {
			System.out.println(ts);
			writer.write(ts.toString());
			 writer.write("\n\n");
		}
		writer.close();
		
	}
	


	public static void main(String args[]) throws IOException	{


		if(args.length == 0) {
			System.out.println("Enter text file path to read!");
			return;
		} else {
			new StockTest().performStocks(args[0]);	
	}
		

	}
}