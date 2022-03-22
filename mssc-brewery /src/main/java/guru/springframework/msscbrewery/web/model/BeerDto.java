package guru.springframework.msscbrewery.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//ctrl+,  ✓ Enable annotation processing
//ctrl+,
public class BeerDto {

    @Null
    private UUID id;

    @NotBlank
    private String beerName;

    @NotBlank
    private String beerStyle;

    @NotBlank
    private Long upc;
}
