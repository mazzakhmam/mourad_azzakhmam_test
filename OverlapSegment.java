package com.nakisa.leasing.libraryScripts;

public class OverlapSegment {


  // A class to represent a sefments. It define the liness of the x-axis
  public class Segment {
    private int x1;
    private int x2;

    // Constructor
    public Segment(int x1, int x2) {
      super();
      // conformity
      if (x1 <= x2) {
        this.x1 = x1;
        this.x2 = x2;
      } else {
        this.x1 = x2;
        this.x2 = x1;
      }
    }

    // overlaps checking
    public boolean checkOverlap(Segment segment2) {
      if (segment2 == null)
        return false;
      // the conformity checkig is already checked so we will all the time have x1<=x2
      return (x1 <= segment2.getX1() && segment2.getX1() <= x2) || (x1 <= segment2.getX2() && segment2.getX2() <= x2) || (x1 >= segment2.getX1() && segment2.getX2() >= x2);
    }


    // print a segment
    @Override
    public String toString() {
      return "Segment [x1=" + x1 + ", X2=" + x2 + "]";
    }


    // getters and setters
    public int getX1() {
      return x1;
    }

    public void setX1(int x1) {
      // conformity checking
      if (x1 <= this.x2) {
        this.x1 = x1;
      }
    }

    public int getX2() {
      return x2;
    }

    public void setX2(int x2) {
      // conformity checking
      if (this.x1 <= x2) {
        this.x2 = x2;
      }
    }

  }


  public static void main(String[] args) {

    OverlapSegment overlapSegment = new OverlapSegment();

    Segment segment1 = overlapSegment.new Segment(1, 5);
    Segment segment2 = overlapSegment.new Segment(2, 6);
    System.out.println("Sgments overlap status is " + segment1.checkOverlap(segment2));
  }

}
