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

import next.school.cesar.desafioSpring.entities.Client;
import next.school.cesar.desafioSpring.repositories.ClientRepository;

@RestController
@RequestMapping("/clients")
public class ClientController {
    
    @Autowired
    private ClientRepository repository;

    @GetMapping
    public ResponseEntity<List<Client>> getClients(){
        List <Client> clients = repository.findAll();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable long id){
         Client client = repository.findById(id).orElse(null);
         if(client == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }else{
            return new ResponseEntity<> (client, HttpStatus.OK);
        }
    } 
    
    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        Client createdClient = repository.save(client);
        return new ResponseEntity <> (createdClient, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable long id, @RequestBody Client clientUpdate){
        Client client = repository.findById(id).orElse(null);
        if(client == null) {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
        	Client updatedClient = repository.save(clientUpdate);
        	return new ResponseEntity<> (updatedClient, HttpStatus.OK); 
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable long id){
    	Client client = repository.findById(id).orElse(null);
        if(client == null) {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
        	repository.delete(client);
        	return new ResponseEntity<> (HttpStatus.OK); 
        }
    }
  
}
