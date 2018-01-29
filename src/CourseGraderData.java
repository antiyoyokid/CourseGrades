import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class CourseGraderData {
    public static void main (String[] args) {
        Gson aishik = new Gson();
        Data.getJsonFilesAsList();
        for (int i = 0; i < 6; i++) {

            System.out.print(Data.getFileContentsAsString(Data.getJsonFilesAsList().get(i)));
        }


    }



}
