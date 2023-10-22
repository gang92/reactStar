package com.woorifis.reactstar.service;

import java.sql.Date;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.woorifis.reactstar.domain.User;
import com.woorifis.reactstar.dto.LoginRequest;
import com.woorifis.reactstar.dto.SignUpRequest;
import com.woorifis.reactstar.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    // ID 중복 확인
    public boolean checkUidDuplicate(String uid) {
        return userRepository.existsByUid(uid);
    }

    // public boolean checkNameDuplicate(String name) {
    //     return userRepository.existsByName(name);
    // }

    // 회원가입
    public void signUp(SignUpRequest req) {
        if(req != null) {
            java.util.Date utilDate = new java.util.Date();
            Date date = new Date(utilDate.getTime());
    
            userRepository.save(req.toEntity(encoder.encode(req.getPw()),date));
        }
    }

    // 로그인
    public User login(LoginRequest req) {
        if(req != null) {
            java.util.Date utilDate = new java.util.Date();
            Date date = new Date(utilDate.getTime());
            int res = userRepository.updateLgnDt(date,req.getUid());
            
            if(res != 0) {
                Optional<User> reqUser = userRepository.findByUid(req.getUid());
                User user = reqUser.get();
        
                if(encoder.matches(req.getPw(),user.getPw())) {
                    return user;
                }
            }
        }
        
        return null;
    }

    // 사용자 정보 조회
    public User getUserInfo(String uId) {
        if(uId != null) {
            Optional<User> user = userRepository.findByUid(uId);

            if(!user.isEmpty()) {
                return user.get();
            }
        }
        
        return null;
    }

    // 사용자 정보 업데이트
    public User updateUser(Map<String,String> req) {
        if(req != null) {
            int res = userRepository.updateUser(req.get("name"), req.get("pw"), req.get("uId"));
            
            if(res != 0) {
                User user = getUserInfo(req.get("uId"));
                
                return user;
            }
        }
        
        return null;
    }

    // 사용자 삭제
    public void deleteUser(String uId) {
        if(uId != null) {
            userRepository.deleteById(uId);
        }
        
        return;
    }
}
