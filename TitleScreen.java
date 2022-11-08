import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Start screen
 * 
 * @author Jan Schweizer, Leo Vogel
 * @version November 2022
 */
public class TitleScreen extends World
{ 
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640, 640, 1); 
        //automatic game start
        Greenfoot.start();
        GreenfootSound bgMusic = new GreenfootSound("./sounds/CountryRoads.mp3");
        bgMusic.playLoop();
    }
    /**
     * act for Titlescreen
     */
    public void act()
    {
        //if space start game
        if (Greenfoot.isKeyDown("space")) Greenfoot.setWorld(new Chart());
    }
}

