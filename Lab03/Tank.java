public class Tank extends EnemyVehicle{

    public Tank(int minX, int maxX, int y) {
        super(minX, maxX, y);
    }

    @Override
    public String getType() {
        return null;
    }
    
    @Override
    public void takeDamage(double damage)
    {
    }

    public String toString()
    {
        return "";
    }
}
