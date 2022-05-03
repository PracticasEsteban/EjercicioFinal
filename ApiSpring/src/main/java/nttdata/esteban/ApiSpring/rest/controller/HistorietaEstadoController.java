package nttdata.esteban.ApiSpring.rest.controller;


import nttdata.esteban.ApiSpring.rest.dto.HistorietaEstadoDTO;
import nttdata.esteban.ApiSpring.rest.service.HistorietaEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/postState")
public class HistorietaEstadoController {


    @Autowired
    HistorietaEstadoService historietaEstadoService;



    @GetMapping("/count")
    public Long count(){
        return this.historietaEstadoService.count();
    }

    @GetMapping(value = "")
    public List<HistorietaEstadoDTO> findAll(@RequestParam(required = false, defaultValue = "false")Boolean conTodo , @RequestParam(required = false, defaultValue = "false")String search){
        return this.historietaEstadoService.findAll(conTodo, search);

    }

    @GetMapping(value = "/{id}")
    public HistorietaEstadoDTO findById(@PathVariable Integer id, @RequestParam(required = false, defaultValue = "false") Boolean conTodo){

        HistorietaEstadoDTO historietaEstadoDTO = this.historietaEstadoService.findById(id,conTodo);


        if (historietaEstadoDTO == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La ESTADO de la Historia con ID: "+id +"no fue encontrada");
        }

        return historietaEstadoDTO;
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public HistorietaEstadoDTO create(@RequestBody HistorietaEstadoDTO historietaEstadoDTO){

        return this.historietaEstadoService.create(historietaEstadoDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "El estado de la Historieta actualizada correctamente")
    public void update(@RequestBody HistorietaEstadoDTO historietaEstadoDTO){

        this.historietaEstadoService.update(historietaEstadoDTO);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Estado de historieta eliminada correctamente")
    public void delete(@RequestBody HistorietaEstadoDTO historietaEstadoDTO){

        this.historietaEstadoService.delete(historietaEstadoDTO);
    }

}
