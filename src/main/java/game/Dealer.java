package game;

/**
 * Created by e165737 on 2017/02/05.
 */
public class Dealer {int limit =21;
    int money;
    int bet;
    Player you;
    Deck deck;     //カードの山
    Hand dealerHand;
    //コンストラクタ
    Dealer(){
        deck = new Deck();
        money = 100;
    }
    //メソッド
    //山からカードを一枚引く
    Card getCard(){
        Card newCard = null;
        newCard = deck.getNextCard();
        return newCard;
    }
    //	DOS出力で、使用
    void startNewGame(){
        do{
            you = new Player();
            dealerHand = new Hand();
            bet = you.PlaceBet(money);  //プレーヤーが掛け金を決める、bet値を取得
            if(bet>0){
                //山をリセット
                deck.resetDeck();
                //山をシャッフル
                deck.shuffleDeck();
                //最初のカードを配る
                //		deck.showShuffleDeck();
                initDealer();
                initPlayer();
                //カードが必要か、プレーヤーに尋ねる
                while(you.under(22) && you.moreCards()){
                    you.getCard(getCard());
                    System.out.println("player Hand:-------");
                    you.showPicture();
                }
                while(dealerHand.mustHit()){
                    dealerHand.addToHand(getCard());
                }
                System.out.println("dealer Hand:-------");
                dealerHand.showPicture();
                //手札を計算
                System.out.println("------------");
                System.out.println("player Value:"+you.getValueOfHand());
                System.out.println("dealer Value:"+dealerHand.getVaule()); // 1回
                System.out.println("------------");
                showResult();
            }
        }while(bet>0);
    }

    void showResult(){
        if(you.over() && dealerHand.over()) tie();
        else if(you.over()) dealerWin();
        else if(dealerHand.over()) playerWin();
        else if(you.bestScore() > dealerHand.bestScore()) playerWin();
        else if(you.bestScore() < dealerHand.bestScore()) dealerWin();
        else tie();
    }

    void initDealer(){
        dealerHand = new Hand();
        //山をリセット
        deck.resetDeck();
        //山をシャッフル
        deck.shuffleDeck();
        dealerHand.addToHand(getCard());
        dealerHand.addToHand(getCard());
        System.out.println("dealer Hand:-------");
        dealerHand.showPicture();
    }
    void initPlayer(){
        you = new Player();
        you.getCard(getCard());
        you.getCard(getCard());
        System.out.println("player Hand:-------");
        you.showPicture();
    }
    void tie(){
        System.out.println("tie");
        System.out.println("Player has ＄" + Integer.toString(money));
        //	B.textArea.setText(B.textArea.setText()+"tie"+"\n" + "Player has ＄" + Integer.toString(money));
    }
    void playerWin(){
        money += bet;
        System.out.println("Player Win ＄" + Integer.toString(bet));
        System.out.println("Player has ＄" + Integer.toString(money));
    }
    void dealerWin(){
        money -= bet;
        System.out.println("Player lose ＄" + Integer.toString(bet));
        System.out.println("Player has ＄" + Integer.toString(money));
    }
}
