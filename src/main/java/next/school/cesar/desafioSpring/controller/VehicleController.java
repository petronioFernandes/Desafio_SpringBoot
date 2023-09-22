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

    @PutMapping("/{id}")
    public  ResponseEntity<Vehicle> updateVehicle(@PathVariable long id, @RequestBody Vehicle vehicleUpdate){
        Vehicle vehicle = repository.findById(id).orElse(null);
        if(vehicle == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            Vehicle updatedVehicle = repository.save(vehicleUpdate);
            return new ResponseEntity<Vehicle>(updatedVehicle, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Vehicle> deleteVehicle(@PathVariable long id){
        Vehicle vehicle = repository.findById(id).orElse(null);
        if(vehicle == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            repository.delete(vehicle);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
