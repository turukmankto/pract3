package com.example.pract3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final String TAG = "MainFragment";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

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
        Toast.makeText(getActivity(), "starting onCreate in MainFragment", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "starting onCreate in MainFragment");
        getParentFragmentManager().setFragmentResultListener("SecondKey",
                this, new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                        String result = bundle.getString("mainResultKey");
                        Toast.makeText(getActivity(), result, Toast.LENGTH_SHORT).show();
                    }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        MainActivity mainActivity = (MainActivity) getActivity();
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_placeholder, SecondFragment.class, null)
                        .commit();
                Bundle result = new Bundle();
                result.putString("secondResultKey", "This string sends from MainFragment");
                getParentFragmentManager().setFragmentResult("MainKey", result);
            }
        };
        view.findViewById(R.id.buttonMain).setOnClickListener(listener);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getActivity(), "starting onStart in MainFragment", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "starting onStart in MainFragment");
    }
    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getActivity(), "starting onResume in MainFragment", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "starting onResume in MainFragment");
    }
    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getActivity(), "starting onPause in MainFragment", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "starting onPause in MainFragment");
    }
    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(getActivity(), "starting onStop in MainFragment", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "starting onStop in MainFragment");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getActivity(), "starting onDestroy in MainFragment", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "starting onDestroy in MainFragment");
    }
}