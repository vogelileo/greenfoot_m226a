import greenfoot.*;
import java.util.ArrayList;
import java.awt.Point;

/**
 * Turtle
 * 
 * @author Taylor Born
 * @version January 2010
 */
public class Horse  extends Actor
{
    private ArrayList<Square> sqrList; // Squares that are looked at
    private ArrayList<Square> myRoute; // My charted course
    private int routeIndex; // How far I've gone on my route
    private int parent; // Square that gets me to another square
    private boolean target; // If found destination
    private Point targetDestination; // Where I want to go
    private int step = 0; // Slow down travel speed
    private boolean resized = false;
    
    private static final int CODE_ID = 71;
    
    public Horse(int x, int y)
    {
        targetDestination = new Point(x, y); // Where I want to be
    }
    public void findPath(Point pPosition, Point startPosition)
    {
        targetDestination = pPosition; // Get destination
        sqrList = new ArrayList<Square>(); // Refresh my squares to look at
        sqrList.add(new Square(startPosition, -1, 0, 0, targetDestination)); // Add my current position as a square to look at
        target = false; // I have just begun
        parent = 0; // Start at first square
    }
    private void makePath()
    {
        for (int q = 0; q < 50 && !target; q++) // Do so many calculations per act so not to lag other parts of the program
        {
            // Check all squares around the currently looked at square
            // Square to the left
            if (getWorld().getObjectsAt(sqrList.get(parent).getX() - 1, sqrList.get(parent).getY(), Bale.class).size() == 0) // Check if no rock
            {
                if (sqrList.get(parent).getX() - 1 > -1) // Check if in bounds of grid
                    if (!check(parent, 10, new Point(-1, 0))) // Check if already found this square and see if this route is better than one that the square is a part of
                        sqrList.add(new Square(new Point(sqrList.get(parent).getX() - 1, sqrList.get(parent).getY()), parent, sqrList.get(parent).getG(), 10, targetDestination)); // Add the square, takes 10 points to move horizontally or vertically, and know how many points it has taken to get here
            }
            // Square to the upper left
            if (getWorld().getObjectsAt(sqrList.get(parent).getX() - 1, sqrList.get(parent).getY() - 1, Bale.class).size() == 0) // Check if no rock
            {
                if (sqrList.get(parent).getX() - 1 > -1 && sqrList.get(parent).getY() - 1 > -1) // Check if in bounds of grid
                    if (!check(parent, 14, new Point(-1, -1))) // Check if already found this square and see if this route is better than one that the square is a part of
                        sqrList.add(new Square(new Point(sqrList.get(parent).getX() - 1, sqrList.get(parent).getY() - 1), parent, sqrList.get(parent).getG(), 14, targetDestination)); // Add the square, takes 14 points to move diagonally, and know how many points it has taken to get here
            }
            // Square above
            if (getWorld().getObjectsAt(sqrList.get(parent).getX(), sqrList.get(parent).getY() - 1, Bale.class).size() == 0) // Check if no rock
            {
                if (sqrList.get(parent).getY() - 1 > -1) // Check if in bounds of grid
                    if (!check(parent, 10, new Point(0, -1))) // Check if already found this square and see if this route is better than one that the square is a part of
                        sqrList.add(new Square(new Point(sqrList.get(parent).getX(), sqrList.get(parent).getY() - 1), parent, sqrList.get(parent).getG(), 10, targetDestination)); // Add the square, takes 10 points to move horizontally or vertically, and know how many points it has taken to get here
            }
            // Square to the upper right
            if (getWorld().getObjectsAt(sqrList.get(parent).getX() + 1, sqrList.get(parent).getY() - 1, Bale.class).size() == 0) // Check if no rock
            {
                if (sqrList.get(parent).getX() + 1 < 10 && sqrList.get(parent).getY() - 1 > -1) // Check if in bounds of grid
                    if (!check(parent, 14, new Point(1, -1))) // Check if already found this square and see if this route is better than one that the square is a part of
                        sqrList.add(new Square(new Point(sqrList.get(parent).getX() + 1, sqrList.get(parent).getY() - 1), parent, sqrList.get(parent).getG(), 14, targetDestination)); // Add the square, takes 14 points to move diagonally, and know how many points it has taken to get here
            }
            if (getWorld().getObjectsAt(sqrList.get(parent).getX() + 1, sqrList.get(parent).getY(), Bale.class).size() == 0) // Check if no rock
            {
                if (sqrList.get(parent).getX() + 1 < 10) // Check if in bounds of grid
                    if (!check(parent, 10, new Point(1, 0))) // Check if already found this square and see if this route is better than one that the square is a part of
                        sqrList.add(new Square(new Point(sqrList.get(parent).getX() + 1, sqrList.get(parent).getY()), parent, sqrList.get(parent).getG(), 10, targetDestination)); // Add the square, takes 10 points to move horizontally or vertically, and know how many points it has taken to get here
            }
            if (getWorld().getObjectsAt(sqrList.get(parent).getX() + 1, sqrList.get(parent).getY() + 1, Bale.class).size() == 0) // Check if no rock
            {
                if (sqrList.get(parent).getX() + 1 < 10 && sqrList.get(parent).getY() + 1 < 10) // Check if in bounds of grid
                    if (!check(parent, 14, new Point(1, 1))) // Check if already found this square and see if this route is better than one that the square is a part of
                        sqrList.add(new Square(new Point(sqrList.get(parent).getX() + 1, sqrList.get(parent).getY() + 1), parent, sqrList.get(parent).getG(), 14, targetDestination)); // Add the square, takes 14 points to move diagonally, and know how many points it has taken to get here
            }
            if (getWorld().getObjectsAt(sqrList.get(parent).getX(), sqrList.get(parent).getY() + 1, Bale.class).size() == 0) // Check if no rock
            {
                if (sqrList.get(parent).getY() + 1 < 10) // Check if in bounds of grid
                    if (!check(parent, 10, new Point(0, 1))) // Check if already found this square and see if this route is better than one that the square is a part of
                        sqrList.add(new Square(new Point(sqrList.get(parent).getX(), sqrList.get(parent).getY() + 1), parent, sqrList.get(parent).getG(), 10, targetDestination)); // Add the square, takes 10 points to move horizontally or vertically, and know how many points it has taken to get here
            }
            if (getWorld().getObjectsAt(sqrList.get(parent).getX() - 1, sqrList.get(parent).getY() + 1, Bale.class).size() == 0) // Check if no rock
            {
                if (sqrList.get(parent).getX() - 1 > -1 && sqrList.get(parent).getY() + 1 < 10) // Check if in bounds of grid
                    if (!check(parent, 14, new Point(-1, 1))) // Check if already found this square and see if this route is better than one that the square is a part of
                        sqrList.add(new Square(new Point(sqrList.get(parent).getX() - 1, sqrList.get(parent).getY() + 1), parent, sqrList.get(parent).getG(), 14, targetDestination)); // Add the square, takes 14 points to move diagonally, and know how many points it has taken to get here
            }
            sqrList.get(parent).close(); // Done looking at this square
            int lowest = -1; // Index for square that has lowest score
            for (int i = 0; i < sqrList.size(); i++) // Get square that has lowest score
            {
                if (!sqrList.get(i).isClosed()) // Make sure we have not already looked at
                {
                    if (lowest == -1) // If havn't found one yet
                        lowest = i; // This lowest one found so far
                    else if (sqrList.get(i).getG() + sqrList.get(i).getH() < sqrList.get(lowest).getG() + sqrList.get(lowest).getH()) // Check to see if score of this square is the new lowest
                        lowest = i; // This lowest one found so far
                }
            }
            if (lowest == -1) // No possible path
            {
                targetDestination = new Point(getX(), getY());
                return;
            }
            parent = lowest; // Now looking at new lowest
            for (int i = 0; i < sqrList.size(); i++) // Loop all squares that have found
            {
                if (sqrList.get(i).getPosition().equals(targetDestination) && sqrList.get(i).isClosed()) // Check to see if found destination
                {
                    parent = i; // Start at this square to chart back to beginning
                    target = true; // We have found the destination
                }
            }
        }
        if (target) // If found destination
        {
            myRoute = new ArrayList<Square>(); // Refresh route to take
            while (parent != -1) // Loop till back to beginning
            {
                myRoute.add(sqrList.get(parent)); // Add square
                parent = sqrList.get(parent).getParent(); // Move to that square's parent
            }
            routeIndex = myRoute.size() - 2; // When start to move, starting at beginning
        }
    }
    private boolean check(int parent, int cost, Point spot)
    {
        boolean flag = false;
        for (int i = 0; i < sqrList.size(); i++) // Loop squares found
        {
            if (sqrList.get(i).getPosition().equals(new Point((int)(sqrList.get(parent).getX() + spot.getX()), (int)(sqrList.get(parent).getY() + spot.getY())))) // Check if already have the square
            {
                flag = true; // Do have this square
                if (!sqrList.get(i).isClosed() && sqrList.get(parent).getG() + cost < sqrList.get(i).getG()) // Check if new route to square is better
                {
                    sqrList.get(i).adopt(parent); // Change square's parent
                    sqrList.get(i).changeG(sqrList.get(parent).getG() + cost); // Change square's score
                }
            }
        }
        return flag; // return if found that already have square
    }
    public void setLocation(int x, int y)
    {
        if (targetDestination.getX() == getX() && targetDestination.getY() == getY())
            targetDestination = new Point(x, y);
        super.setLocation(x, y);
    }
    public void act() 
    {
        if(!resized) {
            GreenfootImage image = getImage();  
            image.scale(60, 60);
            setImage(image);
            
            resized = true;
        }
        step++;
        if (step > 6)
        {
            if (!targetDestination.equals(new Point(getX(), getY()))) // Check to see if already at destination
            {
                if (!target) // If not done charting course
                    makePath(); // Chart it
                else
                {
                    setLocation(myRoute.get(routeIndex).getX(), myRoute.get(routeIndex).getY()); // Move to next spot in route
                    routeIndex--; // Next spot
                    
                    if (routeIndex == -1 && getX() == 1 && getY() == 4 && CodeGenerator.haveUser())
                    {
                        getWorld().removeObjects(getWorld().getObjects(CodeDisplay.class));
                        getWorld().addObject(new CodeDisplay(CODE_ID), 1, 4);
                    }
                }
            }
            else
            {
                // If not moving
            }
            step = 0;
        }
        
        // Listen for commands
        MouseInfo mouse = Greenfoot.getMouseInfo();
        
        if (Greenfoot.mousePressed(null))
            findPath(new Point(mouse.getX(), mouse.getY()), new Point(getX(), getY()));
    }
    
    private class Square  
    {
        private Point position; // Position of square
        private int parent; // Index of square that is before this one in the route
        private boolean closed = false; // Has not been looked at
        private int g; // Score to get to this position. 10s added for every vertical and horizontal move and 14s for every diagonal move since a diagonal move is a farther move
        private int h; // Score estimate for how many vertical and horizontal moves, regardless of obstacles
    
        public Square(Point position, int parent, int parentG, int thisG, Point destination)
        {
            this.position = position; // Position
            this.parent = parent; // Parent
            g = parentG + thisG; // Parent's score plus score took to get from there to here
            h = (int)(Math.abs(position.getX() - destination.getX()) + Math.abs(position.getY() - destination.getY())) * 10; // Vertical and horizontal spaces between here and destination
        }
        public Point getPosition()
        {
            return position;
        }
        public int getX()
        {
            return (int)position.getX();
        }
        public int getY()
        {
            return (int)position.getY();
        }
        public int getParent()
        {
            return parent;
        }
        public void adopt(int parent)
        {
            this.parent = parent;
        }
        public boolean isClosed()
        {
            return closed;
        }
        public void close()
        {
            closed = true;
        }
        public int getG()
        {
            return g;
        }
        public void changeG(int newG)
        {
            g = newG;
        }
        public int getH()
        {
            return h;
        }
    }
}