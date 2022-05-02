package nttdata.esteban.ApiSpring.rest.controller;

import nttdata.esteban.ApiSpring.rest.dto.FriendDTO;
import nttdata.esteban.ApiSpring.rest.dto.UserDTO;
import nttdata.esteban.ApiSpring.rest.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/friend")
public class FriendController {

    @Autowired
    FriendService friendService;

    @GetMapping("/count")
    public Long count(){
        return this.friendService.count();
    }


    @GetMapping(value = "")
    public List<FriendDTO> findAll(@RequestParam(required = false, defaultValue = "false")Boolean conTodo , @RequestParam(required = false, defaultValue = "false")String search){
        return this.friendService.findAll(conTodo, search);

    }

    @GetMapping(value = "/{id}")
    public FriendDTO findById(@PathVariable Integer id, @RequestParam(required = false, defaultValue = "false") Boolean conTodo){

        FriendDTO friendDTO = this.friendService.findById(id,conTodo);

        if (friendDTO == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La asosiacion Amigo no fue encontrado");
        }

        return friendDTO;
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public FriendDTO create(@RequestBody FriendDTO friendDTO){

        return this.friendService.create(friendDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Friend fue cambiada")
    public void update(@RequestBody FriendDTO friendDTO){

        this.friendService.update(friendDTO);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Friend fue eliminado")
    public void delete(@RequestBody FriendDTO friendDTO){

        this.friendService.delete(friendDTO);
    }

}
