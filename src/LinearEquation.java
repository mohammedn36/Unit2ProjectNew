public class LinearEquation {
    /* Instance Variables */
    private int x1;
    private int y1;
    private int x2;
    private int y2;


    /* Creates a LinearEquation object */
/* PRECONDITION: x1 and x2 are NOT equal (client programs are responsible for ensuring
   this precondition is not violated) */
public LinearEquation(int x1, int y1, int x2, int y2){
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
}


/* Calculates and returns distance between (x1, y1) and (x2, y2), rounded to
   the nearest hundredth */
    public double distance(){ // similar to (y2 - y1)^2 + (x2 - x1)^2
        double xPower = Math.pow(x2 - x1, 2);
        double yPower = Math.pow(y2 - y1, 2);
        return roundedToHundredth(Math.sqrt(yPower + xPower));
    }


    /* Calculates and returns the y-intercept of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth */
    public double yIntercept(){
        double firstSlope = slope() * x1;
        return roundedToHundredth(y1 - firstSlope);
    }



    /* Calculates and returns the slope of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth */
    public double slope() {
        return roundedToHundredth((double) (y1 - y2) / (x1 - x2));
    }


    /* Returns a String that represents the linear equation of the line through points
       (x1, y1) and (x2, y2) in slope-intercept (y = mx + b) form, e.g. "y = 3x + 1.5".

        When generating the m value (slope), here are examples of "printable" slopes:
           5, -5, 1/2, 6/8 (reducing not required), 8/5, -2/3, -18/7

        Here are non-examples of "printable" slopes:
     1/-2 (should be -1/2), -4/-3 (should be 4/3), 8/4 (should be reduced to 2),
           -12/3 (should be -4), 3/3 (should be 1), -6/6 (should be -1)

        HINT: Be sure to check if the line is horizontal and return an appropriate string,
        e.g. y = 6
        HINT: Absolute value might be helpful for ensuring proper placement of negative sign!


        When generating the b value, here are some examples of "printable" y-intercepts:
           + 1.0 	- 2.35	      + 12.5		- 8.0		+ 17.19

        Here are non-examples of "printable" y-intercepts:
           - -1.0 	+ -2.35	- -12.5	+ -8.0	     - -17.19	+ 0	- 0

        HINT: Absolute value might be helpful for printing negative y-intercepts as
               subtraction!
     */
    public String equation() {
        double slope = slope();
        double yIntercept = yIntercept();

        // Check for horizontal line
        if (slope == 0) {
            return "y = " + yIntercept;
        }

        // Check for vertical line
        if (Double.isInfinite(slope)) {
            return "x = " + x1;
        }

        // Build the equation string
        String equation = "y = " + slope + "x ";
        if (yIntercept < 0) {
            equation += "- ";
        } else {
            equation += "+ ";
        }
        equation += Math.abs(yIntercept);
        return equation;
    }

// Helper method to find the greatest common
    private static double greatestCommonDivisor(int a, int b) {
        if (b == 0) {
            return a;
        }
        return greatestCommonDivisor(b, a % b);
    }

    public String coordinateForX(double xValue) {
        double y = (slope() * xValue) + yIntercept();
        return "(" + roundedToHundredth(xValue) + ", " + roundedToHundredth(y) + ")";


    }


    public double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }


    public String lineInfo() {
        String n = "\n";

        String l1 = "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")";
        String l2 = "The equation of the line between these points is: " + equation();
        String l3 = "The slope of this line is: " + slope();
        String l4 = "The y-intercept of the line is: " + yIntercept();
        String l5 = "The distance between the two points is: " + distance();
        return l1 + n + l2 + n + l3 + n + l4 + n + l5 + n;


}

}