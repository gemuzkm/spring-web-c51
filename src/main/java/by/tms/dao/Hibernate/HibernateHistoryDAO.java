package by.tms.dao.Hibernate;

import by.tms.entity.Operation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class HibernateHistoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Operation operation) {
        Session session = sessionFactory.getCurrentSession();
        session.save(operation);
        session.close();
    }


}
