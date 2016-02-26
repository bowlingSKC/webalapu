package webalapu.service;

import webalapu.model.User;
import webalapu.service.exception.UserAlreadyException;
import webalapu.service.exception.UserNotFoundException;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserManagerLocal {

    void register(User newUser) throws UserAlreadyException;
    void deleteUser(User user) throws UserNotFoundException;
    List<User> getAllUsers();
    User getUserById(String email) throws UserNotFoundException;
    void updateUser(User user) throws UserNotFoundException;

}
