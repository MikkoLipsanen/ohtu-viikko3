package ohtu;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import ohtu.io.*;
import ohtu.data_access.*;
import ohtu.services.*;

public class Stepdefs {
    App app;
    StubIO io;
    UserDao userDao = new InMemoryUserDao();
    AuthenticationService auth = new AuthenticationService(userDao);
    List<String> inputLines = new ArrayList<>();
    
    @Given("^command login is selected$")
    public void command_login_selected() throws Throwable {
        inputLines.add("login");
    }

    @When("^username \"([^\"]*)\" and password \"([^\"]*)\" are entered$")
    public void a_username_and_password_are_entered(String username, String password) throws Throwable {
       inputLines.add(username);
       inputLines.add(password);
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
    }

    @Then("^system will respond with \"([^\"]*)\"$")
    public void system_will_respond_with(String expectedOutput) throws Throwable {
        assertTrue(io.getPrints().contains(expectedOutput));
    }
    
    @When("^incorrect password is entered$")
    public void incorrect_password_is_entered() throws Throwable {
       inputLines.add("pekka");
       inputLines.add("ellaK");
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
    }
    
    @Then("^system will respond \"([^\"]*)\"$")
    public void system_will_respond(String expectedOutput) throws Throwable {
       assertTrue(io.getPrints().contains(expectedOutput));
    }

    @When("^nonexistent username and password are entered$")
    public void nonexistent_username_and_password_are_entered() throws Throwable {
       inputLines.add("Jani");
       inputLines.add("inaJ");
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
    }
       

    @Then("^system will reply \"([^\"]*)\"$")
    public void system_will_reply(String expectedOutput) throws Throwable {
        assertTrue(io.getPrints().contains(expectedOutput));
    }

   
}
