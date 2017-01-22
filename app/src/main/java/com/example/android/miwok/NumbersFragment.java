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
public class NumbersFragment extends Fragment {



    ListView listView;
    MediaPlayer mp;

    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };


    public NumbersFragment() {
        // Required empty public constructor


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);


        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("one", "এক", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("two", "দুই", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three", "তিন", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four", "চার", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five", "পাঁচ", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("six", "ছয়", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("seven", "সাত", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("eight", "আট", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("nine", "নয়", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("ten", "দশ", R.drawable.number_ten, R.raw.number_ten));


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

    //Releases mediaplayer

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {

        if (mp != null) {

            mp.release();


            mp = null;
        }
    }

}
