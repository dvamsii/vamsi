package com.test.stockbeans;

import java.util.ArrayList;
import java.util.List;

public class TotalStocks implements Comparable<TotalStocks>{

	
	private List<Stock> stocks;
	
	
	public TotalStocks() {
		super();
		stocks = new ArrayList<Stock>();
	}
	
	public List<Stock> getStocks() {
		return stocks;
	}
	public int getTotalCount() {
		int total = 0;
		for(Stock s: stocks) {
			total += s.getCount();
		}
		
		return total;
	}
	
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		for(Stock s : stocks) {
			sb.append(s.toString());
			sb.append(",");
		}
		return sb.toString().substring(0, sb.toString().length()-1);
	}
	@Override
	public int compareTo(TotalStocks o) {
		return o.getTotalCount() - this.getTotalCount();
	}
		
	
	
	
}
