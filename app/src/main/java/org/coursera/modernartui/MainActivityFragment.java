package org.coursera.modernartui;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import java.util.Random;

public class MainActivityFragment extends Fragment {

    private static final String TAG = MainActivityFragment.class.getSimpleName();

    public MainActivityFragment() {
    }

    private View mView1, mView2, mView3, mView4, mView5;
    private SeekBar mSeekBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mSeekBar = (SeekBar) rootView.findViewById(R.id.seek_bar);
        mSeekBar.setMax(100);
        mView1 = (View) rootView.findViewById(R.id.view1);
        mView2 = (View) rootView.findViewById(R.id.view2);
        mView3 = (View) rootView.findViewById(R.id.view3);
        mView4 = (View) rootView.findViewById(R.id.view4);
        mView5 = (View) rootView.findViewById(R.id.view5);

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Log.i(TAG, getClass().getSimpleName() + "Progress is" + Integer.toString(progress));
                changeColour(mView1, progress);
                changeColour(mView2, progress);
                changeColour(mView3, progress);
                changeColour(mView4, progress);
                changeColour(mView5, progress);
            }
        });

        //load random colors
        setRandomColour(mView1, getRandomColour());
        setRandomColour(mView2, getRandomColour());
        setRandomColour(mView3, getRandomColour());
        setRandomColour(mView4, Color.LTGRAY);
        setRandomColour(mView5, getRandomColour());
        return rootView;
    }

    private void setRandomColour(View view, int colour){
        view.setBackgroundColor(colour);
        view.setTag(colour);
    }

    private int getRandomColour(){
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(156), rnd.nextInt(256), rnd.nextInt(256));
    }

    private void changeColour(View view, int additionalValue) {
        int colour = ((ColorDrawable)view.getBackground()).getColor();
        int r = (colour >> 16) & 0xFF;
        int g = (colour >> 8) & 0xFF;
        int b = (colour >> 0) & 0xFF;

        r += additionalValue;
        g += additionalValue;
        b += additionalValue;

        int newColour = Color.argb(255, r, g, b);
        view.setBackgroundColor(newColour);
        view.setTag(newColour);
    }

}
