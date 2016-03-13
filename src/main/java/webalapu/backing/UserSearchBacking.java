package webalapu.backing;

import webalapu.model.User;
import webalapu.service.UserManagerLocal;
import webalapu.service.exception.UserNotFoundException;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class UserSearchBacking extends BaseBacking implements Serializable {

    @EJB
    private UserManagerLocal userManager;

    private List<User> userList;
    private List<User> filteredUsers;
    private User selectedUser;

    public String retrieveUserList() {
        userList = userManager.getAllUsers();
        return null;
    }

    public String update() {
        //TODO: felhasználó adatainak módosítása
        return null;
    }

    public User getUserById(String email){
        User user = new User();
        try {
            user = userManager.getUserById(email);
        } catch (UserNotFoundException ex) {
            ex.printStackTrace();
        }

        return user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public List<User> getFilteredUsers() {
        return filteredUsers;
    }

    public void setFilteredUsers(List<User> filteredUser) {
        this.filteredUsers = filteredUser;
    }
}
