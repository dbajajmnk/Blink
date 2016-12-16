package com.openxoft.blink.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.GsonBuilder;
import com.openxoft.blink.R;
import com.openxoft.blink.activities.ChangePasswordActivity;
import com.openxoft.blink.activities.ProfileActivity;
import com.openxoft.blink.api.ApiParams;
import com.openxoft.blink.listeners.CustomItemClickListener;
import com.openxoft.blink.model.User;
import com.openxoft.blink.util.NetUtil;
import com.openxoft.blink.util.PrefUtil;
import com.openxoft.blink.util.Warning;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this com.openxoft.blink.fragment must implement the
 * {@link ProfileFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this com.openxoft.blink.fragment.
 */
public class ProfileFragment extends Fragment implements View.OnClickListener {

    // the com.openxoft.blink.fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    EditText mFirstName, mEmail, mPhone, mFax, mAddress, mLanguage;

    Button btn_update, btn_changepassword;

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this com.openxoft.blink.fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of com.openxoft.blink.fragment ProfileFragment.
     */

    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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

    private void fillDatainUI(User user) {
        mEmail.setText(user.getULEMAIL());
        mFirstName.setText(user.getULFIRSTNAME());
        mFax.setText(user.getULFAX());
        mLanguage.setText(user.getULPREFERREDLANG());
        mPhone.setText(user.getULMOBILE());
        mAddress.setText(user.getULADDRESS1());
    }

    private void initViews(View view) {
        btn_update = (Button) view.findViewById(R.id.bt_updateprofile);
        btn_changepassword = (Button) view.findViewById(R.id.bt_changepassword);
        mFirstName = (EditText) view.findViewById(R.id.et_name);
        mEmail = (EditText) view.findViewById(R.id.et_email);
        mPhone = (EditText) view.findViewById(R.id.et_phone);
        mFax = (EditText) view.findViewById(R.id.et_fax);
        mLanguage = (EditText) view.findViewById(R.id.et_language);
        mAddress = (EditText) view.findViewById(R.id.et_address);
        String currentuser = PrefUtil.getString(getActivity(), ApiParams.KEY_USEROBJECT, ApiParams.KEY_USEROBJECT);
        if (currentuser != null) {
            User user = new GsonBuilder().create().fromJson(currentuser, User.class);
            fillDatainUI(user);
        }

        enableDisableFields(false);
        btn_changepassword.setOnClickListener(this);
        btn_update.setOnClickListener(this);

    }

    private void enableDisableFields(boolean value) {
        mEmail.setEnabled(value);
        mFirstName.setEnabled(value);
        mFax.setEnabled(value);
        mPhone.setEnabled(value);
        mLanguage.setEnabled(value);
        mAddress.setEnabled(value);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this com.openxoft.blink.fragment
        View view = inflater.inflate(R.layout.activity_profile, container, false);
        initViews(view);
        return view;
    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public void callChangePassword() {
        startActivity(new Intent(getActivity(), ChangePasswordActivity.class));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.bt_updateprofile:

                btn_update.setText("Save");
                if (mFirstName.isEnabled()) {
                    if (validateInput()) {
                        if (NetUtil.isNetworkConnected(getActivity())) {
                            updateProfile();
                        } else {
                            Snackbar.make(view, Warning.NETWORK_PROBLEM, Snackbar.LENGTH_SHORT).show();
                        }
                    }

                }
                enableDisableFields(true);

                break;
            case R.id.bt_changepassword:
                callChangePassword();
                break;
        }
    }

    private void updateProfile() {


    }

    private boolean validateInput() {
        if (mFirstName.getText().toString().isEmpty()) {
            mFirstName.requestFocus();
            mFirstName.setError(Warning.BLANK_FIELD);
        } else if (!Patterns.EMAIL_ADDRESS.matcher(mEmail.getText().toString()).matches()) {
            mEmail.requestFocus();
            mEmail.setError(Warning.INVALID_EMAIL_ADDRESS);
        } else if (mPhone.getText().toString().isEmpty()) {
            mPhone.requestFocus();
            mPhone.setError(Warning.BLANK_FIELD);
        } else if (mAddress.getText().toString().isEmpty()) {
            mAddress.requestFocus();
            mAddress.setError(Warning.BLANK_FIELD);
        } else if (mLanguage.getText().toString().isEmpty()) {
            mLanguage.requestFocus();
            mLanguage.setError(Warning.BLANK_FIELD);
        } else {
            return true;
        }
        return false;


    }

    /**
     * This interface must be implemented by activities that contain this
     * com.openxoft.blink.fragment to allow an interaction in this com.openxoft.blink.fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }
}
