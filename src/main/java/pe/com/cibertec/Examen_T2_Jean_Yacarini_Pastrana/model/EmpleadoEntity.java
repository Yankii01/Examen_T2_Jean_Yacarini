package pe.com.cibertec.Examen_T2_Jean_Yacarini_Pastrana.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_empleado")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoEntity {

    @Id
    @Column(name = "dni_empleado", nullable = false, length = 8)
    private String dni_empleado; // Clave primaria

    @Column(name = "nombre_empleado", nullable = false, length = 45)
    private String nombre_empleado;

    @Column(name = "apellido_empleado", nullable = false, length = 45)
    private String apellido_empleado;

    @Column(name = "fecha_nacimiento", nullable = false, length = 10) // Se establece una longitud para el formato de fecha
    private String fecha_nacimiento; // Cambiado a String
    
    @Column(name = "direccion", nullable = false, length = 45)
    private String direccion;
    
    @Column(name = "correo", nullable = false, length = 45)
    private String correo;

    // Relación ManyToOne
    @ManyToOne
    @JoinColumn(name = "area_id", nullable = false)  // Define la clave foránea
    private AreaEntity area;  // Relaciona EmpleadoEntity con AreaEntity
}
