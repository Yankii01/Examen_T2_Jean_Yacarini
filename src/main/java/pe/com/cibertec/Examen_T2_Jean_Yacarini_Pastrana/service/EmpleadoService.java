package pe.com.cibertec.Examen_T2_Jean_Yacarini_Pastrana.service;

import java.util.List;
import pe.com.cibertec.Examen_T2_Jean_Yacarini_Pastrana.model.EmpleadoEntity;

public interface EmpleadoService {
    List<EmpleadoEntity> listarTodosLosEmpleados();
    EmpleadoEntity buscarEmpleadoPorDni(String dni);
    EmpleadoEntity guardarEmpleado(EmpleadoEntity empleado);
    EmpleadoEntity actualizarEmpleado(EmpleadoEntity empleado);
    void eliminarEmpleado(String dni);
}