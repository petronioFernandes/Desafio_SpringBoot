package next.school.cesar.desafioSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import next.school.cesar.desafioSpring.DTO.ClientDTO;
import next.school.cesar.desafioSpring.entities.Client;
import next.school.cesar.desafioSpring.repositories.ClientRepository;
import next.school.cesar.desafioSpring.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<List<Client>> getClients(){
        List <Client> clients = service.listAll();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable long id){
         Client client = service.getById(id);
         if(client == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }else{
            return new ResponseEntity<> (client, HttpStatus.OK);
        }
    } 
    
    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody ClientDTO clientDTO){
        Client createdClient = service.create(clientDTO);
        return new ResponseEntity <> (createdClient, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable long id, @RequestBody ClientDTO clientDTO){        Client client = service.getById(id);
        Client updatedClient = service.update(id, clientDTO);
        if(updatedClient == null) {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
        	return new ResponseEntity<> (updatedClient, HttpStatus.OK); 
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable long id){
    	boolean client = service.delete(id);
        if(client == false) {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
        	return new ResponseEntity<> (HttpStatus.OK); 
        }
    }
  
}
