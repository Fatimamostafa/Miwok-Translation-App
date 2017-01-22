package com.example.android.miwok;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorsFragment extends Fragment {

    ListView listView;
    MediaPlayer mp;

    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    public ColorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     View rootView = inflater.inflate(R.layout.word_list,container, false);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("BLACK", "কালো", R.drawable.color_black, R.raw.color_brown));
        words.add(new Word("BROWN", "ব্রাউন", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("DUSTY YELLOW", "হাল্কা ব্রাউন", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word("MUSTARD YELLOW", "হলুদ", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
        words.add(new Word("GRAY", "এশ", R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word("RED", "লাল", R.drawable.color_red,  R.raw.color_red));
        words.add(new Word("WHITE", "সাদা", R.drawable.color_white, R.raw.color_white));
        words.add(new Word("GREEN", "সবুজ", R.drawable.color_green, R.raw.color_green));
        words.add(new Word("BLACK", "কালো", R.drawable.color_black,  R.raw.color_brown));
        words.add(new Word("RED", "লাল", R.drawable.color_red, R.raw.color_red));


        WordAdapter adapter = new WordAdapter(getActivity(), words);

        listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Word word = words.get(i);

                releaseMediaPlayer();

                mp = MediaPlayer.create(getActivity(), word.getmMediaResourceId());

                mp.start();

                mp.setOnCompletionListener(mOnCompletionListener);
            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if(mp != null)
            mp.release();
        mp = null;
    }
}
