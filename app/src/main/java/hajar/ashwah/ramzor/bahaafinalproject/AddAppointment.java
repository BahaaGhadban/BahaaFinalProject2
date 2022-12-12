package hajar.ashwah.ramzor.bahaafinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

import hajar.ashwah.ramzor.bahaafinalproject.data.Appointment;

public class AddAppointment extends AppCompatActivity

{
    private EditText etTime2;
    private EditText etDate;
    private TextInputEditText etFullName;
    private TextInputEditText etPhone;
    private TextInputEditText etCondition;
    private SeekBar seekBar;
    private Button btnCancel;
    private Button btnSave;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appointment);
        etTime2 = findViewById(R.id.etTime2);
        etDate = findViewById(R.id.etDate);
        etFullName = findViewById(R.id.etFullName);
        etPhone = findViewById(R.id.etPhone);
        etCondition = findViewById(R.id.etCondition);
        btnCancel = findViewById(R.id.btnCancel);
        btnSave = findViewById(R.id.btnSave);
        seekBar = findViewById(R.id.seekBar);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkandsave();

            }
        });
        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });
    }

    private void showDateDialog() {
        DatePickerDialog dp = new DatePickerDialog(this);
        dp.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                etDate.setText(i + "/" + i1 + "/" + i2);
            }
        });
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        int i = c.get(Calendar.YEAR);
        int i1 = c.get(Calendar.DAY_OF_MONTH);
        int i2 = c.get(Calendar.MONTH);
        dp.updateDate(i, i1, i2);
        dp.show();
    }


    private void checkandsave(){
        //استخراج القيم من صفحة الاضافة

        String Time= etTime2.getText().toString();
        String Date= etDate.getText().toString();
        String FullName= etFullName.getText().toString();
        String Phone= etPhone.getText().toString();
        String Condition= etCondition.getText().toString();
        int Importance=seekBar.getProgress();

        //بناء الكائن واعطائه قيم الصفات

        Appointment m=new Appointment();
        m.setClientName(FullName);
        m.setTime(Time);
        m.setDate(Date);
        m.setPhone(Phone);
        m.setCnodition(Condition);




        String Owner= FirebaseAuth.getInstance().getCurrentUser().getUid();
        m.setOwner(Owner);

        String Key= FirebaseDatabase.getInstance().getReference().child("Appointment").child(Owner).push().getKey();

        m.setKey(Key);

        FirebaseDatabase.getInstance().getReference().child("Appointment").child(Owner).child(Key).setValue(m).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> appointment) {
                if (appointment.isSuccessful()) {
                    finish();
                    Toast.makeText(AddAppointment.this, "added succesfully", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(AddAppointment.this, "added not succesfully", Toast.LENGTH_SHORT).show();
                }
            }

        }

        );}













    }
