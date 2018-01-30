import com.google.gson.Gson;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CourseGraderData {
    /**
     * ***********************************************************************************************************************************************
     * METHODS FOR PART 2 OF CODING ASSIGNMENT
     * ***********************************************************************************************************************************************
     *
     * @param input is a String array of file names
     * @return arrayList with all the Data combined together
     * Combines several json files together and leaves it as arrayList
     */


    public static ArrayList<CourseProperties> combinedData(String[] input) {

        List<String> dataFileNames = Arrays.asList(input);

        ArrayList<CourseProperties> myCourses = new ArrayList<>();
        Gson test = new Gson();
        for (int i = 0; i < dataFileNames.size(); i++) {
            ArrayList<CourseProperties> combined = new ArrayList<>(Arrays.asList(test.fromJson(Data.getFileContentsAsString(dataFileNames.get(i)), CourseProperties[].class)));

            myCourses.addAll(combined);
        }
        return myCourses;
    }

    /**
     * **********************************************************************************************************************************************
     * METHODS IN PART 3 OF CODING ASSIGNMENT
     * **********************************************************************************************************************************************
     *
     * @param input   ArrayList containing all courses
     * @param subject Subject the user is searching for
     * @return new Array list with information on matching subjects
     */

    public static ArrayList<CourseProperties> subjectSort(List<CourseProperties> input, String subject) {

        ArrayList<CourseProperties> sortedSubjects = new ArrayList<>();

        for (CourseProperties index : input) {

            if (index.getSubject().equals(subject)) {

                sortedSubjects.add(index);
            }

        }
        return sortedSubjects;
    }

    /**
     * @param input      ArrayList containing all courses
     * @param partOfName String that contains search term for instructor
     * @return ArrayList name of all matching instructors with the search term
     */
    public static ArrayList<CourseProperties> instructortSort(List<CourseProperties> input, String partOfName) {

        ArrayList<CourseProperties> sortedInstructor = new ArrayList<>();

        for (CourseProperties index : input) {

            if (index.getInstructor().contains(partOfName)) {

                sortedInstructor.add(index);
            }

        }
        return sortedInstructor;
    }

    /**
     * @param input           ArrayList containing all courses
     * @param minCourseNumber minimum course number
     * @param maxCourseNumber maximum course number
     * @return ArrayList of courses that fall within the max and min course numbers
     */
    public static ArrayList<CourseProperties> numberSort(List<CourseProperties> input, int maxCourseNumber, int minCourseNumber) {

        ArrayList<CourseProperties> sortedNumber = new ArrayList<>();

        for (CourseProperties index : input) {

            if (index.getNumber() > maxCourseNumber && index.getNumber() < minCourseNumber) {

                sortedNumber.add(index);
            }


        }
        return sortedNumber;
    }

    /**
     * @param input      ArrayList containing all courses
     * @param minStudent minimum number of Students in course
     * @param maxStudent maximum number of Students in course
     * @return ArrayList of all courses that have students between max and min
     */
    public static ArrayList<CourseProperties> numberStudentsSort(List<CourseProperties> input, int minStudent, int maxStudent) {

        ArrayList<CourseProperties> sortedStudentNumber = new ArrayList<>();


        for (CourseProperties index : input) {

            int sum = 0;

            for (int i = 0; i < index.getGrades().length; i++) {
                sum += index.getGrades()[i];

            }
            if (sum >= minStudent && sum <= maxStudent) {

                sortedStudentNumber.add(index);
            }


        }
        return sortedStudentNumber;
    }

    /**
     * @param input  ArrayList containing all courses
     * @param minAvg minimum average of Course
     * @param maxAvg maximum average of Course
     * @return ArrayList of courses that satisfy the max and min averages
     */

    public static ArrayList<CourseProperties> simpleEasyClassSort(List<CourseProperties> input, double minAvg, double maxAvg) {

        ArrayList<CourseProperties> sortedSimpleEasy = new ArrayList<>();

        for (CourseProperties index : input) {
            if (index.getAverage() > minAvg && index.getAverage() < maxAvg) {

                sortedSimpleEasy.add(index);
            }


        }
        return sortedSimpleEasy;
    }

    /**
     * @param input    ArrayList containing all courses
     * @param minAplus minimum number of A pluses
     * @return Arraylist with courses that have greater than a certain number of A+
     */
    public static ArrayList<CourseProperties> mostAces(List<CourseProperties> input, int minAplus) {

        ArrayList<CourseProperties> sortedMostAPlus = new ArrayList<>();

        for (CourseProperties index : input) {
            if (index.getGrades()[0] > minAplus) {

                sortedMostAPlus.add(index);
            }


        }
        return sortedMostAPlus;

    }

    /**
     * *******************************************************************************************************************************************
     * METHODS THAT RETURN A VALUE I.E. PART 4 OF CODING ASSIGNMENT
     * *******************************************************************************************************************************************
     *
     * @param input ArrayList of all Course info
     * @return integer of the Total number of Students
     */

    public static int numberTotalStudentsSort(List<CourseProperties> input) {
        int sum = 0;
        for (CourseProperties index : input) {

            for (int i = 0; i < index.getGrades().length; i++) {
                sum += index.getGrades()[i];
            }

        }
        return sum;
    }

    /**
     *
     *
     * @param input ArrayList containing all Course information
     * @param lowGrade
     * @param highGrade
     * @return
     */
    public static int StudentbyGrades(List<CourseProperties> input, String lowGrade, String highGrade) {
        int i = 0;
        int j = 0;
        if (lowGrade.equals("A+")) {
            i = 0;
        }

        if (lowGrade.equals("A")) {
            i = 1;
        }
        if (lowGrade.equals("A-")) {
            i = 2;
        }
        if (lowGrade.equals("B+")) {
            i = 3;
        }
        if (lowGrade.equals("B+")) {
            i = 4;
        }
        if (lowGrade.equals("B-")) {
            i = 5;
        }
        if (lowGrade.equals("C+")) {
            i = 6;
        }
        if (lowGrade.equals("C")) {
            i = 7;
        }
        if (lowGrade.equals("C-")) {
            i = 8;
        }
        if (lowGrade.equals("D+")) {
            i = 9;
        }
        if (lowGrade.equals("D")) {
            i = 10;
        }
        if (lowGrade.equals("D-")) {
            i = 11;
        }
        if (lowGrade.equals("F")) {
            i = 12;
        }
        if (lowGrade.equals("W")) {
            i = 13;
        }

        if (highGrade.equals("A+")) {
            j = 0;
        }

        if (highGrade.equals("A")) {
            j = 1;
        }
        if (highGrade.equals("A-")) {
            i = 2;
        }
        if (highGrade.equals("B+")) {
            j = 3;
        }
        if (highGrade.equals("B+")) {
            j = 4;
        }
        if (highGrade.equals("B-")) {
            j = 5;
        }
        if (highGrade.equals("C+")) {
            i = 6;
        }
        if (highGrade.equals("C")) {
            j = 7;
        }
        if (highGrade.equals("C-")) {
            j = 8;
        }
        if (highGrade.equals("D+")) {
            j = 9;
        }
        if (highGrade.equals("D")) {
            j = 10;
        }
        if (highGrade.equals("D-")) {
            j = 11;
        }
        if (highGrade.equals("F")) {
            j = 12;
        }
        if (highGrade.equals("W")) {
            j = 13;
        }

        int sum = 0;
        for (CourseProperties index : input) {

            for (int count = j; count <= i; count++) {
                sum += index.getGrades()[count];

            }


        }
        return sum;
    }

    /**
     *
     * @param input ArrayList containing all information on Courses
     * @return mean weighted average combining all Courses
     */
    public static double weightedMean(List<CourseProperties> input) {

        double sum = 0;
        int studentsEachCourse = 0;
        double weightedGradeAverage = 0;

        for (CourseProperties index : input) {
            for (int i = 0; i < index.getGrades().length; i++) {
                studentsEachCourse = index.getGrades()[i];
                sum += index.getAverage() * studentsEachCourse;
            }
        }

        weightedGradeAverage = sum / numberTotalStudentsSort(input);
        return weightedGradeAverage;

    }


}




