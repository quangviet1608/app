package dumv.com.hoitroll.object;

import java.util.ArrayList;
import java.util.Random;

public class CauHoi {
    public String cauHoi;
    public String cauDung;
    public String giaithichDung;
    public String cauSai[];
    public String giaithichSai[];
    public int vtdung;

    public String getGiaiThichSai(String s) {
       String ss="";
        for(int i=0;i<cauSai.length;i++){
            if(s.equals(cauSai[i])){
                return  giaithichSai[i];
            }
        }
       return ss;
    }
    public CauHoi(String cauHoi, String a,String[] cau, String[] gt) {
        if(a.equals("a")){
            vtdung=0;
        }else  if(a.equals("b")){
            vtdung=1;
        }else  if(a.equals("c")){
            vtdung=2;
        }else {
            vtdung=3;
        }
        cauDung = cau[vtdung];
        giaithichDung = gt[vtdung];

        cauSai= new String[3];
        giaithichSai= new String[3];
        int sx=0;
        for(int i=0;i<cau.length;i++){
            if(i!=vtdung){
                cauSai[sx]=cau[i];
                giaithichSai[sx]=gt[i];
                sx++;
            }
        }
        this.cauHoi = cauHoi;
    }
    public ArrayList<String> lonDauHoi(){
        ArrayList<String>arr= new ArrayList<>();
        Random r= new Random();
        arr.add(cauSai[arr.size()]);
        arr.add(cauSai[arr.size()]);
        arr.add(cauSai[arr.size()]);
        arr.add(r.nextInt(arr.size()),cauDung);
        return arr;
    }
}
