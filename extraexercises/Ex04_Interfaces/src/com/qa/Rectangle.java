//Rectangle.java
package com.qa;

public class Rectangle extends Shape{
        //fields, not available in Shape
        private double height, width;
            //constructor that calls the Shape constructor
        public Rectangle(String name, String colour, double x,

                                              double y, double width, double height) {
            super(name, colour, x, y);
            this.width = width;
            this.height = height;
        }

            //method - not available in Circle
        public boolean isSquare() {
            return (width == height);
        }

            //override the abstract methods in the Shape class
        @Override
        public double getArea() {
            return width * height;
        }

        @Override
        public Point getCentrePoint() {
            double centreX = getX() + width / 2;
            double centreY = getY() + height / 2;
            return new Point(centreX, centreY);
        }

                //override the method in the Object class
        @Override
        public String toString() {
            return "Rectangle [height=" + height + ", width=" + width
                    + ", isSquare()=" + isSquare() + ", getArea()="
                    + getArea() + ", getCentrePoint()=" + getCentrePoint()
                    + ", getX()=" + getX() + ", getY()=" + getY()
                    + ", getName()=" + getName()+ ", getColour()="
                    + getColour() + "]";
        }
}