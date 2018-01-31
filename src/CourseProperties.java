
public class CourseProperties {
    /**
     * List of Data Fields in the array
     * Used Caps to match data in json files
     */
    private String Subject;
    private String Title;
    private String Section;
    private String Type;
    private String Instructor;
    private int CRN;
    private int Term;
    private int Number;
    private int[] Grades;
    private double Average;

    public CourseProperties(String subject) {

    }

    /**
     * Automatic Generation of Getters for the above elements.
     */
    public String getSubject() {
        return Subject;
    }

    public String getTitle() {
        return Title;
    }

    public String getSection() {
        return Section;
    }

    public String getType() {
        return Type;
    }

    public String getInstructor() {
        return Instructor;
    }

    public int getCRN() {
        return CRN;
    }

    public int getTerm() {
        return Term;
    }

    public int getNumber() {
        return Number;
    }

    public int[] getGrades() {
        return Grades;
    }

    public double getAverage() {
        return Average;
    }
}

