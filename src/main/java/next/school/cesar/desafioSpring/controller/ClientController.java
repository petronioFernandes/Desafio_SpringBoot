package next.school.cesar.desafioSpring.controller;

import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public List<Client> getClients(){
        return repository.findAll();
    }
    
    @PostMapping
    public Client createClient(@RequestBody Client client){
        return repository.save(client);
    }

}
