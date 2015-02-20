package vivek.project;
//Factory pattern is implemented
//changes the robot orientation to right from current orientation.
class RightMove implements Move {
    public void move(char c, Position p) {
        if(p.orientation == 'W') {
            p.orientation = 'N';
        }
        else if(p.orientation == 'S') {
            p.orientation = 'W';
        }
        else if(p.orientation == 'N') {
            p.orientation = 'E';
        }
        else if(p.orientation == 'E') {
            p.orientation = 'S';
        }
    }
}
