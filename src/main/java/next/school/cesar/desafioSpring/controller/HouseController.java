package next.school.cesar.desafioSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import next.school.cesar.desafioSpring.entities.House;
import next.school.cesar.desafioSpring.repositories.HouseRepository;

@RestController
@RequestMapping("/houses")
public class HouseController {
    
    @Autowired
    private HouseRepository repository;

    @GetMapping
    public List<House> getHouses(){
        return repository.findAll();
    }

    @PostMapping
    public House createHouse(@RequestBody House house){
        return repository.save(house);
    }
}
