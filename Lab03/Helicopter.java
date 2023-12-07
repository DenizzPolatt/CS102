public class Helicopter extends EnemyVehicle
{

    public Helicopter(int minX, int maxX, int y) {
        super(minX, maxX, y);
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public void move()
    {
    }

    public String toString()
    {
        return "";
    }
}
