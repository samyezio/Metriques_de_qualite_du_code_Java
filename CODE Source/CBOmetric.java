import java.util.HashSet;
import java.util.Set;
public class CBOmetric {
// Méthode pour calculer le CBO d'une classe
    public static int calculateCBO(Class<?> clazz) {
        Set<Class<?>> coupledClasses = getCoupledClasses(clazz);
        
        // Retourner le nombre de classes couplées
        return coupledClasses.size();
    }
    
    // Méthode pour obtenir les classes couplées à une classe donnée
    private static Set<Class<?>> getCoupledClasses(Class<?> clazz) {
        Set<Class<?>> coupledClasses = new HashSet<>();
        // Récupérer les dépendances par les champs
        for (java.lang.reflect.Field field : clazz.getDeclaredFields()) {
            Class<?> fieldType = field.getType();
            coupledClasses.add(fieldType);
        }
        // Récupérer les dépendances par les méthodes
        for (java.lang.reflect.Method method : clazz.getDeclaredMethods()) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                coupledClasses.add(parameterType);
            }
            Class<?> returnType = method.getReturnType();
            if (returnType != null) {
                coupledClasses.add(returnType);
            }
        }
        
        return coupledClasses;
    }
}