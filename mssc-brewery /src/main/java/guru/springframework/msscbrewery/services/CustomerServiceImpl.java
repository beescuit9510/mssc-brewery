package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto getCustomerById(UUID customerId) {

        CustomerDto customer = CustomerDto.builder()
                .customerId(customerId)
                .name("Tristen")
                .build();

        return customer;

    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {

        UUID customerId = UUID.randomUUID();

        CustomerDto customer = CustomerDto.builder()
                .customerId(customerId)
                .build();

        return customer;

    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        //todo impl
        log.debug("Updating.....");
    }

    @Override
    public void deleteCustomerById(UUID customerId) {
        log.debug("Deleting.....");
    }
}
