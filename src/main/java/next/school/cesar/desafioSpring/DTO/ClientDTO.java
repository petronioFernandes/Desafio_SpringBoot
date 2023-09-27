package next.school.cesar.desafioSpring.DTO;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import next.school.cesar.desafioSpring.entities.Client;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDTO {

    @NotBlank
    @Size(min = 5, max = 100)
    private String name;
    @NotNull
    @Min(0)
    private int age;
    @NotNull
    @Min(0)
    private int dependents;
    @NotNull
    @Min(0)
    private double income;
    @NotBlank
    @Size(min = 6,max = 7)
    private String marital_status;

    public Client toEntity(){
        return Client.builder()
        .name(this.name)
        .age(this.age)
        .dependets(this.dependents)
        .income(this.income)
        .marital_status(this.marital_status)
        .createdAt(LocalDate.now())
        .updatedAt(LocalDate.now())
        .build();
    }

    public Client toUpdatedEntity(Client client){
        return Client.builder()
        .id(client.getId())
        .name(this.name)
        .age(this.age)
        .dependets(this.dependents)
        .income(this.income)
        .marital_status(this.marital_status)
        .createdAt(client.getCreatedAt())
        .updatedAt(LocalDate.now())
        .houses(client.getHouses())
        .vehicles(client.getVehicles())
        .insurances(client.getInsurances())
        .build();
    }

}