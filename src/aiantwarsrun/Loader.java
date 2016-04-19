/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiantwarsrun;

import aiantwars.IAntWarsPlayer;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;



/**
 *
 * @author Tobias Grundtvig
 */
public class Loader
{
    private final String rootPath;

    public Loader(String rootPath)
    {
        this.rootPath = rootPath;
    }
    
    public Collection<IAntWarsPlayer> loadCategory(String prefix, int size)
    {
        ArrayList<IAntWarsPlayer> res = new ArrayList<>();
        for(int i = 1; i <= size; ++i)
        {
            String jarFile = rootPath + "/" + prefix + i + ".jar";
            String className = prefix.toLowerCase() + i + "." + prefix + i;
            IAntWarsPlayer player = loadPlayer(jarFile, className);
            if(player != null)
            {
                System.out.println("Loaded: " + prefix + i + " -> " + player.getTeamName());
                res.add(player);
            }
        }
        return res;
    }

    
    public static IAntWarsPlayer loadPlayer(String jar, String className)
    {
        IAntWarsPlayer res = null;
        try
        {
            addJar(jar);
            res = (IAntWarsPlayer) Class.forName(className).newInstance();
        } catch (Exception e)
        {
        }
        return res;
    }

    private static void addJar(String s) throws Exception
    {
        File f = new File(s);
        URI u = f.toURI();
        URLClassLoader urlClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        Class<URLClassLoader> urlClass = URLClassLoader.class;
        Method method = urlClass.getDeclaredMethod("addURL", new Class[]
        {
            URL.class
        });
        method.setAccessible(true);
        method.invoke(urlClassLoader, new Object[]
        {
            u.toURL()
        });
    }
}
