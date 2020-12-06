package id.ac.itn.sqlite_perpustakaan;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Sjudul, Spenulis, Spenerbit, Stahun, Sjumlah ;
    private EditText Eid, Ejudul, Epenulis, Epenerbit, Etahun, Ejumlah ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();

        Sid = i.getStringExtra("Iid");
        Sjudul = i.getStringExtra("Ijudul");
        Spenulis = i.getStringExtra("Ipenulis");
        Spenerbit = i.getStringExtra("Ipenerbit");
        Stahun = i.getStringExtra("Itahun");
        Sjumlah = i.getStringExtra("Ijumlah");

        Ejudul = (EditText) findViewById(R.id.updel_judul);
        Epenulis = (EditText) findViewById(R.id.updel_penulis);
        Epenerbit = (EditText) findViewById(R.id.updel_penerbit);
        Etahun = (EditText) findViewById(R.id.updel_tahun);
        Ejumlah = (EditText) findViewById(R.id.updel_jumlah);

        Ejudul.setText(Sjudul);
        Epenulis.setText(Spenulis);
        Epenerbit.setText(Spenerbit);
        Etahun.setText(Stahun);
        Ejumlah.setText(Sjumlah);

        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sjudul = String.valueOf(Ejudul.getText());
                Spenulis = String.valueOf(Epenulis.getText());
                Spenerbit = String.valueOf(Epenerbit.getText());
                Stahun = String.valueOf(Etahun.getText());
                Sjumlah = String.valueOf(Ejumlah.getText());

                if (Sjudul.equals("")){
                    Ejudul.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi judul buku",
                            Toast.LENGTH_SHORT).show();
                } else if (Spenulis.equals("")){
                    Epenulis.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama penulis",
                            Toast.LENGTH_SHORT).show();
                } else if (Spenerbit.equals("")){
                    Epenerbit.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama penerbit buku",
                            Toast.LENGTH_SHORT).show();
                } else if (Stahun.equals("")){
                    Etahun.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi tahun penerbit",
                            Toast.LENGTH_SHORT).show();
                } else if (Sjumlah.equals("")){
                    Ejumlah.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi jumlah halaman dari buku",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateToko(new Perpustakaan(Sid, Sjudul, Spenulis, Spenerbit, Stahun, Sjumlah));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteToko(new Perpustakaan(Sid, Sjudul, Spenulis, Spenerbit, Stahun, Sjumlah));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
