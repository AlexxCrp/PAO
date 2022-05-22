package com.example.PAO.bursier;

import com.example.PAO.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Bursier")
public class BursierController {
    private final BursierService bursierService;

    @Autowired
    public BursierController(BursierService bursierService) {
        this.bursierService = bursierService;
    }

    @GetMapping
    public List<Bursier> getBursieri(){
        Logging logger = new Logging();
        LocalDateTime timp = LocalDateTime.now();
        logger.writeStudentGet(timp, "GetBursieri");
        return bursierService.getBursieri();
    }
}
