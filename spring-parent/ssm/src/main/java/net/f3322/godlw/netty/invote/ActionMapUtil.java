package net.f3322.godlw.netty.invote;

import java.lang.reflect.Method;
import java.util.HashMap;

public class ActionMapUtil {

    private static HashMap<Integer,Action> hashMap=new HashMap<Integer, Action>();

    public static Object invote(Integer key, Object... args) throws Exception{
        Action action=hashMap.get(key);
        if (action!=null){
            Method method=action.getMethod();
            try {
                return method.invoke(action.getObject(),args);
            }catch (Exception e){
                throw e;
            }
        }
        return null;
    }

    public static void put(Integer key,Action action){
        hashMap.put(key,action);
    }

    public static Action get(Integer key){
       return hashMap.get(key);
    }
}
