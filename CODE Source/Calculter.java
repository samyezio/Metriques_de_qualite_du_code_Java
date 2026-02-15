import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Calculter {
    public static int totalMethods(Class<?> classe) {

        int numTotalMethod = 0;

        // Include declared methods of the class
        for (Method method : classe.getDeclaredMethods()) {
            if (!isOverriddenMethod(method) && !isOverriddenMethodInterface(method)) { // Exclude static methods

                numTotalMethod++;
            }
        }

        // Include methods from interfaces implemented by the class
        for (Class<?> iface : classe.getInterfaces()) {
            numTotalMethod += totalMethods(iface);
        }

        // Include methods from superclasses recursively
        if (classe.getSuperclass() != null) {
            numTotalMethod += totalMethods(classe.getSuperclass());
        }

        return numTotalMethod;
    }

    public static int publicDeclaredInClassMethods(Class<?> classe) {
        int numPublicMethod = 0;
        for (java.lang.reflect.Method method : classe.getDeclaredMethods()) {
            if (java.lang.reflect.Modifier.isPublic(method.getModifiers())) {
                numPublicMethod++;
            }
        }

        return numPublicMethod;
    }
    public static int allPublicMethods(Class<?> classe) {
        int numPublicMethod = 0;
        for (java.lang.reflect.Method method : classe.getMethods()) {
            if (java.lang.reflect.Modifier.isPublic(method.getModifiers())) {
                numPublicMethod++;
            }
        }

        return numPublicMethod;
    }

    public static int privateDeclaredInClassMethods(Class<?> classe) {
        int numPrivateMetohd = 0;
        for (java.lang.reflect.Method method : classe.getDeclaredMethods()) {
            if (java.lang.reflect.Modifier.isPrivate(method.getModifiers())) {
                numPrivateMetohd++;
            }
        }
        return numPrivateMetohd;
    }
    public static int allPrivateMethods(Class<?> classe) {
        int num = 0;
        if (classe != null) {
            num = num + allPrivateMethods(classe.getSuperclass());
        }
        if (classe != null) {
            for (Method method : classe.getDeclaredMethods()) {
                if (java.lang.reflect.Modifier.isPrivate(method.getModifiers())) {
                    num++;
                }
            }
        }
        return num;
    }

    public static int protectedDeclaredInClassMethods(Class<?> classe) {
        int numProtectedMetohd = 0;
        for (java.lang.reflect.Method method : classe.getDeclaredMethods()) {
            if (java.lang.reflect.Modifier.isProtected(method.getModifiers())) {
                numProtectedMetohd++;
            }
        }
        return numProtectedMetohd;
    }
    public static int allProtectedMethods(Class<?> classe) {
        int num = 0;
        if (classe != null) {
            num = num + allProtectedMethods(classe.getSuperclass());
        }
        if (classe != null) {
            for (java.lang.reflect.Method method : classe.getDeclaredMethods()) {
                if (java.lang.reflect.Modifier.isProtected(method.getModifiers()) &&
                        !isOverriddenMethod(method)) {

                    num++;
                }
            }
        }
        return num;
    }

    public static int defaultAccessModifierDeclaredInClassMethods(Class<?> classe) {
        int numDefaultAccessModifierMetohd = 0;
        for (java.lang.reflect.Method method : classe.getDeclaredMethods()) {
            if (!java.lang.reflect.Modifier.isPublic(method.getModifiers()) &&
                    !java.lang.reflect.Modifier.isProtected(method.getModifiers()) &&
                    !java.lang.reflect.Modifier.isPrivate(method.getModifiers())) {
                System.out.println("class name= " + (method.getDeclaringClass()).getName() + "  /  methode name = "
                        + method.getName());

                numDefaultAccessModifierMetohd++;
            }
        }
        return numDefaultAccessModifierMetohd;
    }
    public static int allDefaultAccessModifierMethods(Class<?> classe) {
        int num = 0;
        if (classe != null) {
            num = num + allDefaultAccessModifierMethods(classe.getSuperclass());
        }
        if (classe != null) {
            for (java.lang.reflect.Method method : classe.getDeclaredMethods()) {
                if (!java.lang.reflect.Modifier.isPublic(method.getModifiers()) &&
                        !java.lang.reflect.Modifier.isProtected(method.getModifiers()) &&
                        !java.lang.reflect.Modifier.isPrivate(method.getModifiers()) &&
                        !isOverriddenMethod(method)) {
                    num++;
                }
            }
        }
        return num;
    }


    public static int finalMethods(Class<?> classe) {
        int numFinalMetohd = 0;
        for (java.lang.reflect.Method method : classe.getDeclaredMethods()) {
            if (java.lang.reflect.Modifier.isFinal(method.getModifiers())) {
                numFinalMetohd++;
            }
        }
        return numFinalMetohd;
    }

    public static int staticMethods(Class<?> classe) {
        int numStaticMetohd = 0;
        for (java.lang.reflect.Method method : classe.getDeclaredMethods()) {
            if (java.lang.reflect.Modifier.isStatic(method.getModifiers())) {
                numStaticMetohd++;
            }
        }
        return numStaticMetohd;
    }

    public static int abstractMethods(Class<?> classe) {
        int numAbstractMetohd = 0;
        for (java.lang.reflect.Method method : classe.getDeclaredMethods()) {
            if (java.lang.reflect.Modifier.isAbstract(method.getModifiers())) {
                numAbstractMetohd++;
            }
        }
        return numAbstractMetohd;
    }


    public static int inheritedMethods(Class<?> classe) {
        int numInheritedMetohd = totalMethods(classe);
        for (Method method : classe.getDeclaredMethods()) {
            Method superClassMethod = getSuperclassMethod(classe, method);
            if (superClassMethod == null) {
                numInheritedMetohd--;
            }
        }

        return numInheritedMetohd;
    }

    public static int overrideMethods(Class<?> classe) {
        int numOverrideMetohd = 0;
        for (java.lang.reflect.Method method : classe.getDeclaredMethods()) {
            Method superInterface = getSuperInterfaceMethod(classe, method);
            Method superClassMethod = getSuperclassMethod(classe, method);
            if (superClassMethod != null || superInterface != null) {
                numOverrideMetohd++;
            }

        }
        return numOverrideMetohd;
    }


    private static Method getSuperclassMethod(Class<?> clazz, Method method) {
        Class<?> superclass = clazz.getSuperclass();
        if (superclass != null) {
            try {
                // Attempt to get the method from the superclass
                return superclass.getMethod(method.getName(), method.getParameterTypes());
            } catch (NoSuchMethodException e) {
                // Method not found in the superclass
            }
        }
        return null;
    }

    private static Method getSuperInterfaceMethod(Class<?> clazz, Method method) {
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> iface : interfaces) {
            try {
                // Attempt to get the method from the interface
                return iface.getMethod(method.getName(), method.getParameterTypes());
            } catch (NoSuchMethodException e) {
                // Method not found in this interface, continue checking others
            }
        }
        return null;
    }

    private static boolean isOverriddenMethod(Method method) {
        Class<?> declaringClass = method.getDeclaringClass();
        Class<?> superclass = declaringClass.getSuperclass();

        // Check if method is declared in a superclass
        while (superclass != null) {
            for (Method superMethod : superclass.getDeclaredMethods()) {
                if (method.getName().equals(superMethod.getName()) &&
                        java.util.Arrays.equals(method.getParameterTypes(), superMethod.getParameterTypes())) {
                    return true; // Overridden method found
                }
            }
            superclass = superclass.getSuperclass();
        }

        return false; // Not an overridden method
    }

    private static boolean isOverriddenMethodInterface(Method method) {
        Class<?> declaringClass = method.getDeclaringClass();

        // Get all interfaces implemented by the declaring class
        Class<?>[] interfaceClasses = declaringClass.getInterfaces();

        // Check if method is declared in any interface
        for (Class<?> interfaceClass : interfaceClasses) {
            try {
                // Attempt to retrieve the method from the interface
                Method interfaceMethod = interfaceClass.getMethod(method.getName(), method.getParameterTypes());
                if (interfaceMethod != null) {
                    return true; // Method is declared in an interface
                }
            } catch (NoSuchMethodException e) {
                // Method is not declared in this interface, continue checking others
            }
        }

        return false; // Method is not declared in any interface
    }


    public static String[] namesTotalMethod(Class<?> clazz) {
        List<String> methodNames = new ArrayList<>();

        // Include declared methods of the class
        for (Method method : clazz.getDeclaredMethods()) {
            if (!isOverriddenMethod(method) && !isOverriddenMethodInterface(method)) {
                methodNames.add("class name = " + clazz.getName() + " / method name = " + method.getName());
            }
        }

        // Include methods from interfaces implemented by the class
        for (Class<?> iface : clazz.getInterfaces()) {
            methodNames.addAll(Arrays.asList(namesTotalMethod(iface)));
        }

        // Include methods from superclasses recursively
        if (clazz.getSuperclass() != null) {
            methodNames.addAll(Arrays.asList(namesTotalMethod(clazz.getSuperclass())));
        }

        return methodNames.toArray(new String[0]);
    }

    public static String[] namesPublicDeclaredInClassMetohd(Class<?> classe) {

        int n = publicDeclaredInClassMethods(classe);
        String[] numPublicMethod = new String[n];
        int i = 0;

        for (java.lang.reflect.Method method : classe.getDeclaredMethods()) {
            if (java.lang.reflect.Modifier.isPublic(method.getModifiers())) {
                numPublicMethod[i] = "class name = " + (method.getDeclaringClass()).getName() + " /  method name = "
                        + method.getName();
                i++;
            }
        }

        return numPublicMethod;
    }
    public static String[] namesAllPublicMetohd(Class<?> classe) {

        int n = allPublicMethods(classe);
        String[] numPublicMethod = new String[n];
        int i = 0;
        for (java.lang.reflect.Method method : classe.getMethods()) {
            if (java.lang.reflect.Modifier.isPublic(method.getModifiers())) {
                numPublicMethod[i] = "class name = " + (method.getDeclaringClass()).getName() + " /  method name = "
                        + method.getName();
                i++;
            }
        }

        return numPublicMethod;
    }

    public static String[] namesPrivateDeclaredInClassMetohd(Class<?> classe) {

        int n = privateDeclaredInClassMethods(classe);
        String[] numPrivateMetohd = new String[n];
        int i = 0;
        for (java.lang.reflect.Method method : classe.getDeclaredMethods()) {
            if (java.lang.reflect.Modifier.isPrivate(method.getModifiers())) {
                numPrivateMetohd[i] = "class name = " + (method.getDeclaringClass()).getName() + " /  method name = "
                        + method.getName();
                i++;
            }
        }
        return numPrivateMetohd;
    }
    public static String[] namesAllPrivateMethods(Class<?> classe) {
        List<String> namesPrivateMethods = new ArrayList<>();

        // Collect private method names in the current class
        for (Method method : classe.getDeclaredMethods()) {
            if (java.lang.reflect.Modifier.isPrivate(method.getModifiers())) {
                namesPrivateMethods.add("class name = " + (method.getDeclaringClass()).getName() + " /  method name = "
                + method.getName());
            }
        }

        // Recursively collect private method names from superclasses
        String[] superClassMethods = namesAllPrivateMethods(classe.getSuperclass());
        for (String methodName : superClassMethods) {
            namesPrivateMethods.add(methodName);
        }

        // Convert List to array
        return namesPrivateMethods.toArray(new String[0]);
    }

    public static String[] namesProtectedDeclaredInClassMetohd(Class<?> classe) {
        String[] numProtectedMetohd = new String[protectedDeclaredInClassMethods(classe)];
        int i = 0;

        for (java.lang.reflect.Method method : classe.getDeclaredMethods()) {
            if (java.lang.reflect.Modifier.isProtected(method.getModifiers())) {
                numProtectedMetohd[i] = "class name = " + (method.getDeclaringClass()).getName() + " /  method name = "
                        + method.getName();
                i++;
            }
        }
        return numProtectedMetohd;
    }
    public static String[] namesAllProtectedMethods(Class<?> classe) {
    List<String> namesProtectedMethods = new ArrayList<>();

        // Collect protected method names in the current class
        for (Method method : classe.getDeclaredMethods()) {
            if (java.lang.reflect.Modifier.isProtected(method.getModifiers()) && !isOverriddenMethod(classe, method)) {
                namesProtectedMethods.add("class name = " + (method.getDeclaringClass()).getName() + " /  method name = "
                        + method.getName());
            }
        }

        // Recursively collect protected method names from superclasses
        String[] superClassMethods = namesAllProtectedMethods(classe.getSuperclass());
        for (String methodName : superClassMethods) {
            namesProtectedMethods.add(methodName);
        }

        // Convert List to array
        return namesProtectedMethods.toArray(new String[0]);
    }

    public static String[] namesDefaultAccessModifierDeclaredInClassMetohd(Class<?> classe) {
        String[] numDefaultAccessModifierMetohd = new String[defaultAccessModifierDeclaredInClassMethods(classe)];
        int i = 0;
        for (java.lang.reflect.Method method : classe.getDeclaredMethods()) {
            if (!java.lang.reflect.Modifier.isPublic(method.getModifiers()) &&
                    !java.lang.reflect.Modifier.isProtected(method.getModifiers()) &&
                    !java.lang.reflect.Modifier.isPrivate(method.getModifiers())) {
                System.out.println("class name= " + (method.getDeclaringClass()).getName() + "  /  methode name = "
                        + method.getName());

                numDefaultAccessModifierMetohd[i] = "class name = " + (method.getDeclaringClass()).getName()
                        + " /  method name = " + method.getName();
                i++;
            }
        }
        return numDefaultAccessModifierMetohd;
    }
    public static String[] namesAllDefaultAccessModifierMethods(Class<?> classe) {
        if (classe == null) {
            return new String[0];
        }

        List<String> namesDefaultAccessMethods = new ArrayList<>();

        // Collect default access modifier method names in the current class
        for (Method method : classe.getDeclaredMethods()) {
            if (!java.lang.reflect.Modifier.isPublic(method.getModifiers()) &&
                !java.lang.reflect.Modifier.isProtected(method.getModifiers()) &&
                !java.lang.reflect.Modifier.isPrivate(method.getModifiers()) &&
                !isOverriddenMethod(classe, method)) {
                namesDefaultAccessMethods.add("class name = " + (method.getDeclaringClass()).getName() + " /  method name = "
                + method.getName());
            }
        }

        // Recursively collect default access modifier method names from superclasses
        String[] superClassMethods = namesAllDefaultAccessModifierMethods(classe.getSuperclass());
        for (String methodName : superClassMethods) {
            namesDefaultAccessMethods.add(methodName);
        }

        // Convert List to array
        return namesDefaultAccessMethods.toArray(new String[0]);
    }

    public static String[] namesFinalMethods(Class<?> classe) {
        
        List<String> finalMethodNames = new ArrayList<>();

        // Collect final method names
        for (Method method : classe.getDeclaredMethods()) {
            if (java.lang.reflect.Modifier.isFinal(method.getModifiers())) {
                finalMethodNames.add("class name = " + (method.getDeclaringClass()).getName() + " /  method name = "
                + method.getName());
            }
        }

        // Convert List to array
        return finalMethodNames.toArray(new String[0]);
    }

    public static String[] namesStaticMethods(Class<?> classe) {
        List<String> staticMethodNames = new ArrayList<>();
        // Collect static method names
       for (Method method : classe.getDeclaredMethods()) {
        if (java.lang.reflect.Modifier.isStatic(method.getModifiers())) {
            staticMethodNames.add("class name = " + (method.getDeclaringClass()).getName() + " /  method name = "
            + method.getName());
        }
    }

    // Convert List to array
    return staticMethodNames.toArray(new String[0]);
    }

    public static String[] namesAbstractMethods(Class<?> classe) {
        List<String> AbstractMethodNames = new ArrayList<>();
        // Collect abstract method names
       for (Method method : classe.getDeclaredMethods()) {
        if (java.lang.reflect.Modifier.isAbstract(method.getModifiers())) {
            AbstractMethodNames.add(method.getName());
        }
    }

    // Convert List to array
    return AbstractMethodNames.toArray(new String[0]);
    }


    public static String[] namesInheritedMetohd(Class<?> clazz) {
        List<String> methodNames = new ArrayList<>();

        // Include methods from interfaces implemented by the class
        for (Class<?> iface : clazz.getInterfaces()) {
            methodNames.addAll(Arrays.asList(namesTotalMethod(iface)));
        }

        // Include methods from superclasses recursively
        if (clazz.getSuperclass() != null) {
            methodNames.addAll(Arrays.asList(namesTotalMethod(clazz.getSuperclass())));
        }

        return methodNames.toArray(new String[0]);
    }

    public static String[] namesOverrideMetohd(Class<?> classe) {
        String[] numOverrideMetohd = new String[overrideMethods(classe)];
        int i = 0;

        for (java.lang.reflect.Method method : classe.getDeclaredMethods()) {

            Method superInterface = getSuperInterfaceMethod(classe, method);
            Method superClassMethod = getSuperclassMethod(classe, method);
            if (superClassMethod != null || superInterface != null) {
                numOverrideMetohd[i] = "class name = " + (method.getDeclaringClass()).getName() + " /  method name = "
                        + method.getName();
                i++;
            }

        }
        return numOverrideMetohd;
    }

    private static boolean isOverriddenMethod(Class<?> clazz, Method method) {
        Class<?> superClass = clazz.getSuperclass();
        if (superClass != null) {
            try {
                Method superMethod = superClass.getDeclaredMethod(method.getName(), method.getParameterTypes());
                return superMethod != null;
            } catch (NoSuchMethodException e) {
                return false;
            }
        }
        return false;
    }
    // System.out.println("class name= "+ (method.getDeclaringClass()).getName() + "
    // / methode name = "+ method.getName());

    /*
     * public static int statMetohd(Class<?> classe) {
     * int num;
     * 
     * return num;
     * }
     */
}
