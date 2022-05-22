package com.example.PAO.materie;

import com.example.PAO.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/materie")
public class MaterieController {
    private final MaterieService materieService;

    @Autowired
    public MaterieController(MaterieService materieService) {
        this.materieService = materieService;
    }

    @GetMapping
    public List<Materie> getMaterii(){
        Logging logger = new Logging();
        LocalDateTime timp = LocalDateTime.now();
        logger.writeStudentGet(timp, "GetMaterii");
        return materieService.getMaterii();
    }

    @GetMapping(path = "order")
    public List<Materie> getMateriiOrderedByNrCredite(){
        Logging logger = new Logging();
        LocalDateTime timp = LocalDateTime.now();
        logger.writeStudentGet(timp, "getMateriiOrderedByNrCredite");
        return materieService.getMateriiOrderedByNrCredite();
    }

    @PostMapping
    public void addMaterie(@RequestBody Materie materie){
        Logging logger = new Logging();
        LocalDateTime timp = LocalDateTime.now();
        logger.writeStudentGet(timp, "AddMaterie");
        materieService.addNewMaterie(materie);
    }

    @DeleteMapping(path = "{materieId}")
    public void deleteMaterie(@PathVariable("materieId") Long materieId){
        Logging logger = new Logging();
        LocalDateTime timp = LocalDateTime.now();
        logger.writeStudentGet(timp, "DeleteMaterie");
        materieService.deleteMaterie(materieId);
    }

    @PutMapping(path = "{materieId}")
    public void updateMaterie(@PathVariable("materieId") Long materieId,
                              @RequestParam(required = false) String nume,
                              @RequestParam(required = false) Integer nrCredite){
        Logging logger = new Logging();
        LocalDateTime timp = LocalDateTime.now();
        logger.writeStudentGet(timp, "UpdateMaterie");
        materieService.updateMaterie(materieId, nume, nrCredite);
    }

    @PutMapping(path = "{materieId}/profesor/{profesorId}")
    public void adaugaProfLaMaterie(
        @PathVariable("materieId") Long materieId,
        @PathVariable("profesorId") Long profesorId
        ){
        Logging logger = new Logging();
        LocalDateTime timp = LocalDateTime.now();
        logger.writeStudentGet(timp, "AssignProfToMaterie");
        materieService.adaugaProfLaMaterie(materieId, profesorId);
    }

    @PutMapping(path = "{materieId}/student/{studentId}")
    public void adaugaStudentLaMaterie(
            @PathVariable("materieId") Long materieId,
            @PathVariable("studentId") Long studentId
    ){
        Logging logger = new Logging();
        LocalDateTime timp = LocalDateTime.now();
        logger.writeStudentGet(timp, "AssignStudentToMaterie");
        materieService.adaugaStudentLaMaterie(materieId, studentId);
    }
}
