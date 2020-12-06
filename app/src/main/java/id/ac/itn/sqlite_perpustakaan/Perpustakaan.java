package id.ac.itn.sqlite_perpustakaan;

public class Perpustakaan
{
    private String _id, _judul, _penulis, _penerbit, _tahun, _jumlah;
    public Perpustakaan (String id, String judul, String penulis, String penerbit, String tahun, String jumlah)
    {
        this._id = id;
        this._judul = judul;
        this._penulis = penulis;
        this._penerbit = penerbit;
        this._tahun = tahun;
        this._jumlah = jumlah;
    }
    public Perpustakaan(){
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_judul() {
        return _judul;
    }

    public void set_judul(String _judul) {
        this._judul = _judul;
    }

    public String get_penulis() {
        return _penulis;
    }

    public void set_penulis(String _penulis) {
        this._penulis = _penulis;
    }

    public String get_penerbit() {
        return _penerbit;
    }

    public void set_penerbit(String _penerbit) {
        this._penerbit = _penerbit;
    }

    public String get_tahun() {
        return _tahun;
    }

    public void set_tahun(String _tahun) {
        this._tahun = _tahun;
    }

    public String get_jumlah() {
        return _jumlah;
    }

    public void set_jumlah(String _jumlah) {
        this._jumlah = _jumlah;
    }
}

