import model.Action;
import model.Player;
import model.Replay;
import model.parser.ReplayParser;

public class Main {
    public static void main(String args[]) {
        Replay replay = ReplayParser.parseReplay("test.rep");

        Player player = replay.getPlayers()[0];

        System.out.println(replay.getMap());

        for (Action action : player.getActions()) {
            if (action.getType() == Action.Type.BUILD || action.getType() == Action.Type.TRAIN) {
                System.out.println(action);
            }
        }
    }
}
