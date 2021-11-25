package blackjack;

import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author s1901562
 */
public class Blackjack {

public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    String kutsumanimi;
    String syotto; 

    System.out.println("Miten haluaisit sinua kutsuttavan?");
    syotto = scanner.nextLine();
    kutsumanimi = syotto;
    
   
     System.out.println(" - UUSI PELI ALKAA - ");    
    PelaajanKasi pelaaja = new PelaajanKasi(kutsumanimi);
    PelaajanKasi jakaja = new PelaajanKasi("Jakaja");
    boolean peliOhi = false;

   
   
        KorttiPakka pakka1 = new KorttiPakka();
        pakka1.sekoitaPakka();
        
        Kortti kortti1 = new Kortti(Arvo.ÄSSÄ, Maa.RISTI);
        pakka1.sekoitaPakka();

        pelaaja.otaKortti(pakka1.jaaSeuraavaKortti());
        pelaaja.otaKortti(pakka1.jaaSeuraavaKortti());
        pelaaja.getPelaajanKasi(false);

        jakaja.otaKortti(pakka1.jaaSeuraavaKortti());
        jakaja.otaKortti(pakka1.jaaSeuraavaKortti());
        jakaja.getPelaajanKasi(true);

        //PELAAJA
       do {
            System.out.println("Sinulla on "+ pelaaja.selvitäSumma());
            System.out.println("Haluatko " + pelaaja.getkutsumaNimi() + " Lisätä vai Jäädä? 'lisaa/jaa'");
           do { 
            syotto = scanner.nextLine();
            } while (!syotto.equalsIgnoreCase("jaa") && !syotto.equalsIgnoreCase("lisaa"));
            //LISÄÄ
            if (syotto.equalsIgnoreCase("lisaa")) {
                pelaaja.otaKortti(pakka1.jaaSeuraavaKortti());
                System.out.println(pelaaja.getkutsumaNimi()+ "nosti kortin.");
                System.out.println(pelaaja.getPelaajanKasi(false));
              
                if (pelaaja.selvitäSumma() > 21) {
                    System.out.println("Lisäsit ja sait yhteensä " + pelaaja.selvitäSumma() + ". Jakaja voittaa! ");
                   peliOhi = true;
                }
            }
            //JÄÄ
            if (syotto.equalsIgnoreCase("jaa")) {
                System.out.println("Jäät. Sinun käsi: " + pelaaja.selvitäSumma());
            }

        } while (syotto.equalsIgnoreCase("lisaa") && !peliOhi);

        //JAKAJA
        if (!peliOhi){
            System.out.println("");
            System.out.println("- Jakajan vuoro -");
            System.out.println(jakaja.getPelaajanKasi(false));
        }
        while (!peliOhi)
            
            if (jakaja.selvitäSumma() <= 15) {
                //NOSTA KORTTI
                jakaja.otaKortti(pakka1.jaaSeuraavaKortti());
                System.out.println(jakaja.getkutsumaNimi() + " nosti kortin");
                System.out.println(jakaja.getPelaajanKasi(false));
                if(jakaja.selvitäSumma() == 15){
                    System.out.println("Blackjack! Jakaja voitti.");
                    peliOhi = true;
                }
                if (jakaja.selvitäSumma() > 21) {
                    System.out.println("Jakaja otti lisää ja sai: " + jakaja.selvitäSumma() + ". " + pelaaja.getkutsumaNimi() + " voittaa!");
                     peliOhi = true;
                }
            } else {
                //JÄÄ
                System.out.println("Jakaja jäi!");
                int totalJakajaSumma = jakaja.selvitäSumma();
                int totalPelaajaSumma = pelaaja.selvitäSumma();

                if(totalJakajaSumma > totalPelaajaSumma){
                    System.out.println("Molemmat jää. Voittaja on: " + jakaja.getkutsumaNimi() + " jolla yhteensä: " +  totalJakajaSumma + ".");
                } else {
                    System.out.println("Molemmat jää. Voittaja on: " + pelaaja.getkutsumaNimi() + " jolla yhteensä: " + totalPelaajaSumma + ".");
                }
                 peliOhi = true;
            }
    }
}