import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer extends Actor
{
    public int totalTime = 3600;
    public Timer() { 
        
    } 
    
    public void removeTime(int amount) { 
        totalTime -= amount; 
        renderTime();
    }
    public void setTime(int amount){
        totalTime = amount;
        renderTime();

    }
    public void renderTime(){
        setImage(new GreenfootImage("" + (int)Math.ceil(totalTime / 60), 20, Color.WHITE, Color.BLACK));
        
    }
}
