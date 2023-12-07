import java.util.ArrayList;
import java.awt.*;

public abstract class EnemyVehicle implements Movable, Destructible
{
    public int xCoord;
    public int yCoord;
    ArrayList<Integer> xCoordinates = new ArrayList<>();

    public EnemyVehicle(int minX, int maxX, int y)
    {
        for(int i = 0; i < maxX - minX; i++)
        {
            xCoordinates.add(minX++);
        }

        xContains(xCoord);
        yCoord = y;
    }

    public boolean xContains(int x)
    {
        if(xCoordinates.contains(x)) return true;
        return false;
    }

    public int getDistanceToBorder()
    {
        return 0;
    }

    public abstract String getType();

    public void move()
    {
    }

    public static Point getLocation()
    {
        return null;
    }

    public boolean isDestroyed()
    {
        return true;
    }

    public void takeDamage(double damage)
    {
    }

    public final int BASE_SPEED = 3; // this variable should be used in implementing the move() method

}
