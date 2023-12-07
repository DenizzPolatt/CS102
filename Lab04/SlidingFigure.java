import java.awt.*;

import javax.swing.JFrame;

public class SlidingFigure {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My man is sliding");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        StickFigure figure = new StickFigure(100, 150, Color.yellow, 200);
        frame.getContentPane().add(figure);

        frame.pack();
        frame.setVisible(true);
    }
    
}
