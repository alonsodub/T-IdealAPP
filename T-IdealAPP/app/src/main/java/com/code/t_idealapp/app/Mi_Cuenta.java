package com.code.t_idealapp.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Mi_Cuenta extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup
                             container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_one, container,false);
    }

}