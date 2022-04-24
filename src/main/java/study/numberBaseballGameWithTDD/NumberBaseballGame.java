package study.numberBaseballGameWithTDD;

import static study.numberBaseballGameWithTDD.InputView.*;
import static study.numberBaseballGameWithTDD.InputView.insertContinueGame;

public class NumberBaseballGame {

    private boolean isRestartGame;
    private ScoreStatus scoreStatus;

    public void play() {
        Balls answer = Balls.randomBalls();
        do {
            askAgainUntilWin(answer);
            askGameContinue();
        } while(isRestartGame);
    }

    private void askGameContinue() {
        OutputView.gameContinueMessage();
        int continueGameToken = insertContinueGame();
        if (!isGameContinueRequest(continueGameToken)) {
            isRestartGame = false;
        }
    }

    private boolean isGameContinueRequest(int continueGameToken) {
        return continueGameToken == 1;
    }

    private void askAgainUntilWin(Balls answer) {
        do {
            Balls expectedBalls = getExpectedBalls();
            scoreStatus = answer.matchAll(expectedBalls);
        } while(!isWinningStatus());
    }

    private boolean isWinningStatus() {
        return ScoreStatus.THREE_STRIKE == scoreStatus;
    }

    private Balls getExpectedBalls() {
        OutputView.InputNumberMessage();
        String expected = insertExpectedThreeNumbers();
        return Balls.from(expected);
    }
}
