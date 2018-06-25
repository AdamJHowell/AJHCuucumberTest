package com.adamjhowell.bdd.steps;


/**
 * Created by Adam Howell on 2018-06-11.
 */
public class Price
{
	private String product;
	private Integer perUnitPrice;
	private String currency;


	public Price( String product, Integer perUnitPrice, String currency )
	{
		this.product = product;
		this.perUnitPrice = perUnitPrice;
		this.currency = currency;
	}


	String getProduct()
	{
		return product;
	}


	Integer getPerUnitPrice()
	{
		return perUnitPrice;
	}


	String getCurrency()
	{
		return currency;
	}
}
