package Model;

import java.util.ArrayList;

public class Data {
//"id": 6892542,
//        "name": "Budhil Chaturvedi III",
//        "email": "iii_budhil_chaturvedi@roob.example",
//        "gender": "male",
//        "status": "active"

    private int id;
    private String name;
    private  String email;
    private String gencer;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGencer() {
        return gencer;
    }

    public void setGencer(String gencer) {
        this.gencer = gencer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gencer='" + gencer + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
