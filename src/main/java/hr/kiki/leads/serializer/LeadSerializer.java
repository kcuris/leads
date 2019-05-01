package hr.kiki.leads.serializer;

import com.google.gson.*;
import hr.kiki.leads.entity.Customer;
import hr.kiki.leads.entity.Lead;
import hr.kiki.leads.entity.Car;

import java.lang.reflect.Type;

public class LeadSerializer implements JsonSerializer<Lead> {

    @Override
    public JsonElement serialize(Lead src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();

        object.addProperty("id", src.getId());
        object.addProperty("notes", src.getNotes());

         GsonBuilder custBuilder = new GsonBuilder()
//                .setPrettyPrinting()
                .registerTypeAdapter(Customer.class, new CustomerSerializer());
         Gson cusGson = custBuilder.create();
        object.addProperty("customer", cusGson.toJson(src.getCustomer()));

        final JsonArray cars = new JsonArray();
        for (Car car: src.getCars()){

             GsonBuilder carBuilder = new GsonBuilder()
//                    .setPrettyPrinting()
                    .registerTypeAdapter(Car.class, new CarSerializer());
             Gson carGson = carBuilder.create();
//            cars.add("car", carGson.toJson(car).toString());
            JsonObject jcar = new JsonObject();
            jcar.addProperty("car", carGson.toJson(car));
            cars.add(jcar);
        }
        object.add("cars", cars);

        return object;
    }

}