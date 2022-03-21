package by.tms.dao.Hibernate;

import by.tms.entity.Operation;
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
public class HibernateHistoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Operation findById(long id) {
        Session session = sessionFactory.openSession();
        Operation operation = session.get(Operation.class, id);
        session.close();
        return operation;
    }

     public List<Operation> findAllByUser(User user) {
        List<Operation> operationList = user.getOperationList();
        return operationList;
    }

    public List<Operation> findAll(){
        Session session = sessionFactory.openSession();
        Query<Operation> from_operation = session.createQuery("from Operation ", Operation.class);
        List<Operation> resultList = from_operation.getResultList();
        session.close();
        return resultList;
    }
}
