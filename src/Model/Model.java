package Model;

import Model.Enrolls.manageEnrolls;
import Model.Modules.manageModules;
import Model.Teachers.manageTeachers;

public class Model {
    manageTeachers mt1;
    manageModules mm1;
    manageEnrolls me1;
    public Model(){
        mt1 = new manageTeachers();
        me1 = new manageEnrolls();
        mm1 = new manageModules();
    }

    public void setMe1(manageEnrolls me1) {
        this.me1 = me1;
    }

    public void setMm1(manageModules mm1) {
        this.mm1 = mm1;
    }

    public void setMt1(manageTeachers mt1) {
        this.mt1 = mt1;
    }

    public manageEnrolls getMe1() {
        return me1;
    }

    public manageModules getMm1() {
        return mm1;
    }

    public manageTeachers getMt1() {
        return mt1;
    }
}
