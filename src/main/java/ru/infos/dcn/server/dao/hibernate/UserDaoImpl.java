package ru.infos.dcn.server.dao.hibernate;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Order;

import java.util.List;

import ru.infos.dcn.common.exceptions.UserRegistrationFailedException;
import ru.infos.dcn.server.dao.UserDao;
import ru.infos.dcn.server.dao.entity.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    public User registerUser(String name, String nickName, String password) throws UserRegistrationFailedException {
        final Session session = getSessionFactory().getCurrentSession();
        final Integer count = (Integer) session.createCriteria(User.class).
                add(Restrictions.eq("nickName", nickName)).
                setProjection(Projections.rowCount()).
                uniqueResult();
        if (count > 0) {
            throw new UserRegistrationFailedException("Such user already exists!");
        }
        final User newUser = new User();
        newUser.setName(name);
        newUser.setNickName(nickName);
        newUser.setPassword(password);
        session.save(newUser);
        return newUser;
    }

    public Boolean authorizeUser(String nickName, String password) {
        final Session session = getSessionFactory().getCurrentSession();
        final Integer exists = (Integer) session.createCriteria(User.class).
                add(Restrictions.eq("nickName", nickName)).
                add(Restrictions.eq("password", password)).
                setProjection(Projections.rowCount()).
                uniqueResult();
        return exists > 0;
    }


    public void updateUser(User user) {
        getSessionFactory().getCurrentSession().saveOrUpdate(user);
    }

    public User getUserById(Long userId) {
        final Session session = getSessionFactory().getCurrentSession();
        return (User) session.createCriteria(User.class).
                add(Restrictions.eq("userId", userId)).
                setMaxResults(1).
                uniqueResult();
    }


    public User getUserByNickName(String nickName) {
        final Session session = getSessionFactory().getCurrentSession();
        return (User) session.createCriteria(User.class).
                add(Restrictions.eq("nickName", nickName)).
                setMaxResults(1).
                uniqueResult();
    }

    public List<User> getAllUsers() {
        final Session session = getSessionFactory().getCurrentSession();
        return session.createCriteria(User.class).addOrder(Order.desc("nickName")).list();
    }
}
