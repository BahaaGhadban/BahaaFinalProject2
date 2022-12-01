package hajar.ashwah.ramzor.bahaafinalproject;

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

public class SignUpActivityF extends AppCompatActivity {
    private TextInputEditText etEmail2;
    private TextInputEditText etPassword2;
    private TextInputEditText etrepassword2;
    private Button btnsave2;
    private Button btncancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etEmail2=findViewById(R.id.etEmail2);
        etPassword2=findViewById(R.id.etPassword2);
        etrepassword2=findViewById(R.id.etrepassword2);
        btnsave2=findViewById(R.id.btnsave2);
        btncancel=findViewById(R.id.btncancel);
        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnsave2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkandsave();
            }
        });




    }
    private void checkandsave(){//put the email and the password in motgerat and check if suitable and words matching
        String email=etEmail2.getText().toString();
        String password=etPassword2.getText().toString();
        String repassword=etrepassword2.getText().toString();
        boolean isok=true;//we added this parameter if all condtions (email/password) are ok it will remain true to chanmge activity
        if(email.length()*password.length()*repassword.length()==0){
            etEmail2.setError(("One of the files are is empty"));
            isok=false;
        }
        if(isok){// if (isok)== true that mean all condtions are ok so the code will send to firebase the email and pass and authenction it.
            FirebaseAuth auth= FirebaseAuth.getInstance();
            auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                                                                          @Override
                                                                                          public void onComplete(@NonNull Task<AuthResult> task) {
                                                                                              if(task.isSuccessful()){//check if the mission (built account) is successful

                                                                                                  Toast.makeText(SignUpActivityF.this, "Creation is successful", Toast.LENGTH_SHORT).show();
                                                                                                  finish();
                                                                                              }
                                                                                              else
                                                                                                  Toast.makeText(SignUpActivityF.this, "Creation Faild"+task.getException(), Toast.LENGTH_SHORT).show();
                                                                                          }
                                                                                      });
            ;
        }
    }
}



