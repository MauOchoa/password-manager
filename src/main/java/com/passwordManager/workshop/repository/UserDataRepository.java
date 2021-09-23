package com.passwordManager.workshop.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.passwordManager.workshop.models.UserData;

@Repository
public interface UserDataRepository extends JpaRepository <UserData,Integer> {
    
    Optional <UserData>  findByUserName(String userName);

    Optional <UserData> findById(int id);
}