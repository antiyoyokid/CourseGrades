import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CourseGraderData {


    /** public static void main(String[] args) {
      List<CourseProperties> aishik = new ArrayList<CourseProperties>();
      aishik = allData(Data.JSON_FILES);
      for(CourseProperties index: aishik){
      System.out.println(index.getGrades([]));
      }
      }
     */


    /**
     * @param input is a String array of file names
     * @return arrayList with all the Data combined together
     * Combines
     */


    public static ArrayList<CourseProperties> allData(String[] input) {
        List<String> dataFileNames = Arrays.asList(input);
        ArrayList<CourseProperties> myCourses = new ArrayList<>();
        Gson test = new Gson();
        for (int i = 0; i < dataFileNames.size(); i++) {
            ArrayList<CourseProperties> combined = new ArrayList<>(Arrays.asList(test.fromJson(Data.getFileContentsAsString(dataFileNames.get(i)), CourseProperties[].class)));
            myCourses.addAll(combined);
        }
        return myCourses;
    }

    public static ArrayList<CourseProperties> subjectSort(List<CourseProperties> input, String subject) {
        ArrayList<CourseProperties> sortedSubjects = new ArrayList<>();
        for (CourseProperties index : input) {
            if (index.getSubject().equals(subject)) {

                sortedSubjects.add(index);
            }


        }
        return sortedSubjects;
    }

    public static ArrayList<CourseProperties> instructortSort(List<CourseProperties> input, String partOfName) {
        ArrayList<CourseProperties> sortedInstructor = new ArrayList<>();
        for (CourseProperties index : input) {
            if (index.getInstructor().contains(partOfName)) {

                sortedInstructor.add(index);
            }


        }
        return sortedInstructor;
    }

    public static ArrayList<CourseProperties> numberSort(List<CourseProperties> input, int low, int high) {
        ArrayList<CourseProperties> sortedNumber = new ArrayList<>();
        for (CourseProperties index : input) {
            if (index.getNumber()>low && index.getNumber() < high) {

                sortedNumber.add(index);
            }


        }
        return sortedNumber;
    }
    public static ArrayList<CourseProperties> numberStudentsSort(List<CourseProperties> input, int low, int high) {
        ArrayList<CourseProperties> sortedStudentNumber = new ArrayList<>();



        for (CourseProperties index : input) {

            int sum = 0;

            for (int i =0; i < index.getGrades().length; i++) {
                sum += index.getGrades()[i];

            }
            if (sum >= low && sum <= high) {

                sortedStudentNumber.add(index);
            }


        }
        return sortedStudentNumber;
    }
}