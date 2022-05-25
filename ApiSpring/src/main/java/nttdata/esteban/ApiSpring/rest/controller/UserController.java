package nttdata.esteban.ApiSpring.rest.controller;

import nttdata.esteban.ApiSpring.rest.dto.UserDTO;
import nttdata.esteban.ApiSpring.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/person")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/count")
    public Long count(){
        return this.userService.count();
    }


    @GetMapping(value = "")
    public List<UserDTO> findAll(@RequestParam(required = false, defaultValue = "false")Boolean conTodo , @RequestParam(required = false, defaultValue = "false")String search){
        return this.userService.findAll(conTodo, search);

    }

    @GetMapping(value = "/{id}")
    public UserDTO findById(@PathVariable Integer id, @RequestParam(required = false, defaultValue = "false") Boolean conTodo){

        UserDTO userDTO = this.userService.findById(id, conTodo);


        if (userDTO == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario no fue encontrado");
        }

        return userDTO;
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserDTO create(@RequestBody UserDTO userDTO){

        return this.userService.create(userDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Usuario actualizado")
    public void update(@RequestBody UserDTO userDTO){

        this.userService.update(userDTO);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Usuario eliminado")
    public void delete(@RequestBody UserDTO userDTO){

        this.userService.delete(userDTO);
    }



}
