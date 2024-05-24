package com.mistertea.festival.service;

import com.mistertea.festival.model.Band;
import com.mistertea.festival.model.Scene;
import com.mistertea.festival.repository.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BandService {
    @Autowired
    private BandRepository bandRepository;
    SceneService sceneService = new SceneService();


    public List<Band> getAllBands(){
        return (List<Band>) bandRepository.findAll();
    }

    public Band addBand(Band band) {
        return bandRepository.save(band);
    }

    public void deleteBand(Long id) {
        bandRepository.deleteById(id);
    }

    /* TODO */
    public void updateBand(Long id, Band band) {
        if(bandRepository.findById(id).isPresent()){
            Band bandToUpdate = bandRepository.findById(id).get();
            bandToUpdate.setName(band.getName());
            bandToUpdate.setScene(band.getScene());
            bandRepository.save(bandToUpdate);
        }
    }
}
