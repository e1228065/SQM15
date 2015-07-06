package gluecode;

import org.openqa.selenium.By;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import code.Implementation;

public class GCDefinitions {
	
	private Implementation test = new Implementation();


	
	
	//=================================================================GeneralCode===========================
	@Given("^server is running$")
	public void server_is_running() throws Throwable {
	    test.setUp();
	}


	@When("^client log in with user \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void the_startpage_is_shown_with_the_title(String userID, String passWD) throws Throwable {
	   test.testLogin(userID, passWD);
	}

	@Then("^the start page for user \"([^\"]*)\" should be shown$")
	public void the_start_page_should_be_shown(String userID) throws Throwable {
		test.logincheck(userID);
	}

	
	@Then("^user logout$")
	public void user_logout() throws Throwable {
		test.logout();
		test.tearDown();
	}
	//===========================================================TC0001.AddTheBook=================================
	@When("^client enters book creation section$")
	public void client_enters_book_creation_section() throws Throwable {
	   test.TC0001GoToCreate();
	}

	@When("^client fills in (.*) and (.*) and (.*) and adds a book$")
	public void client_fills_in_book_data_and_adds_a_book(String name,int size, String status) throws Throwable {
	    test.TC0001FillIn(name, size, status);
	}

	@Then("^the book (.*) should be present in the library$")
	public void the_book_should_be_present_in_the_library(String name) throws Throwable {
	    test.TC0001Check(name);
	}


	
	//===========================================================TC0002.SearchTheBook=================================
	
	
	@When("^client serches book \"([^\"]*)\"$")
	public void client_serches_book(String book) throws Throwable {
		test.TC0002Search(book);
	}

	@Then("^the result \"([^\"]*)\" is present on the page$")
	public void the_result_is_present_on_the_page(String result) throws Throwable {
	    test.TC0002SearchResult(result);
	}

	
	//===========================================================TC0010.ErrorLogin=================================
	
	@Then("^Error is displayed$")
	public void Error_is_displayed() throws Throwable {
	   test.TC0010LoginError();
	}

	@Then("^user is not logged in$")
	public void user_is_not_logged_in() throws Throwable {
	  test.TC0010AccChoose();
	  test.tearDown();
	}
	
}