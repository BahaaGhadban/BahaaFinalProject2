package hajar.ashwah.ramzor.bahaafinalproject;

import android.content.DialogInterface;
import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivityF extends AppCompatActivity {
    private ListView List;
    private ImageView btnadd;
    private android.widget.SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //يبني واجهة للمستعمل بحيث تبني كل الكائنات الموجودة في ملف التنسيق xml
        setContentView(R.layout.activity_main);
        searchView=findViewById(R.id.searchview);
        List=findViewById(R.id.List);
        btnadd=findViewById(R.id.btnadd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivityF.this, AddAppointment.class);
                startActivity(i);
            }
        });


















    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.itmsittings) {
            Intent i = new Intent(MainActivityF.this, Sittings.class);
            startActivity(i);
        }
        if (item.getItemId() == R.id.itmsignout) {
            // FirebaseAuth.getInstance().signOut();
            // finish();
            //تجهيز االبناء للديالوج
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle("confirm Signout");
            builder.setMessage("are you sure");
            builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //اخفاء الديالوج
                    dialogInterface.dismiss();
                    //تسجيل خروج من الحساب
                    FirebaseAuth.getInstance().signOut();
                    //الخروج من الشاشة
                    finish();
                }
            });
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            //بناء الديالوج
            AlertDialog dialog=builder.create();
            dialog.show();

        }

        if (item.getItemId() == R.id.itmsittings) {
            return true;
        }
        return false;




    }
    private void readMahamaFromFireBase()
    {
        //مؤشر لجذر قاعدة البيانات التابعة للمشروع
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        //listener لمراقبة اي تغيير يحدث تحت الجذر المحدد
        //اي تغيير بقيمة صفة او حذف او اضافة كائن يتم الاعلام ال listener
        //عندها يتم تنزيل كل المعطيات تحت الجذر
        reference.child("Mahama").addValueEventListener(new ValueEventListener() {
            //دالة معالجة حدث عند تغيير اي قيمة

            /**
             * دالة معالجة حدث عند تغيير اي قيمة
             * @param snapshot يحوي نسخة عن كل المعطيات تحت العنوان المراقب
             */
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}









