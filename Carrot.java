import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the target for the horse
 * 
 * @author Jan Schweizer, Leo Vogel
 * @version November 2022
 */
public class Carrot extends Actor
{
    private boolean resized = false;
    /**
     * act for class Carot
     */
    public void act()
    {
        //Resizes the image to the correct size cause of own pixel art
        if(!resized) {
            GreenfootImage image = getImage();  
            image.scale(60, 60);
            setImage(image);
            
            resized = true;
        }
        //if carrot was eaten, teleport to new free location
        if(isTouching(Horse.class)){
            int[] location = getRandomFreeLocation();
            setLocation(location[0], location[1]);
            
            //Increase count
            Chart chart = (Chart) getWorld(); 
            Counter counter = chart.getCounter(); 
            counter.bumpCount(1);
            
        }
    }
    /**
     * Get an free location on the board
     * @return arr[posX, posY] of free location
     */
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
