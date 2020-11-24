
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HIEGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HIEGHT)/UNIT_SIZE;
    static final int DELAY = 75;
    final int X[] = new int[GAME_UNITS];
    final int Y[] = new int[GAME_UNITS];
    int bodyParts = 4;
    int dotsEaten;
    int dotX;
    int dotY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;


    GamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HIEGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new myKeyAdapter());
        startGame();
    }

    public void startGame() {
        newDot();
        running = true;
        timer = new Timer(DELAY,this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {

        if(running) {
            /*for (int i = 0;i<SCREEN_HIEGHT/UNIT_SIZE; i++) {
                g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HIEGHT);
                g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
            }*/
            g.setColor(Color.red);
            g.fillOval(dotX, dotY, UNIT_SIZE, UNIT_SIZE);

            for(int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    g.setColor(Color.green);
                    g.fillRect(X[i], Y[i], UNIT_SIZE, UNIT_SIZE);
                }
                else {
                    g.setColor(new Color(45,180,0));
                    g.fillRect(X[i], Y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }
            g.setColor(Color.red);
            g.setFont(new Font("Ink Free", Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: " + dotsEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + dotsEaten))/2, g.getFont().getSize());
        }
        else {
            gameOver(g);
        }
    }

    public void newDot() {
        dotX = random.nextInt(SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        dotY = random.nextInt(SCREEN_HIEGHT/UNIT_SIZE)*UNIT_SIZE;
    }

    public void move() {
        for(int i = bodyParts; i>0; i--) {
            X[i] = X[i-1];
            Y[i] = Y[i-1];
        }

        switch(direction){
            case 'U':
            Y[0] = Y[0] - UNIT_SIZE;
            break;
            case 'D':
            Y[0] = Y[0] + UNIT_SIZE;
            break;
            case 'L':
            X[0] = X[0] - UNIT_SIZE;
            break;
            case 'R':
            X[0] = X[0] + UNIT_SIZE;
            break;
        }
    }

    public void checkDot() {
        if((X[0] == dotX) && (Y[0] == dotY)) {
            bodyParts++;
            dotsEaten++;
            newDot();
        }
    }

    public void checkCollisions() {
        //checks if head collides with body
        for(int i = bodyParts; i>0; i--) {
            if((X[0] == X[i])&& (Y[0] == Y[i])) {
                running = false;
            }
        }
        //checks if head touches left border
        if(X[0] < 0) {
            running = false;
        }
        //checks if head touches right border
        if(X[0] > SCREEN_WIDTH) {
            running = false;
        }
        //checks if heads touches top border
        if(Y[0] < 0) {
            running = false;
        }
        //checks if head touches bottom border
        if(Y[0] > SCREEN_HIEGHT) {
            running = false;
        }

        if(!running) {
            timer.stop();
        }
    }

    public void gameOver(Graphics g) {
        //Game Over tex
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("GAME OVER", (SCREEN_WIDTH - metrics1.stringWidth("GAME OVER"))/2, SCREEN_HIEGHT/2);
        //total score
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Score: " + dotsEaten, (SCREEN_WIDTH - metrics2.stringWidth("Score: " + dotsEaten))/2, g.getFont().getSize());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(running) {
            move();
            checkDot();
            checkCollisions();
        }
        repaint();

    }

    public class myKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if(direction != 'R'){
                        direction = 'L';
                    }
                break;
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L'){
                        direction = 'R';
                    }
                break;
                case KeyEvent.VK_UP:
                    if(direction != 'D'){
                        direction = 'U';
                    }
                break;
                case KeyEvent.VK_DOWN:
                    if(direction != 'U'){
                        direction = 'D';
                    }
                break;
            }
        }
    }
    
}
