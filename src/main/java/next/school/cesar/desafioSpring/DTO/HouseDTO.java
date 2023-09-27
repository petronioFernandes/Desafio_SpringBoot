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
public class HouseDTO {

    @NotBlank
    @Size(min = 5, max = 9)
    private String ownership_status;
    @NotBlank
    @Size(min = 3, max = 200)
    private String location;
    @NotBlank
    @Size(min = 9, max = 9)
    private String zipcode;
    @NotNull
    private long client_id;

    public House toEntity(Client client){
        return House.builder()
        .ownership_status(this.ownership_status)
        .location(this.location)
        .zipcode(this.zipcode)
        .client(client)
        .build();
    }
    
}
