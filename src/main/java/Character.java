import java.awt.*;

public class Character {

    public void newCharacter(Graphics character, int X_POS, int Y_POS, int CHAR_SIZE) {
        character.drawRect(X_POS, Y_POS, CHAR_SIZE, CHAR_SIZE);
        character.fillRect(X_POS, Y_POS, CHAR_SIZE, CHAR_SIZE);
    }

}
