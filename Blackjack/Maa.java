package blackjack;

/**
 *
 * @author s1901562
 */
public enum Maa {

HERTTA(" Hertta"),
PATA(" Pata"),
RUUTU(" Ruutu"),
RISTI(" Risti");

private final String maaTeksti;

private Maa(String maaTeksti){
    this.maaTeksti = maaTeksti;
}

public String PrintMaaTeksti(){
    return maaTeksti;
}
}