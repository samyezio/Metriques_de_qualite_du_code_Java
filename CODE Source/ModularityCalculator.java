
   

import java.lang.reflect.Method;

public class ModularityCalculator {

    public static int calculateFanIn(Class<?> clazz) {
        // Compter le nombre de classes qui appellent des méthodes de la classe donnée
        int fanInCount = 0;
        for (Method method : clazz.getDeclaredMethods()) {
            for (Class<?> parameterType : method.getParameterTypes()) {
                if (parameterType.equals(clazz)) {
                    fanInCount++;
                    break; // Sortir de la boucle dès qu'une référence est trouvée
                }
            }
        }
        return fanInCount;
    }

   
    public static int calculateFanOut(Class<?> clazz) {
        // Compter le nombre de classes appelées par les méthodes de la classe donnée
        int fanOutCount = 0;
        for (Method method : clazz.getDeclaredMethods()) {
            Class<?> returnType = method.getReturnType();
            if (returnType != null && !returnType.equals(void.class)) {
                fanOutCount++;
            }
        }
        return fanOutCount;
    }

    
}












