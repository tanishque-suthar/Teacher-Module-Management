package Model.Enrolls;

import Model.Modules.*;
import Model.Displayable;
import Model.Teachers.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class manageEnrolls extends FileHandlingEnrolls implements Displayable {
    ArrayList<teacher> teacher_List = new ArrayList<teacher>();
    ArrayList<module> module_List = new ArrayList<module>();
    ArrayList<Enrolls> enrollment_data = new ArrayList<Enrolls>();
    ObjectMapper objectMapper = new ObjectMapper();

    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;

    public manageEnrolls(){
        manageTeachers mt1 = new manageTeachers();
        teacher_List = mt1.getTable();
        manageModules mm1 = new manageModules();
        module_List = mm1.getTable();
        readEnrollsJsonFile("src\\Model\\Enrolls\\Enrolls.json");
    }
    @Override
    public ArrayList<Enrolls> readEnrollsJsonFile(String file_path) {
        try {
            JsonNode rootNode = objectMapper.readTree(new File(file_path));
            // Iterate through JSON array
            if (rootNode.isArray()) {
                new Enrolls();
                enrollment_data.clear();
                for (JsonNode node : rootNode) {
                    //int check1 = 0,check2=0;
                    int e_temp_id = node.get("e_temp_id").asInt();
                    int teacher_temp = node.get("teacher_temp").asInt();
                    int module_temp = node.get("module_temp").asInt();
                    String enroll_date = node.get("enroll_date").asText();
                    int teacher_sal = node.get("teacher_sal").asInt();

                    teacher teacher_temp_obj = null;
                    module module_temp_obj = null;

                    for(int i = 0; i < teacher_List.size(); i++)
                    {
                        if(teacher_temp == teacher_List.get(i).getTeacher_id())
                        {
                            teacher_temp_obj = teacher_List.get(i);
                            //check1=1;
                        }
                    }
                    /*if(check1!=0) {
                        teacher okxyz = new teacher(0, "[deleted]", "[deleted]", "[deleted]", 0, "[deleted]");
                        teacher_List.add(okxyz);
                        teacher_temp_obj = teacher_List.get(teacher_List.indexOf(okxyz));
                    }*/
                    for(int i = 0; i < module_List.size(); i++)
                    {
                        if(module_temp == module_List.get(i).getModule_id())
                        {
                            module_temp_obj = module_List.get(i);
                            //check2=1;
                        }
                    }
                    //if(check2!=0){module_temp_obj = new module(0,0,"[deleted]",0,"[deleted]",0,"[deleted]");}

                    Enrolls e_temp = new Enrolls(e_temp_id, teacher_temp_obj,module_temp_obj,enroll_date,teacher_sal);
                    enrollment_data.add(e_temp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return enrollment_data;
    }

    @Override
    public void writeEnrollsJsonFile(String file_path, ArrayList<Enrolls> enrolls) throws IOException {

        ArrayList<Map<String, Object>> enroll_to_be_written = new ArrayList<>();

        for(int i = 0; i < enrolls.size(); i++)
        {
            HashMap <String, Object> row = new HashMap<>();
            row.put("e_temp_id", enrolls.get(i).getSerialNo());
            row.put("teacher_temp", enrolls.get(i).getTeacher_temp().getTeacher_id());
            row.put("module_temp", enrolls.get(i).getModule_temp().getModule_id());
            row.put("enroll_date", enrolls.get(i).getEnroll_date());
            row.put("teacher_sal", enrolls.get(i).getTeacher_sal());
            enroll_to_be_written.add(row);
        }
        objectMapper.writeValue(Paths.get(file_path).toFile(), enroll_to_be_written);
    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Serial Number");
        headers.add("Teacher Id");
        headers.add("Teacher Name");
        headers.add("Module Id");
        headers.add("Module Name");
        headers.add("Enrollment Date");
        headers.add("Teacher Salary");

        return headers;
    }

    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> enrollment_details = new ArrayList<String>();
        enrollment_details.add(String.valueOf(enrollment_data.get(line).getSerialNo()));
        enrollment_details.add(String.valueOf(enrollment_data.get(line).getTeacher_temp().getTeacher_id()));
        enrollment_details.add(String.valueOf(enrollment_data.get(line).getTeacher_temp().getTeacher_fname() + " " + enrollment_data.get(line).getTeacher_temp().getTeacher_lname()));
        enrollment_details.add(String.valueOf(enrollment_data.get(line).getModule_temp().getModule_id()));
        enrollment_details.add(String.valueOf(enrollment_data.get(line).getModule_temp().getModule_name()));
        enrollment_details.add(String.valueOf(enrollment_data.get(line).getEnroll_date()));
        enrollment_details.add(String.valueOf(enrollment_data.get(line).getTeacher_sal()));
        return enrollment_details;
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> enrollment_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            enrollment_subset.add(getLine(i));
        }
        return enrollment_subset;
    }

    @Override
    public int getFirstLineToDisplay() {
        return firstLineIndex;
    }

    @Override
    public int getLineToHighlight() {
        return highlightedLine;
    }

    @Override
    public int getLastLineToDisplay() {
        setLastLineToDisplay(getFirstLineToDisplay() + getLinesBeingDisplayed() - 1);
        return lastLineIndex;
    }

    @Override
    public int getLinesBeingDisplayed() {
        return linesBeingDisplayed;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
        this.firstLineIndex = firstLine;
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {
        this.highlightedLine = highlightedLine;
    }
    @Override
    public void setLastLineToDisplay(int lastLine) {
        this.lastLineIndex = lastLine;
    }
    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        this.linesBeingDisplayed = numberOfLines;
    }
    public ArrayList<Enrolls> getTable() {
        return enrollment_data;
    }
    public void addNewEnroll(int t_id, int m_id, int t_sal, String date) throws IOException{
        readEnrollsJsonFile("src\\Model\\Enrolls\\Enrolls.json");
        int t_id_idx = getIndexOfTeacherID(t_id);
        int m_id_idx = getIndexOfModuleID(m_id);

        Enrolls temp_e = new Enrolls(teacher_List.get(t_id_idx),module_List.get(m_id_idx), date, t_sal);
        enrollment_data.add(temp_e);
        writeEnrollsJsonFile("src\\Model\\Enrolls\\Enrolls.json",enrollment_data);
    }
    public void deleteEnroll(int index) throws IOException{
        readEnrollsJsonFile("src\\Model\\Enrolls\\Enrolls.json");
        enrollment_data.remove(index);
        for(int i = index;i<enrollment_data.size();i++){
            enrollment_data.get(i).setSerialNo(i+1);
        }
        writeEnrollsJsonFile("src\\Model\\Enrolls\\Enrolls.json",enrollment_data);
    }
    public void editEnroll(int index, int t_id, int m_id, int t_sal, String date) throws IOException{
        readEnrollsJsonFile("src\\Model\\Enrolls\\Enrolls.json");
        int t_id_idx = getIndexOfTeacherID(t_id);
        int m_id_idx = getIndexOfModuleID(m_id);
        enrollment_data.get(index).setEnroll_date(date);
        //enrollment_data.get(index).setSerialNo(e_id);
        enrollment_data.get(index).setTeacher_sal(t_sal);
        enrollment_data.get(index).setModule_temp(module_List.get(m_id_idx));
        enrollment_data.get(index).setTeacher_temp(teacher_List.get(t_id_idx));
        writeEnrollsJsonFile("src\\Model\\Enrolls\\Enrolls.json",enrollment_data);
    }
    public void deleteEnrollConditional(int id) throws IOException{
        readEnrollsJsonFile("src\\Model\\Enrolls\\Enrolls.json");
        for(int i = 0;i<enrollment_data.size();i++){
            if(id == enrollment_data.get(i).getTeacher_temp().getTeacher_id() || id == enrollment_data.get(i).getModule_temp().getModule_id())
            {
                deleteEnroll(i);
            }
        }
        writeEnrollsJsonFile("src\\Model\\Enrolls\\Enrolls.json",enrollment_data);
    }
    public int getIndexOfTeacherID(int id){
        for (int i =0;i<teacher_List.size();i++){
            if(id == teacher_List.get(i).getTeacher_id()){
                id = i;
                break;
            }
        }
        return id;
    }
    public int getIndexOfModuleID(int id){
        for (int i =0;i<module_List.size();i++){
            if(id == module_List.get(i).getModule_id()){
                id = i;
                break;
            }
        }
        return id;
    }
}
