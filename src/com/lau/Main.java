package com.lau;

public class Main {

    public static void main(String[] args) {
	Point p1 = new Point(2,1);
        System.out.println(p1);
    Point p2 = new Point();
    p2.setXY(5,3);
        System.out.println(p2);
    Line l1 = new Line(p1,p2);
        System.out.println(l1);
        System.out.println(l1.getLength());
        System.out.println(l1.getGradient());
    Point p3 = new Point(7,2);
        System.out.println(l1.distance(p3));
        System.out.println(l1.distance(3,2));
    Line l2 = new Line(3,3,5,-2);
        System.out.println(l2);
        System.out.println(l2.intersects(l1));
    }
}
