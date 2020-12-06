package id.ac.itn.sqlite_perpustakaan;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Sjudul, Spenulis, Spenerbit, Stahun, Sjumlah ;
    private EditText Eid, Ejudul, Epenulis, Epenerbit, Etahun, Ejumlah ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Ejudul = (EditText) findViewById(R.id.create_judul);
        Epenulis = (EditText) findViewById(R.id.create_penulis);
        Epenerbit = (EditText) findViewById(R.id.create_Penerbit);
        Etahun = (EditText) findViewById(R.id.create_tahun);
        Ejumlah = (EditText) findViewById(R.id.create_jumlah);

        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sjudul = String.valueOf(Ejudul.getText());
                Spenulis = String.valueOf(Epenulis.getText());
                Spenerbit = String.valueOf(Epenerbit.getText());
                Stahun = String.valueOf(Etahun.getText());
                Sjumlah = String.valueOf(Ejumlah.getText());

                if (Sjudul.equals("")){
                    Ejudul.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi judul buku",
                            Toast.LENGTH_SHORT).show();
                } else if (Spenulis.equals("")){
                    Epenulis.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama penulis",
                            Toast.LENGTH_SHORT).show();
                } else if (Spenerbit.equals("")){
                    Epenerbit.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama penerbit ",
                            Toast.LENGTH_SHORT).show();
                } else if (Stahun.equals("")){
                    Etahun.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi tahun penerbit",
                            Toast.LENGTH_SHORT).show();                }
                else if (Sjumlah.equals("")){
                    Ejumlah.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi jumlah halaman",
                            Toast.LENGTH_SHORT).show();


                } else {
                    Ejudul.setText("");
                    Epenulis.setText("");
                    Epenerbit.setText("");
                    Etahun.setText("");
                    Ejumlah.setText("");

                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateToko(new Perpustakaan(null, Sjudul, Spenulis, Spenerbit, Stahun, Sjumlah));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}

