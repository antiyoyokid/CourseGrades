import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CourseGraderTest {

    /**
     * **************************************************************************************************************************************
     * TESTS FROM STRINGS
     * **************************************************************************************************************************************
     */

    private static final String TESTER_ARRAY = "[{ \"CRN\": 41758, \"Subject\": \"AAS\", \"Number\": 100, \"Title\": \"Intro Asian American Studies\", \"Section\": \"AD1\", \"Type\": \"DIS\", \"Term\": 120138, \"Instructor\": \"Arai, Sayuri\", \"Grades\": [6, 16, 5, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0], \"Average\": 3.72 } ]";

    private static final String TESTER_JSON = "{\n" +
            "   \"CRN\":41758,\n" +
            "   \"Subject\":\"AAS\",\n" +
            "   \"Number\":100,\n" +
            "   \"Title\":\"Intro Asian American Studies\",\n" +
            "   \"Section\":\"AD1\",\n" +
            "   \"Type\":\"DIS\",\n" +
            "   \"Term\":120138,\n" +
            "   \"Instructor\":\"Arai, Sayuri\",\n" +
            "   \"Grades\":[  \n" +
            "      6,\n" +
            "      16,\n" +
            "      5,\n" +
            "      3,\n" +
            "      2,\n" +
            "      3,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0,\n" +
            "      0\n" +
            "   ],\n" +
            "   \"Average\":3.72\n" +
            "   }";

    private static CourseProperties courseGrader;
    private static CourseProperties courseGraderArray[];

    @Before
    public void setUp() {
        Gson gson = new Gson();
        courseGrader = gson.fromJson(TESTER_JSON, CourseProperties.class);
    }

    @Test
    public void getSubject() {
        assertEquals("AAS", courseGrader.getSubject());
    }

    @Test
    public void getCRN() {
        assertEquals(41758, courseGrader.getCRN());
    }

    @Test
    public void getNumber() {
        assertEquals(100, courseGrader.getNumber());
    }

    @Test
    public void getTitle() {
        assertEquals("Intro Asian American Studies", courseGrader.getTitle());
    }

    @Test
    public void getSection() {
        assertEquals("AD1", courseGrader.getSection());
    }

    @Test
    public void getType() {
        assertEquals("DIS", courseGrader.getType());
    }

    @Test
    public void getInstructor() {
        assertEquals("Arai, Sayuri", courseGrader.getInstructor());
    }

    @Test
    public void getTerm() {
        assertEquals(120138, courseGrader.getTerm());

    }

    @Test
    public void getAverage() {
        assertEquals(3.72, courseGrader.getAverage(), 0.01);

    }

    @Test
    public void getGrades() {
        Gson localGson = new Gson();
        courseGraderArray = localGson.fromJson(TESTER_ARRAY, CourseProperties[].class);
        int[] arrayTestGrades = {6, 16, 5, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(arrayTestGrades, courseGraderArray[0].getGrades());
    }

    /**
     * **********************************************************************************************************************************
     * TESTS FROM JSON
     * FILES*************************************************************************************************************
     * **********************************************************************************************************************************
     */
    private String[] files = {"Fake1.json", "Fake2.json", "Fake3.json", "Fake4.json"};
    private String[] empty = {};
    private String[] nullString = {null};

    @Test
    public void combineFile() {

        List<CourseProperties> combinedList = CourseGraderData.combineData(files);
        assertEquals(18, combinedList.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidCombineFile() {

        List<CourseProperties> combinedList = CourseGraderData.combineData(empty);
        assertEquals(18, combinedList.size());
    }

    @Test(expected = NullPointerException.class)
    public void invalidCombineFile1() {

        List<CourseProperties> combinedList = CourseGraderData.combineData(nullString);
        assertEquals(18, combinedList.size());
    }

    @Test
    public void SubjectFile() {
        String[] subjects = {"ABE", "ABE", "PSYC", "SHS", "VM", "AAS", "ABE", "ACCY", "FIN", "FIN",
                "FIN", "FR", "FR", "CPSC", "CS", "CS", "CS", "CS"};
        ArrayList<String> subjectList = new ArrayList<>(Arrays.asList(subjects));

        List<CourseProperties> subjectSorted;
        subjectSorted = CourseGraderData.combineData(files);
        ArrayList<String> work = new ArrayList<>();
        for (CourseProperties index : subjectSorted) {

            work.add(index.getSubject());

        }

        assertEquals(subjectList, work);

    }

    @Test(expected = IllegalArgumentException.class)
    public void SubjectFile1() {
        String[] subjects = {"ABE", "ABE", "PSYC", "SHS", "VM", "AAS", "ABE", "ACCY", "FIN", "FIN",
                "FIN", "FR", "FR", "CPSC", "CS", "CS", "CS", "CS"};
        List<String> subjectList = new ArrayList<>(Arrays.asList(subjects));

        List<CourseProperties> subjectSorted;
        subjectSorted = CourseGraderData.combineData(empty);
        ArrayList<String> work = new ArrayList<>();
        for (CourseProperties index : subjectSorted) {

            work.add(index.getSubject());

        }

        assertEquals(subjectList, work);

    }

    @Test
    public void subjectSort()

    {
        List<CourseProperties> joinedData;
        joinedData = CourseGraderData.combineData(files);
        String subject = "VM";

        List<CourseProperties> test = CourseGraderData.subjectSort(joinedData, subject);
        assertEquals(58861, test.get(0).getCRN());
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidSubjectSort1()

    {
        List<CourseProperties> joinedData;
        joinedData = CourseGraderData.combineData(empty);
        String subject = "VM";

        List<CourseProperties> test = CourseGraderData.subjectSort(joinedData, subject);
        assertEquals(58861, test.get(0).getCRN());
    }

    @Test
    public void multipleSubjectSort()

    {
        List<CourseProperties> joinedData;
        joinedData = CourseGraderData.combineData(files);
        String subject = "CS";

        List<CourseProperties> test = CourseGraderData.subjectSort(joinedData, subject);

        assertEquals(31129, test.get(3).getCRN());

    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidSubjectSort()

    {
        List<CourseProperties> joinedData;
        joinedData = CourseGraderData.combineData(files);
        String subject = "VM8";

        List<CourseProperties> test = CourseGraderData.subjectSort(joinedData, subject);
        assertEquals(58861, test.get(0).getCRN());
    }

    @Test(expected = NullPointerException.class)
    public void invalidSubjectSort2()

    {
        List<CourseProperties> joinedData;
        joinedData = CourseGraderData.combineData(nullString);
        String subject = "VM8";

        List<CourseProperties> test = CourseGraderData.subjectSort(joinedData, subject);
        assertEquals(58861, test.get(0).getCRN());
    }

    @Test
    public void instructorSort() {
        List<CourseProperties> joinedData = CourseGraderData.combineData(files);
        String instructor = "Neil";
        List<CourseProperties> test = CourseGraderData.instructorSort(joinedData, instructor);
        assertEquals(46819, test.get(0).getCRN());
    }

    @Test
    public void multipleInstructorSort() {
        List<CourseProperties> joinedData = CourseGraderData.combineData(files);
        String instructor = "Chin";
        List<CourseProperties> test = CourseGraderData.instructorSort(joinedData, instructor);
        assertEquals(60711, test.get(1).getCRN());
    }

    @Test // to see if it accepts commas
    public void multipleInstructorSort2() {
        List<CourseProperties> joinedData = CourseGraderData.combineData(files);
        String instructor = "Zhao,";
        List<CourseProperties> test = CourseGraderData.instructorSort(joinedData, instructor);
        assertEquals(31129, test.get(1).getCRN());
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidInstructorSort() {
        List<CourseProperties> joinedData = CourseGraderData.combineData(files);
        String instructor = "Gr12*ift";
        List<CourseProperties> test = CourseGraderData.instructorSort(joinedData, instructor);
        assertEquals(58927, test.get(0).getCRN());
    }

    @Test(expected = NullPointerException.class)
    public void invalidInstructorSort2() {
        List<CourseProperties> joinedData = CourseGraderData.combineData(nullString);
        String instructor = "Gr12*ift";
        List<CourseProperties> test = CourseGraderData.instructorSort(joinedData, instructor);
        assertEquals(58927, test.get(0).getCRN());
    }

    @Test
    public void numberSort() {
        List<CourseProperties> joinedData = CourseGraderData.combineData(files);
        int high = 157;
        int low = 155;
        List<CourseProperties> test = CourseGraderData.numberSort(joinedData, high, low);
        assertEquals(58606, test.get(0).getCRN());

    }

    @Test
    public void multipleNumberSort() {
        List<CourseProperties> joinedData = CourseGraderData.combineData(files);
        int high = 580;
        int low = 580;
        List<CourseProperties> test = CourseGraderData.numberSort(joinedData, high, low);
        assertEquals(60711, test.get(1).getCRN());

    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidNumberSort() {
        List<CourseProperties> joinedData = CourseGraderData.combineData(files);
        int high = 0;
        int low = -580;
        List<CourseProperties> test = CourseGraderData.numberSort(joinedData, high, low);
        assertEquals(60711, test.get(1).getCRN());

    }

    @Test(expected = NullPointerException.class)
    public void invalidNumberSort2() {
        List<CourseProperties> joinedData = CourseGraderData.combineData(nullString);
        int high = 0;
        int low = -580;
        List<CourseProperties> test = CourseGraderData.numberSort(joinedData, high, low);
        assertEquals(60711, test.get(1).getCRN());

    }

    @Test
    public void numberStudents() {
        List<CourseProperties> joinedData = CourseGraderData.combineData(files);
        int high = 30;
        int low = 30;
        List<CourseProperties> test = CourseGraderData.numberStudentsSort(joinedData, low, high);
        assertEquals(60711, test.get(0).getCRN());
    }

    @Test
    public void multipleNumberStudents() {
        List<CourseProperties> joinedData = CourseGraderData.combineData(files);
        int high = 121;
        int low = 121;
        List<CourseProperties> test = CourseGraderData.numberStudentsSort(joinedData, low, high);
        assertEquals(58861, test.get(0).getCRN());
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidNumberStudents() {
        List<CourseProperties> joinedData = CourseGraderData.combineData(files);
        int high = 121;
        int low = -121;
        List<CourseProperties> test = CourseGraderData.numberStudentsSort(joinedData, low, high);
        assertEquals(58861, test.get(0).getCRN());
    }

    @Test(expected = NullPointerException.class)
    public void invalidNumberStudents2() {
        List<CourseProperties> joinedData = CourseGraderData.combineData(nullString);
        int high = 121;
        int low = -121;
        List<CourseProperties> test = CourseGraderData.numberStudentsSort(joinedData, low, high);
        assertEquals(58861, test.get(0).getCRN());
    }

    @Test
    public void easySimpleSort() {
        List<CourseProperties> joinedData = CourseGraderData.combineData(files);
        double high = 3.08;
        double low = 3.08;
        List<CourseProperties> test = CourseGraderData.simpleEasyClassSort(joinedData, low, high);
        assertEquals(31020, test.get(0).getCRN());

    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidEasySimpleSort() {
        List<CourseProperties> joinedData = CourseGraderData.combineData(files);
        double high = -4.00;
        double low = 3.82;
        List<CourseProperties> test = CourseGraderData.simpleEasyClassSort(joinedData, low, high);
        assertEquals(51932, test.get(0).getCRN());

    }

    @Test(expected = NullPointerException.class)
    public void invalidEasySimpleSort2() {
        List<CourseProperties> joinedData = CourseGraderData.combineData(nullString);
        double high = -4.00;
        double low = 3.82;
        List<CourseProperties> test = CourseGraderData.simpleEasyClassSort(joinedData, low, high);
        assertEquals(51932, test.get(0).getCRN());

    }

    @Test
    public void mostASort() {
        List<CourseProperties> joinedData = CourseGraderData.combineData(files);
        int mostAces = 56;
        List<CourseProperties> test = CourseGraderData.mostAces(joinedData, mostAces);
        assertEquals(31018, test.get(0).getCRN());
    }

    @Test // tests multiple by accessing other indexes
    public void multipleMostASort() {
        List<CourseProperties> joinedData = CourseGraderData.combineData(files);
        int mostAces = 10;
        List<CourseProperties> test = CourseGraderData.mostAces(joinedData, mostAces);
        assertEquals(31129, test.get(4).getCRN());
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidMostASort() {
        List<CourseProperties> joinedData = CourseGraderData.combineData(files);
        int mostAces = -56;
        List<CourseProperties> test = CourseGraderData.mostAces(joinedData, mostAces);
        assertEquals(31018, test.get(0).getCRN());
    }

    @Test(expected = NullPointerException.class)
    public void invalidMostASort2() {
        List<CourseProperties> joinedData = CourseGraderData.combineData(nullString);
        int mostAces = -56;
        List<CourseProperties> test = CourseGraderData.mostAces(joinedData, mostAces);
        assertEquals(31018, test.get(0).getCRN());
    }

    @Test
    public void totalStudents() {
        List<CourseProperties> joinedData = CourseGraderData.combineData(files);

        int total = CourseGraderData.numberTotalStudentsSort(joinedData);
        assertEquals(1718, total);
    }

    @Test(expected = NullPointerException.class)
    public void totalStudents2() {
        List<CourseProperties> joinedData = CourseGraderData.combineData(nullString);

        int total = CourseGraderData.numberTotalStudentsSort(joinedData);
        assertEquals(1718, total);
    }

    @Test
    public void gradeStudents() {
        List<CourseProperties> joinedData = CourseGraderData.combineData(files);
        String aPlus = "A+";
        String a = "A";

        int total = CourseGraderData.StudentbyGrades(joinedData, a, aPlus);
        assertEquals(554, total);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidGradeStudents2() {
        List<CourseProperties> joinedData = CourseGraderData.combineData(empty);
        String aPlus = "A+";
        String a = "A";

        int total = CourseGraderData.StudentbyGrades(joinedData, a, aPlus);
        assertEquals(554, total);
    }

    @Test(expected = IllegalArgumentException.class)
    /*
     * Wrong Input for Grades
     */
    public void invalidGradeStudents() {
        List<CourseProperties> joinedData = CourseGraderData.combineData(files);
        String aPlus = "A+";
        String a = "O+";

        int total = CourseGraderData.StudentbyGrades(joinedData, a, aPlus);
        assertEquals(0, total);
    }

    @Test(expected = NullPointerException.class)
    public void invalidGradeStudents1() {
        List<CourseProperties> joinedData = CourseGraderData.combineData(nullString);
        String aPlus = "A+";
        String a = "O+";

        int total = CourseGraderData.StudentbyGrades(joinedData, a, aPlus);
        assertEquals(0, total);
    }

    @Test
    /*
     * Checking to see if higher and lower grades are given in reverse order
     */
    public void gradeStudentsFlipped() {
        List<CourseProperties> joinedData = CourseGraderData.combineData(files);
        String aPlus = "A";
        String a = "A+";

        int total = CourseGraderData.StudentbyGrades(joinedData, a, aPlus);
        assertEquals(554, total);
    }

    @Test
    public void weightedAverage() {
        List<CourseProperties> joinedData = CourseGraderData.combineData(files);

        double mean = CourseGraderData.weightedMean(joinedData);
        assertEquals(3.22, mean, 0.01);
    }

    @Test(expected = NullPointerException.class)
    public void invalidWeightedAverage1() {
        List<CourseProperties> joinedData = CourseGraderData.combineData(nullString);

        double mean = CourseGraderData.weightedMean(joinedData);
        assertEquals(3.22, mean, 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidWeightedAverage() {
        List<CourseProperties> joinedData = CourseGraderData.combineData(empty);

        double mean = CourseGraderData.weightedMean(joinedData);
        assertEquals(3.22, mean, 0.01);
    }

}
