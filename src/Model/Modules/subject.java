package Model.Modules;
/**
 * Identification comments:
 *   Name: Tanishque Suthar
 *   @version 1.0
 *
 *
 * Beginning comments:
 * Filename: subject.java
 * @author:  Tanishque Suthar
 * Overview: This is the Student class. In this file we have achieved the following
 * - Created Attributes
 * --- int subject_id
 * --- String subject_name
 * --- int subject_credits
 *
 * - Created Setters and Getters
 * - Created a Display Function to call the getters and display Instance data
 *
 */
public class subject {
    int subject_id;
    String subject_name;
    int subject_credits;

    public subject()
    {
        System.out.println("Creating a subject");
    }

    public subject(int sub_id,String sub_name,int sub_cred)
    {
        this.setSubject_id(sub_id);
        this.setSubject_name(sub_name);
        this.setSubject_credits(sub_cred);
    }
    public void setSubject_credits(int subject_credits) {
        try{
            if(subject_credits>=0 && subject_credits<=10){
                this.subject_credits = subject_credits;
            }
            else
            {
                throw new maxCreditsException("Maximum Credits per subject is 10 and minimum is 1");
            }
        }
        catch (maxCreditsException e){
            System.out.println("Custom Exception: "+e.getMessage());
        }
    }
    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }
    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }
    public int getSubject_credits() {
        return subject_credits;
    }
    public int getSubject_id() {
        return subject_id;
    }
    public String getSubject_name() {
        return subject_name;
    }

    public void display()
    {
        System.out.println("Subject Id: "+getSubject_id());
        System.out.println("Subject Name: "+getSubject_name());
        System.out.println("Subject Total Credits: "+ getSubject_credits());
    }
}