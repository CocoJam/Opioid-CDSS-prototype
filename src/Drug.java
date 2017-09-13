/**
 * Created by ljam763 on 13/09/2017.
 */
public class Drug {
    private String value;
    private String dose;
    private String method;
    private String Frequency;
    private String[] adverse_effects;
    private String resolve;

    public String getHttps() {
        return https;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setHttps(String https) {
        this.https = https;

    }

    private String https;


    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getFrequency() {
        return Frequency;
    }

    public void setFrequency(String frequency) {
        Frequency = frequency;
    }

    public String[] getAdverse_effects() {
        return adverse_effects;
    }

    public void setAdverse_effects(String[] adverse_effects) {
        this.adverse_effects = adverse_effects;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getResolve() {
        return resolve;
    }

    public void setResolve(String resolve) {
        this.resolve = resolve;
    }

    public Drug(String value, String dose, int numbering, String frequency, String[] adverse_effects, String https) {
        this.value ="Drug Name: " +value;
        if (numbering ==1){
            this.method = "Detoxication";
            this.resolve = "https://www.addictionrecoveryguide.org/treatment/detoxification/opiates";
        }
        else if (numbering == 2){
            this.method = "Maintenance";
            this.resolve = "http://emedicine.medscape.com/article/287790-treatment";
        }
        else if (numbering == 3){
            this.method = "Withdrawal";
            this.resolve="https://www.ncbi.nlm.nih.gov/books/NBK310652/";
        }
        this.method = "Treatment method: "+ this.method;
        this.dose = "Drug dosage: " +dose;
        Frequency ="Dose frequency: " + frequency;
        this.adverse_effects = adverse_effects;

        this.https = https;
    }
}
