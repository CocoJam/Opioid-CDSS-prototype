import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by ljam763 on 10/09/2017.
 */
public class DSM5 {
    private boolean determine;
    private Nodes nodes;

    public boolean isDetermine() {
        return determine;
    }

    public void setDetermine(boolean determine) {
        this.determine = determine;
    }

    public Nodes getNodes() {
        return nodes;
    }

    public void setNodes(Nodes nodes) {
        this.nodes = nodes;
    }

    public DSM5(boolean determine) {
        this.determine = determine;
        this.nodes=setUp();
    }

    protected Nodes setUp (){

        Nodes parent;
            if (this.determine){
                parent = new Nodes("intoxcation");
            //setup for intoxication
            //setup for recent use
            Nodes recent_use = new Nodes("Recent_use");
            parent.addList(recent_use);
            //setup for Problematic
            Nodes behaviour_or_psychological = new Nodes ("behaviour_or_psychological_changes");
            Nodes euphoria = new Nodes("euphoria");
            behaviour_or_psychological.addList(euphoria);
            Nodes apathy = new Nodes("apathy");
            euphoria.addList(apathy);
            Nodes dysphoria = new Nodes ("dysphoria");
            euphoria.addList(dysphoria);
            Nodes psychomotor = new Nodes ("psychomotor");
            Nodes agitation = new Nodes ("agitation");
            Nodes retardation = new Nodes ("retardation");
            psychomotor.addList(agitation);
            psychomotor.addList(retardation);
            euphoria.addList(psychomotor);
            //setup for pupillary
            Nodes pupillary = new Nodes("pupillary");
            parent.addList(pupillary);
            Nodes dilation_Or_Constriction = new Nodes("dilation_Or_Constriction");
            pupillary.addList(dilation_Or_Constriction);
            Nodes drowsiness= new Nodes("drowsiness");
            dilation_Or_Constriction.addList(drowsiness);
            Nodes coma = new Nodes("coma");
            dilation_Or_Constriction.addList(coma);
            Nodes slurred_speech = new Nodes ("slurred_speech");
            dilation_Or_Constriction.addList(slurred_speech);
            Nodes impairment = new Nodes("impairment");
            dilation_Or_Constriction.addList(impairment);
            Nodes attention = new Nodes("attention");
            impairment.addList(attention);
            Nodes memory = new Nodes("memory");
            impairment.addList(memory);
            //setup for perceptual disturbance
            Nodes perceptual_disturbance = new Nodes("perceptual_disturbance");
            parent.addList(perceptual_disturbance);
            Nodes with = new Nodes("with");
            perceptual_disturbance.addList(with);
            Nodes without = new Nodes("without");
            perceptual_disturbance.addList(without);
            Nodes hallcination = new Nodes("hallcination");
            perceptual_disturbance.addList(hallcination);
            Nodes comorbid = new Nodes("comorbid");
            perceptual_disturbance.addList(comorbid);
            Nodes Mild_user = new Nodes("Mild_user");
            Nodes non_dependency = new Nodes("non_dependency");
            Mild_user.addList(non_dependency);
            comorbid.addList(Mild_user);
            Nodes moderate_or_severe_users = new Nodes("moderate_or_severe_users");
            Nodes dependency = new Nodes("dependency");
            moderate_or_severe_users.addList(dependency);
            comorbid.addList(moderate_or_severe_users);
            }
            else{
                //setup for withdrawal
                parent = new Nodes("withdrawal");
                //setup for presence
                Nodes drug_usage = new Nodes("drug_usage");
                parent.addList(drug_usage);
                Nodes cessation_usage = new Nodes("cessation_usage");
                Nodes administrated_opioid_antagonist  = new Nodes("administrated_opioid_antagonist");
                drug_usage.addList(cessation_usage);
                drug_usage.addList(administrated_opioid_antagonist);
                Nodes symptoms  = new Nodes("symptoms");
                parent.addList(symptoms);
                Nodes dysphoric_mood  = new Nodes("dysphoric_mood");
                Nodes sweating  = new Nodes("sweating");
                Nodes nausea  = new Nodes("nausea");
                Nodes diarrhoea  = new Nodes("diarrhoea");
                Nodes vomiting  = new Nodes("vomiting");
                Nodes yawning  = new Nodes("yawning");
                Nodes muscle_aches  = new Nodes("muscle_aches");
                Nodes fever  = new Nodes("fever");
                Nodes lacrimation   = new Nodes("lacrimation");
                Nodes insomnia  = new Nodes("insomnia");
                Nodes rhinorrhoea  = new Nodes("rhinorrhoea");
                Nodes pupillary_dilation  = new Nodes("pupillary_dilation");
                Nodes piloerection  = new Nodes("piloerection");
                symptoms.addList(dysphoric_mood);
                symptoms.addList(sweating);
                symptoms.addList(nausea);
                symptoms.addList(diarrhoea);
                symptoms.addList(vomiting);
                symptoms.addList(yawning);
                symptoms.addList(muscle_aches);
                symptoms.addList(fever);
                symptoms.addList(lacrimation);
                symptoms.addList(insomnia);
                symptoms.addList(pupillary_dilation);
                symptoms.addList(rhinorrhoea);
                symptoms.addList(piloerection);
                Nodes difficulties =new Nodes("difficulty");
                parent.addList(difficulties);
                Nodes social =new Nodes("social");
                Nodes occupational =new Nodes("occupational");
                Nodes other =new Nodes("other");
                difficulties.addList(social);
                difficulties.addList(occupational);
                difficulties.addList(other);
                Nodes comorbid = new Nodes("comorbid");
                parent.addList(comorbid);
                Nodes Mild_user = new Nodes("Mild_user");
                Nodes non_dependency = new Nodes("non_dependency");
                Mild_user.addList(non_dependency);
                comorbid.addList(Mild_user);
                Nodes moderate_or_severe_users = new Nodes("moderate_or_severe_users");
                Nodes dependency = new Nodes("dependency");
                moderate_or_severe_users.addList(dependency);
                comorbid.addList(moderate_or_severe_users);
            }

        return parent;
    }

    public static void main(String[] args) {
        DSM5 d = new DSM5(true);
        System.out.println(d.getNodes().getValue());
    }
}
