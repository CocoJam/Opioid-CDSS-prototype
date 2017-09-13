/**
 * Created by ljam763 on 12/09/2017.
 */
public class COWS_Nodes {
    private String title;
    private String value;
    private int score;

    public COWS_Nodes(String title, String value, int score) {
        this.title = title;
        this.value = value;
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
