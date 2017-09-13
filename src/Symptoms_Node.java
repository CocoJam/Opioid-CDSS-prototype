import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by ljam763 on 12/09/2017.
 */
public class Symptoms_Node {
    public JPanel getCurrentPanel() {
        return currentPanel;
    }

    public void setCurrentPanel(JPanel currentPanel) {
        this.currentPanel = currentPanel;
    }

    public String getSearch_Results() {
        return search_Results;
    }

    public void setSearch_Results(String search_Results) {
        this.search_Results = search_Results;
    }

    private JCheckBox jCheckBox;
    private JPanel currentPanel;
    private String search_Results;
    public JCheckBox getjCheckBox() {
        return jCheckBox;
    }

    public void setjCheckBox(JCheckBox jCheckBox) {
        this.jCheckBox = jCheckBox;

    }

    public Symptoms_Node(JCheckBox jCheckBox) {
        this.jCheckBox = jCheckBox;
        this.currentPanel = (JPanel) jCheckBox.getParent();
        TitledBorder titledBorder = (TitledBorder) currentPanel.getBorder();
        String title = titledBorder.getTitle();
        this.search_Results = title + " -> " +jCheckBox.getText();
    }
    public String treeSearch (JPanel top){
        if (! (currentPanel == top)){
            System.out.println(currentPanel.getParent().getClass());
            this.currentPanel = (JPanel) currentPanel.getParent();
            TitledBorder titledBorder = (TitledBorder) currentPanel.getBorder();
            if (titledBorder == null){
                return search_Results;
            }
            String title = titledBorder.getTitle();
           search_Results = title + " -> " + search_Results;
//            System.out.println(search_Results);
           return treeSearch(top);
        }
        return search_Results;
    }
}
