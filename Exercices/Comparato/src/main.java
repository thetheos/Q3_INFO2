import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import person.*;


public class main {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Guillaume",20));
        persons.add(new Person("John",50));
        persons.add(new Person("Guillaume",10));
        persons.add(new Person("John",10));
        persons.add(new Person("Luc",5));

        sortPerson(persons);
        System.out.println(persons);

    }

    public static void sortPerson(ArrayList<Person> persons){
        Collections.sort(persons, new java.util.Comparator<Person>(){
            @Override
            public int compare(Person p1, Person p2){
                if(p1.name.compareTo(p2.name) == 0){
                    return p1.age -p2.age;
                }
                return p1.name.compareTo(p2.name);
            }
        });
    }
}
