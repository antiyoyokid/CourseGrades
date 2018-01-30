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

    public static ArrayList<CourseProperties> simpleEasyClassSort(List<CourseProperties> input, double low, double high) {
        ArrayList<CourseProperties> sortedSimpleEasy = new ArrayList<>();
        for (CourseProperties index : input) {
            if (index.getAverage() > low && index.getAverage() < high) {

                sortedSimpleEasy.add(index);
            }


        }
        return sortedSimpleEasy;
}

    public static ArrayList<CourseProperties> mostAces(List<CourseProperties> input, int minA) {
        ArrayList<CourseProperties> sortedMostAPlus = new ArrayList<>();
        for (CourseProperties index : input) {
            if (index.getGrades()[0] > minA) {

                sortedMostAPlus.add(index);
            }


        }
        return sortedMostAPlus;

}
    public static int numberTotalStudentsSort(List<CourseProperties> input) {
       int sum = 0;
        for (CourseProperties index : input) {

                for (int i = 0; i < index.getGrades().length; i++) {
                    sum += index.getGrades()[i];

                }


            }
        return sum;
        }

    public static int StudentbyGrades (List<CourseProperties> input, String low, String high) {
        int i =0;
        int j =0;
        if(low.equals("A+")){
            i=0;
        }

        if(low.equals("A")){
            i = 1;
        }
        if(low.equals("A-")){
            i=2;
        }
        if(low.equals("B+")){
            i=3;
        }
        if(low.equals("B+")){
            i=4;
        }
        if(low.equals("B-")){
            i=5;
        }
        if(low.equals("C+")){
            i=6;
        }
        if(low.equals("C")){
            i=7;
        }
        if(low.equals("C-")){
            i=8;
        }
        if(low.equals("D+")){
            i=9;
        }
        if(low.equals("D")){
            i=10;
        }
        if(low.equals("D-")){
            i=11;
        }
        if(low.equals("F")){
            i=12;
        }
        if(low.equals("W")){
            i=13;
        }

        if(high.equals("A+")){
            j=0;
        }

        if(high.equals("A")){
            j = 1;
        }
        if(high.equals("A-")){
            i=2;
        }
        if(high.equals("B+")){
            j=3;
        }
        if(high.equals("B+")){
            j=4;
        }
        if(high.equals("B-")){
            j=5;
        }
        if(high.equals("C+")){
            i=6;
        }
        if(high.equals("C")){
            j=7;
        }
        if(high.equals("C-")){
            j=8;
        }
        if(high.equals("D+")){
            j=9;
        }
        if(high.equals("D")){
            j=10;
        }
        if(high.equals("D-")){
            j=11;
        }
        if(high.equals("F")){
            j=12;
        }
        if(high.equals("W")){
            j=13;
        }

        int sum = 0;
        for (CourseProperties index : input) {

            for (int count = j ; count <=i; count++) {
                sum += index.getGrades()[count];

            }


        }
        return sum;
    }

    public static double weightedMean(List<CourseProperties> input) {
        double sum = 0;
        int studentsEachCourse =0;
        double mean =0;
        for (CourseProperties index : input) {
            for (int i = 0; i < index.getGrades().length; i++) {
                studentsEachCourse = index.getGrades()[i];

                sum += index.getAverage() * studentsEachCourse;
            }
        }
        mean = sum/numberTotalStudentsSort(input);
        return mean;

    }


    }




