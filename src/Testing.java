/**
 * Created by ljam763 on 10/09/2017.
 */


import javax.xml.soap.Node;

/**
 * Created by ljam763 on 2/05/2017.
 */
public class Testing extends DSM5{

    public Testing(boolean determine) {
        super(determine);
    }

    @Override
    protected Nodes setUp (){
        Nodes parent =null;
        if (super.isDetermine()){
            parent = new Nodes("gas_or_liquid_chromatography");
            Nodes mass_spectrometry = new Nodes("mass_spectrometry");
            parent.addList(mass_spectrometry);
            Nodes heroin = new Nodes("heroin");
            Nodes Morphine = new Nodes("Morphine");
            Nodes Codeine = new Nodes("Codeine");
            Nodes Hydro_morphine = new Nodes("Hydro_morphine");
            Nodes Hydro_codeine = new Nodes("Hydro_codeine");
            Nodes norhydro_codeine = new Nodes("norhydro_codeine");
            Nodes hydro_mophine_3_glurcuronide = new Nodes("hydro_mophine_3_glurcuronide");
            Nodes Hydro_morphine_vs_Hydro_codeine = new Nodes("Hydro_morphine < Hydro_codeine");
            Nodes Morphine_concentration = new Nodes("Morphine_concentration > 300 ng/ml");
            Nodes Hydro_morphine_concentration = new Nodes("Hydro_morphine_concentration < 1% of Morphine");
            Morphine.addList(Morphine_concentration);
            Nodes Morphine_intoxication = new Nodes("Morphine_intoxication");
            Nodes Hydro_morphine_intoxication = new Nodes("Hydro_morphine_intoxication");
            Nodes norhydro_codeine_usage = new Nodes("norhydro_codeine_usage");
            Morphine_concentration.addList(Morphine_intoxication);
            Morphine.addList(heroin);
            Morphine.addList(Codeine);
            Morphine.addList(Hydro_morphine);


            Codeine.addList(Morphine);
            Codeine.addList(Hydro_codeine);
            Codeine.addList(Hydro_morphine);



            Hydro_morphine.addList(hydro_mophine_3_glurcuronide);
            Hydro_morphine.addList(Hydro_morphine_vs_Hydro_codeine);
            Hydro_morphine.addList(Hydro_morphine_concentration);
            Hydro_morphine_concentration.addList(Hydro_morphine_intoxication);
            Hydro_morphine_vs_Hydro_codeine.addList(Hydro_morphine_intoxication);

            Hydro_codeine.addList(norhydro_codeine);
            norhydro_codeine.addList(norhydro_codeine_usage);


            mass_spectrometry.addList(heroin);
            mass_spectrometry.addList(Morphine);
            mass_spectrometry.addList(Codeine);
            mass_spectrometry.addList(Hydro_codeine);
            mass_spectrometry.addList(Hydro_morphine);
            mass_spectrometry.addList(norhydro_codeine);
        }
        else{
            parent = new Nodes("opiate_immunoassays");
            Nodes oxy_morphine  = new Nodes("oxy_morphine ");
            Nodes fentanyl = new Nodes("fentanyl");
            Nodes methadone = new Nodes("methadone");
            Nodes buprenorphine = new Nodes("buprenorphine");
            Nodes oxy_codeine = new Nodes("oxy_codeine");
            Nodes oxy_codeine_usage = new Nodes("oxy_codeine_usage");
            oxy_codeine.addList(oxy_morphine);
            oxy_morphine.addList(oxy_codeine_usage);
            parent.addList(oxy_codeine);
            parent.addList(oxy_morphine);
            parent.addList(fentanyl);
            parent.addList(methadone);
            parent.addList(buprenorphine);
        }
        return parent;
    }

    public static void main(String[] args) {
        Testing t = new Testing(true);
        System.out.println(t.isDetermine());
    }
}