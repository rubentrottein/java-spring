package com.payme.app.service;

import com.payme.app.model.Supply;
import com.payme.app.model.User;
import com.payme.app.repository.SupplyRepository;
import com.payme.app.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplyService {
    private SupplyRepository supplyRepository = new SupplyRepository();
    private UserRepository userRepository = new UserRepository();

    public List<Supply> getSupplyListByUserName(String userName) {
        User user = userRepository.getUserByName(userName);
        List<Supply> approvisionnements = supplyRepository.findByUser(user);
        return approvisionnements;
    }
}
