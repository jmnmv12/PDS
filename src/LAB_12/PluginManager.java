package LAB_12;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class PluginManager {

    public static IPlugin load(String name) throws Exception {
        Class<?> c = Class. forName (name);
        return (IPlugin) c.getDeclaredConstructor().newInstance();
    }

}
