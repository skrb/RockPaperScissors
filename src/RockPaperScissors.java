
import java.util.Random;

public class RockPaperScissors {
    private final static int HAND_SIZE = 3;
    private final Random random = new Random();
    private final Judge judge = JudgeFactory.create();

    private int winCount;
    private int loseCount;
    
    public RockPaperScissors() {
        for(;;) {
            System.out.println("\nRock-Paper-Scissors GO!");
            System.out.println("1: Rock, 2: Paper, 3: Scissors");
            String otherHand = System.console().readLine();

            try {
                if (match(otherHand)) {
                    continue;
                }
            } catch (FormatException ex) {
                System.out.println("It's not llegal Hand!\nTry Again!");
                continue;
            }
            
            System.out.println("Continue?: Y or N");
            String answer = System.console().readLine();
            if (!answer.trim().equalsIgnoreCase("y")) {
                System.out.println("Total Win: " + winCount);
                System.out.println("Total Lose: " + loseCount);
                break;
            }
        }
    }
    
    private boolean match(String otherHand) throws FormatException {
        Hand mine = select();
        Hand other = parse(otherHand);

        System.out.println("My hand is: " + mine);
        System.out.println("Your hand is: " + other);

        Result result = judge.judge(mine, other);
        System.out.println(result);
        
        if (result == Result.WIN) {
            winCount++;
        } else if (result == Result.LOSE) {
            loseCount++;
        }

        return result == Result.DRAW;
    }

    private Hand parse(String hand) throws FormatException {
        try {
            int index = Integer.parseInt(hand);
            if (index > 0 && index < 4) {
                return Hand.values()[index - 1];
            } else {
                throw new FormatException("Illegal Number: " + index);
            }
        } catch (NumberFormatException ex) {
            throw new FormatException(ex);
        }
    }

    private Hand select() {
        return Hand.values()[random.nextInt(HAND_SIZE)];
    }

    public static void main(String... args) {
        new RockPaperScissors();
    }
}
