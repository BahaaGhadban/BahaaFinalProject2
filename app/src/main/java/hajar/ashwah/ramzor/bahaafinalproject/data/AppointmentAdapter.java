package hajar.ashwah.ramzor.bahaafinalproject.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import hajar.ashwah.ramzor.bahaafinalproject.R;

public class AppointmentAdapter extends ArrayAdapter<Appointment> {
    public AppointmentAdapter(@NonNull Context context, int resource) {
        super(context, R.layout.appointment_item);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //building item view
        View vitem= LayoutInflater.from(getContext()).inflate(R.layout.appointment_item,parent,false);
        TextView tvTime=vitem.findViewById(R.id.tvTime);
        TextView tvDate=vitem.findViewById(R.id.tvDate);
        TextView tvFullName=vitem.findViewById(R.id.tvFullName);
        TextView tvPhone=vitem.findViewById(R.id.tvPhone);
        TextView tvCondition=vitem.findViewById(R.id.tvCondition);
        RatingBar ratingBar=vitem.findViewById(R.id.ratingBar);
        //getting data source
        final Appointment appointment=getItem(position);
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(appointment.getDate());


        tvTime.setText(date);
        DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT);
        String time = dateFormat.format(appointment.getTime());

        tvDate.setText(time);
        tvFullName.setText(appointment.getClientName());
        tvPhone.setText(appointment.getPhone());
        tvCondition.setText(appointment.getCnodition());




        return vitem;
    }
}

