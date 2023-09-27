package next.school.cesar.desafioSpring.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import next.school.cesar.desafioSpring.entities.Client;
import next.school.cesar.desafioSpring.entities.Vehicle;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleDTO {

    @NotBlank
    @Min(1)
    private String brand;
    @NotBlank
    @Min(1)
    private String model;
    @NotBlank
    @Min(1)
    private int year; 
    @NotNull
    private long client_id;

    public Vehicle toEntity(Client client){
        return Vehicle.builder()
        .brand(this.brand)
        .model(this.model)
        .year(this.year)
        .client(client)
        .build();
    }
    
}
