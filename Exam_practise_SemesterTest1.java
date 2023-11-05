
package exam_practise_semestertest1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import za.ac.tut.bl.StudentManager;
import za.ac.tut.entity.Student;

/**
 *
 * @author Thapelo Mkhwanazi
 */
public class Exam_practise_SemesterTest1 
{

    public static void main(String[] args) throws IOException 
    {
        char option;
        StudentManager sm = new StudentManager();
        File file = new File("classlist.txt");
        Student student;
        
        
        option = menu();
        
        while(option != 'e')
        {

            switch(option)
            {
                case 'a':
                    
                    student = getStudentDetails();
                    sm.addStudent(student, file);
                    System.out.println("Student added to the file!!!!");
                    
                    break;
                    
                case 'g':
                    
                    ArrayList<Student> students;
                    students = sm.getStudents(file);
                    
                    if(students == null)
                    {
                        System.out.println("The list is empty!!!!");                        
                    }
                    else
                    {
                        displayStudents(students);
                    }
                    
                    break;
                    
                default:
                    System.out.println(option + " is invalid, please enter a or g");
            }
            
             option = menu();
        }
    }

    private static char menu() 
    {
        
        char option;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Please Enter The following\n---------------\n" + 
                "a...add a student into the classlist file\n" + 
                "g...get the list of students from the classlist file\n" + 
                "e...exit the application..");
        System.out.print("Your Choice: ");
        option = sc.next().charAt(0);

        option = Character.toLowerCase(option);
        
        return option;
    }
    
    private static Student getStudentDetails()
    {
        Scanner sc = new Scanner(System.in);
        Student student;
        String name;
        int age;
        
        System.out.println("Enter the name of the student");
        name = sc.next();
        
        System.out.println("Enter the age of the student");
        age = sc.nextInt();
        
        student = new Student(name, age);
        return student;
    }

    private static void displayStudents(ArrayList<Student> students) 
    {
        String name, data = "";
        int age;
        
        System.out.println("List of students\n---------\n");
        
        for(Student stud : students)
        {
            name = stud.getName();
            age = stud.getAge();
            data = data + "Name: " + name + "\nAge: " + age + "\n\n";
        }
        
        System.out.println(data);
    }
    
}
