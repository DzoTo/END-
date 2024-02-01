package kz.singularity.bankappdelivery.service;

import kz.singularity.bankappdelivery.model.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUsers();

    User getUserByID(Long id);

    User getUserByUsername(String username);

    void deleteUser(Long id);

    void updateUser(Long id, User user);

    void createUser(String username, String password);

    void createUserWithReqBodyUser(User user);
}
