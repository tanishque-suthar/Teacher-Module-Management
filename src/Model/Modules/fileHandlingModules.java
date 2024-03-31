package Model.Modules;

import Model.Teachers.teacher;

import java.io.IOException;
import java.util.ArrayList;

public abstract class fileHandlingModules {
    protected abstract ArrayList<module> readModuleJsonFile(String file_path);
    protected abstract void writeModuleJsonFile(String file_path, ArrayList<module> modules) throws IOException;
}
