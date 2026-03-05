package bridge;

public class VectorRender implements Renderer {
    @Override
    public void render(String shapeName) {
        System.out.println("Drawing " + shapeName + " as vector");
    }
}
