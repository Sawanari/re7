package game;

/**
 * Created by e165737 on 2017/02/05.
 */
public class kato {public static void main(String[] args){
    Deck D = new Deck();
    String[]  s = new String[100];
    int i = 0;
    D.resetDeck();
    //	D.showOriginalDeck();
    String str = (String)(Object)D.Cards.get(0);
    //	System.out.println(str);
    i = str.indexOf(",");
    String S1 = str.substring(0,i);
    String S2 = str.substring(i+1,str.length()-1);
    System.out.println(S1);
    System.out.println(S2);
    String Pi = null;
    if(S1.equals("1"))  Pi = "Ace";
    System.out.println(Pi);
}
}
