package bridge;

public class RasterRender implements Renderer {

    @Override
    public void render(String shapeName) {
        System.out.println("Rendering " + shapeName + " as pixels");
    }
}
