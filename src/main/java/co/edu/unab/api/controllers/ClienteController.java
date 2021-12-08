package co.edu.unab.api.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unab.api.models.ClienteModel;
import co.edu.unab.api.services.ClienteService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping()
    public ArrayList<ClienteModel> obtenerClientes(){
        return  clienteService.obtenerClientes();
    }

    @PostMapping()
    public ClienteModel guardarCliente(@RequestBody ClienteModel cliente){
        
        return clienteService.guardarCliente(cliente);
    }
    
    @DeleteMapping(path = "/{id}")
    public String eliminarClientePorId(@PathVariable("id") String id){
        boolean resultadoEliminar=this.clienteService.eliminarCliente(id);
        if (resultadoEliminar){
            return "Se eliminó el usuario con id: "+id;
        }else{
            return "No se pudo eliminar el usuario con el id: "+id;
        }
    }
    
    @GetMapping(path = "/{id}")
    public Optional<ClienteModel> obtenerClientePorId(@PathVariable("id") String id){
        return this.clienteService.obtenerClientePorId(id);
    }
    @GetMapping(path = "nombre/{nombre}")
    public ArrayList<ClienteModel> obtenerClientePorNombre(@PathVariable("nombre") String nombre){
        return this.clienteService.obtenerClientesPorNombre(nombre);
    }
    @GetMapping(path = "menorquepuntos/{puntos}")
    public ArrayList<ClienteModel> obtenerClientePorPuntosMenorQue(@PathVariable("puntos") Long puntos){
        return this.clienteService.obtenerClientesPorPuntosMenorQue(puntos);
    }
    @GetMapping(path = "mayorquepuntos/{puntos}")
    public ArrayList<ClienteModel> obtenerClientePorPuntosMayorQue(@PathVariable("puntos") Long puntos){
        return this.clienteService.obtenerClientesPorPuntosMayorQue(puntos);
    }
    @GetMapping(path = "ubicacion/{ciudad}")
    public ArrayList<ClienteModel> obtenerClientePorCiudad(@PathVariable("ciudad") String ciudad){
        return this.clienteService.obtenerClientesPorCiudad(ciudad);
    }
    @GetMapping(path = "nombreCompleto/{nombre}/{apellido}")
    public ArrayList<ClienteModel> obtenerClientePorNombreApellido(@PathVariable("nombre") String nombre, @PathVariable("apellido") String apellido){
        return this.clienteService.obtenerClientesPorNombreApellido(nombre, apellido);
    }
    @GetMapping(path = "puntos/{telefono}")
    public ArrayList<ClienteModel> obtenerClientePuntosPorTelefono(@PathVariable("telefono") String telefono){
        return this.clienteService.obtenerPuntosPorTelefono(telefono);
    }

  
}