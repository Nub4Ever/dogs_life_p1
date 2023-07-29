package com.qa;

// abstract means that this class can't be instantiated, but can
// have abstract methods as well as concrete methods
public abstract class Shape {
        //private fields
        private String name;
            private String colour;
                private double x, y;
                    //basic constructor
        public Shape(String name, String colour, double x, double y) {
            this.name = name;
            this.colour = colour;
            this.x = x;
            this.y = y;
        }

            //getters and setters
        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }


        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getColour() {
            return colour;
        }

        public void setColour(String colour) {
            this.colour = colour;
        }

        //abstract methods - implemented by the sub-classes
    //
        public abstract double getArea();
        public abstract Point getCentrePoint();
}