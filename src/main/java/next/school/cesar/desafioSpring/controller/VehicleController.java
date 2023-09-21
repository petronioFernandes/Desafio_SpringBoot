package next.school.cesar.desafioSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import next.school.cesar.desafioSpring.entities.Vehicle;
import next.school.cesar.desafioSpring.repositories.VehicleRepository;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    
    @Autowired
    private VehicleRepository repository;

    @GetMapping
    public ResponseEntity<List<Vehicle>> getVehicles(){
        List <Vehicle> vehicles = repository.findAll();
    	return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Vehicle> createdVehicle(@RequestBody Vehicle vehicle){
        Vehicle createdVehicle = repository.save(vehicle);
    	return new ResponseEntity<> (createdVehicle, HttpStatus.OK);
    }
}
