import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseGraderTest {

    private static final String TESTER_ARRAY= "[{ \"CRN\": 41758, \"Subject\": \"AAS\", \"Number\": 100, \"Title\": \"Intro Asian American Studies\", \"Section\": \"AD1\", \"Type\": \"DIS\", \"Term\": 120138, \"Instructor\": \"Arai, Sayuri\", \"Grades\": [6, 16, 5, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0], \"Average\": 3.72 }]";

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
    @Before
    public void setUp() throws Exception {
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
        CourseProperties[] courseGraderArray = localGson.fromJson(TESTER_ARRAY,CourseProperties[].class);
        assertArrayEquals(new int[]{6, 16, 5, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0}, courseGraderArray[0].getGrades());
    }

    @Test
    public void getAverage() {
    }
}