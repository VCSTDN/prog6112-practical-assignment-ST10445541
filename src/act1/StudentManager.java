
import javax.swing.JOptionPane;

public class StudentManager {

    public static void main(String[] args) {
        String menu1 = "Please select one of the following menu items: \n"
                + "(1) Capture a new Student \n"
                + "(2) Search for a student \n"
                + "(3) Delete a student \n"
                + "(4) Print student report \n"
                + "(5) Exit Application";

        int size = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of students you want to manage"));
        Students[] us = new Students[size];
        int studentCount = 0;

        while (true) {
            String optionStr = JOptionPane.showInputDialog(menu1);
            int option = Integer.parseInt(optionStr);

            if (option == 1) { // Capture a new Student
                if (studentCount >= size) {
                    JOptionPane.showMessageDialog(null, "Student list is full.");
                    continue;
                }

                int id = Integer.parseInt(JOptionPane.showInputDialog("Enter student ID"));
                String name = JOptionPane.showInputDialog("Enter student name");
                int age = Integer.parseInt(JOptionPane.showInputDialog("Enter student age"));
                String email = JOptionPane.showInputDialog("Enter student email");
                String course = JOptionPane.showInputDialog("Enter student course");

                if (age > 16) { // Checks if age is valid
                    us[studentCount++] = new Students(id, name, age, email, course);
                    JOptionPane.showMessageDialog(null, "Student details have been captured.");
                } else {
                    JOptionPane.showMessageDialog(null, age + " is not a valid age.");
                }

            } else if (option == 2) { // Search for a student
                int searchID = Integer.parseInt(JOptionPane.showInputDialog("Enter the student ID that you would like to search for"));
                boolean found = false;

                for (int i = 0; i < studentCount; i++) {
                    if (us[i] != null && us[i].getID() == searchID) {
                        JOptionPane.showMessageDialog(null, "Student Found:\n" + us[i].toString());
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    JOptionPane.showMessageDialog(null, "Error: Student cannot be located.");
                }

            } else if (option == 3) { // Delete a student
                int deleteID = Integer.parseInt(JOptionPane.showInputDialog("Enter the student ID to delete"));
                boolean deleted = false;

                for (int i = 0; i < studentCount; i++) {
                    if (us[i] != null && us[i].getID() == deleteID) {
                        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the student with ID " + deleteID + "?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

                        if (confirm == JOptionPane.YES_OPTION) {
                            us[i] = null; // Remove student
                            JOptionPane.showMessageDialog(null, "Student has been deleted.");
                            deleted = true;
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Deletion canceled.");
                        }
                    }
                }

                if (!deleted) {
                    JOptionPane.showMessageDialog(null, "Error: Student cannot be located.");
                }

            } else if (option == 4) { // Print student report
                boolean hasStudents = false;
                StringBuilder report = new StringBuilder("Student Report:\n");

                for (int i = 0; i < studentCount; i++) {
                    if (us[i] != null) {
                        report.append(us[i].toString()).append("\n\n");
                        hasStudents = true;
                    }
                }

                if (hasStudents) {
                    JOptionPane.showMessageDialog(null, report.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "No student records found.");
                }

            } else if (option == 5) { // Exit Application
                JOptionPane.showMessageDialog(null, "Exiting...");
                break;

            } else {
                JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        }
    }
}
