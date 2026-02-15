// Interface de test
interface TestInterface {
    void testMethod();
}

// Classe de test
class TestClass implements TestInterface {
    public int publicField;
    private String privateField;

    public TestClass() {
    }

    public int getPublicField() {
        return publicField;
    }

    public void setPublicField(int publicField) {
        this.publicField = publicField;
    }

    public String getPrivateField() {
        return privateField;
    }

    public void setPrivateField(String privateField) {
        this.privateField = privateField;
    }

    public void relevantMethod1() {
        // Méthode pertinente
    }

    public void relevantMethod2() {
        // Méthode pertinente
    }

    @Override
    public void testMethod() {
        // Implémentation de l'interface
    }
}