import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class CodeQualityAnalyzer {

    private static double normalize(double value, double maxValue) {
        if(maxValue==0){
            throw new ArithmeticException();
        }
        return value / maxValue;
    }
    
    private static double max (double a,double b){
          if(a>b){
           return a; 
          } else if (a<b){
            return b;
          }else {
            return a;
          }
    }
   

    public static void analyzeAndDisplayResults(String filePath, int maxLCOM, int maxCBO) {
        Class<?> targetClass = loadClassFromFile(filePath);

        if (targetClass == null) {
            System.out.println("Impossible de charger la classe à partir du fichier spécifié.");
            return;
        }

    int cbo = CBOmetric.calculateCBO(targetClass);
    int lcom = LCOMCalculator.calculateLCOM(targetClass);
    int fanIn = ModularityCalculator.calculateFanIn(targetClass);
    int fanOut = ModularityCalculator.calculateFanOut(targetClass);

    // Normaliser les valeurs
    double normalizedCBO = 1 - normalize(cbo, maxCBO);
    double normalizedLCOM = 1 - normalize(lcom, maxLCOM);
    double normalizedMODULARITY;
    try{
     normalizedMODULARITY = normalize(fanIn + fanOut, 2 * max(fanIn, fanOut));
    }catch(ArithmeticException e){
        normalizedMODULARITY = 0;
    }        

    // Calculer l'Indice de Structuration du Code (ISC)
    double isc = ((normalizedLCOM + normalizedMODULARITY) - (normalizedCBO) +1) / 2;

    new ResultsDisplayGUI(lcom, cbo, fanIn, fanOut, normalizedLCOM, normalizedCBO, normalizedMODULARITY, isc, maxLCOM, maxCBO).setVisible(true);
    }

  

    private static Class<?> loadClassFromFile(String filePath) {
        try {
            File file = new File(filePath);
            URL url = file.toURI().toURL();
            URLClassLoader classLoader = new URLClassLoader(new URL[]{url});
            String className = file.getName().replace(".java", "");
            return classLoader.loadClass(className);
        } catch (MalformedURLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}