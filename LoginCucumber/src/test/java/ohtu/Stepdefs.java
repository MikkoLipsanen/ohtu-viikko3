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

    @When("^correct username and password are entered$")
    public void correct_username_and_password_are_entered() throws Throwable {
       
       inputLines.add("pekka");
       inputLines.add("akkeppekka1");
       
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
       inputLines.add("jani");
       inputLines.add("inaJ");
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
    }
       
    @Then("^system will reply \"([^\"]*)\"$")
    public void system_will_reply(String expectedOutput) throws Throwable {
        assertTrue(io.getPrints().contains(expectedOutput));
    }
    
    @Given("^command new user is selected$")
    public void command_new_selected() throws Throwable {
        inputLines.add("new");
    }

    @When("^valid username and password are entered$")
    public void valid_username_and_password_are_entered() throws Throwable {
       inputLines.add("mikko");
       inputLines.add("okkim123%");
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
    }
    
    @Then("^system will reply with \"([^\"]*)\"$")
    public void system_will_reply1(String expectedOutput) throws Throwable {
        assertTrue(io.getPrints().contains(expectedOutput));
    }
    
    @When("^already taken username and valid password are entered$")
    public void already_taken_username_and_valid_password_are_entered() throws Throwable {
       inputLines.add("pekka");
       inputLines.add("kalamies666");
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
    }
    
    @Then("^system will respond with2 \"([^\"]*)\"$")
    public void system_will_reply2(String expectedOutput) throws Throwable {
        assertTrue(io.getPrints().contains(expectedOutput));
    }
    
    @When("^too short username and valid password are entered$")
    public void too_short_username_and_valid_password_are_entered() throws Throwable {
       inputLines.add("jp");
       inputLines.add("mammamia+&");
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
    }
    
    @Then("^system will respond with3\"([^\"]*)\"$")
    public void system_will_reply3(String expectedOutput) throws Throwable {
        assertTrue(io.getPrints().contains(expectedOutput));
    }
    
    @When("^valid username and too short password are entered$")
    public void valid_username_and_too_short_password_are_entered() throws Throwable {
       inputLines.add("aki");
       inputLines.add("mamma+&");
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
    }
    
    @Then("^system will respond with4\"([^\"]*)\"$")
    public void system_will_reply4(String expectedOutput) throws Throwable {
        assertTrue(io.getPrints().contains(expectedOutput));
    }
    
    @When("^valid username and password consisting of only letters are entered$")
    public void valid_username_and_password_consisting_of_only_letters_are_entered() throws Throwable {

       inputLines.add("anna");
       inputLines.add("ohtuonjees");
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
    }
    
    @Then("^system will respond with5\"([^\"]*)\"$")
    public void system_will_reply5(String expectedOutput) throws Throwable {
        assertTrue(io.getPrints().contains(expectedOutput));
    }
    
    @Given("^user \"([^\"]*)\" with password \"([^\"]*)\" is created$")
    public void user_with_password_is_created(String arg1, String arg2) throws Throwable {
       inputLines.add("new");
       inputLines.add(arg1);
       inputLines.add(arg2);
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
    }
    
    @Given("^command login is selected2$")
    public void command_login_selected2() throws Throwable {
        inputLines.add("login");
    }

    @When("^username \"([^\"]*)\"  and password \"([^\"]*)\" are entered$")
    public void username_and_password_are_entered(String arg1, String arg2) throws Throwable {
       inputLines.add(arg1);
       inputLines.add(arg2);
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
    }
    
    @Then("^system will respond with6 \"([^\"]*)\"$")
    public void system_will_respond_with2(String expectedOutput) throws Throwable {
        assertTrue(io.getPrints().contains(expectedOutput));
    }
    
}

