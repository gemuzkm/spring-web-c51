package by.tms.dao.JPA;

import by.tms.entity.Operation;
import by.tms.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class JPAHistoryDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public Operation findById(long id) {
        Operation operation = entityManager.find(Operation.class, id);
        entityManager.close();
        return operation;
    }

    public List<Operation> findAllByUser(User user) {
        List<Operation> operationList = user.getOperationList();
        return operationList;
    }

    public void save(Operation operation) {
        entityManager.persist(operation);
        entityManager.close();
    }


    public void remove(Operation operation) {
        entityManager.remove(operation);
        entityManager.close();
    }

    public void update(Operation operation) {
        entityManager.merge(operation);
        entityManager.close();
    }
}
