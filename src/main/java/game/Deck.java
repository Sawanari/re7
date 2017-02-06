package game;

/**
 * Created by e165737 on 2017/02/05.
 */
import java.util.Random;
import java.util.Vector;
import java.util.Enumeration;
public class Deck {//変数宣言
    Random random;
    private int cardNum;            //配る前のカードの数
    private int nextItem;			//どの札まで配ったか記憶
    Vector Cards;          //シャッフル前のカードを保存
    private Vector shuffledCards;  //シャッフル後のカードを保存
    //コンストラクタ
    Deck(){
        Cards = new Vector();
        shuffledCards = new Vector();
        random = new Random();
        cardNum = 52;
        nextItem =0;
    }
    //山を初期化
    void resetDeck(){
        createHearts();
        createSpades();
        createClubs();
        createDiamonds();

    }
    //山に残っているカードの枚数を数える
    int getDeckSize(){
        int size = 0;
        size = shuffledCards.size();
        return size;
    }
    //次のカードを配る
    Card getNextCard(){
        Card card = null;
        Object obj =shuffledCards.get(nextItem);
        String str = obj.toString();
        //	String str = (String)(Object)D.Cards.get(0);
        //	System.out.println(str);
        int i = str.indexOf(",");
        String S1 = str.substring(0,i);
        String S2 = str.substring(i+1,str.length()-1);
        //	System.out.println(S1);
        //	System.out.println(S2);
        //	int r = Integer.parseInt(str);
        card = new Card(S1,S2);
        ++nextItem;
        return card;
    }
    void shuffleDeck(){
        for(int i=0; i<52; i++){
            shuffledCards.insertElementAt(Cards.get(i),i);  //shuffledCardsに、コピー
        }

        for(int i=0; i<52; i++){
            //デッキの中のランダムな２枚と交換する
            int a = random.nextInt();
            if(a <0) a=0-a;
            a = a%52;     //ランダムな１３以下の値 a

            int b = random.nextInt();
            if(b <0) b=0-b;
            b = b%52;	//ランダムな１３以下の値 b


            Object temp = shuffledCards.get(a);    //入れ替え
            Object temp2 = shuffledCards.get(b);
            shuffledCards.remove(a);
            shuffledCards.insertElementAt(temp2,a);
            shuffledCards.remove(b);
            shuffledCards.insertElementAt(temp,b);
        }
    }

    void completeDeck(){
    }

    //ハートの札一式を山に入れる
    private void createHearts(){
        for(int i=1; i<=13; i++){
            String s = Integer.toString(i);
            Cards.addElement(s+",Hearts");
        }
    }
    //スペードの札一式を山に入れる
    private void createSpades(){
        for(int i=1; i<=13; i++){
            String s = Integer.toString(i);
            Cards.addElement(s+",Spades");
        }
        //	Cards.addElement("Spades");
    }
    //クラブの札一式を山に入れる
    private void createClubs(){
        for(int i=1; i<=13; i++){
            String s = Integer.toString(i);
            Cards.addElement(s+",Clubs");
        }
//		Cards.addElement("Clubs");
    }
    //ダイヤの札一式を山に入れる
    private void createDiamonds(){
        for(int i=1; i<=13; i++){
            String s = Integer.toString(i);
            Cards.addElement(s+",Diamonds");
        }
//		Cards.addElement("Diamonds");

    }
}
