import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static final int MAXGUESS = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = GetWord("C:\\Users\\6313326\\IdeaProjects\\Bonhomme_Pendue\\liste_francais.txt");
        String wordguest = GenerateHiddenWord(word.length());
        int numberofguess = 0;
        while (numberofguess < MAXGUESS) {
            DrawHangMen(numberofguess);
            System.out.println("Le mot actuel est: "+ wordguest);
            String userinput = AskUserWord(scanner);
            if (PlayerWin(word,userinput)) {
                Victory(numberofguess, MAXGUESS, word);
                break;
            }
            else if (word.contains(userinput)) {
                wordguest = AddLetterToHiddenWord(word, userinput, wordguest);
                if (PlayerWin(word, wordguest)){
                    Victory(numberofguess, MAXGUESS, word);
                    System.exit(1);
                }
                else {
                    numberofguess = GoodGuess(numberofguess, MAXGUESS);
                }
            }
            else{
                numberofguess = WrongGuess(numberofguess, MAXGUESS);
            }
        }
        if (numberofguess == MAXGUESS) {
            System.out.println("Vous avez perdu. Le mot était " + word);
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
        System.out.println("La lettre que vous avez choisis n'est pas dans le mot secret. Vous êtes à " + guesscount +" essaies sur "+ guessmaxtry + ".");
        return guesscount;
    }
    public static int GoodGuess(int guesscount, int guessmaxtry){
        System.out.println("La lettre que vous avez choisis est dans le mot secret. Vous êtes à " + guesscount +" essaies sur "+ guessmaxtry + ".");
        return guesscount;
    }
    public static String GetWord(String filename) {
        List<String> wordlist = GetWordList(filename);
        Random rand = new Random();
        return wordlist.get(rand.nextInt(wordlist.size()));
    }

    private static List<String>GetWordList(String filename){
        List<String> list = new ArrayList<String>();
        File file = new File(filename);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"ISO-8859-1"));
            String text = null;

            while ((text = reader.readLine()) != null) {
                list.add(text);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }
        return list;
    }
    public static void DrawHangMen(int numbefOfGuess){
        if (numbefOfGuess==6){
            System.out.println("  ------");
            System.out.println("  |    |");
            System.out.println("  O    |");
            System.out.println(" /|\\   |");
            System.out.println(" / \\   |");
            System.out.println("       |");
            System.out.println("--------- ");
        }
        else if (numbefOfGuess==5){
            System.out.println("  ------");
            System.out.println("  |    |");
            System.out.println("  O    |");
            System.out.println(" /|\\   |");
            System.out.println(" /      |");
            System.out.println("       |");
            System.out.println("--------- ");
        }
        else if (numbefOfGuess==4){
            System.out.println("  ------");
            System.out.println("  |    |");
            System.out.println("  O    |");
            System.out.println(" /|\\   |");
            System.out.println("        |");
            System.out.println("       |");
            System.out.println("--------- ");
        }
        else if (numbefOfGuess==3){
            System.out.println("  ------");
            System.out.println("  |    |");
            System.out.println("  O    |");
            System.out.println(" /|    |");
            System.out.println("       |");
            System.out.println("       |");
            System.out.println("--------- ");
        }
        else if (numbefOfGuess==2){
            System.out.println("  ------");
            System.out.println("  |    |");
            System.out.println("  O    |");
            System.out.println("  |    |");
            System.out.println("       |");
            System.out.println("       |");
            System.out.println("--------- ");
        }
        else if (numbefOfGuess==1){
            System.out.println("  ------");
            System.out.println("  |    |");
            System.out.println("  O    |");
            System.out.println("       |");
            System.out.println("       |");
            System.out.println("       |");
            System.out.println("--------- ");
        }
        else if (numbefOfGuess==0) {
            System.out.println("  ------");
            System.out.println("  |    |");
            System.out.println("       |");
            System.out.println("       |");
            System.out.println("       |");
            System.out.println("       |");
            System.out.println("--------- ");
        }
    }
}
/*
    <h1>salut</h1>
 */