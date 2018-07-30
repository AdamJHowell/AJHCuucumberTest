package com.adamjhowell;


import com.adamjhowell.calculator.Calculator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Created by Adam Howell on 2018-07-30.
 */
public class CalculatorTests
{
	private Calculator calculator = new Calculator();
	private int value1;
	private int value2;


	@Before public void setUp()
	{
		assertNotNull( calculator );
		value1 = 10;
		value2 = 2;
	}


	@Test
	public void sum()
	{
		calculator.sum( value1, value2 );
		assertEquals( calculator.getResult(), 12 );
	}


	@Test
	public void product()
	{
		calculator.product( value1, value2 );
		assertEquals( calculator.getResult(), 20 );
	}


	@Test
	public void divide()
	{
		calculator.divide( value1, value2 );
		assertEquals( calculator.getResult(), 5 );
	}


	@Test
	public void subtract()
	{
		calculator.subtract( value1, value2 );
		assertEquals( calculator.getResult(), 8 );
	}


	@Test
	public void mod()
	{
		calculator.mod( value1, value2 );
		assertEquals( calculator.getResult(), 0 );
	}


	@Test
	public void power()
	{
		calculator.power( value1, value2 );
		assertEquals( calculator.getResult(), 100 );
	}
}
