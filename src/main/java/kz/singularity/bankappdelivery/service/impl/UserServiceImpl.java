package kz.singularity.bankappdelivery.service.impl;

import kz.singularity.bankappdelivery.Repository.UserRepository;
import kz.singularity.bankappdelivery.model.user.User;
import kz.singularity.bankappdelivery.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByID(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(Long id, User user) {
        User user1 = userRepository.findUserById(id);
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        userRepository.save(user1);
    }

    @Override
    public void createUser(String username, String password) {
        User user = new User(username, password);
        userRepository.save(user);
    }

    @Override
    public void createUserWithReqBodyUser(User user) {
        userRepository.save(user);
    }
}
