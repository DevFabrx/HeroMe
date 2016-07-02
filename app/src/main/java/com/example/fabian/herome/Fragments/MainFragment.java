package com.example.fabian.herome.Fragments;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fabian.herome.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.MainFragementInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Button accidentBtn;
    private Button geneticBtn;
    private Button bornBtn;
    private Button chooseBtn;
    Drawable[] drawables1;
    Drawable[] drawables2;
    Drawable[] drawables3;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private MainFragementInteractionListener mListener;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        accidentBtn = (Button) view.findViewById(R.id.accidentBtn);
        geneticBtn = (Button) view.findViewById(R.id.geneticBtn);
        bornBtn = (Button) view.findViewById(R.id.bornBtn);
        chooseBtn = (Button) view.findViewById(R.id.chooseBtn);

        accidentBtn.setOnClickListener(this);
        geneticBtn.setOnClickListener(this);
        bornBtn.setOnClickListener(this);

        chooseBtn.setEnabled(false);
        chooseBtn.getBackground().setAlpha(128);

        drawables1 = accidentBtn.getCompoundDrawables();
        drawables2 = geneticBtn.getCompoundDrawables();
        drawables3 = bornBtn.getCompoundDrawables();

        drawables1[2].setAlpha(0);
        drawables2[2].setAlpha(0);
        drawables3[2].setAlpha(0);

        // Inflate the layout for this fragment
        return view;
    }



    @Override
    public void onClick(View v){

        chooseBtn.setEnabled(true);
        chooseBtn.getBackground().setAlpha(255);

        Button btn = (Button) v;

        Drawable[] btnDrawable = btn.getCompoundDrawables();

        drawables1[2].setAlpha(0);
        drawables2[2].setAlpha(0);
        drawables3[2].setAlpha(0);

        btnDrawable[2].setAlpha(255);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onMainFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainFragementInteractionListener) {
            mListener = (MainFragementInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface MainFragementInteractionListener {
        // TODO: Update argument type and name
        void onMainFragmentInteraction(Uri uri);
    }
}
