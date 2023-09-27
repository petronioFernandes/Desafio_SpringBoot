package next.school.cesar.desafioSpring.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.aspectj.apache.bcel.generic.InstructionConstants.Clinit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import next.school.cesar.desafioSpring.DTO.ClientDTO;
import next.school.cesar.desafioSpring.entities.Client;
import next.school.cesar.desafioSpring.repositories.ClientRepository;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientService {
    private ClientRepository repository;

    public List<Client> listAll(){
        List<Client> clients = repository.findAll();
        return clients.stream()
        .collect(Collectors.toList());
    }

    public Client getById(long id){
        return this.repository.findById(id).orElse(null);
    }

    public Client create(ClientDTO clientDTO){
        Client client = clientDTO.toEntity();
        return this.repository.save(client);
    }

    public Client update(long id, ClientDTO clientDTO){
        Client client = this.repository.findById(id).orElse(null);
        if (client != null){
            Client clientUpdate = clientDTO.toUpdatedEntity(client);
            return this.repository.save(clientUpdate);
        }else{
            return null;
        }
    }

    public boolean delete(long id){
        Client client = this.repository.findById(id).orElse(null);
        if(client != null){
            this.repository.delete(client);
            return true;
        }else{
            return false;
        }
    }
    
}
