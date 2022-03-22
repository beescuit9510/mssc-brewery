package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.BeerService;
import guru.springframework.msscbrewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController//@Controller + @ResponseBody
//Axis TCP Monitor plugin
public class BeerController {

    private final BeerService beerService;


    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {

        BeerDto beer = beerService.getBeerById(beerId);

        ResponseEntity<BeerDto> responseToReturn = new ResponseEntity<>(beer, HttpStatus.OK);

        return responseToReturn;
    }


    @PostMapping //POST - create new beer
    public ResponseEntity handlePost(@Valid @RequestBody BeerDto beerDto){

        BeerDto savedDto = beerService.saveNewBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();

        String headerName = "Location";
        String url = "/api/v1/beer/"; //todo add host name to url
        String beerId = savedDto.getId().toString();
        String locOfBeer = url+beerId;

        headers.add(headerName, locOfBeer);

        ResponseEntity responseToReturn = new ResponseEntity<>(headers, HttpStatus.CREATED);


        return responseToReturn;
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID bearId, @Valid @RequestBody BeerDto beerDto){

        beerService.updateBeer(bearId, beerDto);

        ResponseEntity responseTorReturn = new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return responseTorReturn;
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
        beerService.deleteBeerById(beerId);
    }
}
