import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StundentsTest {

    @BeforeEach
    public void setUp() {
        StudentManager.initialize(10); // Initialize with a size of 10 for testing
    }

    @Test
    public void testSaveStudent() {
        boolean result = StudentManager.addStudent(1, "John Doe", 20, "john.doe@example.com", "Mathematics");
        assertTrue(result, "Student should be added successfully");

        Students student = Students.searchStudent(1);
        assertNotNull(student, "Student should not be null");
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
        Students student = StudentManager.searchStudent(999); // An ID that does not exist
        assertNull(student, "Student should not be found");
    }

    @Test
    public void testDeleteStudent() {
        StudentManager.addStudent(3, "Alice Johnson", 21, "alice.johnson@example.com", "Chemistry");

        boolean result = StudentManager.deleteStudent(3);
        assertTrue(result, "Student should be deleted successfully");

        Students student = StudentManager.searchStudent(3);
        assertNull(student, "Student should not be found after deletion");
    }

    @Test
    public void testDeleteStudent_StudentNotFound() {
        boolean result = StudentManager.deleteStudent(999); // An ID that does not exist
        assertFalse(result, "Deletion should fail for a non-existent student");
    }
}
