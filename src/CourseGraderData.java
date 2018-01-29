import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class CourseGraderData {
    private static CourseProperties please;
    Gson aishik = new Gson();
    public static void main(String[] args) {
    //public static String combine1() {



        String fall2013 = Data.getFileContentsAsString(Data.getJsonFilesAsList().get(0));
        String fall2014 = Data.getFileContentsAsString(Data.getJsonFilesAsList().get(1));
        String spring2013 = Data.getFileContentsAsString(Data.getJsonFilesAsList().get(2));
        String spring2014 = Data.getFileContentsAsString(Data.getJsonFilesAsList().get(3));
        String summer2013 = Data.getFileContentsAsString(Data.getJsonFilesAsList().get(4));
        String summer2014 = Data.getFileContentsAsString(Data.getJsonFilesAsList().get(5));
        String combine = fall2013 + fall2014 + spring2013 + spring2014 + summer2013 + summer2014;
        //combine =  combine.replaceAll("\\[", "").replaceAll("\\]","");
        combine = combine.replaceAll("[\\[\\](){}]","") + "]";
        combine = "[" + combine;



        System.out.print(combine);






        //for (int i = 0; i < Data.JSON_FILES.length; i++) {

            //System.out.print(Data.getFileContentsAsString(Data.getJsonFilesAsList().get(i)));
        //}


    }


}