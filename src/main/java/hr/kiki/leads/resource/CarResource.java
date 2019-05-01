package hr.kiki.leads.resource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import hr.kiki.leads.dao.CarDao;
import hr.kiki.leads.entity.Car;
import hr.kiki.leads.serializer.CarSerializer;
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

@Path("car")
@Produces(MediaType.APPLICATION_JSON)
public class CarResource {

    private GsonBuilder builder = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(Car.class, new CarSerializer());
    private Gson gson = builder.create();

    private hr.kiki.leads.dao.CarDao CarDao = new CarDao();

    @GET
    public String list() {
        return gson.toJson(CarDao.findAll());
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Long id) {
        Car car = CarDao.get(id);

        if (car != null) {
            String response = gson.toJson(car);
            return Response.ok(response).build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(String json) {
        Car car = gson.fromJson(json, Car.class);

        if (car != null && CarDao.create(car)) {
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
        Car car = gson.fromJson(json, Car.class);
        car.setId(id);

        if (CarDao.update(car)) {
            return Response.status(Response.Status.OK).build();
        }
        else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        Car car = CarDao.get(id);

        if (car != null && CarDao.delete(car)) {
            return Response.status(Response.Status.OK).build();
        }
        else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}
