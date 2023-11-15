package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;


import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades.PublicacionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PublicacionesRepository extends JpaRepository<PublicacionEntity, Integer> {
    //@Query("SELECT p FROM PublicacionEntity WHERE LOWER(p.titulo) LIKE LOWER(:patron) ORDER BY p.idPublicacion DESC")
    //List<PublicacionEntity> listarPublicacionesPorPatron(@Param("patron") String patron);

    /**
     *  obtener las publicaciones por un patrón del título, ignorando
     * mayúsculas y minúsculas y ordenándolas por el id de mayor a menor IgnoreCaseContainingOrderByPublicacionesIdPublicacionDesc
     * @param patron patron del titulo
     * @return Las publicaciones que cumplan con el patrón ; Empty
     */
    List<PublicacionEntity> findByTituloIgnoreCaseContaining(String patron);

    /**
     * Utilizar una query para ver si existe una publicación con un titulo
     * @param titulo titulo que vamos a buscar
     * @return true; si existe al menos 1 publicacion que cumpla ; false no encuentra publciaciones con titulo
     */
    @Query("SELECT COUNT(p) > 0 FROM PublicacionEntity p WHERE LOWER(p.titulo) = LOWER(:titulo)")
    boolean existsByTitulo(@Param("titulo") String titulo);
}
