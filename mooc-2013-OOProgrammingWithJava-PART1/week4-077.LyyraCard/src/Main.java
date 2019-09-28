
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // add here code that tests LyraCard. However before doing 77.6 remove the
        // other code 
        LyyraCard pekka = new LyyraCard(20.0);
        LyyraCard brian = new LyyraCard(30.0);
        pekka.payGourmet();
        brian.payEconomical();
        printCards(pekka, brian);
        pekka.loadMoney(20.0);
        brian.payGourmet();
        printCards(pekka, brian);
        pekka.payEconomical();
        pekka.payEconomical();
        brian.loadMoney(50.0);
        printCards(pekka, brian);
    }
    
    private static void printCards(LyyraCard pekka, LyyraCard brian) {
        System.out.println("Pekka: " + pekka);
        System.out.println("Brian: " + brian);
    }
}
