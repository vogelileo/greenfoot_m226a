import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * GameOver screen
 * 
 * @author Jan Schweizer, Leo Vogel
 * @version November 2022
 */
public class GameOver extends World
{    
    /**
     * Constructor for objects of class GameOver.
     * @param int score - This is the final score
     */
    public GameOver(int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        //Set the final score to the screen
        GreenfootImage gI = new GreenfootImage(" Score:" + Integer.toString(score), 50, Color.WHITE, Color.BLACK);
        GreenfootImage gT = new GreenfootImage(" Thanks for playing! ", 50, Color.WHITE, Color.BLACK);
        getBackground().drawImage(gI, 0,0);
        getBackground().drawImage(gT,0,350);

    }
}
