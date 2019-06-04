package LAB_12;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PDSSerializer {
    public static String fromObject(Object o){
        Class cl = o.getClass();
        //Explore os metodos
        if (o == null) {
            System.out.println("null");
            return "adeus";
        }
        System.out.println(o.getClass().getName());

        if (cl.isPrimitive() || o instanceof java.lang.String || o instanceof Integer || o instanceof Double
                || o instanceof Boolean )
            return o.toString();
        else{
            StringBuilder sb = new StringBuilder();
            for(Method a:cl.getMethods()){
                if(a.getName().startsWith("get") && !a.getName().endsWith("Class")){
                    try
                    {
                        Object object=a.invoke(o);
                        if(object!=null){
                            System.out.println(a.getName());
                            sb.append(a.getName().substring(3)+":"+fromObject(object)+"\n");
                        }
                        //sb.append(fromObject(a));

                    }
                    catch (IllegalAccessException e)
                    {
                        System.err.println("Could not determine method: " + a.getName());
                    }catch (InvocationTargetException e){
                        System.err.println("Could not determine method: " + a.getName());

                    }


                }
            }
            return sb.toString();
        }

        /*
        for(Field a: cl.getFields()){

            try
            {
                sb.append(a.getName().substring(3));
                sb.append(fromObject(a.get(o)));

            }
            catch (IllegalAccessException e)
            {
                System.err.println("Could not determine method: " + a.getName());
            }
        }*/
        //Veja o javadoc das classes: Class, Method, Field, Modifier

    }
}
