public class StudentDriver extends Driver {
    private String school;

    public StudentDriver(String name, String school) {
        super(name);
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

}
