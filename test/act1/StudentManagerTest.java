import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentManagerTest {

    @BeforeEach
    public void setUp() {
        StudentManager.initialize(10); // Initialize with a size of 10 for testing
    }

    @Test
    public void testAddStudent() {
        StudentManager.addStudent(1, "John Doe", 20, "john.doe@example.com", "Mathematics");
        Students student = StudentManager.searchStudent(1);
        assertNotNull(student, "Student should be found");
        assertEquals(1, student.getID(), "Student ID should be 1");
        assertEquals("John Doe", student.getName(), "Student name should be John Doe");
        assertEquals(20, student.getAge(), "Student age should be 20");
        assertEquals("john.doe@example.com", student.getEmail(), "Student email should be john.doe@example.com");
        assertEquals("Mathematics", student.getCourse(), "Student course should be Mathematics");
    }

    @Test
    public void testSearchStudent() {
        StudentManager.addStudent(2, "Jane Smith", 22, "jane.smith@example.com", "Physics");
        Students student = StudentManager.searchStudent(2);
        assertNotNull(student, "Student should be found");
        assertEquals(2, student.getID(), "Student ID should be 2");
        assertEquals("Jane Smith", student.getName(), "Student name should be Jane Smith");
        assertEquals(22, student.getAge(), "Student age should be 22");
        assertEquals("jane.smith@example.com", student.getEmail(), "Student email should be jane.smith@example.com");
        assertEquals("Physics", student.getCourse(), "Student course should be Physics");
    }

    @Test
    public void testSearchStudent_StudentNotFound() {
        Students student = StudentManager.searchStudent(999); // Assuming 999 does not exist
        assertNull(student, "Student should not be found");
    }

    @Test
    public void testDeleteStudent() {
        StudentManager.addStudent(3, "Emily Davis", 23, "emily.davis@example.com", "Biology");
        StudentManager.deleteStudent(3);
        Students student = StudentManager.searchStudent(3);
        assertNull(student, "Student should be deleted and not found");
    }

    @Test
    public void testDeleteStudent_StudentNotFound() {
        StudentManager.deleteStudent(999); // Assuming 999 does not exist
        // Since no exception is expected, no assertion here
    }
}
