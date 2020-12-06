package id.ac.itn.sqlite_perpustakaan;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Perpustakaan> ListToko = new ArrayList<Perpustakaan>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListToko );
        mListView = (ListView) findViewById(R.id.list_perpustakaan);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListToko.clear();
        List<Perpustakaan> contacts = db.ReadToko();
        for (Perpustakaan cn : contacts) {
            Perpustakaan judulModel = new Perpustakaan();
            judulModel.set_id(cn.get_id());
            judulModel.set_judul(cn.get_judul());
            judulModel.set_penulis(cn.get_penulis());
            judulModel.set_penerbit(cn.get_penerbit());
            judulModel.set_tahun(cn.get_tahun());
            judulModel.set_jumlah(cn.get_jumlah());

            ListToko.add(judulModel);
            if ((ListToko.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Perpustakaan obj_itemDetails = (Perpustakaan) o;
        String Sid = obj_itemDetails.get_id();
        String Sjudul = obj_itemDetails.get_judul();
        String Spenulis = obj_itemDetails.get_penulis();
        String Spenerbit = obj_itemDetails.get_penerbit();
        String Stahun = obj_itemDetails.get_tahun();
        String Sjumlah = obj_itemDetails.get_jumlah();

        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Ijudul", Sjudul);
        goUpdel.putExtra("Ipenulis", Spenulis);
        goUpdel.putExtra("Ipenerbit", Spenerbit);
        goUpdel.putExtra("Itahun", Stahun);
        goUpdel.putExtra("Ijumlah", Sjumlah);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListToko.clear();
        mListView.setAdapter(adapter_off);
        List<Perpustakaan> contacts = db.ReadToko();
        for (Perpustakaan cn : contacts) {
            Perpustakaan judulModel = new Perpustakaan();
            judulModel.set_id(cn.get_id());
            judulModel.set_judul(cn.get_judul());
            judulModel.set_penulis(cn.get_penulis());
            judulModel.set_penerbit(cn.get_penerbit());
            judulModel.set_tahun(cn.get_tahun());
            judulModel.set_jumlah(cn.get_jumlah());
            ListToko.add(judulModel);
            if ((ListToko.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
