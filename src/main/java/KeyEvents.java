import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyEvents extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP && Board.DIRECTION != "down") {
            Board.DIRECTION = "up";
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN && Board.DIRECTION != "up") {
            Board.DIRECTION = "down";
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT && Board.DIRECTION != "right") {
            Board.DIRECTION = "left";
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT && Board.DIRECTION != "left") {
            Board.DIRECTION = "right";
        }
        Board.STATE = true;
    }
}