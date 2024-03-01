package com.example.healthcare;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailActivity extends AppCompatActivity {
    private final String[][] doctor_details1=
            {
                    {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri","Exp: 5yrs","Mobile No:8976895678","600"},
                    {"Doctor Name : Prasad Pawar", "Hospital Address : Nigdi","Exp: 15yrs","Mobile No:89768995678","900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Pune","Exp: 8yrs","Mobile No:7856432878","700"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chinchwad","Exp: 6yrs","Mobile No:8976870678","500"},
                    {"Doctor Name : Ashok Panda", "Hospital Address : Katraj","Exp: 7yrs","Mobile No:8976095678","800"}
            };
    private final String[][] doctor_details2=
            {
                    {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri","Exp: 5yrs","Mobile No:8976895678","600"},
                    {"Doctor Name : Prasad Pawar", "Hospital Address : Nigdi","Exp: 15yrs","Mobile No:89768995678","900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Pune","Exp: 8yrs","Mobile No:7856432878","700"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chinchwad","Exp: 6yrs","Mobile No:8976870678","500"},
                    {"Doctor Name : Ashok Panda", "Hospital Address : Katraj","Exp: 7yrs","Mobile No:8976095678","800"}
            };
    private final String[][] doctor_details3=
            {
                    {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri","Exp: 5yrs","Mobile No:8976895678","600"},
                    {"Doctor Name : Prasad Pawar", "Hospital Address : Nigdi","Exp: 15yrs","Mobile No:89768995678","900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Pune","Exp: 8yrs","Mobile No:7856432878","700"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chinchwad","Exp: 6yrs","Mobile No:8976870678","500"},
                    {"Doctor Name : Ashok Panda", "Hospital Address : Katraj","Exp: 7yrs","Mobile No:8976095678","800"}
            };
    private final String[][] doctor_details4=
            {
                    {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri","Exp: 5yrs","Mobile No:8976895678","600"},
                    {"Doctor Name : Prasad Pawar", "Hospital Address : Nigdi","Exp: 15yrs","Mobile No:89768995678","900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Pune","Exp: 8yrs","Mobile No:7856432878","700"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chinchwad","Exp: 6yrs","Mobile No:8976870678","500"},
                    {"Doctor Name : Ashok Panda", "Hospital Address : Katraj","Exp: 7yrs","Mobile No:8976095678","800"}
            };
    private final String[][] doctor_details5=
            {
                    {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri","Exp: 5yrs","Mobile No:8976895678","600"},
                    {"Doctor Name : Prasad Pawar", "Hospital Address : Nigdi","Exp: 15yrs","Mobile No:89768995678","900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Pune","Exp: 8yrs","Mobile No:7856432878","700"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chinchwad","Exp: 6yrs","Mobile No:8976870678","500"},
                    {"Doctor Name : Ashok Panda", "Hospital Address : Katraj","Exp: 7yrs","Mobile No:8976095678","800"}
            };

    TextView tv;
    Button btn;
    String[][] doctor_details={};
    ArrayList list;
    HashMap<String,String>item;
    SimpleAdapter sa;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);

        tv=findViewById(R.id.textViewLTTitle);
        btn=findViewById(R.id.buttonDDBack);

        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details=doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details=doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details=doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details=doctor_details4;
        else
            doctor_details=doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailActivity.this,FindDoctorActivity.class));
            }
        });

        list=new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item=new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons Fees : "+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );

        ListView lst=findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}