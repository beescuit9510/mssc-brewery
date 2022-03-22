package guru.springframework.msscbrewery.web.controller.v2;

import guru.springframework.msscbrewery.services.v2.BeerServiceV2;
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerControllerV2 {

    private final BeerServiceV2 beerServiceV2;


    public BeerControllerV2(BeerServiceV2 beerServiceV2) {
        this.beerServiceV2 = beerServiceV2;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId) {

        BeerDtoV2 beer = beerServiceV2.getBeerById(beerId);

        ResponseEntity<BeerDtoV2> responseToReturn = new ResponseEntity<>(beer, HttpStatus.OK);

        return responseToReturn;
    }



    @PostMapping //POST - create new beer
    public ResponseEntity handlePost(@RequestBody BeerDtoV2 beerDtoV2){

        BeerDtoV2 savedDto = beerServiceV2.saveNewBeer(beerDtoV2);

        HttpHeaders headers = new HttpHeaders();

        String headerName = "Location";
        String url = "/api/v1/beer"; //todo add host name to url
        String beerId = savedDto.getId().toString();
        String locOfBeer = url+beerId;

        headers.add(headerName, locOfBeer);

        ResponseEntity responseToReturn = new ResponseEntity<>(headers, HttpStatus.CREATED);


        return responseToReturn;
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID bearId, @RequestBody BeerDtoV2 beerDtoV2){

        beerServiceV2.updateBeer(bearId, beerDtoV2);

        ResponseEntity responseTorReturn = new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return responseTorReturn;
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
        beerServiceV2.deleteBeerById(beerId);
    }
}
