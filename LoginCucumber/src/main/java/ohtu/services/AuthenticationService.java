package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        
        int digit = 0;
        int special = 0;
        
        if (username.length() < 3) {
            return true;
        }
        
        for(int i = 0; i < username.length(); i++){
           if(!Character.isLetter(username.charAt(i)) && !Character.isLowerCase(username.charAt(i)))
               return true;
        } 	
         
        if (password.length() < 8) {
            return true;
        }
        
        for(int j = 0; j < password.length(); j++){
            if(Character.isDigit(password.charAt(j)))
                digit++;
            if(!Character.isLetterOrDigit(password.charAt(j)) && !Character.isSpaceChar(password.charAt(j)))
                special++;
        }
       
        if(digit == 0 && special == 0){
            return true;
        }
        return false;
    }
}
      
        
    