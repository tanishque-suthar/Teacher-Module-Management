package Model.Teachers;

import java.io.IOException;
import java.util.ArrayList;

public abstract class fileHandlingTeachers {
    protected abstract ArrayList<teacher> readTeacherJsonFile(String file_path);
    protected abstract void writeTeacherJsonFile(String file_path, ArrayList<teacher> teachers) throws IOException;
}

