import model.Action;
import model.GameMap;
import model.Player;
import model.Replay;
import model.parser.ReplayParser;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String args[]) {
        Replay replay = ReplayParser.parseReplay("test.rep");

        Player player = replay.getPlayers()[0];

        System.out.println(replay.getGameMap());

        for (Action action : player.getActions()) {
            if (action.getType() == Action.Type.BUILD || action.getType() == Action.Type.TRAIN) {
                System.out.println(action);
           }
        }

        System.out.println(player);

        // Testing purposes, draw a map of the replay in a JFrame
        drawReplay(replay);
    }

    private static void drawReplay(final Replay replay) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        final GameMap gameMap = replay.getGameMap();
        final int width = gameMap.getWidth();
        final int height = gameMap.getHeight();

        frame.setSize(width, height);

        System.out.println("Width: " + gameMap.getWidth() + ", Height: " + gameMap.getHeight());

        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, width, height);
                // Draw mineral fields
                g.setColor(Color.BLUE);
                for (GameMap.Location location : gameMap.getMineralFieldLocations()) {
                    g.fillRect(location.getX(), location.getY(), 2, 2);
                }

                // Draw geysers
                g.setColor(Color.GREEN);
                for (GameMap.Location location : gameMap.getVespeneGeyserLocations()) {
                    g.fillRect(location.getX(), location.getY(), 2, 2);
                }

                g.setColor(Color.WHITE);
                // Draw player start positions
                for (GameMap.Location location : gameMap.getStartLocations()) {
                    g.fillRect(location.getX(), location.getY(), 2, 2);
                }

                // todo: get buildings created from actions and place on gameMap (include time param)
            }
        };
        frame.add(panel);
    }
}
