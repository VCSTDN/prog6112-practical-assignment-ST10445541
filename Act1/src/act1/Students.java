public class Students {
    private int ID;
    private String name;
    private int age;
    private String email;
    private String course;

    public Students(int ID, String name, int age, String email, String course) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "STUDENT ID: " + ID + "\n "
                + "STUDENT NAME: " + name + "\n"
                + "STUDENT AGE: " + age + "\n"
                + "STUDENT EMAIL: " + email + "\n"
                + "STUDENT COURSE: " + course;
    }
}
