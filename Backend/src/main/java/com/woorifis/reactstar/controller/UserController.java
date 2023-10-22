package com.woorifis.reactstar.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woorifis.reactstar.domain.User;
import com.woorifis.reactstar.dto.LoginRequest;
import com.woorifis.reactstar.dto.SignUpRequest;
import com.woorifis.reactstar.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping(value = {"","/"})
    public Boolean isLoggedIn(Model model, Authentication auth) {
        if(auth != null) {
            User loginUser = userService.getUserInfo(auth.getName());

            if (loginUser != null) {
                model.addAttribute("name", loginUser.getName());
            }

            return true;
        }

        return false;
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest request) {
        if(request != null) {
            User user = userService.login(request);

            if(user != null) {
                return ResponseEntity.ok().body(user);
            }
            else {
                return ResponseEntity.notFound().build();
            }
        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody SignUpRequest request) {
        if(request != null) {
            if(!userService.checkUidDuplicate(request.getUid())) {
                userService.signUp(request);
    
                return ResponseEntity.ok().build();
            }
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/info/{uId}")
    public ResponseEntity<User> userInfo(Model model, Authentication auth, @PathVariable("uId") String uId) {
        if(auth != null) {
            User user = userService.getUserInfo(uId);
            
            if(user != null) {
                return ResponseEntity.ok().body(user);
            }
        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/info/{uId}")
    public ResponseEntity<User> updateNameAndPw(Authentication auth, @RequestBody Map<String,String> request) {
        if(auth != null) {
            User user = userService.updateUser(request);

            if(user != null) {
                return ResponseEntity.ok().body(user);
            }
        }

        return ResponseEntity.badRequest().build();
    }
    
    @DeleteMapping("/delete/{uId}")
    public ResponseEntity<User> deleteUser(Authentication auth, @PathVariable("uId") String uId) {
        if(auth != null) {
            userService.deleteUser(uId);
        
            return ResponseEntity.ok().build();
        }
        
        return ResponseEntity.badRequest().build();
    }
}
