import java.util.Scanner;
import java.util.Vector;
import java.util.Hashtable;
import java.util.Iterator;

class Student {
int regNo;
String name;
Hashtable<String, Integer> marks;
/**
* Constructs a Student object with registration number and name.
* Initializes the marks Hashtable.
*
* @param regNo registration number of the student
* @param name name of the student
*/
Student(int regNo, String name) {
this.regNo = regNo;
this.name = name;
marks = new Hashtable<>();
}
/**
* Adds a subject and its marks to the student's record.
*
* @param subject name of the subject
* @param mark marks obtained in the subject
* @throws IllegalArgumentException if mark is negative or greater than 100
*/
void addMarks(String subject, int mark) throws IllegalArgumentException {
if (mark < 0 || mark > 100) {
throw new IllegalArgumentException("Mark must be between 0 and 100.");
}
marks.put(subject, mark);
}

double calculateAverage() {
int sum = 0;
for (int m : marks.values()) {
sum += m;
}
return marks.size() == 0 ? 0.0 : (double) sum / marks.size();
}

void display() {
System.out.println("RegNo: " + regNo);
System.out.println("Name: " + name);
System.out.println("Marks: " + marks);
System.out.println("Average: " + calculateAverage());
System.out.println("----------------------");
}
}

public class StudentMenuSystem {

public static Student searchStudent(Vector<Student> students, int regNo) {
for (Student s : students) {
if (s.regNo == regNo) {
return s;
}

}
return null;
}

public static void main(String[] args) throws IllegalArgumentException {
Scanner sc = new Scanner(System.in);
Vector<Student> students = new Vector<>();
int choice;
do {
System.out.println("\n--- Student Management System ---");
System.out.println("1. Register New Student");
System.out.println("2. Add Marks");
System.out.println("3. Search Student");
System.out.println("4. Display All Students");
System.out.println("5. Unregister Student");
System.out.println("6. Exit");
System.out.print("Enter your choice: ");
choice = sc.nextInt();
sc.nextLine(); // consume newline
switch (choice) {
case 1:

System.out.print("Enter RegNo: ");
int regNo = sc.nextInt();
sc.nextLine();
System.out.print("Enter Name: ");
String name = sc.nextLine();
if (searchStudent(students, regNo) != null) {
System.out.println("Student with this RegNo already exists!");
} else {
students.add(new Student(regNo, name));
System.out.println("Student registered successfully.");
}
break;

case 2:
System.out.print("Enter RegNo to add marks: ");
int regSearch = sc.nextInt();
sc.nextLine();
Student s = searchStudent(students, regSearch);
if (s != null) {
System.out.print("Enter subject name: ");
String subject = sc.nextLine();
System.out.print("Enter marks: ");
int mark = sc.nextInt();
sc.nextLine();
try {
s.addMarks(subject, mark);
System.out.println("Marks added successfully.");
} catch (IllegalArgumentException e) {
System.out.println("Error: " + e.getMessage());
}
} else {
System.out.println("Student not found!");
}
break;
case 3:

System.out.print("Enter RegNo to search: ");
int searchReg = sc.nextInt();
sc.nextLine();
Student found = searchStudent(students, searchReg);
if (found != null) {
System.out.println("\nStudent Found:");
found.display();
} else {
System.out.println("Student not found!");
}
break;
case 4:

if (students.isEmpty()) {
System.out.println("No students registered.");
} else {
System.out.println("\n--- All Students ---");
Iterator<Student> it = students.iterator();
while (it.hasNext()) {
Student st = it.next();

st.display();
}
}
break;
case 5:

System.out.print("Enter RegNo to unregister: ");
int delReg = sc.nextInt();
sc.nextLine();
Student removeStu = searchStudent(students, delReg);
if (removeStu != null) {
students.remove(removeStu);
System.out.println("Student unregistered successfully.");
} else {
System.out.println("Student not found!");
}
break;
case 6:
System.out.println("Exiting program...");
break;
default:
System.out.println("Invalid choice! Try again.");
}
} while (choice != 6);
sc.close();
}
}
