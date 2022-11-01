import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Carrot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Carrot extends Actor
{
    /**
     * Act - do whatever the Carrot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(isTouching(Horse.class)){
            int[] location = getRandomFreeLocation();
            setLocation(location[0], location[1]);
            
            World world; 
            world = getWorld(); 
            Chart chart = (Chart) getWorld(); 
            Counter counter = chart.getCounter(); 
            counter.bumpCount(1);
            
        }
    }
    public int[] getRandomFreeLocation(){
        boolean found = false;
        int[] arr = {0,0};
        while(!found){
        int randX = Greenfoot.getRandomNumber(10) ;
        int randY = Greenfoot.getRandomNumber(10) ;
        if (getWorld().getObjectsAt(randX, randY, null).isEmpty()) {
            found = true; 
            arr[0] = randX;
            arr[1] = randY;
            
            }
    }
        return arr;
    }
}
