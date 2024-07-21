package day24;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class LamdaExpressions {
	public static class Person {
        private String name;
        private int age;

        public Person() { }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String toString() {
            return "Person(name='" + name + "', age=" + age + ')';
        }
    }
	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();

        people.add(new Person("Anu", 20));
        people.add(new Person("Madhu", 21));
        people.add(new Person("Rohit", 22));
        people.add(new Person("Yash", 25));

        people.sort(Comparator.comparingInt(Person::getAge));

        System.out.println("Sorted by Age:");
        for (Person person : people) {
            System.out.println(person);
        }
		// TODO Auto-generated method stub

	}

}
