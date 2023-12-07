// *******************************************************
// StickFigure.java (modified version of Listing 4.16,
// Lewis and Loftus)
//
// Represents a graphical stick figure
// *******************************************************
import java.awt.*;

import javax.swing.JPanel;
public class StickFigure extends JPanel
{
    private int baseX;
    private int baseY;
    private Color color;
    private int heightOfFigure; 
    private int widthOfHead;
    private int legLength;
    private int legPosition;
    private int armLength; 
    private int armToFloor;
    private int armPosition;


    public StickFigure (int baseX, int baseY, Color color, int size)
    {
        this.baseX = baseX;
        this.baseY = baseY;
        this.color = color;
        heightOfFigure = size;

        widthOfHead = heightOfFigure / 5;
        legLength = heightOfFigure / 2;
        armToFloor = 2 * heightOfFigure / 3;
        armLength = heightOfFigure / 3;

        armPosition = -20;
        legPosition = 15;
    }

    public void setX(int x)
    {
        this.baseX = x;
    }

    public void setY(int y)
    {
        this.baseY = y;
    }

    public void draw(Graphics page)
    {
        super.paintComponent(page);
        
        //compute y-coordinate of top of head
        int topOfHead = baseY - heightOfFigure;
        page.setColor(color);
        //head
        page.drawOval(baseX-widthOfHead/2, topOfHead, widthOfHead, widthOfHead);
        //body
        page.drawLine (baseX, topOfHead+widthOfHead, baseX, baseY - legLength);
        //legs
        page.drawLine(baseX, baseY-legLength, baseX-legPosition, baseY);
        page.drawLine(baseX, baseY-legLength, baseX+legPosition, baseY);
        //arms
        int startY = baseY - armToFloor;
        page.drawLine(baseX, startY, baseX-armLength, startY-armPosition);
        page.drawLine(baseX, startY, baseX+armLength, startY-armPosition);
    }
    
    public void slide()
    {
        for(int i = 0; i < 100; i++)
        {
            baseX += i;
        }
    }
   
    public void setLegPosition(int newPosition)
    {
        legPosition = newPosition;
    }

    public void setArmPosition(int newPos)
    {
        armPosition = newPos;
    }
}