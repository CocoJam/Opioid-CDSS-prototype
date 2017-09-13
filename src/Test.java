/**
 * Created by ljam763 on 10/09/2017.
 */


import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 * A simple JPanel that allows users to add or subtract numbers.
 * <p>
 * TODO Complete this class. No hints this time :)
 */
public class Test extends JPanel implements ActionListener {
    private ArrayList<COWS_Nodes> COWS_List = new ArrayList<>();
    private ArrayList<String> symptoms_track = new ArrayList<>();
    private ArrayList<String> drug_list = new ArrayList<>();
    private String PatientsName = "";
    private JPanel firstPanel;
    private Boolean assessment;
    private double numberingOfIntox = 0;
    private double numberingOfWithdrawal = 0;
    private JPanel panel_for_DSM_intoxication;
    private JPanel panel_for_DSM_withdrawal;
    private JButton submit;
    private JButton Testing;
    private boolean testing;
    private JButton COWS;
    private boolean symptoms;
    private JButton Symptoms;
    private boolean cows;
    private int COWS_scale;
    private JButton Assessment;
    private JButton Treatments;
    private boolean dependency;
    private String Intox_severity;
    private String Withdrawal_severity;
    private boolean Intoxication_Treatment_b;
    private boolean Dependency_Treatment_b;
    private boolean Withdrawal_Treatment_b;
    private JButton Intoxication_Treatment;
    private JButton Dependency_Treatment;
    private JButton Withdrawal_Treatment;

    /**
     * Creates a new ExerciseFivePanel.
     */
    public Test() {
        firstPanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(firstPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        overallSetup();
        this.add(scrollPane);
        System.out.println("Hello");
    }

    private void overallSetup() {
        setBackground(Color.white);
        firstPanel.setLayout(new GridLayout(1, 2));
        firstPanel.setPreferredSize(new Dimension(800, 800));
        Assessment = new JButton("Assessment");
        Assessment.setPreferredSize(new Dimension(400, 800));
//        buttonList.put("Assessment", btn);
        Assessment.addActionListener(this);
        firstPanel.add(Assessment);
        Treatments = new JButton("Treatments");
        Treatments.setPreferredSize(new Dimension(400, 800));
//        buttonList.put("Treatment", btn2);
        Treatments.addActionListener(this);
        firstPanel.add(Treatments);
        assessment = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Actions");
//        System.out.println(e.getSource());
        if (assessment == null) {
            if (e.getSource() == Assessment) {
                System.out.println("ASSESSment");
                assessment_Path();
                return;
            } else if (e.getSource() == Treatments) {
                treatment_Path();
                return;
            }
        }
        if (assessment) {
            if (e.getSource() == Symptoms) {
                logicBool(symptoms);
                symptomsSetUp();
            } else if (e.getSource() == Testing) {
                logicBool(testing);
                testingSetUp();
            } else if (e.getSource() == COWS) {
                clearContent();
                COWS cowss = new COWS();
                logicBool(cows);
                COWSsetUp(cowss);
            } else if (e.getSource() == submit && symptoms) {
                popUpFrame("Patient symptoms");
                symptomsDeciding();
                logicBool();
            } else if (e.getSource() == submit && cows) {
                popUpFrame("Patient COWS");

                overallClear();
            } else if (e.getSource() == submit && testing) {
                popUpFrame("Patient for Laboratory testing");
                System.out.println(COWS_scale);

                overallClear();
            } else if (e.getSource() instanceof Nodes && symptoms) {
                symptomsCheck(e);
            } else if (e.getSource() instanceof Nodes && testing) {
                testing(e);
            } else if (e.getSource() instanceof Nodes && cows) {
                COWSing(e);
            }
            return;
        }
        if (!assessment) {
            System.out.println("Not assess");
            if (e.getSource() == Intoxication_Treatment){
                treatment_setup("Detoxification_treatment");
                Intoxication_Treatment_b = true;
            }
            else if (e.getSource() == Dependency_Treatment){
                treatment_setup("Dependency_treatment");
                Dependency_Treatment_b= true;
            }
            else if (e.getSource() == Withdrawal_Treatment){
                treatment_setup("Withdrawal_treatment");
               Withdrawal_Treatment_b= true;
            }
            else if (e.getSource() instanceof Nodes){
                Nodes jcheck = (Nodes) e.getSource();
                if (!jcheck.hasChild()){
                    System.out.println(jcheck.getValue());
                    drug_list.add(jcheck.getValue());
                }
                testing(e);
            }
            else if (e.getSource()==submit){
                Scanner scanner = null;
                File file = new File("drugList.txt");
                try {
                    scanner = new Scanner(file);
                    boolean framing = false;
                    JFrame frame = null;
                    JPanel panel = null;
                    while (scanner.hasNextLine()){
                        String name = scanner.nextLine();

                        if (drug_list.contains(name)){
                            if (!framing){
                            frame = new JFrame();
                               panel = new JPanel();
                               panel.setLayout(new GridLayout(2,4));
                            }
                            framing = true;
                            System.out.println("Yes have drug");
                            String dose = scanner.nextLine();
                            String frequency = scanner.nextLine();
                            String[] adverse = scanner.nextLine().split(", ");
                            String https = scanner.nextLine();
                            int numbering = 0;
                            if (Intoxication_Treatment_b){
                                numbering = 1;
                            }
                            else if (Dependency_Treatment_b){
                                numbering = 2;
                            }
                            else if (Withdrawal_Treatment_b){
                                numbering =3;
                            }
                            Drug drug = new Drug(name,dose,numbering,frequency,adverse,https);
                            System.out.println(drug.getHttps());
                            drugPopUp(drug,name, panel);
                        }
                    }
                    if (framing){
                        frame.setContentPane(panel);
                        frame.setVisible(true);
                        frame.pack();
                        frame.setLocationRelativeTo(null);
                    }
                    scanner.close();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                    scanner.close();
                }
                popUpFrame("Treatment");
                overallClear();
            }
        }
    }
    private void drugPopUp (Drug drug, String naming, JPanel frame){
        JPanel panel = new JPanel();
        panel.setBorder(
                BorderFactory.createTitledBorder(naming));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//        panel.setPreferredSize(new Dimension(400,300));
//        frame.setTitle(naming);
        JLabel name = new JLabel(drug.getValue());
        JPanel other1 = new JPanel();
        other1.add(name);
        JButton method = new JButton(drug.getMethod());
        JPanel other0 = new JPanel();
        method.setCursor(new Cursor(Cursor.HAND_CURSOR));
        method.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URL(drug.getResolve()).toURI());
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
        });
        other0.add(method);
        JLabel dosage = new JLabel(drug.getDose());
        JPanel other2 = new JPanel();
        other2.add(dosage);
        JLabel frequency = new JLabel(drug.getFrequency());
        JPanel other3 = new JPanel();
        other3.add(frequency);
        JLabel adverse = new JLabel("Adverse Effects:");
        JPanel other4 = new JPanel();
        other4.add(adverse);
        panel.add(other1,BorderLayout.CENTER);
        panel.add(other0,BorderLayout.CENTER);
        panel.add(other2,BorderLayout.CENTER);
        panel.add(other3,BorderLayout.CENTER);
        panel.add(other4,BorderLayout.CENTER);
        for (String s : drug.getAdverse_effects()) {
            JLabel blah = new JLabel(s);
            JPanel otherBlah= new JPanel();
            otherBlah.add(blah);
            panel.add(otherBlah,BorderLayout.CENTER);
        }
        JButton https = new JButton("More Information");
        JPanel panel1 = new JPanel();
        panel1.add(https);
        https.setCursor(new Cursor(Cursor.HAND_CURSOR));
        https.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URL(drug.getHttps()).toURI());
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
        });
        panel.add(panel1,BorderLayout.CENTER);
        frame.add(panel);

    }

    private void treatment_setup(String title) {
        clearContent();
        treatment treatment = new treatment();
        Nodes starting = null;
        for (Nodes nodes : treatment.getNodes().getList()) {
            if (nodes.getValue().equals(title)){
                starting = nodes;
            }
        }
        if (starting == null){
            return;
        }
        JPanel panel = new JPanel(new WrapLayout());
        panel.setBorder(
                BorderFactory.createTitledBorder(title));
        panel.setPreferredSize(new Dimension(800, 750));
        for (Nodes nodes : starting.getList()) {
            JPanel otherPanels = new JPanel(new WrapLayout());
            otherPanels.setBorder(BorderFactory.createTitledBorder(nodes.getValue()));
            nodes.addActionListener(this);
            nodes.setText(nodes.getValue());
            panel.add(otherPanels);
            otherPanels.add(nodes);
        }
        firstPanel.add(panel);
        submit = new JButton("submit");
        submit.setPreferredSize(new Dimension(800, 50));
        submit.addActionListener(this);
        JPanel submitbutton = new JPanel();
        submitbutton.add(submit);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(submitbutton);
        firstPanel.revalidate();
        this.revalidate();

    }

    private void overallClear() {
        logicBool();
        clearContent();
        submit.setVisible(false);
        this.remove(submit);
        overallSetup();
        firstPanel.revalidate();
    }

    private void logicBool(boolean target) {
        symptoms = false;
        cows = false;
        testing = false;
        Intoxication_Treatment_b = false;
        Dependency_Treatment_b =false;
        Withdrawal_Treatment_b = false;
        target = true;
    }

    private void logicBool() {
        symptoms = false;
        cows = false;
        testing = false;
        Intoxication_Treatment_b = false;
        Dependency_Treatment_b =false;
        Withdrawal_Treatment_b = false;
    }


    private void popUpFrame(String titles) {
        JFrame frame = new JFrame();
        frame.setTitle(titles);
        JPanel other = new JPanel();
        other.setLayout(new BoxLayout(other, BoxLayout.Y_AXIS));
        JLabel label = new JLabel();
        label.setText("Patients name: ");
        JPanel other2 = new JPanel();
        JPanel other3 = new JPanel();
        other2.add(label);

        JTextField textField = new JTextField(20);
        if (!PatientsName.trim().equals(null) || !PatientsName.trim().equals("")) {
            textField.setText(PatientsName);
        }
        other2.add(textField);
        JButton submition = new JButton("Submission");

        submition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PatientsName = textField.getText().replaceAll(" ", "_");
                File file1 = new File(PatientsName + "_file");
                String pathing = "";
                if (!file1.exists()) {
                    file1.mkdir();
                    System.out.println(pathing);
                }
                pathing = file1.getAbsolutePath();
                System.out.println("Submitting");
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
                System.out.println(PatientsName);
                String time = dateFormat.format(date).replaceAll("/", ":");
                System.out.println(time);
                pathing = pathing + "/" + PatientsName + "_" + titles + "_" + time.replaceAll(" ", "_").replaceAll("/", "_").replaceAll(":", "_") + "\\";
                File file = new File(pathing);
                try {
                    PrintWriter printWriter = new PrintWriter(file);
                    symptoms_Or_COWS_Or_testing(printWriter, titles);
                    printWriter.close();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                frame.setVisible(false);
                frame.dispose();
                COWS_List.clear();
                symptoms_track.clear();
                drug_list.clear();
            }

            private void symptoms_Or_COWS_Or_testing(PrintWriter printWriter, String title) {
                if (title.equals("Patient symptoms")) {
                    for (String s : symptoms_track) {
                        printWriter.print(s);
                        printWriter.println();
                    }
                }
                if (title.equals("Patient COWS")) {
                    int totalScore = 0;
                    for (COWS_Nodes cows_nodes : COWS_List) {
                        totalScore += Integer.parseInt(cows_nodes.getValue());
                        printWriter.print(cows_nodes.getTitle() + ": " + cows_nodes.getValue() + " -> Socre: " + cows_nodes.getScore());
                        printWriter.println();
                    }
                    printWriter.print("Total Scoring: " + totalScore);
                }
                if (title.equals("Patient for Laboratory testing")) {
                    for (String s : symptoms_track) {
                        printWriter.print(s);
                        printWriter.println();
                    }
                }
                if (title.equals( "Treatment")) {
                    for (String s : drug_list) {
                        printWriter.print(s);
                        printWriter.println();
                    }
                }
            }
        });
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Cancel");
                frame.setVisible(false);
                frame.dispose();
                COWS_List.clear();
                symptoms_track.clear();
                drug_list.clear();
            }
        });
        other3.add(submition);
        other3.add(cancel);
        other.add(other2, BorderLayout.CENTER);
        JPanel other4 = new JPanel();
        JLabel label1 = new JLabel();
        if (titles.equals("Patient COWS")) {
            Withdrawal_severity = "Not";
            if (COWS_scale < 5) {
                Withdrawal_severity = "Not";
            } else if (COWS_scale < 13) {
                Withdrawal_severity = "Mild";
            } else if (COWS_scale < 25) {
                Withdrawal_severity = "Moderate";
            } else if (COWS_scale < 37) {
                Withdrawal_severity = "Moderate Severe";
            } else {
                Withdrawal_severity = "Severe";
            }
            label1.setText("Total Scoring: " + COWS_scale + " and Severity is: " + Withdrawal_severity);
        }
        if (titles.equals("Patient symptoms")) {
            for (String s : symptoms_track) {
                if (s.endsWith("non_dependency")) {
                    dependency = false;
                    break;
                }
                if (s.endsWith("dependency")) {
                    dependency = true;
                    break;
                }
            }
            if (numberingOfIntox < 3) {
                Intox_severity = "Not";
            } else if (numberingOfIntox < 6) {
                Intox_severity = "Mild";
            } else if (numberingOfIntox < 9) {
                Intox_severity = "Moderate";
            } else if (numberingOfIntox < 13) {
                Intox_severity = "Moderate Severe";
            } else {
                Intox_severity = "Severe";
            }
            label1.setText("Intoxication Severity is: " + Intox_severity + " and Dependency is: " + dependency);
        }
        other4.add(label1);
        other.add(other4, BorderLayout.CENTER);
        other.add(other3, BorderLayout.CENTER);
        other.setPreferredSize(new Dimension(400, 100));
        frame.setContentPane(other);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
//        COWS_List.clear();
//        symptoms_track.clear();
        return;
    }

    private void COWSing(ActionEvent e) {
        firstPanel.setPreferredSize(new Dimension(800, 1600));
        Nodes jCheckBox = ((Nodes) e.getSource());
        if (jCheckBox.isSelected()) {
            System.out.println("COWSSS");
            for (Nodes nodes : jCheckBox.getList()) {
                if (!nodes.hasChild()) {
                    for (COWS_Nodes cows_nodes : COWS_List) {
                        if (cows_nodes.getValue().equals(jCheckBox.getValue())) {
                            return;
                        }
                    }
                    TitledBorder titledBorder = (TitledBorder) ((JPanel) jCheckBox.getParent()).getBorder();
                    String title = titledBorder.getTitle();
                    int number = Integer.parseInt((jCheckBox.getList().get(0).getValue()));
                    COWS_Nodes c1 = new COWS_Nodes(title, jCheckBox.getValue(), Integer.parseInt(jCheckBox.getList().get(0).getValue()));
                    COWS_List.add(c1);
                    COWS_scale += number;
                    System.out.println(COWS_scale);
                    System.out.println("No child");
                    return;
                }
                ;
            }
            for (Component component : jCheckBox.getParent().getComponents()) {
                if (component instanceof JPanel) {
                    TitledBorder titledBorder = (TitledBorder) ((JPanel) component).getBorder();
                    String title = titledBorder.getTitle();
                    if (title.equals(jCheckBox.getValue())) {
                        System.out.println("Done");
                        return;
                    }
                }
            }
            JPanel otherPanel = new JPanel(new WrapLayout());
            TitledBorder border = BorderFactory.createTitledBorder(jCheckBox.getValue());
            otherPanel.setBorder(border);
            jCheckBox.getParent().add(otherPanel);
            for (Nodes nodes : jCheckBox.getList()) {
                nodes.addActionListener(this);
                nodes.setText(nodes.getValue());
                otherPanel.add(nodes);
                otherPanel.revalidate();
            }
        }
        if (!jCheckBox.isSelected()) {
            for (Nodes nodes : jCheckBox.getList()) {
                if (!nodes.hasChild()) {
                    COWS_scale -= Integer.parseInt((jCheckBox.getList().get(0).getValue()));
                    Iterator<COWS_Nodes> iterator = COWS_List.iterator();
                    while (iterator.hasNext()) {
                        COWS_Nodes node = iterator.next();
                        if (node.getValue().equals(jCheckBox.getValue())) {
                            COWS_List.remove(node);
                        }
                    }
                    System.out.println(COWS_List.size());
                    return;
                }
                ;
            }
        }
        System.out.println(COWS_scale);
    }

    private void COWSsetUp(COWS COW) {
        symptoms = false;
        testing = false;
        cows = true;
        Nodes starting = COW.getNodes();
        JPanel panel = new JPanel(new WrapLayout());
        panel.setBorder(
                BorderFactory.createTitledBorder("COWS"));
        panel.setPreferredSize(new Dimension(400, 750));
        for (Nodes nodes : starting.getList()) {
            JPanel otherPanels = new JPanel(new WrapLayout());
            otherPanels.setBorder(BorderFactory.createTitledBorder(nodes.getValue()));
            nodes.addActionListener(this);
            nodes.setText(nodes.getValue());
            panel.add(otherPanels);
            otherPanels.add(nodes);
        }
        firstPanel.add(panel);
        submit = new JButton("submit");
        submit.setPreferredSize(new Dimension(800, 50));
        submit.addActionListener(this);
        JPanel submitbutton = new JPanel();
        submitbutton.add(submit);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(submitbutton);
        firstPanel.revalidate();
        this.revalidate();
    }

    private void testing(ActionEvent e) {
        Nodes jCheckBox = ((Nodes) e.getSource());
        if (jCheckBox.isSelected()) {
            if (additionPanelNodes(jCheckBox)) return;
        }
    }

    private void testingSetUp() {
        symptoms = false;
        testing = true;
        clearContent();
        Testing testing1 = new Testing(true);
        Testing testing2 = new Testing(false);
        TestingSetUp(testing1, testing1.getNodes().getValue());
        TestingSetUp(testing2, testing2.getNodes().getValue());
        submit = new JButton("submit");
        submit.setPreferredSize(new Dimension(800, 50));
        submit.addActionListener(this);
        JPanel submitbutton = new JPanel();
        submitbutton.add(submit);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(submitbutton);
        this.revalidate();
        firstPanel.revalidate();
    }

    private void TestingSetUp(Testing testing, String naming) {
        Nodes starting = testing.getNodes();
        JPanel panel = new JPanel(new WrapLayout());
        panel.setBorder(
                BorderFactory.createTitledBorder(naming));
        panel.setPreferredSize(new Dimension(400, 750));

        for (Nodes nodes : starting.getList()) {
            JPanel otherPanels = new JPanel(new WrapLayout());
            otherPanels.setBorder(BorderFactory.createTitledBorder(nodes.getValue()));
            nodes.addActionListener(this);
            nodes.setText(nodes.getValue());
            panel.add(otherPanels);
            otherPanels.add(nodes);
        }

        firstPanel.add(panel);
    }

    private void symptomsDeciding() {
        submit.setVisible(false);
        this.remove(submit);
        clearContent();
        JPanel panel1 = new JPanel(new WrapLayout());
        panel1.setPreferredSize(new Dimension(400, 800));
        panel1.setBorder(
                BorderFactory.createTitledBorder("Intoxication: "));
        JPanel panel2 = new JPanel(new WrapLayout());
        panel2.setPreferredSize(new Dimension(400, 800));
        panel2.setBorder(
                BorderFactory.createTitledBorder("withdrawal: "));
        JTextArea j1 = new JTextArea("Intoxication: " + numberingOfIntox / 16);
        JTextArea j2 = new JTextArea("withdrawal: " + numberingOfWithdrawal / 24);
        panel1.add(j1);
        panel2.add(j2);
        Testing = new JButton("Testing");
        Testing.setPreferredSize(new Dimension(400, 750));
        Testing.addActionListener(this);
        panel1.add(Testing);
        COWS = new JButton("Clinical withdrawal scale");
        COWS.setPreferredSize(new Dimension(400, 750));
        COWS.addActionListener(this);
        panel2.add(COWS);
        firstPanel.add(panel1);
        firstPanel.add(panel2);
        firstPanel.revalidate();
    }

    private void symptomsSetUp() {
        firstPanel.setLayout(new BoxLayout(firstPanel, BoxLayout.X_AXIS));
        clearContent();
        panel_for_DSM_intoxication = new JPanel(new WrapLayout());
        DSM5 dsm51 = new DSM5(true);
        paneling(panel_for_DSM_intoxication, dsm51, firstPanel, "Intoxication");
        panel_for_DSM_withdrawal = new JPanel(new WrapLayout());
        DSM5 dsm52 = new DSM5(false);
        paneling(panel_for_DSM_withdrawal, dsm52, firstPanel, "withdrawal");
        submit = new JButton("submit");
        submit.setPreferredSize(new Dimension(800, 50));
        submit.addActionListener(this);
        JPanel submitbutton = new JPanel();
        submitbutton.add(submit);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(submitbutton);
        firstPanel.revalidate();
        this.revalidate();
        symptoms = true;
    }

    private void symptomsCheck(ActionEvent e) {
        Nodes jCheckBox = ((Nodes) e.getSource());
        System.out.println(jCheckBox.getFocusCycleRootAncestor());

        JPanel target_Intox = getParentPanels(jCheckBox, panel_for_DSM_intoxication);
        JPanel target_withdraw = getParentPanels(jCheckBox, panel_for_DSM_withdrawal);
        if (jCheckBox.isSelected()) {
            determining(target_Intox, target_withdraw, 1);
            firstPanel.revalidate();
            if (additionPanelNodes(jCheckBox)) return;
        }
        if (!jCheckBox.isSelected()) {
            determining(target_Intox, target_withdraw, -1);
            Symptoms_Node symptoms_node = new Symptoms_Node(jCheckBox);
            symptoms_track.remove(symptoms_node.treeSearch(firstPanel));
            firstPanel.revalidate();
        }
    }

    private boolean additionPanelNodes(Nodes jCheckBox) {
        if (!jCheckBox.hasChild()) {
            Symptoms_Node symptoms_node = new Symptoms_Node(jCheckBox);
            String symptoms = symptoms_node.treeSearch(firstPanel);
            symptoms_track.add(symptoms);
            System.out.println(symptoms);
            System.out.println("No child");
            return true;
        }
        for (Component component : jCheckBox.getParent().getComponents()) {
            if (component instanceof JPanel) {
                TitledBorder titledBorder = (TitledBorder) ((JPanel) component).getBorder();
                String title = titledBorder.getTitle();
                if (title.equals(jCheckBox.getValue())) {
                    System.out.println("Done");
                    return true;
                }
            }
        }
        JPanel otherPanel = new JPanel(new WrapLayout());
        TitledBorder border = BorderFactory.createTitledBorder(jCheckBox.getValue());
        otherPanel.setBorder(border);
        jCheckBox.getParent().add(otherPanel);
        for (Nodes nodes : jCheckBox.getList()) {
            nodes.addActionListener(this);
            nodes.setText(nodes.getValue());
            otherPanel.add(nodes);
            otherPanel.revalidate();
        }
        return false;
    }

    private void determining(JPanel target_Intox, JPanel target_withdraw, int num) {
        JPanel panel = null;
        double number = 0;
        String naming = "";
        if (target_Intox != null) {
            panel = target_Intox;
            numberingOfIntox += num;
            System.out.println("Is intox " + numberingOfIntox);
            number = numberingOfIntox / 16;
            naming = "Intoxication: ";
        }
        if (target_withdraw != null) {
            panel = target_withdraw;
            numberingOfWithdrawal += num;
            System.out.println("Is withdrawal " + numberingOfWithdrawal);
            number = numberingOfWithdrawal / 24;
            naming = "Withdrawal: ";
        }
        for (Component component : panel.getComponents()) {
            if (component instanceof JTextArea) {
                try {
                    ((JTextArea) component).setText(naming + ("" + number).substring(0, 5));
                } catch (StringIndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static JPanel getParentPanels(Component component, JPanel target) {
        if (component.getParent() instanceof JPanel) {

            JPanel panel = (JPanel) component.getParent();
            if (panel == target) {
                return panel;
            }
            if (panel != target) {
                return getParentPanels(panel, target);
            }
        }
        return null;
    }

    private void paneling(JPanel panel, DSM5 dsm5, JPanel firstPanel, String naming) {
        panel.setBorder(
                BorderFactory.createTitledBorder(naming));
        panel.setPreferredSize(new Dimension(400, 750));
        Nodes starting = dsm5.getNodes();
        JTextArea textAreaIntox = new JTextArea(naming);
        panel.add(textAreaIntox);
        for (Nodes nodes : starting.getList()) {
            JPanel otherPanels = new JPanel(new WrapLayout());
            otherPanels.setBorder(BorderFactory.createTitledBorder(nodes.getValue()));
            nodes.addActionListener(this);
            nodes.setText(nodes.getValue());
            panel.add(otherPanels);
            otherPanels.add(nodes);
        }
        firstPanel.add(panel);
    }

    private void assessment_Path() {
        assessment = true;
        clearContent();
        System.out.println("Assessment");
        System.out.println(assessment);
        Symptoms = new JButton("Symptoms");
        Symptoms.addActionListener(this);
        firstPanel.add(Symptoms);
        Testing = new JButton("Laboratory Testing");
        Testing.addActionListener(this);
        firstPanel.add(Testing);
    }

    private void treatment_Path() {
        assessment = false;
        clearContent();
        System.out.println("Treatment");
        System.out.println(assessment);
        firstPanel.setLayout(new GridLayout(2, 4, 2, 4));
        Intoxication_Treatment = new JButton("Intoxication Treatment");
        Intoxication_Treatment.addActionListener(this);
        firstPanel.add(Intoxication_Treatment);
        System.out.println("Checking for symptoms or testing");
        Dependency_Treatment = new JButton("Dependency Treatment");
        Dependency_Treatment.addActionListener(this);
        firstPanel.add(Dependency_Treatment);
        Withdrawal_Treatment = new JButton("Withdrawal Treatment");
        Withdrawal_Treatment.addActionListener(this);
        JPanel other = new JPanel();
        other.setLayout(new BoxLayout(other, BoxLayout.Y_AXIS));
        JLabel intoxications = new JLabel();
        intoxications.setText("Current Patient's Intoxication level: " + Intox_severity);
        JLabel intoxications_ratio = new JLabel();
        intoxications_ratio.setText("Ratio of criteria hit: " + numberingOfIntox / 16);
        JLabel dependency1 = new JLabel();
        dependency1.setText("Current Patient's dependency: " + dependency);
        JLabel withdraw = new JLabel();
        withdraw.setText("Current Patient's withdrawal level: " + Withdrawal_severity + " and COWS: " + COWS_scale);
        JLabel withdraw_ratio = new JLabel();
        withdraw_ratio.setText("Ratio of criteria hit: " + numberingOfWithdrawal / 24);
        other.add(intoxications);
        other.add(intoxications_ratio);
        other.add(dependency1);
        other.add(withdraw);
        other.add(withdraw_ratio);
        firstPanel.add(Withdrawal_Treatment);
        firstPanel.add(other);

        if (!Intox_severity.equals("Not") || dependency || COWS_scale > 4 || !Withdrawal_severity.equals("Not")) {
            JFrame frame1 = new JFrame();
            JPanel other1 = new JPanel();
            if (!Intox_severity.equals("Not")) {
                JLabel suggestingDeTox = new JLabel();
                suggestingDeTox.setText("Detect Intoxication present at " + Intox_severity + " degree.");
                JLabel suggestingDeTox2 = new JLabel();
                suggestingDeTox2.setText("Suggesting Intoxication treatment.");
                other1.add(suggestingDeTox);
                other1.add(suggestingDeTox2);
            }
            if (dependency) {
                JLabel suggestingDeTox = new JLabel();
                suggestingDeTox.setText("Detect dependency present.\nSuggesting Dependency treatment.");
                JLabel suggestingDeTox2 = new JLabel();
                suggestingDeTox2.setText("Suggesting Dependency treatment.");
                other1.add(suggestingDeTox);
                other1.add(suggestingDeTox2);
            }
            if (COWS_scale > 4 || !Withdrawal_severity.equals("Not")) {
                JLabel suggestingDeTox = new JLabel();
                suggestingDeTox.setText("Detect Withdrawal present at " + Withdrawal_severity + " and COWS: " + COWS_scale + " degree.");
                JLabel suggestingDeTox2 = new JLabel();
                suggestingDeTox2.setText("Suggesting Withdrawal treatment.");
                other1.add(suggestingDeTox);
                other1.add(suggestingDeTox2);
            }
//            frame1.setDefaultCloseOperation();
            other1.setPreferredSize(new Dimension(400, 100));
            frame1.setContentPane(other1);
            frame1.pack();
            frame1.setLocationRelativeTo(null);
            frame1.setVisible(true);
            JPanel panel = new JPanel();
            JButton cancel = new JButton("Cancel");
            cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame1.setVisible(false);
                    frame1.dispose();
                }
            });
            panel.add(cancel);
            frame1.add(panel, BorderLayout.CENTER);
        }

    }

    private void clearContent() {
        Component[] components = firstPanel.getComponents();
//        buttonList.clear();
        for (Component component : components) {
            component.setVisible(false);
            firstPanel.remove(component);
        }
        firstPanel.revalidate();
    }

    /**
     * A library method that rounds a double to 2dp
     *
     * @return the amount rounded to 2dp
     */

    private static void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("Opioid CDSS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and set up the content pane.
        Test mainPanel = new Test();
        frame.setContentPane(mainPanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}