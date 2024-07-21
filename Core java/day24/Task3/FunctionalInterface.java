package day24;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterface {
	public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String toString() {
            return "Person(name='" + name + "', age=" + age + ')';
        }
    }
	public static void operateOnPerson(Person person, Predicate<Person> predicate,
            Consumer<Person> consumer, Supplier<Person> supplier,
            Function<Person, Person> function) {
		if (predicate.test(person)) {
			Person transformedPerson = function.apply(person);
			consumer.accept(transformedPerson);
			} else {
			Person newPerson = supplier.get();
			consumer.accept(newPerson);
			}
			}
	public static void main(String[] args) {
		Person person = new Person("Hamsini", 21);

        Predicate<Person> isAdult = p -> p.getAge() >= 18;
        Consumer<Person> printPerson = p -> System.out.println("Result: " + p);
        Supplier<Person> createNewPerson = () -> new Person("Rishi", 17);
        Function<Person, Person> makeOlder = p -> {
            p.setAge(p.getAge() + 1);
            return p;
        };

        operateOnPerson(person, isAdult, printPerson, createNewPerson, makeOlder);
		// TODO Auto-generated method stub

	}

}
