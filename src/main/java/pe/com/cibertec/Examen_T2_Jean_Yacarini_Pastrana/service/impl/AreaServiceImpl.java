package pe.com.cibertec.Examen_T2_Jean_Yacarini_Pastrana.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.Examen_T2_Jean_Yacarini_Pastrana.model.AreaEntity;
import pe.com.cibertec.Examen_T2_Jean_Yacarini_Pastrana.repository.AreaRepository;
import pe.com.cibertec.Examen_T2_Jean_Yacarini_Pastrana.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository areaRepository;

    @Override
    public List<AreaEntity> listarTodasLasAreas() {
        return areaRepository.findAll();
    }

    @Override
    public AreaEntity buscarAreaPorId(Integer id) {
        return areaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Área no encontrada con ID: " + id));
    }

    @Override
    public AreaEntity guardarArea(AreaEntity area) {
        return areaRepository.save(area);
    }

    @Override
    public AreaEntity actualizarArea(AreaEntity area) {
        return areaRepository.save(area);
    }

    @Override
    public void eliminarArea(Integer id) {
        areaRepository.deleteById(id);
    }
}