package prototypeprogmob.com;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import prototypeprogmob.com.Adapter.DosenAdapter;
import prototypeprogmob.com.Model.DSN;
import prototypeprogmob.com.Network.GetDataService;
import prototypeprogmob.com.Network.RetrofitClientInstance;
import prototypeprogmob.com.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RecyclerDsnActivity extends AppCompatActivity {
    RecyclerView rvDsn;
    private RecyclerView recyclerView;
    private DosenAdapter dsnAdapter;
    private ArrayList<DSN> dsnArrayList;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_dsn);
        recyclerView = findViewById(R.id.rvDsn);
        ImageButton ImgDsn = (ImageButton) findViewById(R.id.ImgDsn);
        ImgDsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RecyclerDsnActivity.this, CRUDDosen.class);
                startActivity(i);
            }
        });

        registerForContextMenu(recyclerView);


        //addData();
        progressDialog = new

                ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<DSN>> call = service.getDosenAll("72170001");
        call.enqueue(new Callback<DefaultResult>() {
            @Override
            public void onResponse(Callback<List<DSN>> call, Response<List<DSN>> response) {

                progressDialog.dismiss();
                List<DSN> dsnList = response.body();
                dsnAdapter = new DosenAdapter(dsnArrayList);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecyclerDsnActivity.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(dsnAdapter);
            }

            @Override
            public void onFailure(Call<List<DSN>> call, Throwable t) {

            }
        });


    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        DSN dosen = dsnArrayList.get(item.getGroupId());
        if (item.getTitle() == "Ubah Data Dosen") {
            Intent intent = new Intent(RecyclerDsnActivity.this, CRUDDosen.class);
            intent.putExtra("id_Dosen", dosen.getId());
            intent.putExtra("nama_dosen", dosen.getNama());
            intent.putExtra("nidn", dosen.getNidn());
            intent.putExtra("alamat", dosen.getAlamat());
            intent.putExtra("email", dosen.getEmail());
            intent.putExtra("gelar", dosen.getGelar());
            intent.putExtra("foto", dosen.getFoto());
            intent.putExtra("is_update", true);
            startActivity(intent);
        } else if (item.getTitle() == "Hapus Data Dosen") {
            progressDialog = new ProgressDialog(RecyclerDsnActivity.this);
            progressDialog.show();

            GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
            Call<DefaultResult> call = service.delete_dosen(dosen.getId(),
                    "72160000"
            );
            call.enqueue(new Callback<DefaultResult>() {
                @Override
                public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                    progressDialog.dismiss();

                    Toast.makeText(RecyclerDsnActivity.this, "berhasil hapus dosen", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<DefaultResult> call, Throwable t) {

                }
            });

        }


    /*private void addData(){
        dsnArrayList = new ArrayList<>();
        dsnArrayList.add(new DSN("",
                "893456789","willy SR", "WillySr@gmail.com", "jl.Kaliurang Yogyakarta","S.Kom", R.drawable.Willy));
        dsnArrayList.add(new DSN("",
                "234597890","Argo Wibowo","Argo.Wibowo@gmail.com", "JL.pugeran  Yogyakarta", "S.Kom",R.drawable.Argo));
//        R.drawable.yetli
        dsnArrayList.add(new DSN("",
                "345478901"," Andhika", "Andhika12@gmail.com", "jl.Godean Yogyakarta","S.Kom", R.drawable.Andhika));

    }*/


    }

