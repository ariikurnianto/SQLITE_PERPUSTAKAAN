package id.ac.itn.sqlite_perpustakaan;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Perpustakaan> movieItems;

    public CustomListAdapter(Activity activity, List<Perpustakaan> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }
    @Override
    public int getCount() {
        return movieItems.size();
    }

    @Override
    public Object getItem(int location) {
        return  movieItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);

        TextView judul = (TextView) convertView.findViewById(R.id.text_judul);
        TextView penulis = (TextView) convertView.findViewById(R.id.text_penulis);
        TextView penerbit = (TextView) convertView.findViewById(R.id.text_penerbit);
        TextView tahun = (TextView) convertView.findViewById(R.id.text_tahun);
        TextView jumlah = (TextView) convertView.findViewById(R.id.text_jumlah);

        Perpustakaan t = movieItems.get(position);
        judul.setText("Judul Buku   : "+ t.get_judul());
        penulis.setText("Penulis    : "+ t.get_penulis());
        penerbit.setText("Penerbit  : "+ t.get_penerbit());
        tahun.setText("Tahun Terbit : "+ t.get_tahun());
        jumlah.setText("Jumlah Halaman  : "+ t.get_jumlah());
        return convertView;
    }
}
