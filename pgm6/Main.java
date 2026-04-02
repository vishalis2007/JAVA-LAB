
 class InvalidAgeException extends Exception {
public InvalidAgeException(String message) {
super(message);
}
}


 class UserRegistration {

public void processRegistration(String username, int age) {

System.out.println(">>> Processing registration for: " + username);
try {
if (age < 0) {
throw new InvalidAgeException("Age cannot be negative (" + age + ").");
}
if (username == null || username.trim().isEmpty()) {
throw new InvalidAgeException("Username is required.");
}

registerUser(username, age);
System.out.println("STATUS: Success.");
} catch (InvalidAgeException e) {

System.err.println("STATUS: Failed - " + e.getMessage());
} finally {
System.out.println("Finalizing request...\n");
}
}

private void registerUser(String username, int age) {
System.out.println("System: Saving " + username + " (Age: " + age + ") to database.");
}
}

public class Main {
public static void main(String[] args) {
UserRegistration app = new UserRegistration();

app.processRegistration("JavaExpert", 30);

app.processRegistration("JuniorDev", -1);

app.processRegistration("", 20);

}
}
