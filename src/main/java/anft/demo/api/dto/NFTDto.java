package anft.demo.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NFTDto {

    private String hashcode;
    private String ownerId;
    private Double price;
}
