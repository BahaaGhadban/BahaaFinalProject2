package hajar.ashwah.ramzor.bahaafinalproject.data;

import java.sql.Time;
import java.util.Date;

public class Appointment {
    private String Key;
    private String Owner;
    private String ClientName;
    private String Target;
    private Date date;
    private String Phone;
    private Time time;
    private String Cnodition;

    public String getCnodition() {
        return Cnodition;
    }

    public void setCnodition(String cnodition) {
        Cnodition = cnodition;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(String time) {
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public String getTarget() {
        return Target;
    }

    public void setTarget(String target) {
        Target = target;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String date) {
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "Key='" + Key + '\'' +
                ", Owner='" + Owner + '\'' +
                ", ClientName='" + ClientName + '\'' +
                ", Target='" + Target + '\'' +
                ", date=" + date +
                ", Phone='" + Phone + '\'' +
                ", time=" + time +
                ", Cnodition='" + Cnodition + '\'' +
                '}';
    }

}

