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
public class PhrasesFragment extends Fragment {
    ListView listView;
    MediaPlayer mp;

    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };


    public PhrasesFragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("Feeling lazy", "কিছু লিখতে ইচ্ছা করতেসে না!", R.raw.phrase_are_you_coming));
        words.add(new Word("I will keep copying", "হুদাই কপি মাইরা যাই", R.raw.phrase_lets_go));
        words.add(new Word("Feeling lazy", "কিছু লিখতে ইচ্ছা করতেসে না!", R.raw.phrase_im_feeling_good));
        words.add(new Word("I will keep copying", "হুদাই কপি মাইরা যাই", R.raw.phrase_how_are_you_feeling));
        words.add(new Word("Feeling lazy", "কিছু লিখতে ইচ্ছা করতেসে না!", R.raw.phrase_come_here));
        words.add(new Word("I will keep copying", "হুদাই কপি মাইরা যাই", R.raw.phrase_im_coming));
        words.add(new Word("Feeling lazy", "কিছু লিখতে ইচ্ছা করতেসে না!", R.raw.phrase_yes_im_coming));
        words.add(new Word("I will keep copying", "হুদাই কপি মাইরা যাই", R.raw.phrase_my_name_is));
        words.add(new Word("Feeling lazy", "কিছু লিখতে ইচ্ছা করতেসে না!", R.raw.phrase_what_is_your_name));
        words.add(new Word("I will keep copying", "হুদাই কপি মাইরা যাই", R.raw.phrase_where_are_you_going));
        words.add(new Word("Feeling lazy", "কিছু লিখতে ইচ্ছা করতেসে না!", R.raw.phrase_come_here));
        words.add(new Word("I will keep copying", "হুদাই কপি মাইরা যাই", R.raw.phrase_lets_go));

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
        if (mp != null) {

            mp.release();

            mp = null;
        }
    }

}
