package next.school.cesar.desafioSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import next.school.cesar.desafioSpring.entities.Vehicle;
import next.school.cesar.desafioSpring.repositories.VehicleRepository;

@RestController
@RequestMapping
public class VehicleController {
    
    @Autowired
    private VehicleRepository repository;

    public List<Vehicle> getVehicles(){
        return repository.findAll();
    }

    public Vehicle creatVehicle(@RequestBody Vehicle vehicle){
        return repository.save(vehicle);
    }
}
