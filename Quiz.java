import java.util.*;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz {
    private static class Question {
        String question;
        List<String> options;
        int corOpt;

        public Question(String ques, List<String> options, int corOpt) {
            this.question = ques;
            this.options = options;
            this.corOpt = corOpt;
        }
    }

    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        questions.add(new Question("What is the pH value of the human body?", Arrays.asList(
                "1. 9.2 to 9.8",
                "2. 7.0 to 7.8",
                "3. 6.1 to 6.3",
                "4. 5.4 to 5.6"), 2));
        questions.add(new Question("The driving force of an ecosystem is _", Arrays.asList(
                "1. Carbon Mono oxide",
                "2. Biogas",
                "3. Solar Energy",
                "4. Carbon dioxide"), 3));
        questions.add(new Question("Which planet is known as the Red Planet?", Arrays.asList(
                "1. Earth",
                "2. Mars",
                "3. Jupiter",
                "4. Venus"), 2));
        questions.add(new Question("What is the capital of France?", Arrays.asList(
                "1. Berlin",
                "2. Madrid",
                "3. Paris",
                "4. Rome"), 3));
        questions.add(new Question("Which of the given vitamins is responsible for blood clotting?", Arrays.asList(
                "1. Vitamin A",
                "2. Vitamin B",
                "3. Vitamin K",
                "4. Vitamin D"), 3));
        questions.add(new Question("Which of the following is a root vegetable?", Arrays.asList(
                "1. Carrot",
                "2. Cassava",
                "3. Onion",
                "4. All the above"), 4));
        questions.add(new Question("Which of the following state of India is known as 'Silicon State'?", Arrays.asList(
                "1. Maharashtra",
                "2. Karnataka",
                "3. Bihar",
                "4. Jharkhand"), 2));
        questions.add(new Question("Name the National animal of India?", Arrays.asList(
                "1. Tiger",
                "2. Lion",
                "3. Rhino",
                "4. Peacock"), 1));
        questions.add(new Question("Digestion of food in human beings begins in which part of the alimentary canal?", Arrays.asList(
                "1. Liver",
                "2. Kidney",
                "3. Mouth",
                "4. Large intestine"), 3));
        questions.add(new Question("Salt is obtained from sea water through which process.", Arrays.asList(
                "1. Adsorption",
                "2. Evaporation",
                "3. Sublimation",
                "4. Absorption"), 2));

        int score = 0;
        int tpq = 25;

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("Ques " + (i + 1) + ": " + question.question);

            for (String option : question.options) {
                System.out.println(option);
            }

            System.out.println("You have " + tpq + " seconds to answer.");

            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\nTime's up! Moving to the next question.");
                    System.exit(0);
                }
            };

            timer.schedule(task, tpq * 1000);
            System.out.println("Enter your choice (1-4): ");
            int ans = sc.nextInt();
            timer.cancel();

            if (ans == question.corOpt) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + (question.corOpt) + "\n");
            }
        }

        System.out.println("Quiz Complete!");
        System.out.println("Your final Score: " + score + "/" + questions.size());
    }
}
