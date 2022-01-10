package com.example.JpaCRUD.Profesor.infrastructure;

import com.example.JpaCRUD.Profesor.application.IProfesorService;
import com.example.JpaCRUD.Profesor.infrastructure.controller.dto.input.ProfesorInputDto;
import com.example.JpaCRUD.Profesor.infrastructure.controller.dto.output.ProfesorOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
@RestController
public class ControladorProfesor {

    @Autowired
    IProfesorService profesorService;


    @GetMapping("profesor/id/{id}")
    public Object getProfesorId(@PathVariable Integer id, @RequestParam(defaultValue = "simple") String outputType) throws Exception{

        Object profesor = new Object();

        if(outputType.matches("simple")) {
            profesor = profesorService.getProfesorById(id);
            return profesor;
        }
        if(outputType.matches("full")){
            profesor = profesorService.getProfesorYpersonById(id);
            return profesor;
        }

        return profesor;
    }

    @GetMapping("profesor/name/{profesor}")
    public List<ProfesorOutputDto> getPersonaUser(@PathVariable String profesor) throws Exception{

        return profesorService.getProfesoresByName(profesor);
    }

    @GetMapping("allprofesores")
    public List<ProfesorOutputDto> getProfesores(){

        List<ProfesorOutputDto> listaProfesores = profesorService.getAllProfesores();

        return listaProfesores;
    }

    @DeleteMapping("profesor/delete/{id}")
    public String deleteProfesor(@PathVariable int id) throws Exception{
        profesorService.del(id);
        return "El profesor con el id "+ id + " ha sido eliminado";
    }

    @PutMapping("profesor/edit/{id}")
    public ProfesorOutputDto editProfesor(@RequestBody ProfesorInputDto profesorInputDto, @PathVariable int id) throws Exception {

        ProfesorOutputDto profesorEditado = profesorService.editProfesor(profesorInputDto,id);

        return profesorEditado;
    }


    @PostMapping("addProfesor")
    public ProfesorOutputDto addProfesor(@RequestBody ProfesorInputDto profesorInputDto) throws Exception{

        return profesorService.add(profesorInputDto);
    }

}
