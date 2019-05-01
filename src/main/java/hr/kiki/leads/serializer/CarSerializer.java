package hr.kiki.leads.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import hr.kiki.leads.entity.Car;
import hr.kiki.leads.entity.CarProperty;

import java.lang.reflect.Type;

public class CarSerializer implements JsonSerializer<Car> {


    @Override
    public JsonElement serialize(Car src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();

        object.addProperty("id", src.getId());
        object.addProperty("brand", src.getBrand());
        object.addProperty("model", src.getModel());
        ;
        final JsonArray jsonProperties = new JsonArray();
        for (final CarProperty prop :src.getCarProperties()) {
            final JsonObject property = new JsonObject();
            property.addProperty(prop.getProperty().getName(), prop.getId().getValue());
            jsonProperties.add(property);
        }
        object.add("properties", jsonProperties);

//        object.addProperty("properties", src.getCarProperties());

        return object;
    }
}


