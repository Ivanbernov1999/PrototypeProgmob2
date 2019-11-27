package prototypeprogmob.com;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import prototypeprogmob.com.Adapter.KRSAdapter;
import prototypeprogmob.com.Adapter.KRSAdapter;
import prototypeprogmob.com.Model.KRSSI;
import prototypeprogmob.com.Model.KRSSI;

public class RecyclerKrsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private KRSAdapter krsAdapter;
    private ArrayList<KRSSI> KRSSIArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_krs);

        addData();

        recyclerView = findViewById(R.id.rvKrs);
        krsAdapter = new KRSAdapter(KRSSIArrayList);

        RecyclerView.LayoutManager layoutManager = new
                LinearLayoutManager(RecyclerKrsActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(krsAdapter);
    }
    private void addData(){
        KRSSIArrayList = new ArrayList<>();
        KRSSIArrayList.add(new KRSSI("SI001",
                "KTI", "Senin", "2","3","Willy SR","30"));
        KRSSIArrayList.add(new KRSSI("SI002",
                "MRTI","Selasa","4","3","Andhika","32"));
        KRSSIArrayList.add(new KRSSI("SI003",
                "Manajemen Proyek", "Rabu","3","3","Yetli Oslan","54"));
        KRSSIArrayList.add(new KRSSI("SI005",
                "E-Commerce", "Kamis", "4", "3", "Budi Sutedjo", "60"));
        KRSSIArrayList.add(new KRSSI("SI006",
                "ABD", "Jumat", "1", "3", "Katon Wijana", "34"));
    }


}
