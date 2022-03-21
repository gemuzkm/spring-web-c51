package by.tms.service;

import by.tms.dao.Hibernate.HibernateHistoryDAO;
import by.tms.entity.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class СalculatorService {

    @Autowired
    HibernateHistoryDAO hibernateHistoryDAO;

    public Double getResult(Operation operation) {
        double resultValue = 0;

        switch (operation.getOperation()) {
            case "SUM":
                resultValue = operation.getValue1() + operation.getValue2();
                break;
            case "SUBTRACT":
                resultValue = operation.getValue1() - operation.getValue2();
                break;
            case "DIVIDE":
                resultValue = operation.getValue1() / operation.getValue2();
                break;
            case "MULTIPLY":
                resultValue = operation.getValue1() * operation.getValue2();
                break;
        }
        return resultValue;
    }
}
