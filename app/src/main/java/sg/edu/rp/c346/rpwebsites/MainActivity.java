package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spnCat;
    Spinner spnSub;
    Button btnGo;
    TextView testing;
    ArrayList<String> alSub;
    ArrayAdapter<String> aaSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testing = findViewById(R.id.testing);
        spnCat = findViewById(R.id.spinnerCat);
        spnSub = findViewById(R.id.spinnerSub);
        btnGo = findViewById(R.id.buttonGo);

        alSub = new ArrayList<>();
        aaSub = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,alSub);

        spnSub.setAdapter(aaSub);

        spnCat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        alSub.clear(); // clear the array
                        String[] strArray0 = getResources().getStringArray(R.array.subcategory);
                        alSub.addAll(Arrays.asList(strArray0));
                        aaSub.notifyDataSetChanged(); // to notify the change
                        break;

                    case 1:
                        alSub.clear();
                        String[] strArray1 = getResources().getStringArray(R.array.subcategorySOI);
                        alSub.addAll(Arrays.asList(strArray1));
                        aaSub.notifyDataSetChanged();
                        break;
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String [][] sites={
                        {
                            "http://www.rp.edu.sg",
                                "https://www.rp.edu.sg/student-life"
                        },
                        {
                                "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47",
                                "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12"
                        }
                };

                String url = sites[spnCat.getSelectedItemPosition()][spnSub.getSelectedItemPosition()];

                Intent intent = new Intent(getBaseContext(), webActivity.class);
                intent.putExtra("url",url);
                startActivity(intent);

            }
        });
/*
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos1 = spnCat.getSelectedItemPosition();
                int pos2 = spnSub.getSelectedItemPosition();

                if (pos1 == 0){
                    if(pos2 == 0){

                        Intent intent = new Intent(getBaseContext(), webActivity.class);
                        intent.putExtra("url","https://www.rp.edu.sg/");
                        startActivity(intent);

                    }
                    else{
                        Intent intent = new Intent(getBaseContext(), webActivity.class);
                        intent.putExtra("url","https://www.rp.edu.sg/student-life");
                        startActivity(intent);

                    }
                }

                else{
                    if(pos2 == 0){
                        Intent intent = new Intent(getBaseContext(), webActivity.class);
                        intent.putExtra("url","https://www.rp.edu.sg/soi/full-time-diplomas/details/r47");
                        startActivity(intent);
                    }
                    else{
                        Intent intent = new Intent(getBaseContext(), webActivity.class);
                        intent.putExtra("url","https://www.rp.edu.sg/soi/full-time-diplomas/details/r12");
                        startActivity(intent);

                    }
                }

            }
        });
        */


    }
}
