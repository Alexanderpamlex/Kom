package com.lau;

public class Line {
    Point begin,end;

    public Line(int x1,int y1,int x2,int y2){
        begin = new Point(x1,y1);
        end = new Point(x2,y2);
    }

    public Line(Point begin, Point end){
        this.begin = begin;
        this.end = end;
    }

    public Point getBegin() {
        return begin;
    }

    public void setBegin(Point begin) {
        this.begin = begin;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public String toString() {
        return "Line{" + "begin=" + begin + ", end=" + end + '}';
    }

    public double getLength(){
        System.out.print("Длинна отрезка: ");
        return begin.distance(end);
    }

    public double getGradient(){
        double a = end.getY()-begin.getY();
        double b = end.getX()-begin.getX();
        double c = a/b;
        System.out.print("Угол наклона отрезка относительно оси Х: ");
        return Math.atan(c)*180/Math.PI;
    }

    public double distance(Point p){
        double a = begin.distance(end);
        double b = begin.distance(p);
        double c = end.distance(p);
        double d = (a+b+c)/2;
        double s = Math.sqrt(d*(d-a)*(d-b)*(d-c));
        System.out.print("Расстояние от прямой до заданной точки: ");
        return 2*s/a;
    }

    public double distance(int x,int y){
        Point p = new Point(x,y);
        double a = begin.distance(end);
        double b = begin.distance(p);
        double c = end.distance(p);
        double d = (a+b+c)/2;
        double s = Math.sqrt(d*(d-a)*(d-b)*(d-c));
        System.out.print("Расстояние от прямой до заданной точки: ");
        return 2*s/a;
    }

    public boolean intersects(Line another) {

        int x1 = begin.getX();
        int x2 = end.getX();
        int y1 = begin.getY();
        int y2 = end.getY();

        int x3 = another.begin.getX();
        int x4 = another.end.getX();
        int y3 = another.begin.getY();
        int y4 = another.end.getY();

        int z1 = (x3 - x1) * (y2 - y1) - (y3 - y1) * (x2 - x1);
        int z2 = (x4 - x1) * (y2 - y1) - (y4 - y1) * (x2 - x1);
        int z3 = (x1 - x3) * (y4 - y3) - (y1 - y3) * (x4 - x3);
        int z4 = (x2 - x3) * (y4 - y3) - (y2 - y3) * (x4 - x3);

        int k1 = Math.min(x1,x2); int j1 = Math.min(x3,x4);
        int k2 = Math.max(x1,x2); int j2 = Math.max(x3,x4);
        int k3 = Math.min(y1,y2); int j3 = Math.min(y3,y4);
        int k4 = Math.max(y1,y2); int j4 = Math.max(y3,y4);

        if(k1==j1 || k2==j2 || k3==j3 || k4==j4)
            return true;

        if(z1*z2<0 && z3*z4<0) return true;
        else
            return false;

    }
}
