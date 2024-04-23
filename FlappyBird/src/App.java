import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        int boardWidth = 360;
        int boardHeight = 640;

        JFrame frame = new JFrame("FlappyBird");
        frame.setSize(boardWidth, boardHeight); // reihenfolge wichtig
        frame.setLocationRelativeTo(null); // Window in der Mitte
        frame.setResizable(false); // Größe nicht veränderbar
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // schließen des Fensters

        FlappyBird flappyBird = new FlappyBird();
        frame.add(flappyBird);
        frame.pack(); // ohne Titelbar die Größe
        frame.setVisible(true);
    }
}
