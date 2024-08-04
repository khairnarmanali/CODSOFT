import java.util.*;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz {

    static String[] questions = {
        "Q1.What is the capital of India?",
        "Q2.What is the largest planet in our solar system?",
        "Q3.What is the chemical symbol for Mercury?",
        "Q4.Who wrote 'To Kill a Mockingbird'?",
        "Q5.What is the boiling point of water?"
    };

    static String[][] options = {
        {"1. Mumbai", "2. New Delhi", "3. Pune", "4. Hydrabad"},
        {"1. Earth", "2. Jupiter", "3. Mars", "4. Venus"},
        {"1. Au", "2. Ag", "3. Pb", "4. Hg"},
        {"1. Mark Twain", "2. J.K. Rowling", "3. Harper Lee", "4. Ernest Hemingway"},
        {"1. 90°C", "2. 100°C", "3. 110°C", "4. 120°C"}
    };

    static int[] correctAnswers = {2, 2, 4, 3, 2};

    static int score = 0;
    static int questionIndex = 0;
    static boolean answered = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (questionIndex = 0; questionIndex < questions.length; questionIndex++) {
            answered = false;
            System.out.println("Question " + (questionIndex + 1) + ": " + questions[questionIndex]);
            for (String option : options[questionIndex]) {
                System.out.println(option);
            }

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (!answered) {
                        System.out.println("Time's up! Moving to the next question.");
                        questionIndex++;
                        if (questionIndex < questions.length) {
                            main(null);
                        } else {
                            displayResults();
                        }
                    }
                }
            }, 10000); // 10 seconds for each question

            System.out.print("Select an correct option among above: ");
            int userAnswer = sc.nextInt();
            answered = true;
            timer.cancel();

            if (userAnswer == correctAnswers[questionIndex]) {
                score++;
            }
            System.out.println();
        }

        displayResults();
        sc.close();
    }

    private static void displayResults() {
        System.out.println("Quiz Over!");
        System.out.println("\nYour final score is: " + score + "/" + questions.length +"\n");
        if(score==5){
            System.out.println("Congratulations! You've answered all Questions Correctly\n");
        }
        System.out.println("Correct Answers Summary:");
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            System.out.println("Your answer: " + options[i][correctAnswers[i] - 1]+"\n");
            
        }
        
    }
}
