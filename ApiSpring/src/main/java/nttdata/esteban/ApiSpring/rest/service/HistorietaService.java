package nttdata.esteban.ApiSpring.rest.service;


import nttdata.esteban.ApiSpring.repository.customJPADAO.IFriendCustomJPADAO;
import nttdata.esteban.ApiSpring.repository.customJPADAO.IHistorietaCustomJPADAO;
import nttdata.esteban.ApiSpring.repository.jpa.IHistorietaJPADAO;
import nttdata.esteban.ApiSpring.repository.modelo.Friend;
import nttdata.esteban.ApiSpring.repository.modelo.Historieta;
import nttdata.esteban.ApiSpring.rest.dto.HistorietaDTO;
import nttdata.esteban.ApiSpring.rest.mapper.HistorietaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HistorietaService {

    @Autowired
    IHistorietaJPADAO  iHistorietaJPADAO;

    @Autowired
    IHistorietaCustomJPADAO iHistorietaCustomJPADAO;

    @Autowired
    IFriendCustomJPADAO iFriendCustomJPADAO;


    public Long count(){
        return this.iHistorietaJPADAO.count();
    }

    public List<HistorietaDTO> findAll(Boolean conTodo, String search){

        List<Historieta> historietas = new ArrayList<>();


        if (search.equalsIgnoreCase("false")){
            historietas = this.iHistorietaJPADAO.findAll();
        }else{
            historietas = this.iHistorietaCustomJPADAO.findAllWithSearch(search);
        }

        return HistorietaMapper.map(historietas,conTodo);
    }


    public HistorietaDTO findById(Integer id, Boolean conTodo){

        Optional<Historieta> historieta = this.iHistorietaJPADAO.findById(id);

        return HistorietaMapper.map(historieta.get(),conTodo);
    }

    public HistorietaDTO create(HistorietaDTO historietaDTO){

        Historieta historieta = HistorietaMapper.map(historietaDTO, false);
        historieta= this.iHistorietaJPADAO.save(historieta);

        return HistorietaMapper.map(historieta,false);
    }

    public void update(HistorietaDTO historietaDTO){

        Historieta historieta = HistorietaMapper.map(historietaDTO, false);
         this.iHistorietaJPADAO.save(historieta);

    }

    public void delete(HistorietaDTO historietaDTO){

        Historieta historieta = HistorietaMapper.map(historietaDTO, false);
        this.iHistorietaJPADAO.delete(historieta);

    }

    //Listado de historietas del usuario y de sus amigos
    public List<HistorietaDTO> findAllPersonWithFriends(Integer id) {

        List<Historieta> listaHistorietas = new ArrayList<>();

        //Obtenemos de momento todas las historietas del usuario
        String getUsuarioHistorietas="user.id:"+id;
        List<Historieta>  listaHistorietaUsuario= new ArrayList<>();

        listaHistorietaUsuario = this.iHistorietaCustomJPADAO.findAllWithSearch(getUsuarioHistorietas);

        listaHistorietas.addAll(listaHistorietaUsuario);

        //Amigos del usuario

        List<Friend> amigosEnviadoAceptado = new ArrayList<>();
        String friendSendAccept="friend.accept:true,userSend.id:"+id;

        List<Friend> amigosRecividoAceptado = new ArrayList<>();
        String friendRecividoAccept="friend.accept:true,userRecive.id:"+id;

        amigosEnviadoAceptado = this.iFriendCustomJPADAO.findAllWithSearch(friendSendAccept);
        amigosRecividoAceptado=this.iFriendCustomJPADAO.findAllWithSearch(friendRecividoAccept);

        //Lista de id con los amigos del usuario
        List<Integer> listaIDAmigos=new ArrayList<>();

        //Cogemos id Y guardamos
        for (Friend f:amigosEnviadoAceptado) {
            listaIDAmigos.add(f.getUserRecive().getId());
        }

        for (Friend f:amigosRecividoAceptado){
            listaIDAmigos.add(f.getUserSend().getId());
        }

        //Obtenemos las historietas de cada amigo y las añadimos al array
        for (int i = 0; i < listaIDAmigos.size(); i++) {

            String getAmigoHistorietas="user.id:"+listaIDAmigos.get(i);
            List<Historieta> historietasAmigos = new ArrayList<>();
            historietasAmigos = this.iHistorietaCustomJPADAO.findAllWithSearch(getAmigoHistorietas);

            listaHistorietas.addAll(historietasAmigos);

        }
        return HistorietaMapper.map(listaHistorietas, false);
    }
}
