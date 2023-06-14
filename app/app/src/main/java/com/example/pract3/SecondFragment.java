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
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public static final String TAG = "SecondFragment";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SecondFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
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
        Toast.makeText(getActivity(), "starting onCreate in SecondFragment", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "starting onCreate in SecondFragment");
        getParentFragmentManager().setFragmentResultListener("MainKey",
                this, new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                        String result = bundle.getString("secondResultKey");
                        Toast.makeText(getActivity(), result, Toast.LENGTH_SHORT).show();
                    }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        MainActivity mainActivity = (MainActivity) getActivity();
        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mainActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_placeholder, MainFragment.class, null)
                        .commit();
                Bundle result = new Bundle();
                result.putString("mainResultKey", "This string return from SecondFragment");
                getParentFragmentManager().setFragmentResult("SecondKey", result);

            }
        };
        view.findViewById(R.id.button_second).setOnClickListener(listener);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getActivity(), "starting onStart in SecondFragment", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "starting onStart in SecondFragment");
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getActivity(), "starting onResume in SecondFragment", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "starting onResume in SecondFragment");
    }

    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getActivity(), "starting onPause in SecondFragment", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "starting onPause in SecondFragment");
    }

    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(getActivity(), "starting onStop in SecondFragment", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "starting onStop in SecondFragment");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getActivity(), "starting onDestroy in SecondFragment", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "starting onDestroy in SecondFragment");
    }
}