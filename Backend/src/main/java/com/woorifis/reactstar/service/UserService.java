package com.woorifis.reactstar.service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.woorifis.reactstar.config.SSDetails;
import com.woorifis.reactstar.domain.Users;
import com.woorifis.reactstar.dto.LoginRequest;
import com.woorifis.reactstar.dto.SignUpRequest;
import com.woorifis.reactstar.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService implements UserDetailsService {
    
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
            LocalDateTime date = LocalDateTime.now();
    
            userRepository.save(req.toEntity(encoder.encode(req.getPw()),date));
        }
    }

    // 로그인
    @Override
    public UserDetails loadUserByUsername(String Uid) throws UsernameNotFoundException {
        Users user = userRepository.findByUid(Uid)
            .orElseThrow(() -> { return new UsernameNotFoundException("해당 유저를 찾을 수 없습니다.");
        });
        
        return new SSDetails(user);
    }

    @Transactional
    public Users login(LoginRequest req) {
        if(req != null) {
            LocalDateTime date = LocalDateTime.now();
            int res = userRepository.updateLgnDt(date,req.getUid());
            
            if(res != 0) {
                Optional<Users> reqUser = userRepository.findByUid(req.getUid());
                Users user = reqUser.get();
        
                if(encoder.matches(req.getPw(),user.getPw())) {
                    return user;
                }
            }
        }
        
        return null;
    }

    // 사용자 정보 조회
    public Users getUserInfo(String uId) {
        if(uId != null) {
            Optional<Users> user = userRepository.findByUid(uId);

            if(!user.isEmpty()) {
                return user.get();
            }
        }
        
        return null;
    }

    // 사용자 정보 업데이트
    @Transactional
    public Users updateUser(Map<String,String> req) {
        if(req != null) {
            int res = userRepository.updateUser(req.get("name"), req.get("pw"), req.get("uId"));
            
            if(res != 0) {
                Users user = getUserInfo(req.get("uId"));
                
                return user;
            }
        }
        
        return null;
    }

    // 사용자 삭제
    @Transactional
    public void deleteUser(String uId) {
        if(uId != null) {
            userRepository.deleteById(uId);
        }
        
        return;
    }
}
