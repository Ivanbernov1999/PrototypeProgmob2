package prototypeprogmob.com.Model;

import android.provider.ContactsContract;

public class MhsSI {
    private String nama;
    private String nim;
    private String Alamat;
    private String Email;
    private int ImgMhs;

    public MhsSI(String nim,String nama, String Alamat, String Email, int ImgMhs){
        this.nim = nim;
        this.nama = nama;
        this.Alamat = Alamat;
        this.Email = Email;
        this.ImgMhs = ImgMhs;
    }
    public String getNim(){
        return nim;
    }
    public void setNim(String nim){
        this.nim = nim;
    }
    public String getNama(){
        return nama;
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public String getAlamat(){
        return Alamat;
    }
    public void setAlamat(String Alamat){
        this.Alamat = Alamat;
    }
    public String getEmail(){
        return Email;
    }
    public void setEmail(String Email){
        this.Email = Email;
    }
    public int getImgMhs(){
        return ImgMhs;
    }
    public void setImgMhs(int imageResource){
        this.ImgMhs = ImgMhs;
    }
}
