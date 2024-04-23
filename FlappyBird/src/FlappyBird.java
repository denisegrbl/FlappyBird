import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class FlappyBird extends JPanel implements ActionListener{

    int boardWidth = 360;
    int boardHeight = 640;

    // Images
    Image backgroundImg;
    Image birdImg;
    Image topPipeImg;
    Image bottomPiepeImg;

    //Bird
    int birdX = boardWidth/8;
    int birdY = boardHeight/2;
    int birdWidth = 34;
    int birdHeight = 24;

    class Bird {
        int x = birdX;
        int y = birdY;
        int width = birdWidth;
        int height = birdHeight;
        Image img;

        Bird(Image img) {
            this.img = img;
        }
    }
    
    //game logic
    Bird bird;
    int velocityY = -6;

    Timer gameLoop;


    FlappyBird() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));

        // load images
        backgroundImg = new ImageIcon(getClass().getResource("./hintergrund.png")).getImage();
        birdImg = new ImageIcon(getClass().getResource("./flappybird.png")).getImage();
        topPipeImg = new ImageIcon(getClass().getResource("./topsäule.png")).getImage();
        bottomPiepeImg = new ImageIcon(getClass().getResource("./unteresäule.png")).getImage();

        //bird
        bird = new Bird(birdImg);
        
        //game timer
        gameLoop = new Timer(1000/60,this);
        gameLoop.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        System.out.println("draw");
        // background
        g.drawImage(backgroundImg, 0, 0, this.boardWidth, this.boardHeight, null);
        //bird
        g.drawImage(birdImg, bird.x, bird.y, bird.width, bird.height, null);

    }

    public void move(){
        bird.y += velocityY;
        bird.y = Math.max(bird.y,0);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }
}
