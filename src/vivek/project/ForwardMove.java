package vivek.project;
//Factory pattern is implemented
//makes the robot to move one step ahead in particular orientation.
class ForwardMove implements Move {
    public void move(char c, Position p) {
        if(p.orientation == 'W') {
            p.x--;
        }
        else if(p.orientation == 'S') {
            p.y--;
        }
        else if(p.orientation == 'N') {
            p.y++;
        }
        else if(p.orientation == 'E') {
            p.x++;
        }
    }
}