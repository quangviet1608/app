package dumv.com.hoitroll;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class DialogThongBao extends Dialog {
    public DialogThongBao(@NonNull Context context, String thong_bao, String noi_dung) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.diloggoiy);
        TextView txvThongBao = findViewById(R.id.txvThongBao);
        TextView txvNoiDung = findViewById(R.id.txvNoiDung);
        txvThongBao.setText(thong_bao);
        txvNoiDung.setText(noi_dung);
    }
}
