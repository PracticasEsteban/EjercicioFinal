package nttdata.esteban.ApiSpring.rest.controller;


import nttdata.esteban.ApiSpring.repository.modelo.Historieta;
import nttdata.esteban.ApiSpring.rest.dto.HistorietaDTO;
import nttdata.esteban.ApiSpring.rest.service.HistorietaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/post")
public class HistorietaController {


    @Autowired
    HistorietaService historietaService;

    @GetMapping("/count")
    public Long count(){
        return this.historietaService.count();
    }

    @GetMapping(value = "")
    public List<HistorietaDTO> findAll(@RequestParam(required = false, defaultValue = "false")Boolean conTodo , @RequestParam(required = false, defaultValue = "false")String search){
        return this.historietaService.findAll(conTodo, search);

    }

    @GetMapping(value = "/{id}")
    public HistorietaDTO findById(@PathVariable Integer id, @RequestParam(required = false, defaultValue = "false") Boolean conTodo){

        HistorietaDTO historietaDTO = this.historietaService.findById(id,conTodo);


        if (historietaDTO == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La historieta/post no fue encontrada");
        }

        return historietaDTO;
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public HistorietaDTO create(@RequestBody HistorietaDTO historietaDTO){

        return this.historietaService.create(historietaDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Historieta actualizada correctamente")
    public void update(@RequestBody HistorietaDTO historietaDTO){

        this.historietaService.update(historietaDTO);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Historieta eliminada correctamente")
    public void delete(@RequestBody HistorietaDTO historietaDTO){

        this.historietaService.delete(historietaDTO);
    }
}
