package com.example.hideandshowfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class FirstFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private int i = 0;

    private TextView tv;

    private Button button;

    // TODO: Rename and change types of parameters
    private String mParam1;

//    private OnFragmentInteractionListener mListener;

    public FirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment FirstFragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String param1) {

        FirstFragment fragment = new FirstFragment();

        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

            mParam1 = getArguments().getString(ARG_PARAM1);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        button = (Button) view.findViewById(R.id.btn_counter);

        tv = (TextView) view.findViewById(R.id.tv_counter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int d = i++;

                tv.setText("" + d);

            }
        });

        return view;

    }
}
