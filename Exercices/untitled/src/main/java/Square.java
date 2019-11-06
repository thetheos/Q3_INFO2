public class Square extends Shape {

    public void Square(){
    }

    @Override
    public double getArea(double d){
        return d*d;
    }

    @Override
    public double getPerimeter(double d){
        return 4*d;
    }

}
