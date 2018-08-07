package com.adamjhowell.bdd.steps;
// The package for the Steps file, and the Tests file, need to be in "Test Sources Root" folder.


// Import the class to test, based on the "Sources Root" folder.


import com.adamjhowell.calculator.Calculator;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public void iWantToCalculate()
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
			for( Map<Object, Object> map : table.asMaps( String.class, Integer.class ) )
			{
				Integer numerator = ( Integer )map.get( "Numerator" );
				Integer divisor = ( Integer )map.get( "Divisor" );
				Integer result = ( Integer )map.get( "Result" );
			}
		}
	}


	@When( "^I divide this (\\d+) by (\\d+)$" )
	public void iDivideThisNumberByNumber( int arg0, int arg1 )
	{
		// Write code here that turns the phrase above into concrete actions
		calculator.divide( arg0, arg1 );
	}


	private List<Integer> numbers;
	private int sum;


	@Given( "^a list of numbers$" )
	public void aListOfNumbers( List<Integer> numbers )
	{
		// For automatic transformation, change DataTable to one of List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// Where E, K, and V must be a scalar (String, Integer, Date, enum etc).
		this.numbers = numbers;
	}


	@When( "^I summarize them$" )
	public void iSummarizeThem()
	{
		sum = 0;
		for( Integer number : numbers )
		{
			sum += number;
		}
	}


	@Then( "^should I get (\\d+)$" )
	public void shouldIGet( int expectedSum )
	{
		assertEquals( expectedSum, sum );
	}


	private Map<String, Integer> priceList;
	private int totalSum;


	@Given( "^the price list for a donut shop$" )
	public void thePriceListForADonutShop( Map<String, Integer> priceList )
	{
		this.priceList = priceList;
	}


	@When( "^I order (\\d+) (.*) and (\\d+) (.*)$" )
	public void iOrderCoffeeAndDonut( int numberOfFirstItems, String firstItem, int numberOfSecondItems, String secondItem )
	{
		int firstPrice = priceList.get( firstItem );
		int secondPrice = priceList.get( secondItem );

		totalSum += firstPrice * numberOfFirstItems;
		totalSum += secondPrice * numberOfSecondItems;
	}


	@Then( "^should I pay (\\d+)$" )
	public void shouldIPay( int expectedCost )
	{
		assertEquals( totalSum, expectedCost );
	}


	private Map<String, Price> priceList2;
	private int sekSum;
	private int euroSum;


	@Given( "^the price list for an international donut shop$" )
	public void thePriceListForAnInternationalDonutShop( List<Price> prices )
	{
		priceList2 = new HashMap<>();

		for( Price price : prices )
		{
			String key = price.getProduct();
			priceList2.put( key, price );
		}
	}


	@When( "^I choose (\\d+) (.*) and (\\d+) (.*)$" )
	public void iChooseCocoaAndDonuts( int numberOfFirstItems, String firstItem, int numberOfSecondItems, String secondItem )
	{
		Price firstPrice = priceList2.get( firstItem );
		calculate( numberOfFirstItems, firstPrice );
		Price secondPrice = priceList2.get( secondItem );
		calculate( numberOfSecondItems, secondPrice );
	}


	private void calculate( int numberOfItems, Price price )
	{
		if( price.getCurrency().equals( "SEK" ) )
		{
			sekSum += numberOfItems * price.getPerUnitPrice();
			return;
		}
		if( price.getCurrency().equals( "EUR" ) )
		{
			euroSum += numberOfItems * price.getPerUnitPrice();
			return;
		}
		throw new IllegalArgumentException( "The currency is unknown" );
	}


	@Then( "^should I pay (\\d+) EUR and (\\d+) SEK$" )
	public void shouldIPayEURAndSEK( int expectedEuroSum, int expectedSekSum )
	{
		assertEquals( euroSum, expectedEuroSum );
		assertEquals( sekSum, expectedSekSum );
	}
}
