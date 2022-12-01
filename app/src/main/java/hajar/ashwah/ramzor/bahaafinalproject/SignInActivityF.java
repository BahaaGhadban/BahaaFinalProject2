package hajar.ashwah.ramzor.bahaafinalproject;

import android.content.Intent;
import com.google.android.material.textfield.TextInputEditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivityF extends AppCompatActivity {
    private TextInputEditText etEmail;
    private TextInputEditText etPassword;
    private Button btnsignin;
    private Button btnsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//يبني واجهة للمستعمل بحيث تبني كل الكائنات الموجودة في ملف التنسيق xml
        setContentView(R.layout.activity_sign_in);
        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        btnsignin=findViewById(R.id.btnsignin);
        btnsignup=findViewById(R.id.btnsignup);

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignInActivityF.this, SignUpActivityF.class);
                startActivity(i);
            }
        });
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkandsave();
            }
        });

    }

    private void checkandsave() {
        String email=etEmail.getText().toString();
        String password=etPassword.getText().toString();
        boolean isok=true;
        if(email.length()==0){
            etEmail.setError("enter your email ");
            isok=false;
        }
        if(password.length()==0){
            etPassword.setError("enter your password ");
            isok=false;
        }
        if(email.indexOf("@")<=0){
            etEmail.setError("wrong email");
            isok=false;
        }
        if(password.length()<=7) {
            etPassword.setError("password at least 7 char");
            isok = false;
        }
        //if all the conditions are true then the inputs will be sent to the firrebase
        if(isok){
            FirebaseAuth auth = FirebaseAuth.getInstance();
            auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(SignInActivityF.this, "Successful", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(SignInActivityF.this,MainActivityF.class);
                        startActivity(i);
                        finish();

                    }
                    else {
                        Toast.makeText(SignInActivityF.this, "Not Successful"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }



            });
        }
    }
}