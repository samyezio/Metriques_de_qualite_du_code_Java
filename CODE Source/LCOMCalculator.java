
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class LCOMCalculator {

    public static int calculateLCOM(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        int methodCount = methods.length;
        if (methodCount <= 1) {
            return 0; // If there's only one method or no methods, LCOM is 0
        }

        int[][] intersectionMatrix = new int[methodCount][methodCount];

        // Initialize intersection matrix
        for (int i = 0; i < methodCount; i++) {
            for (int j = i + 1; j < methodCount; j++) {
                intersectionMatrix[i][j] = intersectionMatrix[j][i] = countSharedAttributes(methods[i], methods[j]);
            }
        }

        // Calculate LCOM
        int lcom = 0;
        for (int i = 0; i < methodCount; i++) {
            for (int j = i + 1; j < methodCount; j++) {
                if (intersectionMatrix[i][j] == 0) {
                    lcom++;
                }
            }
        }
        return lcom;
    }

    private static int countSharedAttributes(Method method1, Method method2) {
        Set<String> attributes1 = getAttributesFromMethod(method1);
        Set<String> attributes2 = getAttributesFromMethod(method2);

        // Find common attributes
        attributes1.retainAll(attributes2);

        return attributes1.size();
    }

    private static Set<String> getAttributesFromMethod(Method method) {
        Set<String> attributes = new HashSet<>();
        String methodName = method.getName();
        Field[] fields = method.getDeclaringClass().getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            if (methodName.contains(fieldName)) {
                attributes.add(fieldName);
            }
        }
        return attributes;
    }
}

