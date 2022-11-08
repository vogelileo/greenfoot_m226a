import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chart here.
 * 
 * @author Taylor Born
 * @version January 2010
 */
public class Chart extends World
{
    
    private boolean started = false;
    private Counter counter = new Counter();
    private Timer timer = new Timer();
    
    public Chart()
    {    
        super(10, 10, 60);
        GreenfootImage back = new GreenfootImage(10, 10);
        back.fill();
        setBackground(back);
        CodeKeyUser.enter();
        Greenfoot.start();
    }
    public void act()
    {        
            if(started){
                timer.removeTime(1);
                if(timer.totalTime < 1){
                    //Put endscreen here
                    Greenfoot.setWorld(new GameOver(counter.getCounter()));
                    Greenfoot.stop();
                }
            }
            if (!started)
            {
                timer.setTime(3600);
                addObject(timer,0,1);   
                addObject(counter,0,0);
                addObject(new Horse(1, 1), 1, 1);
                int[] carrotLocation = getRandomFreeLocation();
                addObject(new Carrot(), carrotLocation[0], carrotLocation[1]);
                
                for(int i=0;i<25;i++){
                    int[] location = getRandomFreeLocation();
                    addObject(new Hay(), location[0], location[1]);
                    
                }
            
                setBackground("floor.png");
                started=true;
            }
    }
    public Counter getCounter(){
        return counter;
    }
    public int[] getRandomFreeLocation(){
        boolean found = false;
        int[] arr = {0,0};
        while(!found){
        int randX = Greenfoot.getRandomNumber(10) ;
        int randY = Greenfoot.getRandomNumber(10) ;
        if (getObjectsAt(randX, randY, null).isEmpty()) {
            found = true; 
            arr[0] = randX;
            arr[1] = randY;
            
            }
    }
        return arr;
    }
}
