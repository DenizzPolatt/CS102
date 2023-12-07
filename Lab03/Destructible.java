/**
 * Destructible
 */
public interface Destructible {

    public default  boolean isDestroyed()
    {
        return true;
    }

    public default void takeDamage(double damage)
    {
    }
    
}