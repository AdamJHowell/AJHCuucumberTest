package com.adamjhowell.bdd.calculator;
// The class to be tested by Cucumber does not need to know about Cucumber at all.


public class Calculator
{

	private int result;


	public void sum( int a, int b )
	{
		result = a + b;
	}


	public void product( int a, int b )
	{
		result = a * b;
	}


	public void divide( int a, int b )
	{
		result = a / b;
	}


	public void subtract( int a, int b )
	{
		result = a - b;
	}


	public void mod( int a, int b )
	{
		result = a % b;
	}


	public void power( int a, int b )
	{
		result = 1;
		while( b-- > 0 )
		{
			result *= a;
		}
	}


	public int getResult()
	{
		return result;
	}
}
