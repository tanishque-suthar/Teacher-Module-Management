package Model.Enrolls;

import Model.Modules.module;

import java.io.IOException;
import java.util.ArrayList;

public abstract class FileHandlingEnrolls {
    protected abstract ArrayList<Enrolls> readEnrollsJsonFile(String file_path);
    protected abstract void writeEnrollsJsonFile(String file_path, ArrayList<Enrolls> enrolls) throws IOException;
}
