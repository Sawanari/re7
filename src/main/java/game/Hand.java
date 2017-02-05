package game;

/**
 * Created by e165737 on 2017/02/05.
 */
import java.util.Vector;
public class Hand {//変数宣言
    private int Value; //手札の値を保存
    private Vector hand;  //手札の内容を保存

    //コンストラクタ
    Hand(){
        hand = new Vector();
        int Value = 0;
    }
    //手札の値を計算して返す
    int getVaule(){
        Value =0;
        Value = bestScore();
        return Value;
    }
    void addToHand(Card card){
        hand.addElement(card);
    }
    void showHand(){
        for(int i=0; i<hand.size(); i++){
            Card car=(Card)(Object)hand.get(i);
            System.out.println(car.getValue() +" of "+ car.getName());
        }
    }
    void showPicture(){
        for(int i=0; i<hand.size(); i++){
            Card car=(Card)(Object)hand.get(i);
            System.out.println(car.getPicture() +" of "+ car.getName());
        }
    }
    boolean under(int limit){
        int point =0;
        for(int i=0; i<hand.size(); i++){
            Card car=(Card)(Object)hand.get(i);
            point += car.getValue();
        }
        if(point < limit) return true;
        else return false;
    }
    boolean over(){
        if(!under(22)) return true;
        else return false;
    }
    int bestScore(){
        int point=0;
        boolean haveAce = false;
        for(int i=0; i<hand.size(); i++){
            Card car=(Card)(Object)hand.get(i);
            point += car.getValue();
            if(car.getValue()==1) haveAce = true;
        }
        if(haveAce){
            if(point+10 < 22) point += 10;
        }
        return point;
    }
    boolean mustHit(){
        if(bestScore() <17) return true;
        else return false;
    }
}
