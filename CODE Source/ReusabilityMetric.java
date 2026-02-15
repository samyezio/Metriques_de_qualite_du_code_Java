import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReusabilityMetric {
    // Méthode pour calculer le score de réutilisabilité
    public static double calculateReusability(Class<?> clazz) {
        double cohesionScore = calculateCohesionScore(clazz);
        double couplingScore = calculateCouplingScore(clazz);
        double interfaceUsageScore = calculateInterfaceUsageScore(clazz);

        // Calculer un score global de réutilisabilité
        return (cohesionScore + interfaceUsageScore) / (couplingScore + 1);

    }


    // Méthode pour calculer le score de cohésion
     public static double calculateCohesionScore(Class<?> clazz) {
        int relevantMethodsCount = 0;

        for (Method method : clazz.getDeclaredMethods()) {
            if (!method.getName().startsWith("get") && !method.getName().startsWith("set") && !method.getName().startsWith("is")
                    && !method.getName().equals("<init>")) {
                relevantMethodsCount++;
            }
        }

        double cohesionScore = relevantMethodsCount / (double) clazz.getDeclaredMethods().length;

        return cohesionScore;
    }


    /*la méthode de calcul du score de cohésion évalue à quel point les méthodes 
    d'une classe travaillent ensemble vers un objectif commun. Plus le score est proche de 1, 
    plus les méthodes sont liées, ce qui améliore la cohésion et la maintenabilité du code */

    // Méthode pour calculer le score de couplage
     public static double calculateCouplingScore(Class<?> clazz) {
        int externalDependenciesCount = 0;

        for (Field field : clazz.getDeclaredFields()) {
            if (Modifier.isPublic(field.getModifiers())) {
                externalDependenciesCount++;
            }
        }

        for (Method method : clazz.getDeclaredMethods()) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                if (!parameterType.getName().startsWith("java.") && !parameterType.getName().startsWith("javax.")) {
                    externalDependenciesCount++;
                }
            }
        }

        double couplingScore = externalDependenciesCount / (double) (clazz.getDeclaredFields().length + clazz.getDeclaredMethods().length);

        return couplingScore;
    }
    /* cette partie du code compte le nombre de dépendances externes 
    indirectes de la classe en comptant les types de paramètres des méthodes qui 
    ne font pas partie des packages standard de Java. Cela permet de quantifier 
    le degré de dépendance de la classe par rapport à d'autres classes utilisées en 
    tant que types de paramètres */


    // Méthode pour calculer le score d'utilisation d'interfaces  
     public static double calculateInterfaceUsageScore(Class<?> clazz) {
        int implementedInterfacesCount = clazz.getInterfaces().length;

        double interfaceUsageScore = implementedInterfacesCount / (double) (clazz.getInterfaces().length +1); // +1 pour éviter la division par zéro

        return interfaceUsageScore;
    }
    /* le score d'utilisation d'interfaces évalue la flexibilité et l'extensibilité d'une classe en mesurant 
    dans quelle mesure elle utilise les interfaces. Une forte utilisation d'interfaces indique une conception 
    orientée vers l'interface, ce qui peut rendre le code plus adaptable et plus facile à maintenir */
}