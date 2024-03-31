package Model.Teachers;

import java.util.ArrayList;

/**
 * Identification comments:
 *   Name: Tanishque Suthar
 *   @version 1.0
 *
 * Beginning comments:
 * Filename: teacher.java
 * @author:  Tanishque Suthar
 * Overview: This is the Student class. In this file we have achieved the following
 * - Created Attributes
 * --- private static int teacher_count
 * --- int teacher_id
 * --- String teacher_qualification
 * --- int teacher_exp
 *
 * - Created Setters and Getters
 * - Created a Display Function to call the getters and display Instance data
 * - Inherited parent class's variables
 *
 */
public class teacher extends person {
    private static int teacher_count = 0;
    int teacher_id;
    String teacher_qualification;
    int teacher_exp;
    public static int getTeacher_count()
    {
        return teacher_count;
    }

    public teacher()
    {
        setTeacher_count(getTeacher_count()+1);
        this.setTeacher_id(getTeacher_count());
    }
    public teacher(String teacher_fname, String teacher_lname, String teacher_qual, int teacher_exp, String teacher_mobile)
    {
        //passing variables to parent class
        super(teacher_fname,teacher_lname,teacher_mobile);
        setTeacher_count(getTeacher_count()+1);
        this.setTeacher_id(getTeacher_count());
        this.setTeacher_qualification(teacher_qual);
        this.setTeacher_exp(teacher_exp);
    }

    public teacher(int teacher_id, String teacher_fname, String teacher_lname, String teacher_qual, int teacher_exp, String teacher_mobile)
    {
        //passing variables to parent class
        super(teacher_fname,teacher_lname,teacher_mobile);
        setTeacher_count(getTeacher_count()+1);
        this.setTeacher_id(teacher_id);
        this.setTeacher_qualification(teacher_qual);
        this.setTeacher_exp(teacher_exp);
    }

    public static void setTeacher_count(int teacher_count) {
        teacher.teacher_count = teacher_count;
    }
    public void setTeacher_exp(int teacher_exp) {
        this.teacher_exp = teacher_exp;
    }
    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }
    public void setTeacher_qualification(String teacher_qualification) {
        this.teacher_qualification = teacher_qualification;
    }

    public int getTeacher_exp() {
        return teacher_exp;
    }
    public int getTeacher_id() {
        return teacher_id;
    }
    public String getTeacher_qualification() {
        return teacher_qualification;
    }

    public void display()
    {
        System.out.println("Teacher Id: "+getTeacher_id());
        //calling parent class's display function
        super.display();
        System.out.println("Teacher Qualification: "+getTeacher_qualification());
        System.out.println("Teacher Experience in years: "+getTeacher_exp());
    }

}
