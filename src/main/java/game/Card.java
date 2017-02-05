package game;

/**
 * Created by e165737 on 2017/02/05.
 */
public class Card {//変数宣言
    private String Name; //カードのスートを保存
    private int Value;  //カードの値を保存
    private String Suite; //カードのスートを保存
    private String Picture; //絵札を保存

    public Card(String s1, String s2){
        setName(s1,s2);
        setValue(s1,s2);
        setPicture(s1,s2);
    }

    String getName(){
        return Name;
    }

    int getValue(){
        return Value;
    }
    String getSuite(){
        return Suite;
    }
    String getPicture(){
        return Picture;
    }

    void setName(String S1, String S2){
        Name = S2;
    }


    void setValue(String S1, String S2){
        Value = Integer.parseInt(S1);
        if(Value >10) Value =10;
    }
    void setSuite(){

    }
    void setPicture(String S1, String S2){
        Picture = S1;
        if(Picture.equals("1")) Picture = "Ace";
        if(Picture.equals("10")) Picture = "Ten";
        if(Picture.equals("11")) Picture = "Jack";
        if(Picture.equals("12")) Picture = "Oueen";
        if(Picture.equals ("13")) Picture = "King";
    }
}
