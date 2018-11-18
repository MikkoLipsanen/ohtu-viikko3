Feature: User can log in with valid username/password-combination

    Scenario: user can login with correct password
       Given command login is selected
       When  correct username and password are entered
       Then  system will respond with "logged in"

    Scenario: user can not login with incorrect password
        Given command login is selected
        When  incorrect password is entered
        Then  system will respond "wrong username or password"

    Scenario: nonexistent user can not login to 
        Given command login is selected
        When  nonexistent username and password are entered 
        Then  system will reply "wrong username or password"