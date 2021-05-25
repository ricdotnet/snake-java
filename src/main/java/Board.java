import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel implements ActionListener {

    public static Boolean STATE = true;
    private final int CHAR_SIZE = 10;
    private int BODY = 0;

    private int DELAY = 200;
    private Timer timer;
    private int POINTS = 0;

    private final int B_WIDTH = 200;
    private final int B_HEIGHT = 280;
    private int X_POS = 0;
    private int Y_POS = 0;

    private int ITEM_X_POS;
    private int ITEM_Y_POS;

    public static String DIRECTION;
    private int hor[] = new int[560];
    private int ver[] = new int[560];

    private final Character character = new Character();
    private final Item item = new Item();

    public Board() {
        initBoard();
    }
    private void initBoard() {

        timer = new Timer(DELAY, this);
        addKeyListener(new KeyEvents());
        setBackground(Color.white);
        setLayout(null);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        itemPosition();

        BODY = 3;
        for(int i = 0; i<BODY; i++) {
            hor[i] = 50-i * 10;
            ver[i] = 50;
        }

        timer.start();
    }

    //move method
    private void move() {

        for(int i = BODY; i > 0; i--) {
            hor[i] = hor[i-1];
            ver[i] = ver[i-1];
        }

        if(DIRECTION == "right") {
            hor[0] += CHAR_SIZE;
        }
        if(DIRECTION == "left") {
            hor[0] -= CHAR_SIZE;
        }
        if(DIRECTION == "up") {
            ver[0] -= CHAR_SIZE;
        }
        if(DIRECTION == "down") {
            ver[0] += CHAR_SIZE;
        }
    }

    //check box collision
    private void boxCollision() {
        if(hor[0] < 0 || ver[0] < 0 || hor[0] > B_WIDTH || ver[0] > B_HEIGHT) {
            STATE = false;
        }
        for(int i = BODY; i > 0; i--) {
            if (BODY > 4 && hor[0] == hor[i] && ver[0] == ver[i]) {
                STATE = false;
                break;
            }
        }
    }
    //check if eaten
    private void eat() {
        if(hor[0] == ITEM_X_POS && ver[0] == ITEM_Y_POS) {
            POINTS = POINTS + 1;
            BODY++;
            itemPosition();
            if(DELAY > 50) {
                DELAY = DELAY - 5;
            }
            timer.setDelay(DELAY);
        }
    }

    //points message
    private void showPoints(Graphics g) {
        super.paintComponent(g);
        Font small = new Font("Monospace", Font.BOLD, 10);
        g.setFont(small);
        g.drawString(String.valueOf(POINTS), B_WIDTH/2-CHAR_SIZE/2, 10);
    }

    //game over message
    private void gameOver(Graphics g) {
        super.paintComponent(g);
        Font small = new Font("Monospace", Font.BOLD, 15);
        g.setFont(small);
        g.drawString("Game Over....", 10, 50);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        draw(g);
    }

    private void draw(Graphics g) {
        if(STATE) {
            showPoints(g);

            for (int i = 0; i < BODY; i++) {
                character.newCharacter(g, hor[i], ver[i], CHAR_SIZE);
            }
            item.newItem(g, ITEM_X_POS, ITEM_Y_POS, CHAR_SIZE);
        } else {
            gameOver(g);
        }
    }

    private void itemPosition() {
        int r = (int) (Math.random() * 19);
        ITEM_X_POS = (r * CHAR_SIZE);

        r = (int) (Math.random() * 27);
        ITEM_Y_POS = (r * CHAR_SIZE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(STATE) {
            move();
            boxCollision();
            eat();
            repaint();
        } else {
            timer.stop();
        }
    }
}
