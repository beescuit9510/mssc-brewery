package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    @Override
    public BeerDto getBeerById(UUID beerId) {

        BeerDto beer  = BeerDto.builder()
                .id(beerId)
                .beerName("Smelly Cat")
                .beerStyle("Pale Ale")
                .build();

        return beer;
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {

        UUID beerId = UUID.randomUUID();

        BeerDto beer = BeerDto.builder()
                .id(beerId)
                .build();

        return beer;
    }

    @Override
    public void updateBeer(UUID bearId, BeerDto beerDto) {
        //todo impl - would add a impl to update beer;
    }

    @Override
    public void deleteBeerById(UUID beerId) {
        log.debug("Deleting a beer...");
    }
}
