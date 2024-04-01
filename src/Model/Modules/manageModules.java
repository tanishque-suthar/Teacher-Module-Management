package Model.Modules;

import Model.Displayable;
import Model.Modules.module;
import Model.Teachers.teacher;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class manageModules extends fileHandlingModules implements Displayable {
    ArrayList <module> modules = new ArrayList<> ();
    ObjectMapper objectmapper = new ObjectMapper ();
    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;
    public manageModules(){
        readModuleJsonFile("src\\Model\\Modules\\modules.json");
    }
    public ArrayList<module> readModuleJsonFile(String file_path)
    {
        try {
            JsonNode rootNode = objectmapper.readTree(new File (file_path));
            // Iterate through JSON array
            if (rootNode.isArray()) {
                modules.clear();
                for (JsonNode node : rootNode) {
                    int mod_id = node.has("module_id") ? node.get("module_id").asInt() : 0;
                    int sub_id = node.has("subject_id") ? node.get("subject_id").asInt() : 0;
                    String sub_name = node.has("subject_name") ? node.get("subject_name").asText() : "";
                    int sub_cred = node.has("subject_credits") ? node.get("subject_credits").asInt() : 0;
                    String module_name = node.has("module_name") ? node.get("module_name").asText() : "";
                    int mod_cred = node.has("module_credits") ? node.get("module_credits").asInt() : 0;
                    String tb_name = node.has("module_tb") ? node.get("module_tb").asText() : "";
                    module m = new module(mod_id,sub_id,sub_name,sub_cred,module_name,mod_cred,tb_name);
                    modules.add(m);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return modules;
    }
    public void writeModuleJsonFile(String file_path, ArrayList<module> modules) throws IOException {
        objectmapper.writeValue(Paths.get("src/Model/Modules/modules.json").toFile(), modules);
    }
    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> module_details = new ArrayList<String>();

        module_details.add(String.valueOf(modules.get(line).getModule_id()));
        module_details.add(String.valueOf(modules.get(line).getSubject_id()));
        module_details.add(modules.get(line).getSubject_name());
        module_details.add(String.valueOf(modules.get(line).getSubject_credits()));
        module_details.add(modules.get(line).getModule_name());
        module_details.add(String.valueOf(modules.get(line).getModule_credits()));
        module_details.add(modules.get(line).getModule_tb());

        return module_details;
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> module_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            module_subset.add(getLine(i));
        }
        return module_subset;
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
    public void setModulesTable(ArrayList<module> modules) {
        this.modules = modules;
    }
    public ArrayList<module> getTable() {
        return modules;
    }
    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Module Id");
        headers.add("Subject Id");
        headers.add("Subject Name");
        headers.add("Subject Credits");
        headers.add("Module Name");
        headers.add("Module Credits");
        headers.add("Module Textbook");

        return headers;
    }
    public void addNewModule(int m_id,int s_id, String sub_name,int sub_cred,String module_name,int mod_cred,String tb_name) throws IOException{
        modules = readModuleJsonFile("src/Model/Modules/modules.json");
        module temp_m = new module(m_id, s_id, sub_name, sub_cred, module_name, mod_cred, tb_name);
        modules.add(temp_m);
        writeModuleJsonFile("src/Model/Modules/modules.json",modules);
    }

    public ArrayList<module> getModules() {
        return modules;
    }
    public int deleteModule(int index) throws IOException{
        readModuleJsonFile("src/Model/Modules/modules.json");
        int id = modules.get(index).getModule_id();
        modules.remove(index);
        writeModuleJsonFile("src/Model/Modules/modules.json",modules);
        return id;
    }
    public void editModule(int index, int m_id,int s_id, String sub_name,int sub_cred,String module_name,int mod_cred,String tb_name) throws IOException{
        readModuleJsonFile("src/Model/Modules/modules.json");
        modules.get(index).setModule_id(m_id);
        modules.get(index).setModule_name(module_name);
        modules.get(index).setModule_tb(tb_name);
        modules.get(index).setModule_credits(mod_cred);
        modules.get(index).setSubject_id(s_id);
        modules.get(index).setSubject_credits(sub_cred);
        modules.get(index).setSubject_name(sub_name);
        writeModuleJsonFile("src/Model/Modules/modules.json",modules);
    }
}
