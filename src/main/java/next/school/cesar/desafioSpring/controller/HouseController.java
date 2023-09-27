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

import next.school.cesar.desafioSpring.DTO.HouseDTO;
import next.school.cesar.desafioSpring.DTO.HouseUpdateDTO;
import next.school.cesar.desafioSpring.entities.House;
import next.school.cesar.desafioSpring.repositories.HouseRepository;
import next.school.cesar.desafioSpring.services.HouseService;

@RestController
@RequestMapping("/houses")
public class HouseController {
    
    @Autowired
    private HouseService service;

    @GetMapping
    public ResponseEntity<List<House>> getHouses(){
        List <House> houses = service.listAllHouses();
    	return new ResponseEntity<>(houses, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<House> createHouse(@RequestBody HouseDTO houseDTO){
        House createdHouse = service.createHouse(houseDTO);
    	return new ResponseEntity<>(createdHouse, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<House> updateHouse(@PathVariable long id, @RequestBody HouseUpdateDTO houseUpdateDTO){
    	House updatedHouse = service.updateHouse(houseUpdateDTO, id);
    	if (updatedHouse == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}else {
    		return new ResponseEntity<> (updatedHouse, HttpStatus.OK);
    	}
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<House> deleteHouse(@PathVariable long id){
        boolean house = service.delete(id);
        if(house == false){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
