import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = "banane";
        String wordguest = GenerateHiddenWord(word.length());
        int numberofguess = 0;
        int maxguess = 4;
        while (numberofguess < maxguess) {
            System.out.println("Le mot actuel est: "+wordguest);
            String userinput = AskUserWord(scanner);
            if (PlayerWin(word,userinput)) {
                Victory(numberofguess, maxguess, word);
                break;
            }
            else if (word.contains(userinput)) {
                wordguest = AddLetterToHiddenWord(word, userinput, wordguest);
                if (PlayerWin(word, wordguest)){
                    Victory(numberofguess, maxguess, word);
                    System.exit(1);
                }
                else {
                    numberofguess = WrongGuess(numberofguess, maxguess);
                }
            }
            else{
                numberofguess = WrongGuess(numberofguess, maxguess);
            }
        }
    }
    public static String AskUserWord(Scanner scanner){
        System.out.println("Entre la lettre choisi ou le mot final");
        return scanner.nextLine();
    }
    public static String GenerateHiddenWord(int lenofword){
        String hiddenword = "";
        for (int i =0; i<lenofword; i++){
            hiddenword += "_";
        }
        return hiddenword;
    }
    public static boolean PlayerWin(String reponse, String userinput){
        return reponse.equals(userinput);
    }
    public static void Victory(int numberofguess, int numberofguessmax, String word){
        System.out.println("Bravo! Vous avez deviné le mot. Vous êtes à " + numberofguess +" essaies sur "+numberofguessmax + ". Le mot était "+ word);
    }
    public static String AddLetterToHiddenWord(String word, String letter, String CurrentGuessWord){
        String response = "";
        for (int i=0;i<word.length(); i++){
            if (word.charAt(i) == letter.charAt(0)){
                response += letter.charAt(0);
            } else if (CurrentGuessWord.charAt(i) != '_'){
                response += word.charAt(i);
            } else{
                response += "_";
            }
        }
        return response;
    }
    public static int WrongGuess(int guesscount, int guessmaxtry){
        guesscount++;
        System.out.println("La lettre que vous avez choisis est dans le mot secret. Vous êtes à " + guesscount +" essaies sur "+ guessmaxtry + ".");
        return guesscount;
    }
}