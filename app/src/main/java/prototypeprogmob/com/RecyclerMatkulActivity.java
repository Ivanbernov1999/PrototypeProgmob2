package prototypeprogmob.com;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import prototypeprogmob.com.Adapter.MatkulAdapter;
import prototypeprogmob.com.Model.Matkul;

public class RecyclerMatkulActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MatkulAdapter matkulAdapter;
    private ArrayList<Matkul> MatkulArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_matkul);

        addData();

        recyclerView = findViewById(R.id.rvMatkul);
        matkulAdapter = new MatkulAdapter(MatkulArrayList);

        RecyclerView.LayoutManager layoutManager = new
                LinearLayoutManager(RecyclerMatkulActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(matkulAdapter);
    }
    private void addData(){
        MatkulArrayList = new ArrayList<>();
        MatkulArrayList.add(new Matkul("SI001",
                "KTI", "Senin", "3","3"));
        MatkulArrayList.add(new Matkul("SI002",
                "MRTI","Selasa","4","3"));
        MatkulArrayList.add(new Matkul("SI003",
                "Manajemen Proyek", "Rabu","3","3"));
        MatkulArrayList.add(new Matkul("SI004",
                "Progmob", "Rabu","4","3"));
        MatkulArrayList.add(new Matkul("SI005",
                "E-Commerce", "Kamis","4","3"));
        MatkulArrayList.add(new Matkul("SI006",
                "ABD", "Jumat","1","3"));

    }

}
