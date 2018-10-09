package mavis.com.bmi;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bmi(View view){
        Log.d("MainActivity" , "bmi");
        final EditText edWeight = findViewById(R.id.ed_weight);
        final EditText edHeight = findViewById(R.id.ed_height);
        //取得輸入方塊元件
        String w = edWeight.getText().toString();
        String h = edHeight.getText().toString();
        //取得上面的字
        Log.d("MainActivity", w + "/" + h);
        float weight = Float.parseFloat(w);
        float height = Float.parseFloat(h);
        float bmi = weight / (height + height);
        //改成浮點數
        Log.d("MainActivity", bmi + "");

        Toast.makeText(this, "Your BMI is " + bmi, Toast.LENGTH_LONG).show();
        // 浮字出來  最後一定要show出來 charSequence 就是 String 的父類別
        new AlertDialog.Builder(this).setMessage("Your BMI is" + bmi).setTitle("BMI").setPositiveButton("OK!",null).setNegativeButton("OK!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                edWeight.setText("");
                edHeight.setText("");
            }
        }).show();
        //跳視窗   support為支援，可以向下相容   builder為 alertDialog 專用

    }
}
