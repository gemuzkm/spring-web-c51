package by.tms.dao;

import by.tms.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private List<User> userList;

    {
        userList = new ArrayList<>();
        userList.add(new User(1, "user1", "user1"));
        userList.add(new User(2, "user2", "user2"));
        userList.add(new User(3, "user3", "user3"));
    }

    public List<User> index() {
        return userList;
    }

    public User show(int id) {
        return userList.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }
}
