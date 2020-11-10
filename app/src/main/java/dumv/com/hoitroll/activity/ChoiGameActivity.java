package dumv.com.hoitroll.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import dumv.com.hoitroll.Data;
import dumv.com.hoitroll.DialogThongBao;
import dumv.com.hoitroll.R;
import dumv.com.hoitroll.object.Lever;

public class ChoiGameActivity extends AppCompatActivity {
TextView txvSoLanTraLoiSai;
TextView txvNoiDungCauHoi;
TextView txvLever;
TextView txvSoLanGoiY;
int soLanTraLoiSai=5;
int lever=1;
int so_lan_goi_y =1;
boolean boQua=true;
ArrayList<TextView> arrTxvCauTraLoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choi_game);
        init();
        anhXa();
        setUp();
        setClick();
    }
    private void init(){
        Lever l = new Lever();
        l.getData(this);
        lever= l.lever;
        Data.data.fackeCauHoi();
        Data.data.taoCauHoi();
    }
    private void anhXa(){
        txvSoLanTraLoiSai=findViewById(R.id.txvSoLanTraLoiSai);
        txvNoiDungCauHoi=findViewById(R.id.txvNoiDungCauHoi);
        txvLever=findViewById(R.id.txvLever);
        txvSoLanGoiY=findViewById(R.id.txvSoLanGoiY);
        arrTxvCauTraLoi= new ArrayList<>();
        arrTxvCauTraLoi.add((TextView) findViewById(R.id.txvCauTraLoi1));
        arrTxvCauTraLoi.add((TextView) findViewById(R.id.txvCauTraLoi2));
        arrTxvCauTraLoi.add((TextView) findViewById(R.id.txvCauTraLoi3));
        arrTxvCauTraLoi.add((TextView) findViewById(R.id.txvCauTraLoi4));
    }
    private void setUp(){
        hienSoLanSai();
        hienCauHoi();
        txvSoLanGoiY.setText("1");
    }
    private void setClick(){
        for (int i =0 ;i<arrTxvCauTraLoi.size();i++){
            arrTxvCauTraLoi.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView t = (TextView) v;
                    String s =t.getText().toString();
                    if(s.equals(Data.getData().cauHoi.cauDung)){
                        lever++;
                        Lever l = new Lever();
                        l.lever = lever;
                        l.setData(ChoiGameActivity.this);
                        new DialogThongBao(ChoiGameActivity.this,"Chúc Mừng Bạn Đã Trả Lời Đúng",Data.getData().cauHoi.giaithichDung).show();
                        Data.data.taoCauHoi();
                        hienSoLanSai();
                        hienCauHoi();
                        boQua=true;
                    }else{
                        if(soLanTraLoiSai>0) {
                            soLanTraLoiSai--;
                            new DialogThongBao(ChoiGameActivity.this,"Bạn đã Chọn Sai",Data.getData().cauHoi.getGiaiThichSai(s)).show();
                            Data.data.taoCauHoi();
                            hienSoLanSai();
                            hienCauHoi();
                        }else{
                            new DialogThongBao(ChoiGameActivity.this,"Rất Tiếc","Bạn đã thua cuộc").show();
                            finish();
                            for (int i =0 ;i<arrTxvCauTraLoi.size();i++) {
                                arrTxvCauTraLoi.get(i).setOnClickListener(null);
                            }
                        }
                    }
                }
            });
        }}
    private void hienSoLanSai(){
        txvSoLanTraLoiSai.setText(""+soLanTraLoiSai);
        txvLever.setText("Lever : "+lever);
    }
    private void hienCauHoi(){
        txvNoiDungCauHoi.setText(Data.getData().cauHoi.cauHoi);
        ArrayList<String> arr=Data.data.cauHoi.lonDauHoi();
        for (int i =0 ;i<arr.size();i++){
            arrTxvCauTraLoi.get(i).setText(""+arr.get(i));
        }
    }

    public void GoiY(View view) {
        if(so_lan_goi_y<=0){
            Toast.makeText(ChoiGameActivity.this, "Xin lỗi bạn đã hết gợi ý", Toast.LENGTH_SHORT).show();
            return;
        }
        so_lan_goi_y--;
        txvSoLanGoiY.setText(""+so_lan_goi_y);
        new DialogThongBao(this,"Câu Trả Lời Đúng Là",Data.getData().cauHoi.cauDung).show();
    }

    public void boQua(View view) {
        if(boQua){
            Data.data.taoCauHoi();
            hienSoLanSai();
            hienCauHoi();
            boQua=false;
        }else{
            Toast.makeText(ChoiGameActivity.this, "Xin lỗi bạn đã bỏ qua 1 câu", Toast.LENGTH_SHORT).show();
        }
    }
}
