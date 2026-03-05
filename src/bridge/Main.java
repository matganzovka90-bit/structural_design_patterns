package bridge;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        Renderer vector = new VectorRender();
        Renderer raster = new RasterRender();

        Shape circle = new Circle(vector);
        Shape square1 = new Square(raster);
        Shape square2 = new Square(vector);
        Shape triangle = new Triangle(raster);


        circle.draw();
        square1.draw();
        square2.draw();
        triangle.draw();
    }
}
