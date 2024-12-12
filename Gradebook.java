
import java.util.HashMap;
import java.util.Map; 


public class Gradebook {

    //Method to determine the number of labs
    public static double[] num_of_labs(Map<String, Assignment> map_of_assignments) {
        double num_of_labs = 0;
        double points_earned_from_labs = 0;
        double availabe_points_from_labs = 0;
    
        for (Map.Entry<String, Assignment> entry : map_of_assignments.entrySet()) {

            // Check if the assignment type is "Lab"
            if (entry.getValue().getType().equals("Lab")) {
                num_of_labs++; 
    
                // Sum earned points from labs
                double a = entry.getValue().getEarned_points(); 
                points_earned_from_labs = points_earned_from_labs + a;

                // Sum avalibe points from labs
                double b = entry.getValue().getTotal_points(); 
                availabe_points_from_labs = availabe_points_from_labs + b;
            }
        }
        // Return both values in an array (index 0: num_of_labs, index 1: points_earned_from_labs)
        return new double[] { num_of_labs, points_earned_from_labs, availabe_points_from_labs};
    }
    
    //Method to determine possible ammout of points earnable

    public static double lab_stats (double num_of_labs, double earned_points_from_labs, double avaiable_points_from_labs){

        double lab_avg =  earned_points_from_labs/avaiable_points_from_labs;
        double lab_avg_percent = lab_avg *100;

        System.out.println("Lab stats: ");
        System.out.println("Number of labs: " + num_of_labs);
        System.out.println("Earned points from labs: " + earned_points_from_labs);
        System.out.println("Total avaliabe points from labs: " + avaiable_points_from_labs);
        System.out.println("Average lab score: " + lab_avg_percent);

        return lab_avg;
    }

    //Method to determine the number of quizes
    public static double[] num_of_quizes(Map<String, Assignment> map_of_assignments) {
        double num_of_quizes = 0;
        double points_earned_from_quizes = 0;
        double availabe_points_from_quizes = 0;
    
        for (Map.Entry<String, Assignment> entry : map_of_assignments.entrySet()) {

            // Check if the assignment type is "Quiz"
            if (entry.getValue().getType().equals("Quiz")) {
                num_of_quizes++; 
    
                // Sum earned points from quizes
                double a = entry.getValue().getEarned_points(); 
                points_earned_from_quizes = points_earned_from_quizes + a;

                // Sum avalibe points from quizes
                double b = entry.getValue().getTotal_points(); 
                availabe_points_from_quizes = availabe_points_from_quizes + b;
            }
        }
        return new double[] { num_of_quizes, points_earned_from_quizes, availabe_points_from_quizes};
    }


    public static double quiz_stats (double num_of_quizes, double earned_points_from_quizes, double avaiable_points_from_quizes){

        double quiz_avg =  earned_points_from_quizes/avaiable_points_from_quizes;
        double quiz_avg_percent = quiz_avg *100;

        System.out.println("Quiz stats: ");
        System.out.println("Number of quizes: " + num_of_quizes);
        System.out.println("Earned points from quizes: " + earned_points_from_quizes);
        System.out.println("Total avaliabe points from quizes: " + avaiable_points_from_quizes);
        System.out.println("Average quiz score: " + quiz_avg_percent);

        return quiz_avg;
    }


    public static double[] final_exam(Map<String, Assignment> map_of_assignments) {
        double points_earned_on_final = 0;
        double availabe_points_on_final = 0;
    
        for (Map.Entry<String, Assignment> entry : map_of_assignments.entrySet()) {

            // Check if the assignment type is "FINAL exam/project"
            if (entry.getValue().getType().equals("Final")) {
    
                double a = entry.getValue().getEarned_points(); 
                points_earned_on_final = a;

                double b = entry.getValue().getTotal_points(); 
                availabe_points_on_final = b;
            }
        }
        return new double[] {points_earned_on_final,availabe_points_on_final};
    }

    public static double final_stats (double earned_points_on_final, double avaiable_points_on_final){

        double final_dec =  earned_points_on_final/avaiable_points_on_final;
        double final_percent = final_dec *100;

        System.out.println("Final project/exam stats: ");
        System.out.println("Earned points on final: " + earned_points_on_final);
        System.out.println("Total avaliabe points on final: " + avaiable_points_on_final);
        System.out.println("Final project/exam score: " + final_percent);

        return final_dec;
    }

    public static double final_num_grade(double lab_weight, double avg_lab, double quiz_weight, double avg_quiz, double final_weight, double final_dec) {
        double lab_calc = lab_weight * avg_lab;
        double quiz_calc = quiz_weight * avg_quiz;
        double final_calc = final_weight * final_dec;
    
        double final_number_grade = lab_calc + quiz_calc + final_calc;
        final_number_grade = final_number_grade * 100;

        return final_number_grade;
    }
    
    public static void main(String[] args) {
        

        //Grading System here
        double lab_weight = .50;
        double quiz_weight = .20;
        double final_weight = .30;


        // Make new assignment objects here:

        Assignment Lab1 = new Assignment("Lab 1", "Lab", 50, 54);
        Assignment Lab2 = new Assignment("Lab 2", "Lab", 45, 50);
        Assignment Lab3 = new Assignment("Lab 3", "Lab", 48, 55);
        Assignment Lab4 = new Assignment("Lab 4", "Lab", 42, 50);
        Assignment Lab5 = new Assignment("Lab 5", "Lab", 44, 52);
        Assignment Lab6 = new Assignment("Lab 6", "Lab", 46, 54);
        Assignment Lab7 = new Assignment("Lab 7", "Lab", 47, 53);
        Assignment Lab8 = new Assignment("Lab 8", "Lab", 41, 49);
        Assignment Lab9 = new Assignment("Lab 9", "Lab", 49, 56);
        Assignment Lab10 = new Assignment("Lab 10", "Lab", 43, 51);
        Assignment Lab11 = new Assignment("Lab 11", "Lab", 46, 53);
        Assignment Lab12 = new Assignment("Lab 12", "Lab", 45, 48);
        
        Assignment Quiz1 = new Assignment("Quiz 1", "Quiz", 16, 18);
        Assignment Quiz2 = new Assignment("Quiz 2", "Quiz", 18, 20);
        Assignment Quiz3 = new Assignment("Quiz 3", "Quiz", 15, 17);
        Assignment Quiz4 = new Assignment("Quiz 4", "Quiz", 17, 19);
        Assignment Quiz5 = new Assignment("Quiz 5", "Quiz", 19, 22);
        Assignment Quiz6 = new Assignment("Quiz 6", "Quiz", 16, 17);

        
        Assignment Final = new Assignment("Final", "Final", 123,145);


        // Add assignments to the HashMap here:
        Map<String, Assignment> map_of_assignments = new HashMap<>();

        map_of_assignments.put(Lab1.getName(), Lab1);
        map_of_assignments.put(Lab2.getName(), Lab2);
        map_of_assignments.put(Lab3.getName(), Lab3);
        map_of_assignments.put(Lab4.getName(), Lab4);
        map_of_assignments.put(Lab5.getName(), Lab5);
        map_of_assignments.put(Lab6.getName(), Lab6);
        map_of_assignments.put(Lab7.getName(), Lab7);
        map_of_assignments.put(Lab8.getName(), Lab8);
        map_of_assignments.put(Lab9.getName(), Lab9);
        map_of_assignments.put(Lab10.getName(), Lab10);
        map_of_assignments.put(Lab11.getName(), Lab11);
        map_of_assignments.put(Lab12.getName(), Lab12);
        
        

        map_of_assignments.put(Quiz1.getName(), Quiz1);
        map_of_assignments.put(Quiz2.getName(), Quiz2);
        map_of_assignments.put(Quiz3.getName(), Quiz3);
        map_of_assignments.put(Quiz4.getName(), Quiz4);
        map_of_assignments.put(Quiz5.getName(), Quiz5);
        map_of_assignments.put(Quiz6.getName(), Quiz6);

        map_of_assignments.put(Final.getName(), Final);

        //LABS CLACULATIONS
        double[] lab_results = num_of_labs(map_of_assignments);
        double num_of_labs = lab_results[0];
        double earned_points_from_labs = lab_results[1];
        double avaiable_points_from_labs = lab_results[2];
        double avg_lab = lab_stats(num_of_labs, earned_points_from_labs, avaiable_points_from_labs);

        System.out.println("");
        //Quiz CALCULATIONS
        double[] quiz_results = num_of_quizes(map_of_assignments);
        double num_of_quizes = quiz_results[0];
        double earned_points_from_quizes = quiz_results[1];
        double avaiable_points_from_quizes = quiz_results[2];
        double avg_quiz = quiz_stats(num_of_quizes, earned_points_from_quizes, avaiable_points_from_quizes);


        System.out.println("");
        //Final project/exam CALCULATIONS
        double [] final_results = final_exam(map_of_assignments);
        double earned_points_on_final = final_results[0];
        double avaiable_points_on_final = final_results[1];
        double final_dec = final_stats(earned_points_on_final, avaiable_points_on_final);

        double final_grade_percent = final_num_grade(lab_weight, avg_lab, quiz_weight, avg_quiz, final_weight, final_dec);

        // Initialize GradeTree and insert grade thresholds
        GradeTree gradeTree = new GradeTree();
        gradeTree.insert(97, "A+");
        gradeTree.insert(93, "A");
        gradeTree.insert(90, "A-");
        gradeTree.insert(87, "B+");
        gradeTree.insert(83, "B");
        gradeTree.insert(80, "B-");
        gradeTree.insert(77, "C+");
        gradeTree.insert(73, "C");
        gradeTree.insert(70, "C-");
        gradeTree.insert(67, "D+");
        gradeTree.insert(63, "D");
        gradeTree.insert(60, "D-");
        gradeTree.insert(0, "F");


        System.out.println("");
        // Get the letter grade based on the final number grade
        String finalLetterGrade = gradeTree.getLetterGrade(final_grade_percent);
        System.out.println("Final letter grade: " + finalLetterGrade);
        System.out.println("Final number grade: " + final_grade_percent);
        }
}

