package com.example.rehberuyg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etAd,etSoyad,etTel,etcinsiyet,etyas,etdogumtarihi;
    private Button btnKaydet, btnListele,btnSil,btnGuncelle;
    private ListView lstListele;
    int idBul=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAd=findViewById(R.id.etAd);
        etSoyad=findViewById(R.id.etSoyad);
        etTel=findViewById(R.id.etTel);
        btnKaydet=findViewById(R.id.btnKaydet);
        btnListele=findViewById(R.id.btnListele);
        btnGuncelle=findViewById(R.id.btnGuncelle);
        btnSil=findViewById(R.id.btnSil);
        lstListele=findViewById(R.id.lstListele);
        etcinsiyet=findViewById(R.id.etcinsiyet);
        etdogumtarihi=findViewById(R.id.etdogumtarihi);
        etyas=findViewById(R.id.etyas);



    }

    public void Kaydet(View v){

        String gelenAd = etAd.getText().toString();
        String gelenSoyad = etSoyad.getText().toString();
        String gelenTel = etTel.getText().toString();
        String gelenyas = etyas.getText().toString();
        String gelendogumtarihi = etdogumtarihi.getText().toString();
        String gelencinsiyet = etcinsiyet.getText().toString();

        VeriTabani vt = new VeriTabani(MainActivity.this);
        vt.VeriEkle(gelenAd, gelenSoyad, gelenTel, gelencinsiyet, gelendogumtarihi, gelenyas);


    }

    public void Listele(){
        VeriTabani vt=new VeriTabani(MainActivity.this);
        List<String> liste=vt.VeriListele();
        ArrayAdapter<String> adapter=new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,android.R.id.text1,liste);
        lstListele.setAdapter(adapter);

    }
    public void Sil(View v){
        VeriTabani vt=new VeriTabani(MainActivity.this);
        vt.VeriSil(idBul);
        Listele();
    }
    public void Guncelle(View v){
        String gelenAd = etAd.getText().toString();
        String gelenSoyad = etSoyad.getText().toString();
        String gelenTel = etTel.getText().toString();
        String gelenyas = etyas.getText().toString();
        String gelendogumtarihi = etdogumtarihi.getText().toString();
        String gelencinsiyet = etcinsiyet.getText().toString();

        VeriTabani vt=new VeriTabani(MainActivity.this);
        vt.VeriDuzenle(idBul,gelenAd,gelenSoyad,gelenTel,gelencinsiyet,gelendogumtarihi,gelencinsiyet);
        Listele();

    }
}