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
		calculator.sum( 10, 2 );
		assertEquals( 12, calculator.getResult() );
	}


	@Test
	public void product()
	{
		calculator.product( value1, value2 );
		assertEquals( 20, calculator.getResult() );
	}


	@Test
	public void divide()
	{
		calculator.divide( value1, value2 );
		assertEquals( 5, calculator.getResult() );
	}


	@Test
	public void subtract()
	{
		calculator.subtract( value1, value2 );
		assertEquals( 8, calculator.getResult() );
	}


	@Test
	public void mod()
	{
		calculator.mod( value1, value2 );
		assertEquals( 0, calculator.getResult() );
	}


	@Test
	public void power()
	{
		calculator.power( value1, value2 );
		assertEquals( 100, calculator.getResult() );
	}
}
