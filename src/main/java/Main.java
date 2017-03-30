import model.Action;
import model.Replay;
import model.parser.ReplayParser;

public class Main {
    public static void main(String args[]) {
        Replay replay = ReplayParser.parseReplay("/home/jacob/Downloads/test.rep");

        for (Action action : replay.getPlayers()[0].getActions()) {
            if (action.getName().equals("Build") || action.getName().equals("Train")) {
                System.out.println(action);
            }
        }
    }
}
