import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] wordList = {"Piano", "Occur", "Faint", "Voice", "Value", "Float", "Quiet", "Sauce", "Noise"};
        String wordToGuess = generateWord(wordList).toLowerCase();
        int numberTries = 6;
        boolean gameWon = false;


        while(numberTries > 0 && !gameWon){
            System.out.println("Guess a 5 letter word.");
            StringBuilder currentWord = new StringBuilder();
            StringBuilder charInWord = new StringBuilder();

            numberTries--;
            String currentGuess = scanner.nextLine().toLowerCase();
            String feedback = makeGuess(currentGuess, wordToGuess);
            if(feedback.equals("GGGGG")){
                gameWon = true;
            }

            for(int i = 0; i<feedback.length(); i++){
                char currentChar = currentGuess.charAt(i);
                if(feedback.charAt(i) == 'G'){
                    currentWord.append(currentChar);
                }
                else if(feedback.charAt(i) == 'Y'){
                    currentWord.append("_");
                    charInWord.append(currentChar);
                }
                else{
                    currentWord.append("_");
                }
            }
            System.out.println(currentWord + ", " + charInWord + " letters in the word");
        }
        if(!gameWon){
            System.out.println("Sorry, you lose.");
        }
        else {
            System.out.println("Congrats, you guessed the word!");
        }
    }
    public static String makeGuess(String guess, String wordToGuess){
        StringBuilder feedback = new StringBuilder();
        for(int i = 0; i<guess.length(); i++){
            if(guess.charAt(i) == wordToGuess.charAt(i)){
                feedback.append("G");
            }
            else if(wordToGuess.contains(String.valueOf(guess.charAt(i)))){
                feedback.append("Y");
            }
            else {
                feedback.append("B");
            }
        }

        return feedback.toString();
    }



    public static String generateWord(String[] wordList){
        int i = (int)(Math.random()*wordList.length-1);
        return wordList[i];
    }
}
