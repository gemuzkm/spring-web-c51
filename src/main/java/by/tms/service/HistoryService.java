package by.tms.service;

import by.tms.dao.Hibernate.HibernateHistoryDAO;
import by.tms.dao.Hibernate.HibernateUserDAO;
import by.tms.entity.Operation;
import by.tms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@Component
public class HistoryService {

    @Autowired
    HibernateHistoryDAO hibernateHistoryDAO;

    @Autowired
    HibernateUserDAO hibernateUserDAO;

    public HistoryService() {
    }

    public void save(HttpSession session, Operation operation) {
        User user = (User) session.getAttribute("user");
        List<Operation> operationList = user.getOperationList();
        operationList.add(operation);
        user.setOperationList(operationList);

        hibernateUserDAO.update(user);
    }


}
