
public class ClassMetrics {
    private int ntm; // Total number of methods
    private int publicMethods;
    private int privateMethods;
    private int protectedMethods;
    private int defaultMethods;
    private int finalMethods;
    private int staticMethods;
    private int abstractMethods;
    private int inheritedMethods;
    private int overriddenMethods;
    private String name;
    public ClassMetrics(int ntm, int publicMethods, int privateMethods, int protectedMethods, int defaultMethods,
                        int finalMethods, int staticMethods, int abstractMethods, int inheritedMethods, int overriddenMethods,String name) {
        this.ntm = ntm;
        this.publicMethods = publicMethods;
        this.privateMethods = privateMethods;
        this.protectedMethods = protectedMethods;
        this.defaultMethods = defaultMethods;
        this.finalMethods = finalMethods;
        this.staticMethods = staticMethods;
        this.abstractMethods = abstractMethods;
        this.inheritedMethods = inheritedMethods;
        this.overriddenMethods = overriddenMethods;
        this.name = name;
    }

    public int getNtm() {
        return ntm;
    }

    public int getPublicMethods() {
        return publicMethods;
    }

    public int getPrivateMethods() {
        return privateMethods;
    }

    public int getProtectedMethods() {
        return protectedMethods;
    }

    public int getDefaultMethods() {
        return defaultMethods;
    }

    public int getFinalMethods() {
        return finalMethods;
    }

    public int getStaticMethods() {
        return staticMethods;
    }

    public int getAbstractMethods() {
        return abstractMethods;
    }

    public int getInheritedMethods() {
        return inheritedMethods;
    }

    public int getOverriddenMethods() {
        return overriddenMethods;
    }
    public String getName(){
        return name;
    }
}