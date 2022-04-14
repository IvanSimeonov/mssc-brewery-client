package ivansimeonov.springframework.msscbreweryclient.web.client;

import ivansimeonov.springframework.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author ivansimeonov
 * @Date 14.04.22
 */
@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto beerDto = client.getBeerById(UUID.randomUUID());

        assertNotNull(beerDto);
    }

    @Test
    void addBeer() {

        // given
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();

        //when
        URI uri = client.addBeer(beerDto);

        //then
        assertNotNull(uri);
    }
}