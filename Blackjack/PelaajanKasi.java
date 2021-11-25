package blackjack;
import java.util.ArrayList;
/**
 *
 * @author s1901562
 */
public class PelaajanKasi {
    
private String kutsumaNimi;

private int PelaajaNumKortteja;

private ArrayList<Kortti> PelaajanKasi;

public PelaajanKasi (String kutsumaNimi){
    this.kutsumaNimi = kutsumaNimi;
    this.PelaajanKasi = new ArrayList<Kortti>();
}

public String getkutsumaNimi() {
    return kutsumaNimi;
}

public void otaKortti(Kortti kortti){
    PelaajanKasi.add(kortti);
}

public int selvitäSumma(){
    int kasiSum = 0;
    for (Kortti kortti : PelaajanKasi){
        kasiSum += kortti.getArvo().getArvoValue();
    }
    return kasiSum;
}

public String getPelaajanKasi(boolean hideCard) {
    StringBuilder sb = new StringBuilder();
    sb.append(kutsumaNimi + " nykyinen käsi:");
    sb.append('\n');
    for ( int c = 0; c < PelaajanKasi.size(); c++){
        if(c == 0 && hideCard){
            sb.append("[Piilotettu Kortti]");
            sb.append('\n');
        } else {
            sb.append(PelaajanKasi.get(c));
            sb.append('\n');
        }
    }
    return sb.toString();
}
}