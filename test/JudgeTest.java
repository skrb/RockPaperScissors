import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class JudgeTest {
    
    public JudgeTest() {
    }

    @Test
    public void testJudge() {
        Judge judge = JudgeFactory.create();
        
        assertThat(judge.judge(Hand.ROCK, Hand.ROCK), is(Result.DRAW));
        assertThat(judge.judge(Hand.ROCK, Hand.PAPER), is(Result.LOSE));
        assertThat(judge.judge(Hand.ROCK, Hand.SCISSORS), is(Result.WIN));

        assertThat(judge.judge(Hand.PAPER, Hand.ROCK), is(Result.WIN));
        assertThat(judge.judge(Hand.PAPER, Hand.PAPER), is(Result.DRAW));
        assertThat(judge.judge(Hand.PAPER, Hand.SCISSORS), is(Result.LOSE));

        assertThat(judge.judge(Hand.SCISSORS, Hand.ROCK), is(Result.LOSE));
        assertThat(judge.judge(Hand.SCISSORS, Hand.PAPER), is(Result.WIN));
        assertThat(judge.judge(Hand.SCISSORS, Hand.SCISSORS), is(Result.DRAW));
    }
}
