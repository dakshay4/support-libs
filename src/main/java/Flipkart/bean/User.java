package Flipkart.bean;

/**
 * Created by dakshay on 23/10/2021.
 */
public class User {
    private final String name;
    private Judgement judgement;


    public User(String name, Judgement judgement) {
        this.name = name;
        this.judgement = judgement;
    }

    public String getName() {
        return name;
    }

    public Judgement getJudgement() {
        return judgement;
    }

    public void setJudgement(Judgement judgement) {
        this.judgement = judgement;
    }

    public enum Judgement {
        VIEWER,
        CRITIC
    }
}
