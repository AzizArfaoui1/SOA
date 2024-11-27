package projection;

import org.springframework.data.rest.core.config.Projection;

import com.iset.entities.Customer;

@Projection(name = "fullCustomer", types = Customer.class)
public interface CustomerProjection {
    Long getId();
    String getName();
    String getEmail();
}