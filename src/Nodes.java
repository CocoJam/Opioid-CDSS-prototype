
import javax.swing.*;

import java.util.ArrayList;


/**
 * Created by ljam763 on 10/09/2017.
 */
public class Nodes extends JCheckBox{
    private String value;
    private ArrayList<Nodes> list = new ArrayList<>();

    public void setList(ArrayList<Nodes> list) {
        this.list = list;
    }

    public Nodes getAnswer() {
        return answer;
    }

    public void setAnswer(Nodes answer) {
        this.answer = answer;
    }

    private Nodes answer;

    public Nodes(String value, ArrayList<Nodes> list) {
        this.value = value;
        this.list = list;
    }

    public Nodes(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ArrayList<Nodes> getList() {
        return list;
    }

    public void addList(Nodes nodes) {
        this.list.add(nodes);
    }

    public boolean hasChild() {
        return this.getList().size() > 0;
    }

    public Nodes find(Nodes nodes, String s) {

        if (nodes.getValue().equals(s)) {
            System.out.println(s);
            System.out.println("found it");
            answer = nodes;
            return nodes;
        } else {
            if (nodes.hasChild()) {
                for (Nodes nodes1 : nodes.getList()) {
                    System.out.println(nodes1.getValue());
                    find(nodes1, s);
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {


        Nodes n = new Nodes("asd");
        Nodes n0 =(new Nodes("a"));
        n.addList(n0);
        Nodes n1 = (new Nodes("b"));
        n.addList(n1);
        Nodes n2 = new Nodes("c");
        n1.addList(n2);
        Nodes n3 = new Nodes("d");
        n0.addList(n3);
        Nodes answer = n.find(n, "b");
        System.out.println(answer.getAnswer());
    }
}
