public class Point {
    private int x;
    private int y;


    // TODO: implement the constructor
    public Point(int x, int y){
			this.x = x;
			this.y = y;
		}

		private double distanceSquaredFromOrigin(){
			return x * x + y * y;
		}

    @Override
    public boolean equals(Object other){
        // TODO: change this implementaion as specified in the question
        // reflexive
        if(other == this) 
            return true; 
        // non-null
        if(other == null) 
            return false;
        // don't even bother! they have different types
        if(getClass() != other.getClass()) 
            return false;
        Point point = (Point) other; // why do we need this type cast?
        //return x == point.x && y == point.y;
        return this.distanceSquaredFromOrigin() == point.distanceSquaredFromOrigin();
    }

    @Override
    public int hashCode(){
        int hash = 41 + x;
        hash = 41 * hash + y;
        return hash;
    }

}