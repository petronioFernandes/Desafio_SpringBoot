package next.school.cesar.desafioSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import next.school.cesar.desafioSpring.entities.Insurance;
import next.school.cesar.desafioSpring.repositories.InsuranceRepository;

@RestController
@RequestMapping("/insurances")
public class InsuranceController {
    
    @Autowired
    private InsuranceRepository repository;

    @GetMapping
    public List<Insurance> getInsurances(){
        return repository.findAll();
    }

    @PostMapping
    public Insurance createInsurance(@RequestBody Insurance insurance){
        return repository.save(insurance);
    }
}
