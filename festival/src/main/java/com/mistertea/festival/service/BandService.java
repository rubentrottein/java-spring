package com.mistertea.festival.service;

import com.mistertea.festival.model.Band;
import com.mistertea.festival.repository.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BandService {
    @Autowired
    private BandRepository bandRepository;

    public Band addBand(Band band) {
        bandRepository.save(band);
        return band;
    }
    public List<Band> getAllBands(){
        return (List<Band>) bandRepository.findAll();
    }
}