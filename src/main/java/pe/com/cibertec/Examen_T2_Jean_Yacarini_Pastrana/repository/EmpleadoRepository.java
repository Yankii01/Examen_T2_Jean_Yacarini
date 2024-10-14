package pe.com.cibertec.Examen_T2_Jean_Yacarini_Pastrana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.cibertec.Examen_T2_Jean_Yacarini_Pastrana.model.EmpleadoEntity;

@Repository
public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, String> {
	
}