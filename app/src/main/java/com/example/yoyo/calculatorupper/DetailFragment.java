package com.example.yoyo.calculatorupper;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "id";
    private static final String ARG_PARAM2 = "param2";
    EditText ed_f, ed_s, ed_t;
    TextView tv_f, tv_s, tv_t;
    Button danwei_calculate, danwei_ce;
    double first, second, third;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public DetailFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        tv_f = (TextView) view.findViewById(R.id.tv_f);
        tv_s = (TextView) view.findViewById(R.id.tv_s);
        tv_t = (TextView) view.findViewById(R.id.tv_t);
        ed_f = (EditText) view.findViewById(R.id.ed_f);
        ed_s = (EditText) view.findViewById(R.id.ed_s);
        ed_t = (EditText) view.findViewById(R.id.ed_t);

        danwei_calculate = (Button) view.findViewById(R.id.danwei_calculate);
        danwei_ce = (Button) view.findViewById(R.id.danwei_ce);
        danwei_ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_f.setText("");
                ed_s.setText("");
                ed_t.setText("");
            }
        });

        switch (mParam1) {
            case "1":
                tv_f.setText("千米");
                tv_s.setText("米");
                tv_t.setText("厘米");
                danwei_calculate.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        String fStr = ed_f.getText().toString();
                        String sStr = ed_s.getText().toString();
                        String tStr = ed_t.getText().toString();
                        if(!fStr.equals("")){
                            first = Double.parseDouble(fStr);
                            ed_s.setText(String.valueOf(first * 1000));
                            ed_t.setText(String.valueOf(first * 100000));
                        }else {
                            if(!sStr.equals("")) {
                                second = Double.parseDouble(sStr);
                                ed_f.setText(String.valueOf(second / 1000));
                                ed_t.setText(String.valueOf(second * 100));
                            }
                            else {
                                if(!tStr.equals("")) {
                                    third = Double.parseDouble(tStr);
                                    ed_f.setText(String.valueOf(third/100000));
                                    ed_s.setText(String.valueOf(third/100));
                                }
                            }
                        }
                    }
                });
                break;
            case "2":
                tv_f.setText("千克");
                tv_s.setText("斤");
                tv_t.setText("克");
                danwei_calculate.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        String fStr = ed_f.getText().toString();
                        String sStr = ed_s.getText().toString();
                        String tStr = ed_t.getText().toString();
                        if(!fStr.equals("")){
                            first = Double.parseDouble(fStr);
                            ed_s.setText(String.valueOf(first * 2));
                            ed_t.setText(String.valueOf(first * 1000));
                        }else {
                            if(!sStr.equals("")) {
                                second = Double.parseDouble(sStr);
                                ed_f.setText(String.valueOf(second / 2));
                                ed_t.setText(String.valueOf(second * 500));
                            }
                            else {
                                if(!tStr.equals("")) {
                                    third = Double.parseDouble(tStr);
                                    ed_f.setText(String.valueOf(third/1000));
                                    ed_s.setText(String.valueOf(third/500));
                                }
                            }
                        }
                    }
                });
                break;
            case "3":
                tv_f.setText("时");
                tv_s.setText("分");
                tv_t.setText("秒");
                danwei_calculate.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        String fStr = ed_f.getText().toString();
                        String sStr = ed_s.getText().toString();
                        String tStr = ed_t.getText().toString();
                        if(!fStr.equals("")){
                            first = Double.parseDouble(fStr);
                            ed_s.setText(String.valueOf(first * 60));
                            ed_t.setText(String.valueOf(first * 3600));
                        }else {
                            if(!sStr.equals("")) {
                                second = Double.parseDouble(sStr);
                                ed_f.setText(String.valueOf(second / 60));
                                ed_t.setText(String.valueOf(second * 60));
                            }
                            else {
                                if(!tStr.equals("")) {
                                    third = Double.parseDouble(tStr);
                                    ed_f.setText(String.valueOf(third/3600));
                                    ed_s.setText(String.valueOf(third/60));
                                }
                            }
                        }
                    }
                });

        }
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
