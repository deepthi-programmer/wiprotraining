package day24;
import java.lang.reflect.*;
public class ReflectionDemo {

	public static void main(String[] args) {
		
		
		        try {
		            // Create an instance of the Person class
		            Class<?> personClass = Class.forName("Person");
		            Constructor<?> constructor = personClass.getConstructor(String.class, int.class);
		            Object person = constructor.newInstance("John Doe", 30);
		           
		            // Inspecting fields
		            System.out.println("Fields:");
		            Field[] fields = personClass.getDeclaredFields();
		            for (Field field : fields) {
		                System.out.println(field);
		            }
		            System.out.println("\nMethods:");
		            Method[] methods = personClass.getDeclaredMethods();
		            for (Method method : methods) {
		                System.out.println(method);
		            }
		            System.out.println("\nConstructors:");
		            Constructor<?>[] constructors = personClass.getDeclaredConstructors();
		            for (Constructor<?> cons : constructors) {
		                System.out.println(cons);
		            }
		            Field nameField = personClass.getDeclaredField("name");
		            nameField.setAccessible(true);  // Make the private field accessible
		            nameField.set(person, "Jane Doe");  // Set the value of the private field
		            Method getDetailsMethod = personClass.getDeclaredMethod("getDetails");
		            getDetailsMethod.setAccessible(true);  // Make the private method accessible
		            String details = (String) getDetailsMethod.invoke(person);
		            System.out.println("\nDetails after modification: " + details);

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		// TODO Auto-generated method stub

	}

}
