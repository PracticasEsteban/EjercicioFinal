package nttdata.esteban.ApiSpring.rest.controller;


import nttdata.esteban.ApiSpring.rest.dto.EventoDTO;
import nttdata.esteban.ApiSpring.rest.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    EventoService eventoService;

    @GetMapping("/count")
    public Long count(){
        return this.eventoService.count();
    }


    @GetMapping(value = "")
    public List<EventoDTO> findAll(@RequestParam(required = false, defaultValue = "false")Boolean conTodo){
        return this.eventoService.findAll(conTodo);

    }

    @GetMapping(value = "/{id}")
    public EventoDTO findById(@PathVariable Integer id, @RequestParam(required = false, defaultValue = "false") Boolean conTodo){

        EventoDTO eventoDTO = this.eventoService.findById(id,conTodo);

        if (eventoDTO == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El evento no fue encontrado");
        }

        return eventoDTO;
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public EventoDTO create(@RequestBody EventoDTO eventoDTO){

        return this.eventoService.create(eventoDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Evento fue cambiado")
    public void update(@RequestBody EventoDTO eventoDTO){

        this.eventoService.update(eventoDTO);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Evento fue eliminado")
    public void delete(@RequestBody EventoDTO eventoDTO){

        this.eventoService.delete(eventoDTO);
    }

}
