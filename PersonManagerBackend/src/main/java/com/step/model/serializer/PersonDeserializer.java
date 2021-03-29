package com.step.model.serializer;

import com.step.model.Person;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;

public class PersonDeserializer extends JsonDeserializer<Person> {
    @Override
    public Person deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
        final String name = node.get("name").getValueAsText();
        final String surname = node.get("surname").getValueAsText();
        final String description = node.get("description").getValueAsText();
        final String phone = node.get("phone").getValueAsText();
        final String mobile = node.get("mobile").getValueAsText();
        final String email = node.get("email").getValueAsText();
        final String idnp = node.get("idnp").getValueAsText();
        final LocalDate birthday = LocalDate.parse(node.get("birthday").getValueAsText());
        return new Person(name, surname, description, phone, mobile,  email,  LocalDate.now(),  idnp,  birthday);
    }
}
