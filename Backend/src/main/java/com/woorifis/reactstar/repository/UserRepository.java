package com.woorifis.reactstar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.woorifis.reactstar.domain.Users;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,String> {
    boolean existsByUid(String uId);
    // boolean existsByName(String name);
    Optional<Users> findByUid(String uid);

    @Modifying
    @Query(value="UPDATE Users u SET name=:name and pw=:pw where u.id = :uId", nativeQuery=true)
    int updateUser(@Param(value="name") String name, @Param(value="pw") String pw, @Param(value="uId") String uId);

    @Modifying
    @Query(value="UPDATE Users u SET u.lgn_dt = :lgn_dt WHERE u.id = :uId", nativeQuery=true)
    int updateLgnDt(@Param(value="lgn_dt") LocalDateTime lgn_dt, @Param(value="uId") String uId);

    void deleteById(String uId);
}
