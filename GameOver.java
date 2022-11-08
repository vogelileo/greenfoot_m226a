import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{    
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver(int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        //showText("Score:" + Integer.toString(score),25, Color.BLACK, 300, 200);
        GreenfootImage gI = new GreenfootImage(" Score:" + Integer.toString(score), 50, Color.WHITE, Color.BLACK);
        GreenfootImage gT = new GreenfootImage(" Thanks for playing! ", 50, Color.WHITE, Color.BLACK);
        getBackground().drawImage(gI, 0,0);
        getBackground().drawImage(gT,0,350);

    }
}
