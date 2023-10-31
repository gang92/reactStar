package com.woorifis.reactstar.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
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

import com.woorifis.reactstar.config.JwtTokenUtil;
import com.woorifis.reactstar.domain.Users;
import com.woorifis.reactstar.dto.LoginRequest;
import com.woorifis.reactstar.dto.SignUpRequest;
import com.woorifis.reactstar.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;

    @GetMapping(value = {"","/"})
    public ResponseEntity<String> isLoggedIn(Authentication auth) {
        if(auth != null) {
            Users loginUser = userService.getUserInfo(auth.getName());

            if (loginUser != null) {
                return new ResponseEntity<String>(loginUser.getName(), HttpStatus.OK);
            }
        }

        return new ResponseEntity<String>("Not Logged In", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        if(request != null) {
            Users user = userService.login(request);
            
            if(user != null) {
                String secretKey = "secret-023151-key";
                long expireTimeMs = 1000 * 60 * 60;
                String jwtToken = JwtTokenUtil.createToken(user.getUid(), secretKey, expireTimeMs);

                return new ResponseEntity<String>(jwtToken, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<String>("Failed to Login", HttpStatus.NOT_FOUND);
            }
        }

        return new ResponseEntity<String>("Failed to Login",HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody SignUpRequest request) {
        if(request != null) {
            if(!userService.checkUidDuplicate(request.getUid())) {
                userService.signUp(request);
    
                return new ResponseEntity<String>("Signed Up!", HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>("Failed to Signup", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/info/{uId}")
    public ResponseEntity<Users> userInfo(Authentication auth, @PathVariable("uId") String uId) {
        if(auth != null) {
            Users user = userService.getUserInfo(uId);
            
            if(user != null) {
                return new ResponseEntity<Users>(user, HttpStatus.OK);
            }
        }

        return new ResponseEntity<Users>( HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/info/{uId}")
    public ResponseEntity<Users> updateNameAndPw(Authentication auth, @RequestBody Map<String,String> request) {
        if(auth != null) {
            Users user = userService.updateUser(request);

            if(user != null) {
                return new ResponseEntity<Users>(user, HttpStatus.OK);
            }
        }

        return new ResponseEntity<Users>( HttpStatus.BAD_REQUEST);
    }
    
    @DeleteMapping("/delete/{uId}")
    public ResponseEntity<String> deleteUser(Authentication auth, @PathVariable("uId") String uId) {
        if(auth != null) {
            userService.deleteUser(uId);
        
            return new ResponseEntity<String>("Deleted "+uId, HttpStatus.OK);
        }
        
        return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
    }
}
