package com.adamjhowell.bdd.steps;
// The package for the Steps file, and the Tests file, need to be in "Test Sources Root" folder.

// Import the class to test, based on the "Sources Root" folder.
import com.adamjhowell.bdd.calculator.Calculator;
import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Map;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class CalculatorSteps
{
	private Calculator calculator;


	@Before
	public void setUp()
	{
		calculator = new Calculator();
	}


	@Given( "^I want to perform a calculation$" )
	public void iWantToAddTwoNumbers()
	{
		// This only checks that we have an instance of the calculator class.
		assertNotNull( calculator );
	}


	@When( "^I add (\\d+) and (\\d+)$" )
	public void addAnd( int a, int b )
	{
		// This performs the calculation, and saves the answer in the class variable "result".
		calculator.sum( a, b );
	}


	@Then( "^the result should be (\\d+)$" )
	public void theResultShouldBe( int result )
	{
		// This can be reused for any calculation, since it is effectively a getter for the class variable "result".
		assertEquals( result, calculator.getResult() );
	}


	@When( "^I subtract (\\d+) from (\\d+)$" )
	public void iSubtractFrom( int a, int b )
	{
		// This performs the calculation, and saves the answer in the class variable "result".
		// Be cautious of the wording here.
		calculator.subtract( b, a );
	}


	@When( "^I multiply (\\d+) and (\\d+)$" )
	public void iMultiplyAnd( int arg0, int arg1 )
	{
		// Write code here that turns the phrase above into concrete actions
		calculator.product( arg0, arg1 );
	}


	@When( "^I divide (\\d+) by (\\d+)$" )
	public void iDivideBy( int arg0, int arg1 )
	{
		// Write code here that turns the phrase above into concrete actions
		calculator.divide( arg0, arg1 );
	}


	@When( "^I raise (\\d+) to the power of (\\d+)$" )
	public void iRaiseToThePowerOf( int arg0, int arg1 )
	{
		// Write code here that turns the phrase above into concrete actions
		calculator.power( arg0, arg1 );
	}


	@When( "^I modulus (\\d+) by (\\d+)$" )
	public void iModulusBy( int arg0, int arg1 )
	{
		// Write code here that turns the phrase above into concrete actions
		calculator.mod( arg0, arg1 );
	}


	@When( "^I divide <Numerator> by <Divisor>$" )
	public void iDivideNumeratorByDivisor()
	{
		// Write code here that turns the phrase above into concrete actions
		calculator.divide( 4, 3 );
	}


	@Then( "^the result should be <Result>$" )
	public void theResultShouldBeResult()
	{
		// Write code here that turns the phrase above into concrete actions
		assertEquals( 1, calculator.getResult() );
	}


	@Given( "^I want to perform a data table calculation$" )
	public void iWantToPerformADataTableCalculation( DataTable table )
	{
		if( table != null )
		{
			for ( Map<String, Integer> map : table.asMaps( String.class, Integer.class ) )
			{
				Integer numerator = map.get( "Numerator" );
				Integer divisor = map.get( "Divisor" );
				Integer result = map.get( "Result" );
				System.out.println( format( "Dividing %d by %d yields %d", numerator, divisor, result ) );
			}
		}
	}
}
