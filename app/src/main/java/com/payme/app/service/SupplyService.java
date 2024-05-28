package com.payme.app.service;

import com.payme.app.model.Operation;
import com.payme.app.model.Supply;
import com.payme.app.model.User;
import com.payme.app.repository.SupplyRepository;
import com.payme.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplyService {
    @Autowired
    private SupplyRepository supplyRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Supply> getSupplyListByUserName(String userName) {
        User user = userRepository.getUserByName(userName);
        List<Supply> approvisionnements = supplyRepository.findByUser(user);
        return approvisionnements;
    }

    public void addSupply(Supply supply){
        //User user = userRepository.getUserByName(userName);
        userRepository.getUserByName("user").getSupplyList().add(supply);
    }

}
