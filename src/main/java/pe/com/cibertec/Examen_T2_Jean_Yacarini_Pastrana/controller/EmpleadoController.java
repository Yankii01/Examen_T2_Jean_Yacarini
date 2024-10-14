package pe.com.cibertec.Examen_T2_Jean_Yacarini_Pastrana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.cibertec.Examen_T2_Jean_Yacarini_Pastrana.model.EmpleadoEntity;
import pe.com.cibertec.Examen_T2_Jean_Yacarini_Pastrana.service.EmpleadoService;
import pe.com.cibertec.Examen_T2_Jean_Yacarini_Pastrana.service.AreaService;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private AreaService areaService;

    // Redirigir desde la página principal ("/") a la lista de empleados
    @GetMapping("/")
    public String redirigirAlListadoPrincipal() {
        return "redirect:/empleados";  // Redirige a /empleados
    }

    // Listar todos los empleados y mostrar "lista.html"
    @GetMapping
    public String listarEmpleados(Model model) {
        model.addAttribute("empleados", empleadoService.listarTodosLosEmpleados());
        return "lista";  // Aquí se muestra el listado en templates/lista.html
    }

    // Mostrar formulario para crear nuevo empleado
    @GetMapping("/nuevo")
    public String mostrarFormularioDeCrearEmpleado(Model model) {
        model.addAttribute("empleado", new EmpleadoEntity());
        model.addAttribute("areas", areaService.listarTodasLasAreas());
        return "empleados/formulario";
    }

    // Guardar un nuevo empleado
    @PostMapping("/guardar")
    public String guardarEmpleado(@ModelAttribute("empleado") EmpleadoEntity empleado) {
        // Asegúrate de que la fecha esté en el formato correcto antes de guardar
       
        empleadoService.guardarEmpleado(empleado);
        return "redirect:/empleados";
    }

    // Mostrar formulario para editar un empleado existente
    @GetMapping("/editar/{dni}")
    public String mostrarFormularioDeEditarEmpleado(@PathVariable String dni, Model model) {
        EmpleadoEntity empleado = empleadoService.buscarEmpleadoPorDni(dni);
        model.addAttribute("empleado", empleado);
        model.addAttribute("areas", areaService.listarTodasLasAreas());
        return "empleados/formulario";
    }

    // Actualizar un empleado existente
    @PostMapping("/actualizar/{dni}")
    public String actualizarEmpleado(@PathVariable String dni, @ModelAttribute("empleado") EmpleadoEntity empleado) {
        // Asegúrate de que la fecha esté en el formato correcto antes de actualizar
        
        empleadoService.actualizarEmpleado(empleado);
        return "redirect:/empleados";
    }

    // Eliminar un empleado
    @GetMapping("/eliminar/{dni}")
    public String eliminarEmpleado(@PathVariable String dni) {
        empleadoService.eliminarEmpleado(dni);
        return "redirect:/empleados";
    }
}