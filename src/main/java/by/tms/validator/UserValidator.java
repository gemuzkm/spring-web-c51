package by.tms.validator;

import by.tms.dao.Hibernate.HibernateUserDAO;
import by.tms.entity.User;
import by.tms.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    @Autowired
    private HibernateUserDAO hibernateUserDAO;

    // not used
    public boolean isValid(User user) {
        return true;
    }

    public boolean isValid(UserDTO userDTO) {
        return isValidUserName(userDTO) && isValidUserPassword(userDTO);
    }

    private boolean isValidUserName(UserDTO userDTO) {
        return hibernateUserDAO.findAllByName(userDTO.getName()).size() != 0;
    }

    private boolean isValidUserPassword(UserDTO userDTO) {
        User user = hibernateUserDAO.findByUsername(userDTO.getName());
        return user.getPassword().equals(userDTO.getPassword());
    }

}
