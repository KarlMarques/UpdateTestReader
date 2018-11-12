package com.teachsoft.updatetestreader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static com.teachsoft.updatetestreader.BaseActivity.CURRENT_CHAPTER;
import static com.teachsoft.updatetestreader.BaseActivity.CURRENT_EXERCISE;
import static com.teachsoft.updatetestreader.BaseActivity.CURRENT_SUBJECT;

public class ExerciseResolutionActivity extends AppCompatActivity {

    private TextView mTextViewTitle;
    private TextView mTextViewQuestion;
    private Button mButtonSubmit;

    private RadioGroup mRadioGroupAlternatives;

    private RadioButton mRadioButton1;
    private RadioButton mRadioButton2;
    private RadioButton mRadioButton3;
    private RadioButton mRadioButton4;
    private RadioButton mRadioButton5;

    private Subject mCurrentSubject;
    private Chapter mCurrentChapter;
    private Exercise mCurrentExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_resolution);

        Intent intent = getIntent();
        mCurrentSubject = (Subject) intent.getSerializableExtra(CURRENT_SUBJECT);
        String subjectCode = mCurrentSubject.getCode();
        mCurrentChapter = (Chapter) intent.getSerializableExtra(CURRENT_CHAPTER);
        String chapterCode = mCurrentChapter.getCode();
        mCurrentExercise = (Exercise) intent.getSerializableExtra(CURRENT_EXERCISE);
        String exerciseCode = mCurrentExercise.getCode();
        String exerciseTitle = mCurrentExercise.getTitle();
        String exerciseQuestion = mCurrentExercise.getQuestion();
        String exerciseA = mCurrentExercise.getAlternative("a");
        String exerciseB = mCurrentExercise.getAlternative("b");
        String exerciseC = mCurrentExercise.getAlternative("c");
        String exerciseD = mCurrentExercise.getAlternative("d");
        String exerciseE = mCurrentExercise.getAlternative("e");

        mTextViewTitle = findViewById(R.id.textViewTitle);
        mTextViewQuestion = findViewById(R.id.textViewQuestion);

        mRadioGroupAlternatives = findViewById(R.id.radioGroupAlternatives);
        mRadioButton1 = findViewById(R.id.radioButton1);
        mRadioButton2 = findViewById(R.id.radioButton2);
        mRadioButton3 = findViewById(R.id.radioButton3);
        mRadioButton4 = findViewById(R.id.radioButton4);
        mRadioButton5 = findViewById(R.id.radioButton5);

        mButtonSubmit = findViewById(R.id.buttonSubmit);

        mTextViewTitle.setText(exerciseTitle);
        mTextViewQuestion.setText(exerciseQuestion);
        mRadioButton1.setText(exerciseA);
        mRadioButton2.setText(exerciseB);
        mRadioButton3.setText(exerciseC);
        mRadioButton4.setText(exerciseD);
        mRadioButton5.setText(exerciseE);

        mButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int buttonId = mRadioGroupAlternatives.getCheckedRadioButtonId();

                if (buttonId != -1){
                    RadioButton radioButton = findViewById(buttonId);
                    String text = radioButton.getText().toString();
                    Toast.makeText(ExerciseResolutionActivity.this, "id: " + text, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
