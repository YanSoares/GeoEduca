package br.com.yrsoares.geoeduca;

public class Question {
    public static final String DIFFICULTY_PSC1 = "PSC1";
    public static final String DIFFICULTY_PSC2 = "PSC2";
    public static final String DIFFICULTY_PSC3 = "PSC3";
    public static final String DIFFICULTY_ENEM = "ENEM";

    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String option5;
    private int answerNr;
    private String difficulty;

    public Question(){}

    public Question(String question, String option1, String option2, String option3,
                    String option4, String option5, int answerNr, String difficulty) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.option5 = option5;
        this.answerNr = answerNr;
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getOption5() {
        return option5;
    }

    public void setOption5(String option5) {
        this.option5 = option5;
    }

    public int getAnswerNr() {
        return answerNr;
    }

    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public static String[] getAllDifficultyLevels(){
        return new String[]{
                DIFFICULTY_PSC1,
                DIFFICULTY_PSC2,
                DIFFICULTY_PSC3,
                DIFFICULTY_ENEM
        };
    }
}