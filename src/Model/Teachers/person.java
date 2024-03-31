package Model.Teachers;
/**
 * Identification comments:
 *   Name: Tanishque Suthar
 *   @version 1.0
 *
 * Beginning comments:
 * Filename: person.java
 * @author:  Tanishque Suthar
 * Overview: This is the Person class. In this file we have achieved the following
 * - Created Attributes
 * --- String teacher_fname
 * --- String teacher_lname
 * --- String teacher_phone_number
 *
 * - Created Setters and Getters
 * - Created a Display Function to call the getters and display Instance data
 *
 */
public class person {
    String teacher_fname;
    String teacher_lname;
    String teacher_phone_number;

    public person(){System.out.println("Creating a person");}

    public person(String teacher_fname, String teacher_lname, String teacher_phone_number){
        this.setTeacher_fname(teacher_fname);
        this.setTeacher_lname(teacher_lname);
        this.setTeacher_phone_number(teacher_phone_number);
    }

    public void setTeacher_fname(String teacher_fname) {
        this.teacher_fname = teacher_fname;
    }
    public void setTeacher_lname(String teacher_lname) {
        this.teacher_lname = teacher_lname;
    }
    public void setTeacher_phone_number(String teacher_phone_number) {
        this.teacher_phone_number = teacher_phone_number;
        try {
            if (teacher_phone_number.length() == 10) {
                this.teacher_phone_number = teacher_phone_number;
            }
            else {
                throw new mobileNumberException("Phone number should be of 10 numbers");
            }
        }
        catch (mobileNumberException e){
            System.out.println("Custom exception: "+e.getMessage());
        }
    }
    public String getTeacher_fname() {
        return teacher_fname;
    }
    public String getTeacher_lname() {
        return teacher_lname;
    }
    public String getTeacher_phone_number() {
        return teacher_phone_number;
    }

    public void display()
    {
        System.out.println("Teacher First Name: "+getTeacher_fname());
        System.out.println("Teacher Last Name: "+getTeacher_lname());
        System.out.println("Teacher Mobile No: "+getTeacher_phone_number());
    }
}

