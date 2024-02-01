package kz.singularity.bankappdelivery.controller;

import kz.singularity.bankappdelivery.model.request.LoginReq;
import kz.singularity.bankappdelivery.model.user.User;
import kz.singularity.bankappdelivery.service.impl.UserServiceImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.PartitionKey;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Getter
@Setter
public class UserController {
    private final UserServiceImpl userService;


    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{user_id}")
    public User findUserById(@PathVariable("user_id") Long id){
        return userService.getUserByID(id);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody LoginReq loginReq){
        userService.createUser(loginReq.getUsername(), loginReq.getPassword());
    }

    @PutMapping("/update/{user_id}")
    public void updateUser(@PathVariable("user_id") Long id,
                           @RequestBody User user){
        userService.updateUser(id, user);
    }

    @DeleteMapping("/delete{user_id}")
    public void deleteUser(@PathVariable("user_id") Long id){
        userService.deleteUser(id);
    }

}
