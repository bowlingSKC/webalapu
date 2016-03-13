package webalapu.service;

import webalapu.model.User;
import webalapu.model.UserGroup;
import webalapu.service.exception.UserAlreadyException;
import webalapu.service.exception.UserNotFoundException;
import webalapu.util.Constants;
import webalapu.util.PasswordEncryption;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UserManager implements UserManagerLocal {

    @PersistenceContext(unitName = "cinemaUnit")
    EntityManager em;

    @Override
    public void register(User newUser) throws UserAlreadyException {
        Query query = em.createQuery("SELECT user FROM User user WHERE user.email = :email");
        query.setParameter("email", newUser.getEmail());

        try {
            query.getSingleResult();
            throw new UserAlreadyException();
        } catch (NoResultException ex) {
            // semmi baj nem történt, sőőt ...
        }

        newUser.setCredit(Constants.DEFAULT_CREDIT);
        try {
            newUser.setPassword(PasswordEncryption.hashPassword(newUser.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<UserGroup> userGroups = new ArrayList<>();
        UserGroup userGroup = new UserGroup();
        userGroup.setUserId(newUser);
        userGroup.setGroupId(Constants.USER_GROUP);
        userGroups.add(userGroup);

        newUser.setUserGroupList(userGroups);

        em.persist(newUser);
        em.flush();
    }

    @Override
    public void deleteUser(User user) throws UserNotFoundException {
        User dbUser = em.find(User.class, user.getEmail());
        if( dbUser == null ) {
            throw new UserNotFoundException();
        }

        em.remove(user);
        em.flush();
    }

    @Override
    public List<User> getAllUsers() {
        Query query = em.createQuery("SELECT user FROM User user", User.class);
        List<User> users = query.getResultList();
        if(users == null) {
            new ArrayList<User>();
        }
        return users;
    }

    @Override
    public User getUserById(String email) throws UserNotFoundException {
        Query query = em.createQuery("SELECT user.email, user.firstName, user.lastName, user.password, user.credit FROM User user WHERE user.email LIKE :email");
        query.setParameter("email", email);
        Object[] userInfo;
        try {
            userInfo = (Object[]) query.getSingleResult();
        } catch (NoResultException ex) {
            throw new UserNotFoundException();
        }

        User user = new User(
                (String) userInfo[0],
                (String) userInfo[1],
                (String) userInfo[2],
                (String) userInfo[3],
                (Integer) userInfo[4]
        );
        return user;
    }

    @Override
    public void updateUser(User user) throws UserNotFoundException {
        User updateUser = em.find(User.class, user.getEmail());
        if( updateUser == null ) {
            throw new UserNotFoundException();
        }

        mergeUserAttrs(user, updateUser);
        em.merge(updateUser);
        em.flush();
    }

    private void mergeUserAttrs(User user, User updateUser) {
        // TODO: implementálni
    }
}
