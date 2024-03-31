package Model.Modules;

import java.util.ArrayList;

/**
 * Identification comments:
 *   Name: Tanishque Suthar
 *   @version 1.0
 *
 *
 * Beginning comments:
 * Filename: module.java
 * @author:  Tanishque Suthar
 * Overview: This is the Student class. In this file we have achieved the following
 * - Created Attributes
 * --- private static int mod_count
 * --- int module_id
 * --- String module_name
 * --- int module_credits
 * --- String module_tb
 *
 * - Created Setters and Getters
 * - Created a Display Function to call the getters and display Instance data
 * - Inherited parent class's variables
 *
 */
public class module extends subject {
    private static int mod_count=0;
    int module_id;
    String module_name;
    int module_credits;
    String module_tb;
    public module()
    {
        setMod_count(getMod_count()+1);
        this.setModule_id(getMod_count());
    }
    public module(int sub_id, String sub_name,int sub_cred,String module_name,int mod_cred,String tb_name)
    {
        //passing variables to parent class
        super(sub_id,sub_name,sub_cred);
        setMod_count(getMod_count()+1);
        this.setModule_id(getMod_count());
        this.setModule_credits(mod_cred);
        this.setModule_name(module_name);
        this.setModule_tb(tb_name);
    }

    public module(int mod_id,int sub_id, String sub_name,int sub_cred,String module_name,int mod_cred,String tb_name)
    {
        //passing variables to parent class
        super(sub_id,sub_name,sub_cred);
        setMod_count(getMod_count()+1);
        this.setModule_id(mod_id);
        this.setModule_credits(mod_cred);
        this.setModule_name(module_name);
        this.setModule_tb(tb_name);
    }

    public static void setMod_count(int mod_count) {
        module.mod_count = mod_count;
    }

    public static int getMod_count() {
        return mod_count;
    }

    public void setModule_credits(int module_credits) {
        try{
            if(module_credits>=0 && module_credits<=super.subject_credits){
                this.module_credits = module_credits;
            }
            else{
                throw new maxCreditsException("Module credits should be less than subject credits and more than 1");
            }
        }
        catch (maxCreditsException e){
            System.out.println("Custom Exception: "+e.getMessage());
        }
    }

    public void setModule_id(int module_id) {
        this.module_id = module_id;
    }

    public void setModule_tb(String module_tb) {
        this.module_tb = module_tb;
    }

    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }

    public int getModule_credits() {
        return module_credits;
    }

    public int getModule_id() {
        return module_id;
    }

    public String getModule_name() {
        return module_name;
    }

    public String getModule_tb() {
        return module_tb;
    }

    public void display()
    {
        //calling parent class's display function
        super.display();
        System.out.println("Module id: "+getModule_id());
        System.out.println("Module name: "+getModule_name());
        System.out.println("Module credits: "+getModule_credits());
        System.out.println("Module textbooks: "+getModule_tb());
    }
}