package com.example.PAO.profesor;

import com.example.PAO.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/profesor")
public class ProfesorController {
    private final ProfesorService profesorService;

    @Autowired
    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @GetMapping
    public List<Profesor> getProfesori() {
        Logging logger = new Logging();
        LocalDateTime timp = LocalDateTime.now();
        logger.writeStudentGet(timp, "GetProfesori");
        return profesorService.getProfesori();
    }

    @PostMapping
    public void addProfesor(@RequestBody Profesor profesor) {
        Logging logger = new Logging();
        LocalDateTime timp = LocalDateTime.now();
        logger.writeStudentGet(timp, "AddProfesor");
        profesorService.addProfesor(profesor);
    }

    @PutMapping(path = "{profesorId}")
    public void updateProfesor(@PathVariable("profesorId") Long profesorId,
                               @RequestParam(required = false) String email,
                               @RequestParam(required = false) String nume,
                               @RequestParam(required = false) String prenume) {
        Logging logger = new Logging();
        LocalDateTime timp = LocalDateTime.now();
        logger.writeStudentGet(timp, "UpdateProfesor");
        profesorService.updateProfesor(profesorId, email, nume, prenume);

    }

    @DeleteMapping(path = "{profesorId}")
    public void deleteProfesor(@PathVariable("profesorId") Long profesorId){
        Logging logger = new Logging();
        LocalDateTime timp = LocalDateTime.now();
        logger.writeStudentGet(timp, "DeleteProfesor");
        profesorService.deleteProfesor(profesorId);
    }
}
