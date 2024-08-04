import java.util.*;

public class studentreport{

    public static void main(String arg[]){

        Scanner sc = new Scanner(System.in);
        int marks[] = new int[6];
        int totalmarks = 0 ;
        int subjects = marks.length;

        //marks input
        System.out.println("Enter marks obtained at each subject out of 100 :");
        for(int i=0 ;i<subjects ;i++){
            System.out.print("Subject " + (i+1) + " : ");
            marks[i] = sc.nextInt();
            totalmarks += marks[i];
        }

        //AvgPercentage
         double avgpercentage = (double)totalmarks / subjects;

        //Grade
        char grade;
        if(avgpercentage >= 90){
            grade = 'A';
        }
        else if(avgpercentage >= 80){
            grade = 'B';
        }
        else if(avgpercentage >= 70){
            grade = 'C';
        }
        else if(avgpercentage >= 60){
            grade = 'D';
        }
        else{
            grade = 'F';
        }

        //Results
        System.out.println("Result :");
        System.out.println("Total Marks Obtained :" + totalmarks);
        System.out.println("Average Percentage :" +avgpercentage + "%");
        System.out.println("Grade :" + grade);
    }
}