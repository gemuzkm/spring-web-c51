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

    @Transactional(readOnly = true)
    public Operation findById(long id) {
        Operation operation = entityManager.find(Operation.class, id);
        entityManager.close();
        return operation;
    }

    public List<Operation> findAllByUser(User user) {
        List<Operation> operationList = user.getOperationList();
        return operationList;
    }
}
