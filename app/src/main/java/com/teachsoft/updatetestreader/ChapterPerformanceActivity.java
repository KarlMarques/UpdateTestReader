package com.teachsoft.updatetestreader;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import java.util.ArrayList;

public class ChapterPerformanceActivity extends BaseActivity {
    private GraphView mGraphView;
    private Subject mCurrentSubject;
    private Chapter mCurrentChapter;

    int mExerciseQuantity = 0;
    int mTotalScore = 0;
    String mChapterTitle;

    FirebaseDatabase mFirebaseDB = FirebaseDatabase.getInstance();
    DatabaseReference mDBReferenceExercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_performance);

        Intent intent = getIntent();
        mCurrentSubject = (Subject) intent.getSerializableExtra(CURRENT_SUBJECT);
        String subjectCode = mCurrentSubject.getCode();
        mCurrentChapter = (Chapter) intent.getSerializableExtra(CURRENT_CHAPTER);
        String chapterCode = mCurrentChapter.getCode();
        mChapterTitle = mCurrentChapter.getTitle();

        mDBReferenceExercises = mFirebaseDB.getReference(SUBJECTS_TITLE).child(subjectCode).child(CHAPTERS_TITLE).child(chapterCode).child(EXERCISES_TITLE);
        mDBReferenceExercises.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                getData(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mGraphView = findViewById(R.id.graphViewChapter);
        initGraph();
    }

    void initGraph() {
        mGraphView.setTitle(mChapterTitle);

        BarGraphSeries<DataPoint> totalSeries = new BarGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 5),
        });
        totalSeries.setColor(Color.BLUE);
        totalSeries.setSpacing(30);
        totalSeries.setAnimated(true);
        mGraphView.addSeries(totalSeries);

        BarGraphSeries<DataPoint> scoreSeries = new BarGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 1),
        });
        scoreSeries.setColor(Color.GREEN);
        scoreSeries.setSpacing(30);
        scoreSeries.setAnimated(true);
        mGraphView.addSeries(scoreSeries);

        // legend
        totalSeries.setTitle("Total");
        scoreSeries.setTitle("Score");
        mGraphView.getLegendRenderer().setVisible(true);
        mGraphView.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
    }

    private void getData(DataSnapshot dataSnapshot){
        mExerciseQuantity = 0;
        mTotalScore = 0;

        for (DataSnapshot ds : dataSnapshot.getChildren()){
            mExerciseQuantity++;
            Exercise exercise= ds.getValue(Exercise.class);
            int currentScore = exercise.getScore();
            if (currentScore > 0){
                mTotalScore += currentScore;
            }
        }
    }

}
