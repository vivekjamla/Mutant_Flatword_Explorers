/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vivek.project;

import java.io.*;
import java.util.*;

/**
 *@author Vivekkumar
 *this class have user defined grid instance variables for robot.
 */
//class postion


class Position {
    int x;				//x axes of grid
    int y;				//y axes Position of grid
    char orientation;	//which direction robot is facing.
}

/*
 * Contains main method,
 * reads input from file and add robots objects to the arraylist and start processing robots sequentially by calling the robot class.
 * 
 */

public class Game {
    public static void main(String []args) throws Exception {
    	FileReader fr = new FileReader("vivek.txt");
        BufferedReader br = new BufferedReader(fr);
        String input = null;
        input = br.readLine();
        //reading the first line which has the grid information.
        StringTokenizer st = new StringTokenizer(input);
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        
        // robot holder
        ArrayList<Robot> robots = new ArrayList<Robot>();
        
        while((input = br.readLine())!=null) {
            String initPos = input;
            StringTokenizer ston = new StringTokenizer(initPos);
            String moves   = br.readLine();
            int initx = Integer.parseInt(ston.nextToken());
            int inity = Integer.parseInt(ston.nextToken());
            char []direction = ston.nextToken().toCharArray();
            // create robot and add it to list
            Robot r = new Robot(x, y, initx, inity, direction[0], moves);	//calling the robot constructor and initialize.
            robots.add(r);	//adding robot object into arraylist.
        }
        br.close();
        
        // start processing robots sequentially
        for(Robot robot:robots) {
            robot.findEnd();
        }
    }
}
