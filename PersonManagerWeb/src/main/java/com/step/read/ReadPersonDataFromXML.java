package edu.step.read;

import edu.step.entity.Person;
import org.jdom2.Element;
import org.jdom2.input.DOMBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadPersonDataFromXML {

        public static void readPersonDataFromXML() {

//            String fileName =


            final String fileName = "E:\\Dropbox\\STEP_IT\\HomeWork\\Java\\personManager\\src\\main\\java\\person.xml";
            org.jdom2.Document jdomDoc;
            try {
                jdomDoc = useDOMParser(fileName);
                Element root = jdomDoc.getRootElement();
                List<Element> personListElements = root.getChildren("person");
                List<Person> personList = new ArrayList<>();
                for (Element personElement : personListElements) {
                    Person per = new Person();

//                    per.setName(Integer.parseInt(empElement.getAttributeValue("id")));
                    per.setName(personElement.getChildText("name"));
                    per.setSurname(personElement.getChildText("surname"));
                    per.setDescription(personElement.getChildText("description"));
                    per.setPhone(personElement.getChildText("phone"));
                    per.setMobile(personElement.getChildText("mobile"));
                    per.setEmail(personElement.getChildText("email"));
                    per.setIdnp(personElement.getChildText("idnp"));
                    per.setRegDate(LocalDate.parse(personElement.getChildText("regDate")));

                    personList.add(per);
                }
                //lets print Employees list information
                for (Person pers : personList)
                    System.out.println(pers);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


        //Get JDOM document from DOM Parser
        private static org.jdom2.Document useDOMParser(String fileName)
                throws ParserConfigurationException, IOException, SAXException {
            //creating DOM Document
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder;
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File(fileName));
            DOMBuilder domBuilder = new DOMBuilder();
            return domBuilder.build(doc);

        }
}
