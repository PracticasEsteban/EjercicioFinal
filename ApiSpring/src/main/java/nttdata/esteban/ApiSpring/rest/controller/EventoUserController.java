package nttdata.esteban.ApiSpring.rest.controller;



import nttdata.esteban.ApiSpring.rest.dto.EventoUserDTO;

import nttdata.esteban.ApiSpring.rest.service.EventoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/eventoUser")
public class EventoUserController {

    @Autowired
    EventoUserService eventoUserService;


    @GetMapping("/count")
    public Long count(){
        return this.eventoUserService.count();
    }


    @GetMapping(value = "")
    public List<EventoUserDTO> findAll(@RequestParam(required = false, defaultValue = "false")Boolean conTodo, @RequestParam(required = false, defaultValue = "false")String search){
        return this.eventoUserService.findAll(conTodo, search);

    }

    @GetMapping(value = "/{id}")
    public EventoUserDTO findById(@PathVariable Integer id, @RequestParam(required = false, defaultValue = "false") Boolean conTodo){

        EventoUserDTO eventoUserDTO = this.eventoUserService.findById(id,conTodo);

        if (eventoUserDTO == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El eventoUser no fue encontrada");
        }

        return eventoUserDTO;
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public EventoUserDTO create(@RequestBody EventoUserDTO eventoUserDTO){

        return this.eventoUserService.create(eventoUserDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "EventoUser fue cambiado")
    public void update(@RequestBody EventoUserDTO eventoUserDTO){

        this.eventoUserService.update(eventoUserDTO);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Evento fue eliminado")
    public void delete(@RequestBody EventoUserDTO eventoUserDTO){

        this.eventoUserService.delete(eventoUserDTO);
    }

}
