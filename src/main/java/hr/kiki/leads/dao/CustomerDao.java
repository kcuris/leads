package hr.kiki.leads.dao;

import hr.kiki.leads.entity.Customer;

public class CustomerDao extends AbstractDao<Customer> {

    public CustomerDao() {
        super(Customer.class);
    }

}
