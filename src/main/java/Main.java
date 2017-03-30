import model.Replay;
import model.parser.ReplayParser;

public class Main {
    public static void main(String args[]) {
        Replay replay = ReplayParser.parseReplay("/home/jacob/Downloads/test.rep");
        System.out.println(replay);
    }
}
