package vertx;


import io.vertx.core.Launcher;

/**
 * Hello world!
 *
 */
public class App extends Launcher
{
    public static void main( String[] args )
    {
        new App().dispatch(args);
    }
}
