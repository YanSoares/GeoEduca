package br.com.yrsoares.geoeduca;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class SImuladoActivity extends AppCompatActivity {

    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private TextView textViewCountDown;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private RadioButton rb5;
    private Button buttonConfirmNext;

    private ColorStateList textColorDefaultRb;

    private List<Question> questionList;
    private int questionCounter;
    private int questionCountTotal;
    private Question currentQuestion;

    private int score;
    private boolean answered;

    private long backPressedTime;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulado);

        textViewQuestion = findViewById(R.id.text_view_question);
        textViewScore = findViewById(R.id.text_view_score);
        textViewQuestionCount = findViewById(R.id.text_view_question_count);
        //textViewCountDown = findViewById(R.id.text_view_countdown);
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);
        rb4 = findViewById(R.id.radio_button4);
        rb5 = findViewById(R.id.radio_button5);
        buttonConfirmNext = findViewById(R.id.button_confirm_next);

        textColorDefaultRb = rb1.getTextColors();
        textViewQuestion.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);


        Intent intent = getIntent();
        String difficulty = intent.getStringExtra(AnoSimulado.EXTRA_DIFFICULTY);

        QuizDbHelper dbHelper = new QuizDbHelper(this);
        questionList = dbHelper.getQuestions(difficulty);
        questionCountTotal = questionList.size();
        Collections.shuffle(questionList);

        showNextQuestion();

        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered){
                    if(rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked() || rb5.isChecked()){
                        checkAnswer();
                    }else{
                        Toast.makeText(SImuladoActivity.this, "Por favor selecione uma opção", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        rb1.setTextColor(textColorDefaultRb);
        rb1.setTypeface(null, Typeface.NORMAL);
        rb2.setTextColor(textColorDefaultRb);
        rb2.setTypeface(null, Typeface.NORMAL);
        rb3.setTextColor(textColorDefaultRb);
        rb3.setTypeface(null, Typeface.NORMAL);
        rb4.setTextColor(textColorDefaultRb);
        rb4.setTypeface(null, Typeface.NORMAL);
        rb5.setTextColor(textColorDefaultRb);
        rb5.setTypeface(null, Typeface.NORMAL);
        rbGroup.clearCheck();

        if(questionCounter < questionCountTotal){
            currentQuestion = questionList.get(questionCounter);

            textViewQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());
            rb5.setText(currentQuestion.getOption5());

            questionCounter++;
            textViewQuestionCount.setText("Questão: " + questionCounter + "/" + questionCountTotal);
            answered = false;
            buttonConfirmNext.setText("Confirmar");
        }else{
            finishQuiz();
        }
    }

    private void checkAnswer(){
        answered = true;

        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNr = rbGroup.indexOfChild(rbSelected) + 1;

        if(answerNr == currentQuestion.getAnswerNr()){
            score++;
            textViewScore.setText("Pontuação: " + score);
        }

        showSolution();
    }

    private void showSolution(){
        rb1.setTextColor(Color.RED);
        rb1.setTypeface(null, Typeface.NORMAL);
        rb2.setTextColor(Color.RED);
        rb2.setTypeface(null, Typeface.NORMAL);
        rb3.setTextColor(Color.RED);
        rb3.setTypeface(null, Typeface.NORMAL);
        rb4.setTextColor(Color.RED);
        rb4.setTypeface(null, Typeface.NORMAL);
        rb5.setTextColor(Color.RED);
        rb5.setTypeface(null, Typeface.NORMAL);

        switch (currentQuestion.getAnswerNr()){
            case 1:
                rb1.setTextColor(getResources().getColor(R.color.VerdeEscuro));
                rb1.setTypeface(null, Typeface.BOLD);
                //textViewQuestion.setText("A letra A é a correta");
                break;
            case 2:
                rb2.setTextColor(getResources().getColor(R.color.VerdeEscuro));
                rb2.setTypeface(null, Typeface.BOLD);
                //textViewQuestion.setText("A letra B é a correta");
                break;
            case 3:
                rb3.setTextColor(getResources().getColor(R.color.VerdeEscuro));
                rb3.setTypeface(null, Typeface.BOLD);
                //textViewQuestion.setText("A letra C é a correta");
                break;
            case 4:
                rb4.setTextColor(getResources().getColor(R.color.VerdeEscuro));
                rb4.setTypeface(null, Typeface.BOLD);
                //textViewQuestion.setText("A letra D é a correta");
                break;
            case 5:
                rb5.setTextColor(getResources().getColor(R.color.VerdeEscuro));
                rb5.setTypeface(null, Typeface.BOLD);
                //textViewQuestion.setText("A letra E é a correta");
                break;
        }
        if(questionCounter<questionCountTotal){
            buttonConfirmNext.setText("Próximo");
        }else{
            buttonConfirmNext.setText("Final");
        }
    }

    private void finishQuiz() {

        float porcentagem = (((float)score)/questionCountTotal)*100;

        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage("Você teve " + (int)porcentagem + "% de acerto!");
        dlgAlert.setTitle("Resultado");
        dlgAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();

    }

    @Override
    public void onBackPressed() {
        if(backPressedTime + 2000 > System.currentTimeMillis()){
            finishQuiz();
        }else{
            Toast.makeText(this, "Pressione novamente para sair", Toast.LENGTH_SHORT).show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}
