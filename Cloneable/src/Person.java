import java.util.ArrayList;
import java.util.List;

public class Person implements Comparable<Person>, Cloneable{
    
    String name;
    int age;
    List<String> hobbies;

    public Person(String name, int age, List<String>hobbies) {
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getHobbies() {
        return this.hobbies;
    }

    @Override
    public int compareTo(Person p){
        if(this.age > p.age)
            return 1;
        else if (this.age < p.age)
            return -1;
        else return 0;
    }

    @Override
    public Person clone() throws CloneNotSupportedException {
        Person p_copy = (Person) super.clone();
        /* The following piece of code illustrates the deep copy
         * If you remove the following code and simply return p_copy, then
         * it will be shallow copy
         */
        List<String> hobbies_copy = new ArrayList<>();
        for(String hobby: this.hobbies) {
            hobbies_copy.add(hobby);
        }
        p_copy.hobbies = hobbies_copy;
        return p_copy;
    }

    @Override
    public String toString() {
        String hobbies_str = "";
        for (String hobby: hobbies) {
            hobbies_str += hobby + ",";
        }
        hobbies_str = hobbies_str.substring(0, hobbies_str.length() - 1);
        return String.format("%s loves %s", this.name, hobbies_str);
    }
}
