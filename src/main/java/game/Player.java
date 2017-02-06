package game;

/**
 * Created by e165737 on 2017/02/05.
 */
import java.io.*;
public class Player {int limit = 21;
    Hand hand;   // 自分の手札
    BufferedReader myreader;
    //コンストラクタ
    Player(){
        hand = new Hand();
        myreader = new BufferedReader(new InputStreamReader(System.in),1);
    }
    //カードをもう一枚引くかどうかを　true,falseで答える
    boolean moreCards(){
        char ch = ' ';
        do{
            System.out.print("Hit or Stay: ");
            try{
                String myString = myreader.readLine();
                ch = myString.charAt(0);
            }catch(IOException e){
            }catch(StringIndexOutOfBoundsException e){};
            if(ch == 'H' || ch == 'h') return true;
            if(ch == 'S' || ch == 's') return false;
        }while(true);
    }
    void getCard(Card card){
        hand.addToHand(card);
    }
    void showHand(){
        hand.showHand();
    }
    void showPicture(){
        hand.showPicture();
    }
    int getValueOfHand(){
        int Value =0;
        Value = hand.getVaule();
        return Value;
    }
    boolean under(int limit){
        return hand.under(limit);

    }
    boolean over(){
        return hand.over();
    }
    int bestScore(){
        return hand.bestScore();
    }
    int PlaceBet(int money){
        int Bet =0;
        do{
            System.out.println("Please bet:");
            try{
                String myString = myreader.readLine();
                Bet = Integer.parseInt(myString);
            }catch(NumberFormatException e){
            }catch(IOException e){}
        }while (Bet < 0 || Bet > money);
        return Bet;
    }
}
