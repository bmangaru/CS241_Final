import static org.junit.Assert.*;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class GradebookTest {

    @Test
    public void testNumOfLabs() {
        Map<String, Assignment> map_of_assignments = new HashMap<>();
        map_of_assignments.put("Lab 1", new Assignment("Lab 1", "Lab", 50, 54));
        map_of_assignments.put("Lab 2", new Assignment("Lab 2", "Lab", 45, 50));

        double[] result = Gradebook.num_of_labs(map_of_assignments);
        assertEquals(2, result[0]);
        assertEquals(95, result[1], 0.01);
        assertEquals(104, result[2], 0.01);
    }

    @Test
    public void testLabStats() {
        double num_of_labs = 2;
        double earned_points_from_labs = 95;
        double available_points_from_labs = 104;

        double avg_lab = Gradebook.lab_stats(num_of_labs, earned_points_from_labs, available_points_from_labs);
        assertEquals(0.913, avg_lab, 0.001);
    }

    @Test
    public void testNumOfQuizes() {
        Map<String, Assignment> map_of_assignments = new HashMap<>();
        map_of_assignments.put("Quiz 1", new Assignment("Quiz 1", "Quiz", 16, 18));
        map_of_assignments.put("Quiz 2", new Assignment("Quiz 2", "Quiz", 18, 20));

        double[] result = Gradebook.num_of_quizes(map_of_assignments);
        assertEquals(2, result[0]);
        assertEquals(34, result[1], 0.01);
        assertEquals(38, result[2], 0.01);
    }

    @Test
    public void testQuizStats() {
        double num_of_quizes = 2;
        double earned_points_from_quizes = 34;
        double available_points_from_quizes = 38;

        double avg_quiz = Gradebook.quiz_stats(num_of_quizes, earned_points_from_quizes, available_points_from_quizes);
        assertEquals(0.895, avg_quiz, 0.001);
    }

    @Test
    public void testFinalExam() {
        Map<String, Assignment> map_of_assignments = new HashMap<>();
        map_of_assignments.put("Final", new Assignment("Final", "Final", 123, 145));

        double[] result = Gradebook.final_exam(map_of_assignments);
        assertEquals(123, result[0], 0.01);
        assertEquals(145, result[1], 0.01);
    }

    @Test
    public void testFinalStats() {
        double earned_points_on_final = 123;
        double available_points_on_final = 145;

        double final_dec = Gradebook.final_stats(earned_points_on_final, available_points_on_final);
        assertEquals(0.848, final_dec, 0.001);
    }

    @Test
    public void testFinalNumGrade() {
        double lab_weight = 0.50;
        double avg_lab = 0.90;
        double quiz_weight = 0.20;
        double avg_quiz = 0.85;
        double final_weight = 0.30;
        double final_dec = 0.80;

        double final_number_grade = Gradebook.final_num_grade(lab_weight, avg_lab, quiz_weight, avg_quiz, final_weight, final_dec);
        assertEquals(87.50, final_number_grade, 0.01);
    }
}
