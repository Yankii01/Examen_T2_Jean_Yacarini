package pe.com.cibertec.Examen_T2_Jean_Yacarini_Pastrana.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.Examen_T2_Jean_Yacarini_Pastrana.model.EmpleadoEntity;
import pe.com.cibertec.Examen_T2_Jean_Yacarini_Pastrana.repository.EmpleadoRepository;
import pe.com.cibertec.Examen_T2_Jean_Yacarini_Pastrana.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<EmpleadoEntity> listarTodosLosEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public EmpleadoEntity buscarEmpleadoPorDni(String dni) {
        return empleadoRepository.findById(dni)
                .orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado con DNI: " + dni));
    }

    @Override
    public EmpleadoEntity guardarEmpleado(EmpleadoEntity empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public EmpleadoEntity actualizarEmpleado(EmpleadoEntity empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public void eliminarEmpleado(String dni) {
        empleadoRepository.deleteById(dni);
    }
}
