import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Constants for grading
        final int MAX_MARKS_PER_SUBJECT = 100;
        final int A_GRADE_THRESHOLD = 90;
        final int B_GRADE_THRESHOLD = 80;
        final int C_GRADE_THRESHOLD = 70;
        final int D_GRADE_THRESHOLD = 60;

        // Input: Take marks obtained in each subject
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        int totalMarks = 0;
        
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + " (out of " + MAX_MARKS_PER_SUBJECT + "): ");
            int marks = scanner.nextInt();
            
            if (marks < 0 || marks > MAX_MARKS_PER_SUBJECT) {
                System.out.println("Invalid input. Marks should be between 0 and " + MAX_MARKS_PER_SUBJECT + ". Please try again.");
                i--; // Decrement i to re-enter marks for the current subject.
            } else {
                totalMarks += marks;
            }
        }
        
        // Calculate total marks and average percentage
        double averagePercentage = (double) totalMarks / (numSubjects * MAX_MARKS_PER_SUBJECT) * 100;

        // Grade Calculation
        char grade;
        
        if (averagePercentage >= A_GRADE_THRESHOLD) {
            grade = 'A';
        } else if (averagePercentage >= B_GRADE_THRESHOLD) {
            grade = 'B';
        } else if (averagePercentage >= C_GRADE_THRESHOLD) {
            grade = 'C';
        } else if (averagePercentage >= D_GRADE_THRESHOLD) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display Results
        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}

