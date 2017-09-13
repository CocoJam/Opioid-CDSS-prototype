import com.sun.org.apache.regexp.internal.RE;

import javax.xml.soap.Node;

/**
 * Created by ljam763 on 11/09/2017.
 */
public class COWS {
    private Nodes nodes;

    public Nodes getNodes() {
        return nodes;
    }

    public void setNodes(Nodes nodes) {
        this.nodes = nodes;
    }

    public COWS() {
        this.nodes = setUp();
    }

    private Nodes setUp() {
        Nodes parent = new Nodes("COWS");

        Nodes Resting_Pulse_Rate = new Nodes("Resting_Pulse_Rate");
        Nodes GI_Upset = new Nodes("GI_Upset");
        Nodes Sweating = new Nodes("Sweating");
        Nodes Tremor = new Nodes("Tremor");
        Nodes Restlessness = new Nodes("Restlessness");
        Nodes Yawning = new Nodes("Yawning");
        Nodes Pupil_size = new Nodes("Pupil_size");
        Nodes Anxiety_or_Irritability = new Nodes("Anxiety_or_Irritability");
        Nodes Bone_or_Joint_aches = new Nodes("Bone_or_Joint_aches");
        Nodes Gooseflesh_skin = new Nodes("Gooseflesh_skin");
        Nodes Runny_nose_or_tearing = new Nodes("Runny_nose_or_tearing");

        parent.addList(Resting_Pulse_Rate);
        parent.addList(GI_Upset);
        parent.addList(Sweating);
        parent.addList(Tremor);
        parent.addList(Restlessness);
        parent.addList(Yawning);
        parent.addList(Pupil_size);
        parent.addList(Anxiety_or_Irritability);
        parent.addList(Bone_or_Joint_aches);
        parent.addList(Gooseflesh_skin);
        parent.addList(Runny_nose_or_tearing);

        Nodes b1 = new Nodes("80 or below");
        Nodes b10 = new Nodes("0");
        b1.addList(b10);
        Nodes b2 = new Nodes("81 - 100");
        Nodes b21 = new Nodes("1");
        b2.addList(b21);
        Nodes b3 = new Nodes("101 - 120");
        Nodes b32 = new Nodes("2");
        b3.addList(b32);
        Nodes b4 = new Nodes("greater than 120");
        Nodes b44 = new Nodes("4");
        b4.addList(b44);

        Resting_Pulse_Rate.addList(b1);
        Resting_Pulse_Rate.addList(b2);
        Resting_Pulse_Rate.addList(b3);
        Resting_Pulse_Rate.addList(b4);

        Nodes g1 = new Nodes("no GI symptoms");
        Nodes g10 = new Nodes("0");
        g1.addList(g10);
        Nodes g2 = new Nodes("stomach cramps");
        Nodes g21 = new Nodes("1");
        g2.addList(g21);
        Nodes g3 = new Nodes("nausea or loose stool");
        Nodes g32 = new Nodes("2");
        g3.addList(g32);
        Nodes g4 = new Nodes("vomiting or diarrhea");
        Nodes g43 = new Nodes("3");
        g4.addList(g43);
        Nodes g5 = new Nodes("multiple episodes of diarrhea or vomiting");
        Nodes g55 = new Nodes("5");
        g5.addList(g55);

        GI_Upset.addList(g1);
        GI_Upset.addList(g2);
        GI_Upset.addList(g3);
        GI_Upset.addList(g3);
        GI_Upset.addList(g4);
        GI_Upset.addList(g5);

        Nodes s1 = new Nodes("no report of chills or flushing");
        Nodes s10 = new Nodes("0");
        s1.addList(s10);
        Nodes s2 = new Nodes("subjective report of chills or flushing");
        Nodes s21 = new Nodes("1");
        s2.addList(s21);
        Nodes s3 = new Nodes("flushed or observable moistness on face");
        Nodes s32 = new Nodes("2");
        s3.addList(s32);
        Nodes s4 = new Nodes("beads of sweat on brow or face");
        Nodes s43 = new Nodes("3");
        s4.addList(s43);
        Nodes s5 = new Nodes("sweat streaming off face");
        Nodes s54 = new Nodes("4");
        s5.addList(s54);

        Sweating.addList(s1);
        Sweating.addList(s2);
        Sweating.addList(s3);
        Sweating.addList(s4);
        Sweating.addList(s5);

        Nodes t1 = new Nodes("no tremor");
        Nodes t10 = new Nodes("0");
        t1.addList(t10);
        Nodes t2 = new Nodes("tremor can be felt, but not observed");
        Nodes t21 = new Nodes("1");
        t2.addList(t21);
        Nodes t3 = new Nodes("slight tremor observable");
        Nodes t32 = new Nodes("2");
        t3.addList(t32);
        Nodes t4 = new Nodes("gross tremor or muscle twitching");
        Nodes t43 = new Nodes("4");
        t4.addList(t43);

        Tremor.addList(t1);
        Tremor.addList(t2);
        Tremor.addList(t3);
        Tremor.addList(t4);

        Nodes r1 = new Nodes("able to sit still");
        Nodes r10 = new Nodes("0");
        r1.addList(r10);
        Nodes r2 = new Nodes("reports difficulty sitting still, but is able to do so");
        Nodes r21 = new Nodes("1");
        r2.addList(r21);
        Nodes r3 = new Nodes("frequent shifting or extraneous movements of legs/arms");
        Nodes r33 = new Nodes("3");
        r3.addList(r33);
        Nodes r4 = new Nodes("unable to sit stil l for more than a few seconds");
        Nodes r45 = new Nodes("5");
        r4.addList(r45);

        Restlessness.addList(r1);
        Restlessness.addList(r2);
        Restlessness.addList(r3);
        Restlessness.addList(r3);
        Restlessness.addList(r4);

        Nodes y1 = new Nodes("no yawning");
        Nodes y10 = new Nodes("0");
        y1.addList(y10);
        Nodes y2 = new Nodes("yawning once or twice during assessment");
        Nodes y21 = new Nodes("1");
        y2.addList(y21);
        Nodes y3 = new Nodes("yawning three or more times during assessment");
        Nodes y32 = new Nodes("2");
        y3.addList(y32);
        Nodes y4 = new Nodes("yawning several times/minute");
        Nodes y44 = new Nodes("4");
        y4.addList(y44);

        Yawning.addList(y1);
        Yawning.addList(y2);
        Yawning.addList(y3);
        Yawning.addList(y3);
        Yawning.addList(y4);

        Nodes p1 = new Nodes("pupils pinned or normal size for room light");
        Nodes p10 = new Nodes("0");
        p1.addList(p10);
        Nodes p2 = new Nodes("pupils possibly larger than normal for room light");
        Nodes p21 = new Nodes("1");
        p2.addList(p21);
        Nodes p3 = new Nodes("pupils moderately dilated");
        Nodes p32 = new Nodes("2");
        p3.addList(p32);
        Nodes p4 = new Nodes("pupils so dilated that only the rim of the iris is visible");
        Nodes p45 = new Nodes("5");
        p4.addList(p45);

        Pupil_size.addList(p1);
        Pupil_size.addList(p2);
        Pupil_size.addList(p3);
        Pupil_size.addList(p3);
        Pupil_size.addList(p4);


        Nodes a1 = new Nodes("none");
        Nodes a10 = new Nodes("0");
        a1.addList(a10);
        Nodes a2 = new Nodes("patient reports increasing irritability or anxiousness");
        Nodes a21 = new Nodes("1");
        a2.addList(a21);
        Nodes a3 = new Nodes("patient obviously irritable or anxious");
        Nodes a32 = new Nodes("2");
        a3.addList(a32);
        Nodes a4 = new Nodes("patient so irritable or anxious that participation in the assessment is difficult");
        Nodes a44 = new Nodes("4");
        a4.addList(a44);

        Anxiety_or_Irritability.addList(a1);
        Anxiety_or_Irritability.addList(a2);
        Anxiety_or_Irritability.addList(a3);
        Anxiety_or_Irritability.addList(a3);
        Anxiety_or_Irritability.addList(a4);

        Nodes BJA1 = new Nodes("not present");
        Nodes BJA10 = new Nodes("0");
        BJA1.addList(BJA10);
        Nodes BJA2 = new Nodes("mild diffuse discomfort");
        Nodes BJA21 = new Nodes("1");
        BJA2.addList(BJA21);
        Nodes BJA3 = new Nodes("patient reports severe diffuse aching of joints/muscles");
        Nodes BJA32 = new Nodes("2");
        BJA3.addList(BJA32);
        Nodes BJA4 = new Nodes("patient is rubbing joints or muscles and is unable to sit still because of discomfort");
        Nodes BJA44 = new Nodes("4");
        BJA4.addList(BJA44);

        Bone_or_Joint_aches.addList(BJA1);
        Bone_or_Joint_aches.addList(BJA2);
        Bone_or_Joint_aches.addList(BJA3);
        Bone_or_Joint_aches.addList(BJA3);
        Bone_or_Joint_aches.addList(BJA4);

        Nodes GS1 = new Nodes("skin is smooth");
        Nodes GS10 = new Nodes("0");
        GS1.addList(GS10);
        Nodes GS2 = new Nodes("stomach cramps");
        Nodes GS21 = new Nodes("1");
        GS2.addList(GS21);
        Nodes GS3 = new Nodes("piloerrection of skin can be felt or hairs standing up on arms");
        Nodes GS33 = new Nodes("3");
        GS3.addList(GS33);
        Nodes GS4 = new Nodes("prominent piloerrection");
        Nodes GS45 = new Nodes("5");
        GS4.addList(GS45);

       Gooseflesh_skin.addList(GS1);
       Gooseflesh_skin.addList(GS2);
       Gooseflesh_skin.addList(GS3);
       Gooseflesh_skin.addList(GS3);
       Gooseflesh_skin.addList(GS4);

        Nodes RNT1 = new Nodes("not present");
        Nodes RNT10 = new Nodes("0");
        RNT1.addList(RNT10);
        Nodes RNT2 = new Nodes("nasal stuffiness or unusually moist eyes");
        Nodes RNT21 = new Nodes("1");
        RNT2.addList(RNT21);
        Nodes RNT3 = new Nodes("nose running or tearing");
        Nodes RNT32 = new Nodes("2");
        RNT3.addList(RNT32);
        Nodes RNT4 = new Nodes("nose constantly running or tears streaming down cheeks");
        Nodes RNT44 = new Nodes("4");
        RNT4.addList(RNT44);

       Runny_nose_or_tearing.addList(BJA1);
       Runny_nose_or_tearing.addList(BJA2);
       Runny_nose_or_tearing.addList(BJA3);
       Runny_nose_or_tearing.addList(BJA3);
       Runny_nose_or_tearing.addList(BJA4);
        
        return parent;
    }
}
