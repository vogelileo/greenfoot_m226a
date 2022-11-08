import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Counter
 * 
 * @author Jan Schweizer, Leo Vogel
 * @version November 2022
 */
public class Counter extends Actor { 
    private int totalCount = 0;
    /**
     * constructor for counte rclass
     */
    public Counter() { 
        //Score to image converter
        setImage(new GreenfootImage("0",20,Color.WHITE, Color.BLACK)); 
    } 
    /**
     * @param int amount - increase by amonut
     */
    public void bumpCount(int amount) { 
        totalCount += amount; 
        setImage(new GreenfootImage("" + totalCount + " P", 20, Color.WHITE, Color.BLACK)); 
    }
    /**
     * @return int totalcount - returns current count
     */
    public int getCounter(){
        return totalCount;
    }
}
