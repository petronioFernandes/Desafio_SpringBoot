package next.school.cesar.desafioSpring.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import next.school.cesar.desafioSpring.entities.Client;
import next.school.cesar.desafioSpring.entities.House;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HouseUpdateDTO {
    @NotBlank
    @Size(min = 5, max = 9)
    private String ownership_status;
    @NotNull
    private long client_id;

    public House toUpdatedEntity(Client client, House house){
        return House.builder()
        .ownership_status(this.ownership_status)
        .location(house.getLocation())
        .zipcode(house.getZipcode())
        .client(client)
        .build();
    }
    
}
