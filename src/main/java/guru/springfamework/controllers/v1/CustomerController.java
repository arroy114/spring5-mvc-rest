package guru.springfamework.controllers.v1;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.api.v1.model.CustomerListDTO;
import guru.springfamework.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/api/v1/customers/")
    public ResponseEntity<CustomerListDTO> getListofCustomers(){

        return new ResponseEntity<>(new CustomerListDTO(customerService.getAllCustomers()), HttpStatus.OK);
    }
    @GetMapping("/api/v1/customers/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id){

        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }
}
