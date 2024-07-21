package day24;

public class Person {
	private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Private method
    private String getDetails() {
        return "Name: " + name + ", Age: " + age;
    }

    // Public method
    public void displayDetails() {
        System.out.println(getDetails());
    }
}
