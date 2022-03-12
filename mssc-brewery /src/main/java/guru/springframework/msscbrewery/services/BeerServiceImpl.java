package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
}
