import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CourseGraderTest {

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

    }

    @Test
    public void getNumber() {
    }

    @Test
    public void getTitle() {
    }

    @Test
    public void getSection() {
    }

    @Test
    public void getType() {
    }

    @Test
    public void getInstructor() {
    }

    @Test
    public void getTerm() {
    }

    @Test
    public void getGrades() {
        Gson localGson = new Gson();
        courseGraderArray = localGson.fromJson(TESTER_ARRAY, CourseProperties[].class);
        int[] arrayTestGrades = {6, 16, 5, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(arrayTestGrades, courseGraderArray[0].getGrades());
    }

    @Test
    public void getAverage() {

    }

    @Test
    public void combineFile() {
        String[] lol = {"Fake2.json", "Fake1.json"};
        List<CourseProperties> aishik = new ArrayList<CourseProperties>();
        aishik = CourseGraderData.combinedData(lol);
        for (CourseProperties index : aishik) {

        }
        assertEquals(17, aishik.size());
    }

    @Test
    public void SubjectFile() {
        String[] subjects = {"AAS", "ABE", "ABE", "ABE", "ABE", "ABE", "ABE", "ACCY"};
        List<String> please = new ArrayList<String>(Arrays.asList(subjects));


        String[] lol = {"Fake2.json"};
        List<CourseProperties> aishik = new ArrayList<CourseProperties>();
        aishik = CourseGraderData.combinedData(lol);
        ArrayList<String> work = new ArrayList<>();
        for (CourseProperties index : aishik) {

            work.add(index.getSubject());

        }

        assertEquals(please, work);


    }

    String[] files = {"Fake1.json", "Fake2.json"};
    @Test
    public void subjectSort()

    {
        List<CourseProperties> trial2;
        trial2 = CourseGraderData.combinedData(files);
        String subject = "VM";

        List<CourseProperties> test = CourseGraderData.subjectSort(trial2, subject);
        assertEquals(58861, test.get(0).getCRN());
    }
    @Test
    public void instructorSort()
    {
        List<CourseProperties> trial2 = CourseGraderData.combinedData(files);
        String instructor = "Grift";
        List<CourseProperties> test = CourseGraderData.instructortSort(trial2, instructor);
        assertEquals(58927, test.get(0).getCRN());
    }

    @Test
    public void numberSort (){
        List<CourseProperties> trial2 = CourseGraderData.combinedData(files);
        int high = 102;
        int low = 98;
        List<CourseProperties> test = CourseGraderData.numberSort(trial2,low,high);
        assertEquals(51932, test.get(0).getCRN());

    }

    @Test
    public void numberStudents(){
        List<CourseProperties> trial2 = CourseGraderData.combinedData(files);
        int high = 121;
        int low = 121;
        List<CourseProperties> test = CourseGraderData.numberStudentsSort(trial2,low,high);
        assertEquals(58861, test.get(0).getCRN());
    }
    @Test
    public void easySimpleSort(){
        List<CourseProperties> trial2 = CourseGraderData.combinedData(files);
        double high = 4.00;
        double low = 3.82;
        List<CourseProperties> test = CourseGraderData.simpleEasyClassSort(trial2,low,high);
        assertEquals(51932, test.get(0).getCRN());

    }
    @Test
    public void mostASort(){
        List<CourseProperties> trial2 = CourseGraderData.combinedData(files);
        int mostAces = 11 ;
        List<CourseProperties> test = CourseGraderData.mostAces(trial2,mostAces);
        assertEquals(51932, test.get(0).getCRN());
    }
    String[] fakeFiles =  {"Fake3.json"};
    @Test
    public void totalStudents(){
        List<CourseProperties> trial2 = CourseGraderData.combinedData(fakeFiles);

        int total = CourseGraderData.numberTotalStudentsSort(trial2);
        assertEquals(154, total);
    }
    String[] fakeFiles1 =  {"Fake4.json"};
    @Test
    public void gradeStudents(){
        List<CourseProperties> trial2 = CourseGraderData.combinedData(fakeFiles1);
        String aPlus = "A+";
        String a = "A";

        int total = CourseGraderData.StudentbyGrades(trial2,a,aPlus);
        assertEquals(36, total);
    }

    @Test
    public void weightedAverage(){
        List<CourseProperties> trial2 = CourseGraderData.combinedData(fakeFiles);

        double mean = CourseGraderData.weightedMean(trial2);
        assertEquals(2.91, mean,0.01);
    }





    }









