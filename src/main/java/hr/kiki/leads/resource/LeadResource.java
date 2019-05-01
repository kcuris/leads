package hr.kiki.leads.resource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import hr.kiki.leads.dao.LeadDao;
import hr.kiki.leads.entity.Lead;
import hr.kiki.leads.serializer.LeadSerializer;
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

@Path("lead")
@Produces(MediaType.APPLICATION_JSON)
public class LeadResource {

    private GsonBuilder builder = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(Lead.class, new LeadSerializer());
    private Gson gson = builder.create();

    private hr.kiki.leads.dao.LeadDao LeadDao = new LeadDao();

    @GET
    public String list() {
        return gson.toJson(LeadDao.findAll());
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Long id) {
        Lead lead = LeadDao.get(id);

        if (lead != null) {
            String response = gson.toJson(lead);
            return Response.ok(response).build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(String json) {
        Lead lead = gson.fromJson(json, Lead.class);

        if (lead != null && LeadDao.create(lead)) {
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
        Lead lead = gson.fromJson(json, Lead.class);
        lead.setId(id);

        if (LeadDao.update(lead)) {
            return Response.status(Response.Status.OK).build();
        }
        else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        Lead lead = LeadDao.get(id);

        if (lead != null && LeadDao.delete(lead)) {
            return Response.status(Response.Status.OK).build();
        }
        else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}
