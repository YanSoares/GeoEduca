package br.com.yrsoares.geoeduca;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.yrsoares.geoeduca.QuizContract.*;

public class QuizDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GeoEduca.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION5 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER, " +
                QuestionsTable.COLUMN_DIFFICULTY + " TEXT" +
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable() {
        Question q1 = new Question("(ENEM-2017) - Após a Declaração Universal dos Direitos Humanos pela ONU, em 1948, a Unesco publicou estudos de cientistas de todo o mundo que desqualificaram as doutrinas racistas e demonstraram a unidade do gênero humano. Desde então, a maioria dos próprios cientistas europeus passou a reconhecer o caráter discriminatório da pretensa superioridade racial do homem branco e a condenar as aberrações cometidas em seu nome. SILVEIRA, R. Os selvagens e a massa: papel do racismo científico na montagem da hegemonia ocidental. Afro-Ásia, n, 23, 1999(adaptado). \nA posição assumida pela Unesco, a partir de 1948 foi motivada por acontecimentos então recentes, dentre os quais se destacava o(a)", "ataque feito pelos japoneses à base militar americana de Pearl Harbor.", "desencadeamento da Guerra Fria e de novas rivalidades entre nações.", "morte de milhões de soldados nos combates da Segunda Guerra Mundial. ", "execução de judeus e eslavos presos em guetos e campos de concentração nazistas. ", "lançamento de bombas atômicas em Hiroshima e Nagasaki pelas forças norte-americanas.", 4, Question.DIFFICULTY_ENEM);
        addQuestion(q1);
        Question q2 = new Question("(PSC1-2017) - Art. 231. São reconhecidos aos índios sua organização social, costumes, línguas, crenças e tradições, e os direitos originários sobre as terras que tradicionalmente ocupam. competindo à União demarcá-las, proteger e fazer respeitar todos os seus bens. BRASIL. Constituição da República Federativa do Brasil de 1988. Disponível em: www. planalto. gov. br. Acesso em: 27 abr. 2017. \nA persistência das reivindicações relativas à aplicação desse preceito normativo tem em vista a vinculação histórica fundamental entre ", "etnia e miscigenação racial.", "sociedade e igualdade jurídica. ", "espaço e sobrevivência cultural.", "progresso e educação ambiental.", "bem-estar e modernização econômica.", 3, Question.DIFFICULTY_PSC1);
        addQuestion(q2);
        Question q3 = new Question("(ENEM-2017) - A configuração do espaço urbano da região do Entorno do Distrito Federal assemelha-se às demais aglomerações urbanas e regiões metropolitanas do pais, onde é facilmente identificável a constituição de um centro dinâmico e desenvolvido, onde se concentram as oportunidades de trabalho e os principais serviços, e a constituição de uma região periférica concentradora de população de baixa renda, com acesso restrito às principais atividades com capacidade de acumulação e produtividade, e aos serviços sociais e infraestrutura básica. CAIADO, M. C. A migração intrametropolitana e o processo de estruturação do espaço da Região Integrada de Desenvolvimento do Distrito Federal e Entorno. In: HOGAN, D. J. et al. (Org.). Migração e ambiente nas aglomerações urbanas. Campinas: Nepo/Unicamp, 2002. \nA organização interna do aglomerado urbano descrito é resultado da ocorrência do processo de ", "expansão vertical. ", "polarização nacional. ", "emancipação municipal. ", "segregação socioespacial. ", "desregulamentação comercial.", 4, Question.DIFFICULTY_ENEM);
        addQuestion(q3);
        Question q4 = new Question("(PSC2-2017) - México, Colômbia, Peru e Chile decidiram seguir um caminho mais curto para a integração regional. Os quatro países, em meados de 2012, criaram a Aliança do Pacífico e eliminaram, em 2013, as tarifas aduaneiras de 90% do total de produtos comercializados entre suas fronteiras. OLIVEIRA, E. Aliança do Pacífico se fortalece e Mercosul fica à sua sombra. O Globo, 24 fev. 2013 (adaptado). \n" +
                "\nO acordo descrito no texto teve como objetivo econômico para os países-membros ", "promover a livre circulação de trabalhadores. ", "fomentar a competitividade no mercado externo. ", "restringir investimentos de empresas multinacionais. ", " adotar medidas cambiais para subsidiar o setor agrícola. ", "reduzir a fiscalização alfandegária para incentivar o consumo", 2, Question.DIFFICULTY_PSC2);
        addQuestion(q4);
        Question q5 = new Question("(PSC3-2017) - O desgaste acelerado sempre existirá se o agricultor não tiver o devido cuidado de combater as causas, relacio - nadas a vários processos, tais como: empobrecimento químico e lixiviação provocados pelo esgotamento causado pelas colheitas e pela lavagem vertical de nutrientes da água que se infiltra no solo, bem como pela retirada de elementos nutritivos com as colheitas. Os nutrientes retirados, quando não repostos, são comumente substituídos por elementos tóxicos, como, por exemplo, o alumínio. LEPSCH, I. Formação e consumação dos solos. São Paulo: Oficina de Textos, 2002 (adaptado). \nA dinâmica ambiental exemplificada no texto gera a seguinte consequência para o solo agricultável: ", "Elevação da acidez.", "Ampliação da salinidade. ", "Formação de voçorocas. ", "Remoção da camada superior. ", "Intensificação do escoamento superficial.", 1, Question.DIFFICULTY_PSC3);
        addQuestion(q5);
        Question q6 = new Question("(ENEM-2017) - O desgaste acelerado sempre existirá se o agricultor não tiver o devido cuidado de combater as causas, relacio - nadas a vários processos, tais como: empobrecimento químico e lixiviação provocados pelo esgotamento causado pelas colheitas e pela lavagem vertical de nutrientes da água que se infiltra no solo, bem como pela retirada de elementos nutritivos com as colheitas. Os nutrientes retirados, quando não repostos, são comumente substituídos por elementos tóxicos, como, por exemplo, o alumínio. LEPSCH, I. Formação e consumação dos solos. São Paulo: Oficina de Textos, 2002 (adaptado). \nA dinâmica ambiental exemplificada no texto gera a seguinte consequência para o solo agricultável: ", "Elevação da acidez.", "Ampliação da salinidade. ", "Formação de voçorocas. ", "Remoção da camada superior. ", "Intensificação do escoamento superficial.", 1, Question.DIFFICULTY_ENEM);
        addQuestion(q6);
        Question q7 = new Question("(PSC3-2017) - TESTE: ", "Elevação da acidez.", "Ampliação da salinidade. ", "Formação de voçorocas. ", "Remoção da camada superior. ", "Intensificação do escoamento superficial.", 1, Question.DIFFICULTY_PSC3);
        addQuestion(q7);

    }

    private void addQuestion(Question question){
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuestionsTable.COLUMN_OPTION5, question.getOption5());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(QuestionsTable.COLUMN_DIFFICULTY, question.getDifficulty());

        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public List<Question> getAllQuestions(){
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if(c.moveToFirst()){
            do{
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setOption5(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION5)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
                questionList.add(question);
            }while (c.moveToNext());
        }

        c.close();
        return  questionList;
    }

    public List<Question> getQuestions(String difficulty){
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();

        String[] selectionArgs = new String[]{difficulty};
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME +
                " WHERE " + QuestionsTable.COLUMN_DIFFICULTY + " = ?", selectionArgs);

        if(c.moveToFirst()){
            do{
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setOption5(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION5)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
                questionList.add(question);
            }while (c.moveToNext());
        }

        c.close();
        return  questionList;
    }
}
