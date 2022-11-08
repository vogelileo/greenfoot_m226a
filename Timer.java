import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Timer
 * 
 * @author Jan Schweizer, Leo Vogel
 * @version November 2022
 */
public class Timer extends Actor
{
    public int totalTime = 3600;
    /**
     * Constuctor for object of Timer
     */
    public Timer() { 
        
    } 
    /**
     * @param int amount - amount to remove
     */
    public void removeTime(int amount) { 
        totalTime -= amount; 
        renderTime();
    }
    /**
     * @param int amount - amount to set
     */
    public void setTime(int amount){
        totalTime = amount;
        renderTime();

    }
   /**
    * Converts timer to image
    */
    public void renderTime(){
        setImage(new GreenfootImage("" + (int)Math.ceil(totalTime / 60) + " s", 20, Color.WHITE, Color.BLACK));
        
    }
}
