package ravi.com.instashop.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ravi.com.instashop.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class IntroFragment2 extends Fragment {


    public IntroFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_intro_fragment2, container, false);
    }

}
