package co.edu.unab.api.repositories;
import java.util.ArrayList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.unab.api.models.ClienteModel;

@Repository
public interface ClienteRepository extends MongoRepository<ClienteModel , String> {
    ArrayList<ClienteModel> findByNombre(String nombre);
    ArrayList<ClienteModel> findByPuntosGreaterThanEqual(Long puntos);
    ArrayList<ClienteModel> findByPuntosLessThanEqual(Long puntos);
    
    @Query(value= "{'address.ciudad':?0}", fields = "{'nombre':1,'apellido':1}")
    ArrayList<ClienteModel> clientexCiudad(String ciudad);
    @Query("{'cliente.nombre':?0,'cliente.apellido':?1}")
    ArrayList<ClienteModel> clientexNombreYApellido(String nombre, String apellido);
    @Query(value="{'cliente.telefono':?0}", fields="{'puntos':1}")
    ArrayList<ClienteModel> puntosXTelefono (String telefono);
    
}

