package hr.kiki.leads.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import hr.kiki.leads.entity.Customer;

import java.lang.reflect.Type;

public class CustomerSerializer implements JsonSerializer<Customer> {

    @Override
    public JsonElement serialize(Customer src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();

        object.addProperty("id", src.getId());
        object.addProperty("email", src.getEmail());
        object.addProperty("name", src.getName());
        object.addProperty("extid", src.getExtId());
        object.addProperty("phone", src.getPhone());

        return object;
    }

}
