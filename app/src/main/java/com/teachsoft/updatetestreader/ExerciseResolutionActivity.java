package com.teachsoft.updatetestreader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.teachsoft.updatetestreader.BaseActivity.CURRENT_CHAPTER;
import static com.teachsoft.updatetestreader.BaseActivity.CURRENT_EXERCISE;
import static com.teachsoft.updatetestreader.BaseActivity.CURRENT_SUBJECT;

public class ExerciseResolutionActivity extends AppCompatActivity {

    private TextView mTextViewTitle;
    private TextView mTextViewQuestion;
    private CheckBox mCheckBoxA;
    private CheckBox mCheckBoxB;
    private CheckBox mCheckBoxC;
    private CheckBox mCheckBoxD;
    private CheckBox mCheckBoxE;
    private Button mButtonSubmit;

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
        mCheckBoxA = findViewById(R.id.checkBoxA);
        mCheckBoxB = findViewById(R.id.checkBoxB);
        mCheckBoxC = findViewById(R.id.checkBoxC);
        mCheckBoxD = findViewById(R.id.checkBoxD);
        mCheckBoxE = findViewById(R.id.checkBoxE);
        mButtonSubmit = findViewById(R.id.buttonSubmit);

        mTextViewTitle.setText(exerciseTitle);
        mTextViewQuestion.setText(exerciseQuestion);
        mCheckBoxA.setText(exerciseA);
        mCheckBoxB.setText(exerciseB);
        mCheckBoxC.setText(exerciseC);
        mCheckBoxD.setText(exerciseD);
        mCheckBoxE.setText(exerciseE);

        mCheckBoxA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mCheckBoxB.setChecked(false);
                mCheckBoxC.setChecked(false);
                mCheckBoxD.setChecked(false);
                mCheckBoxE.setChecked(false);
            }
        });
        mCheckBoxB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mCheckBoxA.setChecked(false);
                mCheckBoxC.setChecked(false);
                mCheckBoxD.setChecked(false);
                mCheckBoxE.setChecked(false);
            }
        });
        mCheckBoxC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mCheckBoxA.setChecked(false);
                mCheckBoxB.setChecked(false);
                mCheckBoxD.setChecked(false);
                mCheckBoxE.setChecked(false);
            }
        });
        mCheckBoxD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mCheckBoxA.setChecked(false);
                mCheckBoxB.setChecked(false);
                mCheckBoxC.setChecked(false);
                mCheckBoxE.setChecked(false);
            }
        });
        mCheckBoxE.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mCheckBoxA.setChecked(false);
                mCheckBoxB.setChecked(false);
                mCheckBoxC.setChecked(false);
                mCheckBoxD.setChecked(false);
            }
        });


        mButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean boxChecked = mCheckBoxA.isChecked() ||
                        mCheckBoxB.isChecked() ||
                        mCheckBoxC.isChecked() ||
                        mCheckBoxD.isChecked() ||
                        mCheckBoxE.isChecked();

                if (boxChecked){
                    String id = "none";

                    if (mCheckBoxA.isChecked()){
                        id = "a";
                    }
                    else if (mCheckBoxB.isChecked()){
                        id = "b";
                    }
                    else if (mCheckBoxC.isChecked()){
                        id = "c";
                    }
                    else if (mCheckBoxD.isChecked()){
                        id = "d";
                    }
                    else if (mCheckBoxE.isChecked()){
                        id = "e";
                    }

                    Toast.makeText(ExerciseResolutionActivity.this, "id: " + id, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
