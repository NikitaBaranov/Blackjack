package strategies;

import common.Decision;

public interface Strategy {
    Decision makeDecision(int handValue);

//    boolean hit(int handValue);
//    boolean stand(int handValue);
//    boolean doubleDown(int handValue);
//    boolean bet(int handValue);

//    public void split();
//    public void surrender();
//    public void insurance();
}
