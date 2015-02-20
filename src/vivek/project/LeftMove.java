package vivek.project;
//Factory pattern is implemented
//changes the orientation of robot to the left.
class LeftMove implements Move {
    public void move(char prev, Position p) {
        if(p.orientation == 'W') {
            p.orientation = 'S';
        }
        else if(p.orientation == 'S') {
            p.orientation = 'E';
        }
        else if(p.orientation == 'N') {
            p.orientation = 'W';
        }
        else if(p.orientation == 'E') {
            p.orientation = 'N';
        }
    }
}