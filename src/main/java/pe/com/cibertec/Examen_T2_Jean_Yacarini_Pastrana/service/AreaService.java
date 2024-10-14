package pe.com.cibertec.Examen_T2_Jean_Yacarini_Pastrana.service;

import java.util.List;
import pe.com.cibertec.Examen_T2_Jean_Yacarini_Pastrana.model.AreaEntity;

public interface AreaService {
    List<AreaEntity> listarTodasLasAreas();
    AreaEntity buscarAreaPorId(Integer id);
    AreaEntity guardarArea(AreaEntity area);
    AreaEntity actualizarArea(AreaEntity area);
    void eliminarArea(Integer id);
}