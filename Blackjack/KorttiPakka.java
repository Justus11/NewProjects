package blackjack;

import java.util.ArrayList;
import java.util.Collections;
/**
 *'
 * @author s1901562
 */
public class KorttiPakka {

private final ArrayList<Kortti> kortit;

private int nykyinenKortti; //index of next Card to be deal (0-51)
private static int NUMERO_KORTTEJA = 52; //Constant number of cards

public KorttiPakka(){
 kortit = new ArrayList<Kortti>();
    for (Maa maa : Maa.values()) {
        for (Arvo arvo : Arvo.values()){
            kortit.add(new Kortti(arvo, maa));
        }
    }
}
      
public void sekoitaPakka(){
 Collections.shuffle(kortit);
    }

public Kortti jaaSeuraavaKortti(){
return kortit.remove(0);
 }
    @Override
    public String toString() {
        return "KorttiPakka{" + "kortit=" + kortit + ", nykyinenKortti=" + nykyinenKortti + '}';
    }

}