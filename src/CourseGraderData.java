import com.google.gson.Gson;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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


    public static ArrayList<CourseProperties> combineData(String[] input) {

        if (input.length == 0) throw new IllegalArgumentException(Errors.STRING_ARRAY_ERROR);

        if (input == null) throw new IllegalArgumentException(Errors.STRING_ARRAY_ERROR);


        List<String> dataFileNames = Arrays.asList(input);

        ArrayList<CourseProperties> myCourses = new ArrayList<>();
        Gson test = new Gson();
        /*
        Perhaps the most powerful line in this entire program. Returns arrayList combining JSON files
        Converts dataFile to string, Json makes string into Array, to make the program work Array to ArrayList
         */
        for (int i = 0; i < dataFileNames.size(); i++) {
            ArrayList<CourseProperties> combined = new ArrayList<>(Arrays.asList(test.fromJson
                    (Data.getFileContentsAsString(dataFileNames.get(i)), CourseProperties[].class)));

            myCourses.addAll(combined);
        }
        return myCourses;
    }

    /**
     * **********************************************************************************************************************************************
     * METHODS IN PART 3 OF CODING ASSIGNMENT
     * <p>
     * - most of the methods use for each loop and return a new ArrayList by modifying the initial ArrayList
     * **********************************************************************************************************************************************
     *
     * @param input   ArrayList containing all courses
     * @param subject Subject the user is searching for
     * @return new Array list with information on matching subjects
     */

    public static ArrayList<CourseProperties> subjectSort(List<CourseProperties> input, String subject) {

        if (input.size() == 0) throw new IllegalArgumentException(Errors.ARRAY_LIST_ERROR);

        /**
         * From StackOverFlow https://stackoverflow.com/questions/24191040/checking-to-see-if-a-string-is-letters-spaces-only
         */
        subject = subject.toUpperCase();
        Pattern p = Pattern.compile("^[a-zA-Z, ]*$");
        Matcher m = p.matcher(subject);
        boolean b = m.matches();
        if (b == false) {
            throw new IllegalArgumentException(Errors.STRING_ERROR);
        }


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
    public static ArrayList<CourseProperties> instructorSort(List<CourseProperties> input, String partOfName) {
        if (input.size() == 0) throw new IllegalArgumentException(Errors.ARRAY_LIST_ERROR);

        /**
         * From StackOverFlow https://stackoverflow.com/questions/24191040/checking-to-see-if-a-string-is-letters-spaces-only
         */
        Pattern p = Pattern.compile("^[a-zA-Z, ]*$");
        Matcher m = p.matcher(partOfName);
        boolean b = m.matches();
        if (b == false) {
            throw new IllegalArgumentException(Errors.STRING_ERROR);
        }

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
        if (input.size() == 0) throw new IllegalArgumentException(Errors.ARRAY_LIST_ERROR);
        if (minCourseNumber < 0 || maxCourseNumber < 0) throw new IllegalArgumentException(Errors.INT_ERROR);

        if (minCourseNumber > maxCourseNumber) {
            int temp = minCourseNumber;
            minCourseNumber = maxCourseNumber;
            maxCourseNumber = temp;

        }


        ArrayList<CourseProperties> sortedNumber = new ArrayList<>();

        for (CourseProperties index : input) {

            if (index.getNumber() <= maxCourseNumber && index.getNumber() >= minCourseNumber) {

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
        if (input.size() == 0) throw new IllegalArgumentException(Errors.ARRAY_LIST_ERROR);
        if (minStudent < 0 || maxStudent < 0) throw new IllegalArgumentException(Errors.INT_ERROR);
        if (minStudent > maxStudent) {
            int temp = minStudent;
            minStudent = maxStudent;
            maxStudent = temp;
        }


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
        if (input.size() == 0) throw new IllegalArgumentException(Errors.ARRAY_LIST_ERROR);
        if (minAvg < 0 || maxAvg < 0) {
            throw new IllegalArgumentException(Errors.DOUBLE_ERROR);
        }
        if (minAvg > maxAvg) {
            double temp = minAvg;
            minAvg = maxAvg;
            maxAvg = temp;

        }

        ArrayList<CourseProperties> sortedSimpleEasy = new ArrayList<>();

        for (CourseProperties index : input) {
            if (index.getAverage() >= minAvg && index.getAverage() <= maxAvg) {

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
        if (input.size() == 0) throw new IllegalArgumentException(Errors.ARRAY_LIST_ERROR);
        if (minAplus < 0) {
            throw new IllegalArgumentException(Errors.INT_ERROR);
        }

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
        if (input.size() == 0) throw new IllegalArgumentException(Errors.ARRAY_LIST_ERROR);
        int sum = 0;
        for (CourseProperties index : input) {

            for (int i = 0; i < index.getGrades().length; i++) {
                sum += index.getGrades()[i];
            }

        }
        return sum;
    }

    /**
     * @param input     ArrayList containing all Course information
     * @param lowGrade  Worser Grade
     * @param highGrade Better Grade
     * @return number of students who have a range of Grades between low and high Grades.
     */
    public static int StudentbyGrades(List<CourseProperties> input, String lowGrade, String highGrade) {
        if (input.size() == 0) throw new IllegalArgumentException(Errors.ARRAY_LIST_ERROR);


        int i = -1;
        int j = -1;
        String[] letterGrades = {"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F", "W"};

        for (int k = 0; k < letterGrades.length; k++) {
            if (lowGrade.equals(letterGrades[k])) {
                i = k;
            }
            if (highGrade.equals(letterGrades[k])) {
                j = k;
            }


        }
        if (i == -1 || j == -1) {
            throw new IllegalArgumentException(Errors.STRING_ERROR);
        }


        int sum = 0;

        if (j > i) {
            int temp = j;
            j = i;
            i = temp;

        }

        for (CourseProperties index : input) {

            for (int count = j; count <= i; count++) {
                sum += index.getGrades()[count];

            }


        }
        return sum;
    }

    /**
     * @param input ArrayList containing all information on Courses
     * @return mean weighted average combining all Courses
     */
    public static double weightedMean(List<CourseProperties> input) {
        if (input.size() == 0) throw new IllegalArgumentException(Errors.ARRAY_LIST_ERROR);


        double sum = 0;
        int studentsEachCourse;
        double weightedGradeAverage;

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




