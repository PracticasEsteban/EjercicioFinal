package nttdata.esteban.ApiSpring.rest.service;


import nttdata.esteban.ApiSpring.repository.customJPADAO.IHistorietaCustomJPADAO;
import nttdata.esteban.ApiSpring.repository.jpa.IHistorietaJPADAO;
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
}
