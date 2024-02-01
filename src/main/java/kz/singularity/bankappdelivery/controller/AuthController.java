package kz.singularity.bankappdelivery.controller;

import kz.singularity.bankappdelivery.auth.JwtUtil;
import kz.singularity.bankappdelivery.model.request.LoginReq;
import kz.singularity.bankappdelivery.model.response.ErrorRes;
import kz.singularity.bankappdelivery.model.response.LoginResponse;
import kz.singularity.bankappdelivery.model.user.User;
import kz.singularity.bankappdelivery.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserServiceImpl userService;

    private final JwtUtil jwtUtil;


//    @PostMapping("/authenticate")
//    public ResponseEntity generateToken() {
//        try {
//            // For simplicity, creating a temporary user without registration
//            User temporaryUser = new User("temporaryUser", "password");
//            userService.createUserWithReqBodyUser(temporaryUser);
//            log.info("Temporary user created");
//            Authentication authentication =
//                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(temporaryUser.getUsername(), temporaryUser.getPassword()));
//            log.info("Authentication ok");
//            String username = authentication.getName();
//            String token = jwtUtil.createToken(new User(username, ""));
//            log.info("Token created");
//            LoginResponse loginRes = new LoginResponse(username,token);
//
//            return ResponseEntity.ok(loginRes);
//        } catch (Exception e) {
//            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, e.getMessage());
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
//        }
//    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody LoginReq registerRequest) {
        User registeredUser = new User(registerRequest.getUsername(), registerRequest.getPassword());
        userService.createUserWithReqBodyUser(registeredUser);
        String token = jwtUtil.createToken(registeredUser);

        return ResponseEntity.ok(new LoginResponse(registeredUser.getUsername(), token));
    }

    @ResponseBody
    @PostMapping( "/login")
    public ResponseEntity login(@RequestBody LoginReq loginReq)  {

        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReq.getUsername(), loginReq.getPassword()));
            String username = authentication.getName();
            User user = new User(username,"");
            String token = jwtUtil.createToken(user);
            LoginResponse loginRes = new LoginResponse(username,token);

            return ResponseEntity.ok(loginRes);

        }catch (BadCredentialsException e){
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST,"Invalid username or password");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }catch (Exception e){
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }


}
