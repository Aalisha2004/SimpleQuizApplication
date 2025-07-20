import java.util.*;

public class SimpleQuizApplication{
    private static final int TIMER_SECONDS=10;
    private static int score=0;
    private static Scanner scanner=new Scanner(System.in);


    public static void main(String[] args){
        String questions[][]={
            {"What is the capital of India?", "Mumbai", "Delhi", "Goa", "Nagpur"},
            {"Which planet is known as the Red Planet?", "Earth", "Mars", "Jupiter", "Saturn"},
            {"Who is known as Missile Man'?", "Dr.A.P.J.Abdul Kalam", "Mahatma Gandhi", "Dr. Babasaheb Ambedkar", "Rabendranath Taigor"},
            {"What is the square root of 64?", "6", "7", "8", "9"},
            {"Which element has the chemical symbol 'O'?", "Oxygen", "Gold", "Silver", "Iron"}
        };
        int correctAnswers[]={2, 2, 1, 3, 1};
        for(int i = 0; i < questions.length; i++){
            askQuestion(questions[i], correctAnswers[i]);
        }
        displayResults(questions,correctAnswers);
    }


    private static void askQuestion(String questionData[],int correctAnswers){
        System.out.println(questionData[0]);
        for(int i=1;i<questionData.length;i++){
            System.out.println(i+". "+questionData[i]);
        }
        int userAnswer=getUserAnswerWithTimer();
        if(userAnswer==correctAnswers){
            System.out.println("Correct!\n");
            score++;
        }else{
            System.out.println("Incorrect! The correct answer was: "+questionData[correctAnswers]+"\n");
        }
    }


    private static int getUserAnswerWithTimer(){
        final int userAnswer[]={-1};
        Timer timer=new Timer();
        TimerTask task=new TimerTask(){
            public void run(){
                System.out.println("\nTime's up!");
                userAnswer[0]=-1;  
            }
        };
        timer.schedule(task,TIMER_SECONDS*1000);
        try{
            System.out.print("Your answer (enter the option number): ");
            userAnswer[0]=scanner.nextInt();
        }catch(Exception e){
            userAnswer[0]=-1; 
        }finally{
            timer.cancel();  
        }
        return userAnswer[0];
    }


    private static void displayResults(String questions[][],int correctAnswers[]){
        System.out.println("Quiz Finished!");
        System.out.println("Your final score is: "+score+"/" +questions.length);
        for (int i=0;i<questions.length;i++){
            System.out.println("\nQuestion: "+questions[i][0]);
            System.out.println("Correct answer: "+questions[i][correctAnswers[i]]);
        }
    }
}