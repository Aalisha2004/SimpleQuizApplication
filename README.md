# SimpleQuizApplication

SimpleQuizApplication
A basic Java console-based quiz application that tests the user's knowledge with multiple-choice questions. It features a built-in timer for each question and provides instant feedback on the user's answers.

Features
🧠 5 pre-defined multiple-choice questions

⏱️ 10-second countdown timer for each question

✅ Immediate feedback on correct/incorrect answers

🧾 Final score summary with correct answers displayed

📦 Written in pure Java with standard libraries (no external dependencies)

How It Works
The user is presented with one question at a time, each with four options.

A timer starts as soon as the question is displayed. If the user doesn’t answer within 10 seconds, the question is marked as skipped.

The user inputs the option number (1–4) as their answer.

At the end of the quiz, the final score and correct answers are displayed.

How to Run
Compile the code:

bash
Copy
Edit
javac SimpleQuizApplication.java
Run the application:

bash
Copy
Edit
java SimpleQuizApplication
Example
vbnet
Copy
Edit
What is the capital of India?
1. Mumbai
2. Delhi
3. Goa
4. Nagpur
Your answer (enter the option number): 2
Correct!

...
Quiz Finished!
Your final score is: 4/5
Question: What is the capital of India?
Correct answer: Delhi
...
Notes
If the user inputs an invalid response or exceeds the time limit, the question is marked incorrect.

You can expand the quiz by adding more questions and adjusting the timer if needed.
