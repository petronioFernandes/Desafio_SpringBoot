package next.school.cesar.desafioSpring.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import next.school.cesar.desafioSpring.DTO.HouseDTO;
import next.school.cesar.desafioSpring.DTO.HouseUpdateDTO;
import next.school.cesar.desafioSpring.entities.Client;
import next.school.cesar.desafioSpring.entities.House;
import next.school.cesar.desafioSpring.repositories.ClientRepository;
import next.school.cesar.desafioSpring.repositories.HouseRepository;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class HouseService {
    private HouseRepository houseRepository;
    private ClientRepository clientRepository;

    public List <House> listAllHouses(){
        List<House> houses = houseRepository.findAll();
        return houses.stream()
        .collect(Collectors.toList());
    }

    public House getById(long id){
        return this.houseRepository.findById(id).orElse(null);
    }

    public House createHouse(HouseDTO houseDTO){
        Client client = this.clientRepository.findById(houseDTO.getClient_id()).orElse(null);
        if(client != null){
            House house = houseDTO.toEntity(client);
            return this.houseRepository.save(house);
        }else{
            return null;
        }
    }

    public House updateHouse(HouseUpdateDTO houseUpdateDTO, long id){
        House house = houseRepository.findById(id).orElse(null);
        Client client = clientRepository
        .findById(houseUpdateDTO
        .getClient_id())
        .orElse(null);
        if(house != null && client != null){
            House updatedHouse = houseUpdateDTO.toUpdatedEntity(client, house);
            return this.houseRepository.save(updatedHouse);
        }else{
            return null;
        }
    }

    public boolean delete(long id){
        House house = this.houseRepository.findById(id).orElse(null);
        if(house != null){
            this.houseRepository.delete(house);
            return true;
        }else{
            return false;
        }
    }
}
