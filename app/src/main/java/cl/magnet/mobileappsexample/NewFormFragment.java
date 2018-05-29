package cl.magnet.mobileappsexample;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import cl.magnet.mobileappsexample.db.Form;
import cl.magnet.mobileappsexample.db.FormViewModel;



public class NewFormFragment extends Fragment {
    private FormViewModel mFormViewModel;

    public NewFormFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_form, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mFormViewModel = ViewModelProviders.of(this).get(FormViewModel.class);
        Button btn = (Button) getView().findViewById(R.id.btnid);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ((EditText)getView().findViewById(R.id.editText)).getText().toString();
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat mdformat = new SimpleDateFormat("yyyy / MM / dd ");
                String strDate = "" + mdformat.format(calendar.getTime());
                Random rand = new Random();
                int id = rand.nextInt((1000000 - 1) + 1);
                Form f = new Form(id,name,strDate);
                List<Form> fs = new ArrayList<Form>();
                mFormViewModel.insert(fs);
                Toast.makeText(getActivity(), "Formulario creado exitosamente!",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}
