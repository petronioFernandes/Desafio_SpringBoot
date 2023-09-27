package next.school.cesar.desafioSpring.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import next.school.cesar.desafioSpring.entities.Client;
import next.school.cesar.desafioSpring.entities.Vehicle;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleUpdateDTO {
    @NotNull
    private long client_id;

    public Vehicle toEntity(Client client, Vehicle vehicle){
        return Vehicle.builder()
        .id(vehicle.getId())
        .brand(vehicle.getBrand())
        .model(vehicle.getModel())
        .client(client)
        .build();
    }
}
