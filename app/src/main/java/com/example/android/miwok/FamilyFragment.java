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
public class FamilyFragment extends Fragment {

    ListView listView;
    MediaPlayer mp;

    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };



    public FamilyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("Farwa", "আমি", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Word("Father", "আব্বু", R.drawable.family_father, R.raw.family_father));
        words.add(new Word("Grandfather", "দাদু", R.drawable.family_grandfather, R.raw.family_grandfather));
        words.add(new Word("Grandmother", "দাদী", R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new Word("Mother", "আম্মু", R.drawable.family_mother, R.raw.family_mother));
        words.add(new Word("Elder Sister", "বড় আপু", R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new Word("Brother", "ভাইয়া", R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Word("Younger Sister", "তানি", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new Word("Shuhaib", "শুহাইব", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Word("Zareer", "যারীর", R.drawable.family_son, R.raw.family_son));
        words.add(new Word("Saad", "সা'দ", R.drawable.family_son, R.raw.family_son));


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
    }

    private void releaseMediaPlayer() {

        if (mp != null) {

            mp.release();

            mp = null;
        }
    }
}
