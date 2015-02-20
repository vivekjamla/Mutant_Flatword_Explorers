package vivek.project;

import java.util.HashSet;


/**
 * @author Vivekkumar
 *
 */
public class Robot {
	   int gridx;
	   int gridy;
	   Position initialPosition;	//making instance of position class.
	   String moves;
	   Scent sct = null;			//instance of scent class
	   // initialize robot parameters
	   public Robot(int x, int y, int initx, int inity, char d, String moves) {
	       initialPosition = new Position();	//object of position class.
	       gridx = x;							//storing the grid information.
	       gridy = y;
	       initialPosition.x = initx;			//assigning the initial x position .
	       initialPosition.y = inity;			//assigning the initial y position
	       initialPosition.orientation = d;		//initial orientation of robot.
	       this.moves = moves;
	       sct = Scent.getInstance();			//this will return single instance of scent as scent is singleton.
	   }
	   
	   // check whether robot has gone out of the grid return true or false accordingly.
	   private boolean withinLimit() {
	       if(initialPosition.x>gridx) {		//
	           initialPosition.x--;
	           sct.addScent(""+initialPosition.x+""+initialPosition.y+""+initialPosition.orientation);
	           return false;
	       }
	        if(initialPosition.x<0) {
	            initialPosition.x++;
	            sct.addScent(""+initialPosition.x+""+initialPosition.y+""+initialPosition.orientation);
	            return false;
	        }
	        if(initialPosition.y>gridy) {
	            initialPosition.y--;
	            sct.addScent(""+initialPosition.x+""+initialPosition.y+""+initialPosition.orientation);
	            return false;
	        }
	        if(initialPosition.y<0) {
	            initialPosition.y++;
	            sct.addScent(""+initialPosition.x+""+initialPosition.y+""+initialPosition.orientation);
	            return false;
	        }        
	        return true;
	   }
	  
	  /**
	   * This method set new position of robot based on inputs
	   * @return Nothing 
	   * 
	   */
	   public void findEnd() {
	      char[] movementChars = moves.toCharArray();
	      // get moves from move factory
	      MoveFactory mf = new MoveFactory();
	      Move lm = mf.getMove("left");
	      Move rm = mf.getMove("right");
	      Move fm = mf.getMove("forward");
	      boolean lostflag = false;
	      
	      for(char c:movementChars) {
	          String mvs = null;
	          // if the next move is forward make sure of the scent
	          if(c == 'F') {
	            mvs = ""+initialPosition.x+""+initialPosition.y+""+initialPosition.orientation;
	            // check whether previous robot has left the scent
	            if(sct.boundry(mvs)) {
	                continue;
	            }
	          }	          
	          if(c == 'L') {
	              lm.move(c, initialPosition);
	          }
	          else if(c == 'R') {
	              rm.move(c, initialPosition);
	          }
	          else if(c == 'F') {
	              fm.move(c, initialPosition);
	              //check if robot is withinlimit or not.
	              if(!withinLimit()) {
	                  lostflag = true;
	                  break;
	              }
	          }
	      }
	      // print the last position of robot
	      System.out.print(initialPosition.x+" "+initialPosition.y+" "+initialPosition.orientation);
	      if(lostflag) {
	          System.out.print(" Lost");
	      }
	      System.out.println();
	   }
	   
}

/*
 *This class should be singleton as we do not want to create multiple copies of 
 *HashSet holding scent information of robots. It should be shared by all the 
 *robots.
*/
class Scent {
	private static Scent scent = null;
	private HashSet<String> hst = new HashSet<>();	//stroes the scent information of lost robots.

	private Scent() {
		
	}
	//public method which allows other classes to create single object of scent.
	public static Scent getInstance() {
		if(scent == null) {
			scent = new Scent();	//create new instance.
		}
		return scent;			//return existing.
	}

	// check whether any robot has left any scent. if it has
	// then return true.also a public so any class can access it,
	public boolean boundry (String mvs) {
	   if(hst.contains(mvs)) {
		   return true;
	   }
	   return false;
	}
	
	// robot going out of grid will leave the scent which will be registered here
	public void addScent(String mvs) {
		hst.add(mvs);					//adding the position and orientation to the hashset.
	}
	
}