package ivansimeonov.springframework.msscbreweryclient.web.client;

import ivansimeonov.springframework.msscbreweryclient.web.model.BeerDto;
import ivansimeonov.springframework.msscbreweryclient.web.model.CustomerDto;
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

    @Test
    void updateBeer() {
        // given
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();

        // when
        client.updateBeer(UUID.randomUUID(), beerDto);
    }


    @Test
    void deleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getCustomerById() {
        CustomerDto customerDto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void saveCustomer() {
        CustomerDto customerDto = CustomerDto.builder()
                .name("TEST NAME")
                .build();
        URI uri = client.saveCustomer(customerDto);
        assertNotNull(uri);
    }

    @Test
    void updateCustomer() {
        CustomerDto customerDto = CustomerDto.builder()
                .name("TEST NAME")
                .build();
        client.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void deleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }
}