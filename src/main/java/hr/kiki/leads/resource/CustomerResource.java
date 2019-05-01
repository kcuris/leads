package hr.kiki.leads.resource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import hr.kiki.leads.dao.CustomerDao;
import hr.kiki.leads.entity.Customer;
import hr.kiki.leads.serializer.CustomerSerializer;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;

@Path("customer")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {

    private GsonBuilder builder = new GsonBuilder()
        .setPrettyPrinting()
        .registerTypeAdapter(Customer.class, new CustomerSerializer());
    private Gson gson = builder.create();
    
    private CustomerDao CustomerDao = new CustomerDao();

    @GET
    public String list() {
        return gson.toJson(CustomerDao.findAll());
    }
    
    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Long id) {
        Customer customer = CustomerDao.get(id);

        if (customer != null) {
            String response = gson.toJson(customer);
            return Response.ok(response).build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(String json) {
        Customer Customer = gson.fromJson(json, Customer.class);

        if (Customer != null && CustomerDao.create(Customer)) {
            return Response.status(Response.Status.OK).build();
        }
        else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") BigDecimal id, String json) {
        Customer Customer = gson.fromJson(json, Customer.class);
        Customer.setId(id);

        if (CustomerDao.update(Customer)) {
            return Response.status(Response.Status.OK).build();
        }
        else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        Customer Customer = CustomerDao.get(id);

        if (Customer != null && CustomerDao.delete(Customer)) {
            return Response.status(Response.Status.OK).build();
        }
        else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}
