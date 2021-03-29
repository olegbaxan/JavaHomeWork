package com.step.model.serializer;

import com.step.model.Person;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;

public class PersonSerializer extends JsonSerializer<Person> {
    public PersonSerializer() {
        super();
    }
    @Override
    public void serialize(Person person, JsonGenerator json, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        json.writeStartObject();
        json.writeNumberField("personId", person.getPersonId());
        json.writeStringField("name", person.getName());
        json.writeStringField("surname", person.getSurname());
        json.writeStringField("description", person.getDescription());
        json.writeStringField("phone", person.getPhone());
        json.writeStringField("mobile", person.getMobile());
        json.writeStringField("regdate", person.getRegDate().toString());
        json.writeStringField("idnp", person.getIdnp());
        json.writeStringField("birthday", person.getBirthday().toString());
        json.writeEndObject();
    }
}
