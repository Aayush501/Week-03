// definition of StudentNode class
class StudentNode {
    // declaring the attributes of this class
    private String rollNumber, name, grade;
    private int age;
    StudentNode next;

    // created a parameterized constructor to initialize the object
    StudentNode(String rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // created getter methods to maintain encapsulation and data security
    public String getName(){
        return this.name;
    }

    public String getRollNumber(){
        return this.rollNumber;
    }

    public String getGrade(){
        return this.grade;
    }

    public int getAge(){
        return this.age;
    }

    public void setGrade(String grade){
        this.grade = grade;
    }
}




// definition of Student class
class Student {
    // declaring the attributes of this class
    StudentNode head; // head of the linked list
    static int totalStudents=0;

    // defining the behaviour of this class

    // created a parameterized constructor to initialize a linked list of Students
    Student(String rollNumber, String name, int age, String grade) {
        head = new StudentNode(rollNumber, name, age, grade);
        totalStudents++;
    }


    // created a method to display all student records
    public void displayAllRecords() {
        StudentNode student = head;
        while (student != null) {
            System.out.println("Name of the student: " + student.getName() + "\nRoll Number: " + student.getRollNumber() + "\nAge: " + student.getAge() + "\nGrade: " + student.getGrade() + "\n");
            student = student.next;
        }
    }



    // created a method addNewStudent to add a new student at the end of the list
    public void addNewStudent(String rollNumber, String name, int age, String grade) {
        addStudent(rollNumber, name, age, grade, totalStudents+1);
    }



    // created a method to add a record at any position of the list including the beginning and end position
    public void addStudent(String rollNumber, String name, int age, String grade, int position) {
        if (position == 1) { // if user wants to add a record at the beginning
            StudentNode newStudent = new StudentNode(rollNumber, name, age, grade);
            newStudent.next = head;
            head = newStudent;
            totalStudents++;
            return;
        }

        // if the inserting position is not the beginning
        StudentNode student1 = head;
        StudentNode student2 = null;
        
        // created an integer variable to iterate through the list till we reach to the position
        int i=1; //2
        while (i<position) { // after this loop we have to insert the new record between student1 and student2 nodes
            if (student1 == null){ // means student2 is already at the last position  
                System.out.println("Invalid insert position!!");
                return;
            }
            student2 = student1;
            student1 = student1.next;
            i++;
        }
        
        // initializing a new student record
        StudentNode newStudent = new StudentNode(rollNumber, name, age, grade);
        
        // inserting the new record between student1 and student2
        newStudent.next = student1;
        student2.next = newStudent;
        totalStudents++;
    }



    // created a method to search a record by roll number
    public void searchByRollNumber(String rollNumber) {
        // iterator for the list
        StudentNode student1 = head;

        while (student1 != null) { // with this loop student1 will reach to the position that is required
            if (student1.getRollNumber().equals(rollNumber)) {
                System.out.println("Details of the student:\nName: " + student1.getName() + "\nRoll Number: " + student1.getRollNumber() + "\nAge: " + student1.getAge() + "\nGrade: " + student1.getGrade() + "\n");
                return;
            }
            student1 = student1.next;
        }

        System.out.println("Roll number does not exist.");
    }



    // created a method to delete a record by roll number
    public void deleteByRollNumber(String rollNumber) {
        // iterators for the list
        StudentNode student1 = head;
        StudentNode student2 = null;

        while (student1 != null) { // with this loop student1 will reach to the position that is needed to be deleted
            if (student1.getRollNumber().equals(rollNumber)) {
                student2.next = student1.next;
                totalStudents--;
                return;
            }
            student2 = student1;
            student1 = student1.next;
        }

        System.out.println("Roll number does not exist.");
    }


    // created a method to update the grade of a student by roll number
    public void updateGrade(String rollNumber) {
        // iterator for the list
        StudentNode student1 = head;

        while (student1 != null) { // with this loop student1 will reach to the position that is required
            if (student1.getRollNumber().equals(rollNumber)) {
                student1.setGrade("A");
                return;
            }
            student1 = student1.next;
        }

        System.out.println("Roll number does not exist.");
    }
}

// definition of StudentRecordManagement class
public class StudentRecordManagement {
    public static void main(String[] args) {
        // created a linked list of students
        Student students = new Student("1", "Student1", 15, "B");

        // iteration to add new students
        for (int i = 0; i < 4; i++) {
            students.addNewStudent("" + (i+2), "Student" + (i+2), 15, (i%2==1)? "B" : "C");
        }

        // displaying details of all students
        students.displayAllRecords();

        // adding new record at beginning of the list
        students.addStudent("0", "Student0", 15, "B", 1);

        // adding new record at the end of the list
        students.addStudent("6", "Student6", 15, "B", Student.totalStudents+1);

        // searching a student by roll number
        students.searchByRollNumber("3");

        // deleting a student record by roll number
        students.deleteByRollNumber("4");

        // updating the grade of a student by roll number
        students.updateGrade("5");

        // displaying details of all students
        students.displayAllRecords();
    }
}