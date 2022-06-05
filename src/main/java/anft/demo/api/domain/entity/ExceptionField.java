package anft.demo.api.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionField {
    private String code;
    private String message;
}
