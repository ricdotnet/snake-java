import java.awt.*;

public class Item {

    public void newItem(Graphics g, int X_POS, int Y_POS, int ITEM_SIZE) {
        g.setColor(Color.green);
        g.drawOval(X_POS, Y_POS, ITEM_SIZE, ITEM_SIZE);
        g.fillOval(X_POS, Y_POS, ITEM_SIZE, ITEM_SIZE);
    }

}