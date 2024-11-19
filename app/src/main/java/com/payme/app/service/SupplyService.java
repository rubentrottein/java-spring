package com.payme.app.service;

import com.payme.app.model.Supply;
import com.payme.app.model.User;
import com.payme.app.repository.SupplyRepository;
import com.payme.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplyService {
    @Autowired
    private SupplyRepository supplyRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Supply> getSupplyListByUserName(String userName) {
        Optional<User> user = userRepository.getUserByName(userName);
        return supplyRepository.findByUser(user);
    }

    public void addSupply(Supply supply, String userName){
        Optional<User> user = userRepository.getUserByName(userName);
        //userRepository.getUserByName("user").getSupplyList().add(supply);
    }

}
