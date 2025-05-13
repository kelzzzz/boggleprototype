import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglFiles;
import com.badlogic.gdx.backends.lwjgl.LwjglNativesLoader;

public class Headless {
    public static void loadHeadless() {
        LwjglNativesLoader.load();
        Gdx.files = new LwjglFiles();
    }
}
