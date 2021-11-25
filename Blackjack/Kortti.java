package blackjack;

/**
 *
 * @author s1901562
 */
public class Kortti {
    private Arvo arvo;
    private Maa maa;

public Kortti (Arvo arvo, Maa maa){ 
    this.arvo = arvo;
    this.maa = maa;
}

public Arvo getArvo(){
     return arvo;
}

public Maa getMaa(){
    return maa;
}

    @Override
    public String toString(){ 
    return arvo + " " + maa;
}
}