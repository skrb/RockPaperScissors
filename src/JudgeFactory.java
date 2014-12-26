
import java.util.EnumMap;
import java.util.Map;

public class JudgeFactory {

    static Judge create() {
        return new Judge() {
            Map<Hand, Map<Hand, Result>> judgeMap;

            {
                judgeMap = new EnumMap<>(Hand.class);

                Map<Hand, Result> rockMap = new EnumMap<>(Hand.class);
                rockMap.put(Hand.PAPER, Result.LOSE);
                rockMap.put(Hand.SCISSORS, Result.WIN);
                rockMap.put(Hand.ROCK, Result.DRAW);
                judgeMap.put(Hand.ROCK, rockMap);

                Map<Hand, Result> paperMap = new EnumMap<>(Hand.class);
                paperMap.put(Hand.SCISSORS, Result.LOSE);
                paperMap.put(Hand.ROCK, Result.WIN);
                paperMap.put(Hand.PAPER, Result.DRAW);
                judgeMap.put(Hand.PAPER, paperMap);

                Map<Hand, Result> scissorsMap = new EnumMap<>(Hand.class);
                scissorsMap.put(Hand.ROCK, Result.LOSE);
                scissorsMap.put(Hand.PAPER, Result.WIN);
                scissorsMap.put(Hand.SCISSORS, Result.DRAW);
            }
        
            @Override
            public Result judge(Hand one, Hand other) {
                return judgeMap.get(one).get(other);
            }
        };
    }
}
