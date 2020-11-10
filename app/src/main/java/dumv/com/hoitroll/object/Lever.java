package dumv.com.hoitroll.object;

import android.content.Context;
import android.content.SharedPreferences;

public class Lever {
    public int lever=1;
    public String tenfileData = "tenfileData";

    public void getData(Context ct){
        SharedPreferences mSharedPreferences = ct.getSharedPreferences(tenfileData, Context.MODE_PRIVATE);
int lever = mSharedPreferences.getInt("lever", 1);
    }

    public void setData(Context ct){
        SharedPreferences mSharedPreferences = ct.getSharedPreferences(tenfileData, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt("lever", lever);
        editor.apply();
        editor.commit();
    }
}
