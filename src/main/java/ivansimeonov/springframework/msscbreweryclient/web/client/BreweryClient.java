package ivansimeonov.springframework.msscbreweryclient.web.client;

import ivansimeonov.springframework.msscbreweryclient.web.model.BeerDto;
import ivansimeonov.springframework.msscbreweryclient.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

/**
 * @Author ivansimeonov
 * @Date 14.04.22
 */
@Component
@Slf4j
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beer/";
    private final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private String apihost;
    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID uuid) {
        log.warn(apihost + BEER_PATH_V1 + uuid.toString());
        return restTemplate.getForObject(apihost + BEER_PATH_V1 + uuid, BeerDto.class);
    }

    public URI addBeer(BeerDto beerDto) {
        return restTemplate.postForLocation(apihost + BEER_PATH_V1, beerDto);
    }

    public void updateBeer(UUID uuid, BeerDto beerDto) {
        log.warn(apihost + BEER_PATH_V1 + uuid);
        restTemplate.put(apihost + BEER_PATH_V1 + uuid, beerDto);
    }

    public void deleteBeer(UUID uuid) {
        log.warn(apihost + BEER_PATH_V1 + uuid);
        restTemplate.delete(apihost + BEER_PATH_V1 + uuid);
    }

    public CustomerDto getCustomerById(UUID uuid) {
        log.warn(apihost + CUSTOMER_PATH_V1 + uuid);
        return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 + uuid, CustomerDto.class);
    }

    public URI saveCustomer(CustomerDto customerDto) {
        log.warn(apihost + CUSTOMER_PATH_V1);
        return restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, customerDto);
    }

    public void updateCustomer(UUID uuid, CustomerDto customerDto) {
        log.warn(apihost + CUSTOMER_PATH_V1 + uuid);
        this.restTemplate.put(apihost + CUSTOMER_PATH_V1 + uuid, customerDto);
    }

    public void deleteCustomer(UUID uuid) {
        log.warn(apihost + CUSTOMER_PATH_V1 + uuid);
        this.restTemplate.delete(apihost + CUSTOMER_PATH_V1 + uuid);
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}
