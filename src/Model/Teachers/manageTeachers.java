package Model.Teachers;

import Model.Displayable;
import Model.Modules.module;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class manageTeachers extends fileHandlingTeachers implements Displayable {
    ArrayList <teacher> teachers = new ArrayList<> ();
    ObjectMapper objectMapper = new ObjectMapper ();
    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;
    public manageTeachers(){
        readTeacherJsonFile("src\\Model\\Teachers\\teachers.json");
    }
    public ArrayList<teacher> readTeacherJsonFile(String file_path)
    {
        try {
            JsonNode rootNode = objectMapper.readTree(new File(file_path));
            // Iterate through JSON array
            if (rootNode.isArray()) {
                teachers.clear();
                for (JsonNode node : rootNode) {
                    int teacher_id = node.has("teacher_id") ? node.get("teacher_id").asInt() : 0;
                    String fname = node.has("teacher_fname") ? node.get("teacher_fname").asText() : "";
                    String lname = node.has("teacher_lname") ? node.get("teacher_lname").asText() : "";
                    String qual = node.has("teacher_qualification") ? node.get("teacher_qualification").asText() : "";
                    int exp_years = node.has("teacher_exp") ? node.get("teacher_exp").asInt() : 0;
                    String mobile = node.has("teacher_phone_number") ? node.get("teacher_phone_number").asText() : "";
                    teacher t = new teacher(teacher_id, fname, lname, qual, exp_years, mobile);
                    teachers.add(t);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    public void writeTeacherJsonFile(String file_path, ArrayList<teacher> teachers) throws IOException {
        objectMapper.writeValue(Paths.get(file_path).toFile(), teachers);
    }
    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> teacher_details = new ArrayList<String>();

        teacher_details.add(String.valueOf(teachers.get(line).getTeacher_id()));
        teacher_details.add(teachers.get(line).getTeacher_fname());
        teacher_details.add(teachers.get(line).getTeacher_lname());
        teacher_details.add(teachers.get(line).getTeacher_phone_number());
        teacher_details.add(teachers.get(line).getTeacher_qualification());
        teacher_details.add(String.valueOf(teachers.get(line).getTeacher_exp()));

        return teacher_details;
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> teacher_subset = new ArrayList<ArrayList<String>>();
        for (int i = firstLine; i <= lastLine; i++) {
            teacher_subset.add(getLine(i));
        }
        return teacher_subset;
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
    public void setTeachersTable(ArrayList<teacher> teachers) {
        this.teachers = teachers;
    }
    public ArrayList<teacher> getTable() {
        return teachers;
    }
    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Teacher ID");
        headers.add("First Name");
        headers.add("Last Name");
        headers.add("Mobile");
        headers.add("Qualifications");
        headers.add("Teaching Experience");

        return headers;
    }
    public void addNewTeacher (int id, String fname, String lname,String qual, int exp, String mobno) throws IOException{
        readTeacherJsonFile("src\\Model\\Teachers\\teachers.json");
        teacher temp_t = new teacher(id, fname, lname, qual, exp, mobno);
        teachers.add(temp_t);
        writeTeacherJsonFile("src\\Model\\Teachers\\teachers.json", teachers);
    }
    public void editNewTeacher(int index, int id, String fname, String lname,String qual, int exp, String mobno) throws IOException{
        readTeacherJsonFile("src\\Model\\Teachers\\teachers.json");
        teachers.get(index).setTeacher_id(id);
        teachers.get(index).setTeacher_fname(fname);
        teachers.get(index).setTeacher_lname(lname);
        teachers.get(index).setTeacher_exp(exp);
        teachers.get(index).setTeacher_qualification(qual);
        teachers.get(index).setTeacher_phone_number(mobno);
        writeTeacherJsonFile("src\\Model\\Teachers\\teachers.json", teachers);
    }
    public int deleteTeacher(int index) throws IOException{
        readTeacherJsonFile("src\\Model\\Teachers\\teachers.json");
        int id = teachers.get(index).getTeacher_id();
        teachers.remove(index);
        writeTeacherJsonFile("src\\Model\\Teachers\\teachers.json", teachers);
        return id;
    }

    public ArrayList<teacher> getTeachers() {
        return teachers;
    }
}
