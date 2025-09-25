import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
        List<String> hobbies = new ArrayList<>(List.of("Football", "Swimming"));
        Person p1  = new Person("Kevin", 25, hobbies);
        Person p2 = p1.clone(); 
        ArrayList<String> p2_hobbies = (ArrayList<String>)p2.getHobbies();
        p2_hobbies.add("Bowling");

        System.out.println(p1);
        System.out.println(p2); 


        Person p3 = new Person("Tyler", 30, new ArrayList<>(List.of("Reading", "BirdWatching")));

        ArrayList<Person> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p3);
        Collections.sort(persons);
        
    }
}
