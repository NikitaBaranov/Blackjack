package strategies;

import common.Decision;

public class AI implements Strategy {
    private final int threshold;

    public AI(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public Decision makeDecision(int handValue) {
        if (handValue < threshold) {
            return Decision.HIT;
        }

        return Decision.STAND;
    }
}
