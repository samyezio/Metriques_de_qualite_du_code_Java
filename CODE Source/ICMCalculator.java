import java.util.List;
import java.util.ArrayList;

public class ICMCalculator {

    private List<ClassMetrics> classMetricsList;
    private double meanNTM;
    private double stdDevNTM;

    public ICMCalculator(List<ClassMetrics> classMetricsList) {
        this.classMetricsList = classMetricsList;
        this.meanNTM = calculateMeanNTM();
        this.stdDevNTM = calculateStdDevNTM();
    }

    public ICMCalculator() {

    }

    private double calculateMeanNTM() {
        return classMetricsList.stream()
                .mapToInt(ClassMetrics::getNtm)
                .average()
                .orElse(0.0);
    }

    private double calculateStdDevNTM() {
        double mean = calculateMeanNTM();
        double variance = classMetricsList.stream()
                .mapToDouble(cm -> Math.pow(cm.getNtm() - mean, 2))
                .average()
                .orElse(0.0);
        return Math.sqrt(variance);
    }

    public double calculateDM(int ntm) {
        double e = Math.E;
        double exponent = -(ntm - meanNTM) / stdDevNTM;
        return 1 - 1 / (1 + Math.pow(e, exponent));
    }

    public int calculateNTM(ClassMetrics classMetrics) {
        return classMetrics.getNtm();
    }

    public double calculateCMA(ClassMetrics classMetrics) {
        double pm = classMetrics.getPublicMethods();
        double prm = classMetrics.getPrivateMethods();
        double ptm = classMetrics.getProtectedMethods();
        double dam = classMetrics.getDefaultMethods();
        double Wpm = 2;
        double Wprm = 1;
        double Wptm = 1.5;
        double Wdam = 1.2;
        return (Wpm * pm + Wprm * prm + Wptm * ptm + Wdam * dam) / 4.0;
    }

    public double calculatePSM(ClassMetrics classMetrics) {
        double fm = classMetrics.getFinalMethods();
        double sm = classMetrics.getStaticMethods();
        double am = classMetrics.getAbstractMethods();
        double Wfm = 1;
        double Wsm = 1.5;
        double Wam = 2.5;
        return (Wfm*fm + Wsm*sm + Wam*am) / 3.0;
    }

    public double calculateIH(ClassMetrics classMetrics) {
        double im = classMetrics.getInheritedMethods();
        double om = classMetrics.getOverriddenMethods();
        return (im + om) / 2.0;
    }

    public double calculateICM(ClassMetrics classMetrics) {
        int ntm = calculateNTM(classMetrics);
        double cma = calculateCMA(classMetrics);
        double psm = calculatePSM(classMetrics);
        double ih = calculateIH(classMetrics);
        double dm = calculateDM(ntm);

        return ntm * (cma + psm + ih) * dm;
    }
}