package blackjack;

/**
 *
 * @author s1901562
 */
  public enum Arvo {

ÄSSÄ(1), KAKSI (2), KOLME (3),
NELJÄ(4), VIISI(5), KUUSI(6),
SEITSEMÄN(7), KAHDEKSAN(8), YHDEKSÄN(9),
KYMMENEN(10), JÄTKÄ(10), KUNINGATAR(10),
KUNINGAS(10);

private final int arvoValue;

private Arvo(int arvoValue){
    this.arvoValue = arvoValue;
}

public int getArvoValue(){
    return arvoValue;
}
}