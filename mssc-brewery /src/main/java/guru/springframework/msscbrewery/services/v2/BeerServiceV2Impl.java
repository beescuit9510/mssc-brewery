package guru.springframework.msscbrewery.services.v2;

import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import guru.springframework.msscbrewery.web.model.v2.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceV2Impl implements BeerServiceV2 {

    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {

        BeerDtoV2 beer = BeerDtoV2.builder()
                .id(beerId)
                .beerName("Smelly Cat")
                .beerStyle(BeerStyle.ALE)
                .build();

        return beer;
    }

    @Override
    public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {

        UUID beerId = UUID.randomUUID();

        BeerDtoV2 beer = BeerDtoV2.builder()
                .id(beerId)
                .build();

        return beer;
    }

    @Override
    public void updateBeer(UUID bearId, BeerDtoV2 beerDto) {
        //todo impl - would add a impl to update beer;
    }

    @Override
    public void deleteBeerById(UUID beerId) {
        log.debug("Deleting a beer...");
    }

}
