import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseGraderTest {

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


    private static CourseGrader courseGrader;
    @Before
    public void setUp() throws Exception {
        Gson gson = new Gson();
        courseGrader = gson.fromJson(TESTER_JSON, CourseGrader.class);
    }

    @Test
    public void getSubject() {

        assertEquals("AAS", courseGrader.getSubject());
    }
    @Test
    public void getCRN() {

    }
    @Test
    public void getCourseNumber() {
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
    }

    @Test
    public void getAverage() {
    }
}