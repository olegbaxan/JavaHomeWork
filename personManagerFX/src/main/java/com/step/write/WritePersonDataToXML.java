package com.step.write;

import com.step.files.FilePaths;
import com.step.person.Person;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class WritePersonDataToXML {
    public static void savePersonDataToXml(List<Person> pers) { //
        try {
            Element persons = new Element("persons");                 // <persons>
            Document document = new Document(persons);
            for (Person per : pers) {
                Element person = new Element("person");               // <person>
                Element personId = new Element("personID");                   //      <name>
                personId.setText(String.valueOf(per.getPersonId()));
                Element name = new Element("name");                   //      <name>
                name.setText(per.getName());
                Element surname = new Element("surname");             //      <surname>
                surname.setText(per.getSurname());
                Element description = new Element("description");     //      <description>
                description.setText(per.getDescription());
                Element phone = new Element("phone");                 //      <phone>
                phone.setText(per.getPhone());
                Element mobile = new Element("mobile");               //      <mobile>
                mobile.setText(per.getMobile());
                Element email = new Element("email");                 //      <email>
                email.setText(per.getEmail());
                Element regDate = new Element("regDate");             //      <regDate>
                regDate.setText(per.getRegDate().toString());
                Element idnp = new Element("idnp");                   //      <idnp>
                idnp.setText(per.getIdnp());
                Element birthday = new Element("birthday");                   //      <birthday>
                birthday.setText(per.getBirthday().toString());

                person.addContent(personId);
                person.addContent(name);
                person.addContent(surname);
                person.addContent(description);
                person.addContent(phone);
                person.addContent(mobile);
                person.addContent(email);
                person.addContent(regDate);
                person.addContent(idnp);
                person.addContent(birthday);
                persons.addContent(person);
            }
            String folderPath = FilePaths.selectDirectory();
            XMLOutputter xmlOutputter = new XMLOutputter();
            xmlOutputter.setFormat(Format.getPrettyFormat());
            xmlOutputter.output(document, new FileOutputStream(folderPath+"\\person.xml"));
//            xmlOutputter.output(document, new FileOutputStream(System.getProperty("user.dir")+"\\src\\main\\java\\person.xml"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}