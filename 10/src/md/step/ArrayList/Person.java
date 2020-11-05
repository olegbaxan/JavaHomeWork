package md.step.ArrayList;

public class Person {
    public String name;

    public Person(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object object){
//logicadecomparare
//comparamadresa?
        if(this==object)return true;
////dacaadreselesuntegale-acelasiobiect(true)
//dacaadreselenusuntegale?-cautammaideparte
//verificamdacatipurileobiectelorsuntegale?
        boolean sameClass=this.getClass().equals(object.getClass());
        boolean sameClass2=object instanceof Person;
////dacaelesuntdetipdiferit-false
        if(!sameClass2)return false;

//dacaelesuntdeacelasitip
//name,surname,gen,birthdate
        Person p=(Person)object;
        return name.equalsIgnoreCase(p.name);
//&&surname.equalsIgnoreCase(p.surname)
//&&gender==p.gender;
    }
}
