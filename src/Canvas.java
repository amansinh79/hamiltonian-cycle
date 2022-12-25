import javax.swing.*;
import java.awt.*;

public class Canvas extends JComponent {
    @Override
    public void paint(Graphics g) {
       for(int i = 0; i < Main.height;i++){
           for(int j = 0; j < Main.width;j++){
                g.setColor(Color.white);
                g.drawString(Integer.toString(Main.path.indexOf(Main.board[i][j])),20 + i*Main.rectSize,20 +j*Main.rectSize);

           }
       }
    }
}
