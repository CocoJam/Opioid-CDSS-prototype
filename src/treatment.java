/**
 * Created by ljam763 on 12/09/2017.
 */
public class treatment {
    private Nodes nodes;

    public Nodes getNodes() {
        return nodes;
    }

    public void setNodes(Nodes nodes) {
        this.nodes = nodes;
    }

    public treatment() {

        this.nodes = setup();
    }
    public Nodes setup(){
        Nodes parent = new Nodes("Treatments");
        Nodes Detoxification_treatment = new Nodes("Detoxification_treatment");
        parent.addList(Detoxification_treatment);
        Nodes Dependency_treatment = new Nodes("Dependency_treatment");
        parent.addList(Dependency_treatment);
        Nodes Withdrawal_treatment = new Nodes("Withdrawal_treatment");
        parent.addList(Withdrawal_treatment);
        Nodes Antagonist = new Nodes("Antagonist");
        Detoxification_treatment.addList(Antagonist);
        Dependency_treatment.addList(Antagonist);
        Withdrawal_treatment.addList(Antagonist);
        Nodes Naltrexone = new Nodes("Naltrexone");
        Antagonist.addList(Naltrexone);

        Nodes Buprenorphine = new Nodes("Buprenorphine");
        Nodes Levomethadyl_acetate = new Nodes("Levomethadyl_acetate");
        Nodes Methadone = new Nodes("Methadone");
        Nodes Clonidine = new Nodes( "Clonidine");

        Nodes Dependency_treatment_Agonists = new Nodes("Dependency_treatment_Agonists");
        Dependency_treatment_Agonists.addList(Buprenorphine);
        Dependency_treatment_Agonists.addList(Levomethadyl_acetate);
        Dependency_treatment_Agonists.addList(Methadone);
        Dependency_treatment_Agonists.addList(Clonidine);
        Dependency_treatment.addList(Dependency_treatment_Agonists);

        Nodes Withdrawal_treatment_Agonists = new Nodes("Withdrawal_treatment_Agonists");
        Withdrawal_treatment_Agonists.addList(Buprenorphine);
        Withdrawal_treatment_Agonists.addList(Methadone);
        Withdrawal_treatment_Agonists.addList(Clonidine);
        Withdrawal_treatment.addList(Withdrawal_treatment);

        return parent;
    }
}
