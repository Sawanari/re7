package game;

import static org.junit.Assert.*;

/**
 * Created by e165737 on 2017/02/06.
 */
import java.util.Random;
import java.util.Vector;
import java.util.Enumeration;
public class DeckTest {
    Random random;
    private int cardNum;            //配る前のカードの数
    private int nextItem;			//どの札まで配ったか記憶
    Vector Cards;          //シャッフル前のカードを保存
    private Vector shuffledCards;  //シャッフル後のカードを保存
    //コンストラクタ
    DeckTest(){
        Cards = new Vector();
        shuffledCards = new Vector();
        random = new Random();
        cardNum = 52;
        nextItem =0;
    }
}