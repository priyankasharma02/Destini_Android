package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView storyTextView;
    Button topButton,bottomButton;
    CharSequence mcurrent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        storyTextView = findViewById(R.id.storyTextView);
        topButton = findViewById(R.id.buttonTop);
        bottomButton = findViewById(R.id.buttonBottom);

        if(savedInstanceState!=null) {
            mcurrent = savedInstanceState.getCharSequence("currentStory");
            storyTextView.setText(mcurrent);
            topButton.setText(savedInstanceState.getCharSequence("currentTopButton"));
            bottomButton.setText(savedInstanceState.getCharSequence("currentBottomButton"));
            topButton.setVisibility(savedInstanceState.getInt("buttonVisibility"));
            bottomButton.setVisibility(savedInstanceState.getInt("buttonVisibility"));
        }



        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               mcurrent = storyTextView.getText();

                if(mcurrent.equals(getResources().getText(R.string.T1_Story)))
                {
                    storyTextView.setText(R.string.T3_Story);
                    topButton.setText(R.string.T3_Ans1);
                    bottomButton.setText(R.string.T3_Ans2);
                }
                else if(mcurrent.equals(getResources().getText(R.string.T3_Story))){
                    storyTextView.setText(R.string.T6_End);
                    topButton.setVisibility(View.INVISIBLE);
                    bottomButton.setVisibility(View.INVISIBLE);
                }
                else if(mcurrent.equals(getResources().getText(R.string.T2_Story))) {
                    storyTextView.setText(R.string.T3_Story);
                    topButton.setText(R.string.T3_Ans1);
                    bottomButton.setText(R.string.T3_Ans2);
                }
            }
        });




        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        bottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mcurrent = storyTextView.getText();

                if (mcurrent.equals(getResources().getText(R.string.T1_Story))) {
                    storyTextView.setText(R.string.T2_Story);
                    topButton.setText(R.string.T2_Ans1);
                    bottomButton.setText(R.string.T2_Ans2);
                } else if (mcurrent.equals(getResources().getText(R.string.T2_Story))) {
                    storyTextView.setText(R.string.T4_End);
                    topButton.setVisibility(View.INVISIBLE);
                    bottomButton.setVisibility(View.INVISIBLE);
                }
                else if (mcurrent.equals(getResources().getText(R.string.T3_Story))) {
                    storyTextView.setText(R.string.T5_End);
                    topButton.setVisibility(View.INVISIBLE);
                    bottomButton.setVisibility(View.INVISIBLE);
                }
            }
        });

        }

        public void onSaveInstanceState(Bundle outstate)
        {
            super.onSaveInstanceState(outstate);
            outstate.putCharSequence("currentStory",storyTextView.getText());
            outstate.putCharSequence("currentTopButton",topButton.getText());
            outstate.putCharSequence("currentBottomButton",bottomButton.getText());
            outstate.putInt("buttonVisibility",topButton.getVisibility());
        }


    }

