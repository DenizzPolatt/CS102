import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

public class StickFigurePanel extends JPanel {
    
    StickFigurePanel()
    {
        StickFigure man = new StickFigure(100, 150, Color.blue, 50);

        setPreferredSize(new DimensionUIResource(300, 200));
        setBackground(Color.GRAY);
    }
}
