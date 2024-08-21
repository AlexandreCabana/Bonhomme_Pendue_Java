//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        String mot = "banane";
        String wordguest = "";
        for (int i =0; i<mot.length(); i++){
            wordguest += "_";
        }
        int nd = 0;
        int ndmax = 3;
        while (nd < ndmax) {
            nd++;
            System.out.println("Entre la lettre choisi ou le mot final");
            System.out.println(wordguest);
            String userinput;
            userinput = scanner.nextLine();
            if (userinput.equals(mot)) {
                System.out.println("Bravo! Vous avez deviné le mot en "+nd+" essaies. Le mot était "+ mot);
                break;
            }
            else if (mot.contains(userinput)) {
                System.out.println("La lettre que vous avez choisis est dans le mot secret. Vous êtes à " +nd+" essaies sur "+ndmax + ".");
                String newwordguest = "";
                for (int i=0;i<mot.length(); i++){
                    if (mot.charAt(i) == userinput.charAt(0)){
                        newwordguest += userinput;
                    } else if (wordguest.charAt(i) != '_'){
                        newwordguest += mot.charAt(i);
                    } else{
                        newwordguest += "_";
                    }
                }
                nd--;
                wordguest = newwordguest;
                if (wordguest.equals(mot)){
                    System.out.println("Bravo! Vous avez deviné le mot en "+nd+" essaies. Le mot était "+ mot);
                    System.exit(1);
                }
            }
            else{
                System.out.println("Wrong Guest");
            }
        }
    }
}