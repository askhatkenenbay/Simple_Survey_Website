package kz.pro2.webtask.entity;

public class Survey {
    private String email;
    private int score;
    private String questionOne;
    private String questionTwo;
    private String questionThree;

    public Survey(String email, String score, String questionOne, String questionTwo, String questionThree) {
        this.email = email;
        this.score = Integer.parseInt(score);
        this.questionOne = questionOne;
        this.questionTwo = questionTwo;
        this.questionThree = questionThree;
    }

    public String getEmail() {
        return email;
    }

    public int getScore() {
        return score;
    }

    public String getQuestionOne() {
        return questionOne;
    }

    public String getQuestionTwo() {
        return questionTwo;
    }

    public String getQuestionThree() {
        return questionThree;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
