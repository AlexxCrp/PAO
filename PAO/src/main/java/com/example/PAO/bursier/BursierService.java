package com.example.PAO.bursier;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BursierService {

    private final BursierRepository bursierRepository;

    public BursierService(BursierRepository bursierRepository) {
        this.bursierRepository = bursierRepository;
    }

    public List<Bursier> getBursieri() {
        return bursierRepository.findAll();
    }
}
