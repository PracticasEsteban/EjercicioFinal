package nttdata.esteban.ApiSpring.rest.service;


import nttdata.esteban.ApiSpring.repository.jpa.IHistorietaEstadoJPADAO;
import nttdata.esteban.ApiSpring.repository.modelo.HistorietaEstado;
import nttdata.esteban.ApiSpring.rest.dto.HistorietaEstadoDTO;
import nttdata.esteban.ApiSpring.rest.mapper.HistorietaEstadoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HistorietaEstadoService {

    @Autowired
    IHistorietaEstadoJPADAO iHistorietaEstadoJPADAO;


    public Long count(){
        return this.iHistorietaEstadoJPADAO.count();
    }

    public List<HistorietaEstadoDTO> findAll(Boolean conTodo, String search){

        List<HistorietaEstado> historietasEstado = new ArrayList<>();


        if (search.equalsIgnoreCase("false")){
            historietasEstado = this.iHistorietaEstadoJPADAO.findAll();
        }else{
            historietasEstado = null;
        }

        return HistorietaEstadoMapper.map(historietasEstado,conTodo);
    }


    public HistorietaEstadoDTO findById(Integer id, Boolean conTodo){

        Optional<HistorietaEstado> historietaEstado = this.iHistorietaEstadoJPADAO.findById(id);

        return HistorietaEstadoMapper.map(historietaEstado.get(),conTodo);
    }

    public HistorietaEstadoDTO create(HistorietaEstadoDTO historietaEstadoDTO){

        HistorietaEstado historietaEstado = HistorietaEstadoMapper.map(historietaEstadoDTO, false);
        historietaEstado= this.iHistorietaEstadoJPADAO.save(historietaEstado);

        return HistorietaEstadoMapper.map(historietaEstado,false);
    }

    public void update(HistorietaEstadoDTO historietaEstadoDTO){

        HistorietaEstado historietaEstado = HistorietaEstadoMapper.map(historietaEstadoDTO, false);
        this.iHistorietaEstadoJPADAO.save(historietaEstado);

    }

    public void delete(HistorietaEstadoDTO historietaEstadoDTO){

        HistorietaEstado historietaEstado = HistorietaEstadoMapper.map(historietaEstadoDTO ,false);
        this.iHistorietaEstadoJPADAO.delete(historietaEstado);

    }

}
