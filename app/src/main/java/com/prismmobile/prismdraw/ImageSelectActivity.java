package com.prismmobile.prismdraw;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import com.google.android.glass.touchpad.Gesture;
import com.google.android.glass.touchpad.GestureDetector;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class ImageSelectActivity extends Activity
        implements com.google.android.glass.touchpad.GestureDetector.BaseListener {

    private GestureDetector mGestureDetector;
    public List mPictures;

    public static final String TAG = ImageSelectActivity.class.getSimpleName();



    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        mGestureDetector = (new GestureDetector(this)).setBaseListener(this);
        mPictures = queryImages();

        }

    private List queryImages() {

        ArrayList arraylist = new ArrayList();
        File photoParser[] = (new File("/mnt/sdcard/DCIM/Camera/")).listFiles(); // Is there a better way to not hard code this?
        Log.i(TAG, "Running Image Query");
        Arrays.sort(photoParser, new Comparator() {


            public int compare(Object obj, Object obj1)
            {

                if (((File)obj).lastModified() > ((File)obj1).lastModified())
                {
                    return -1;
                }
                return ((File)obj).lastModified() >= ((File)obj1).lastModified() ? 0 : 1;
            }


            {

            }
        });
        int i = photoParser.length;
        for (int j = 0; j < i; j++)
        {
            File file = photoParser[j];

        }

        Log.i(TAG, "Done Querying!");
        return arraylist;
    }




    @Override //send motion events to GestureDetector - BaseListener and TwoFingerScrollListener
    public boolean onGenericMotionEvent(MotionEvent event) {
        return mGestureDetector.onMotionEvent(event);
    }

    @Override
    public boolean onGesture(Gesture gesture)
    {
        if (gesture == Gesture.TAP)
        {

        }
        return false;
    }




}
