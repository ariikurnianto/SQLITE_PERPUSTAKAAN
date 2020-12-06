package id.ac.itn.sqlite_perpustakaan;

import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_perpustakaan";
    private static final String tb_perpustakaan = "tb_perpustakaan";
    private static final String tb_id = "id";
    private static final String tb_judul = "judul";
    private static final String tb_penulis = "penulis";
    private static final String tb_penerbit = "penerbit";
    private static final String tb_tahun = "tahun";
    private static final String tb_jumlah = "jumlah";
    private static final String CREATE_TABLE_TOKO = "CREATE TABLE " +
            tb_perpustakaan + "("
            + tb_id + " INTEGER PRIMARY KEY ,"
            + tb_judul + " TEXT,"
            + tb_penulis + " TEXT,"
            + tb_penerbit + " TEXT,"
            + tb_tahun + " TEXT,"
            + tb_jumlah + " TEXT " + ")";

    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TOKO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreateToko (Perpustakaan mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_id, mdNotif.get_id());
        values.put(tb_judul, mdNotif.get_judul());
        values.put(tb_penulis, mdNotif.get_penulis());
        values.put(tb_penerbit, mdNotif.get_penerbit());
        values.put(tb_tahun, mdNotif.get_tahun());
        values.put(tb_jumlah, mdNotif.get_jumlah());
        db.insert(tb_perpustakaan, null, values);
        db.close();
    }

    public List<Perpustakaan> ReadToko() {
        List<Perpustakaan> judulModelList = new ArrayList<Perpustakaan>();
        String selectQuery = "SELECT * FROM " + tb_perpustakaan;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Perpustakaan mdKontak = new Perpustakaan();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_judul(cursor.getString(1));
                mdKontak.set_penulis(cursor.getString(2));
                mdKontak.set_penerbit(cursor.getString(3));
                mdKontak.set_tahun(cursor.getString(4));
                mdKontak.set_jumlah(cursor.getString(5));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdateToko (Perpustakaan mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_judul, mdNotif.get_judul());
        values.put(tb_penulis, mdNotif.get_penulis());
        values.put(tb_penerbit, mdNotif.get_penerbit());
        values.put(tb_tahun, mdNotif.get_tahun());
        values.put(tb_jumlah, mdNotif.get_jumlah());

        return db.update(tb_perpustakaan, values, tb_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }
    public void DeleteToko (Perpustakaan mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_perpustakaan, tb_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}
