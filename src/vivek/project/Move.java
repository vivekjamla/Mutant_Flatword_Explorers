package vivek.project;

interface Move {
    public void move(char c, Position p);
}

// Factory method pattern for move. return according the fact value.
class MoveFactory {
	public Move getMove(String fact) {
		if(fact == null) {
			return null;
		}
		else if(fact.equals("left")) {
			return new LeftMove();
		}
		else if(fact.equals("right")) {
			return new RightMove();
		}
		else if(fact.equals("forward")) {
			return new ForwardMove();
		}
		return null;
	}
}