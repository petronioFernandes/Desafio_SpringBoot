package next.school.cesar.desafioSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<List<House>> getHouses(){
        List <House> houses = repository.findAll();
    	return new ResponseEntity<>(houses, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<House> createHouse(@RequestBody House house){
        House createdHouse = repository.save(house);
    	return new ResponseEntity<>(createdHouse, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<House> updateHouse(@PathVariable long id, @RequestBody House houseUpdate){
    	House house = repository.findById(id).orElse(null);
    	if (house == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}else {
    		House updatedHouse = repository.save(houseUpdate);
    		return new ResponseEntity<> (updatedHouse, HttpStatus.OK);
    	}
    }
}
