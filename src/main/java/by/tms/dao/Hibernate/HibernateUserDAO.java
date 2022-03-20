package by.tms.dao.Hibernate;

import by.tms.dao.UserDAO;
import by.tms.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class HibernateUserDAO implements UserDAO<User> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(User user) {
        Session session = sessionFactory.openSession();
        session.save(user);
        session.close();
    }

    @Override
    public User findById(long id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    @Override
    public void remove(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
//        session.beginTransaction().commit();
//        session.close();
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(user);
//        session.beginTransaction().commit();
//        session.close();
    }

    @Override
    public List<User> findAllByName(String name) {
        Session session = sessionFactory.openSession();
        Query<User> query = session.createQuery("from User where name = :name", User.class);
        query.setParameter("name", name);
        List<User> resultList = query.getResultList();
        session.close();
        return resultList;
    }

    @Override
    public List<User> findAll(){
        Session session = sessionFactory.openSession();
        Query<User> from_user = session.createQuery("from User", User.class);
        List<User> resultList = from_user.getResultList();
        session.close();
        return resultList;
    }

    @Override
    public User findByUsername(String username){
        Session session = sessionFactory.openSession();
        Query<User> query = session.createQuery("from User where name = :un", User.class);
        query.setParameter("un", username);
        User singleResult = query.getSingleResult();
        session.close();
        return singleResult;
    }
}
