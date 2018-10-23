package mavis.com.bmi;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//快速鍵，Alt + `  ，Git的快速鍵。
//快速鍵，Ctrl + E，快速換頁面。

public class MainActivity extends AppCompatActivity {
    private EditText edWeight;
    private EditText edHeight;
//    MyListener listener = new MyListener(); 寫一個類別new出來，這樣多了很多步驟。

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
    }

    // Refactor -> Extract -> Method 萃取出一個方法 Ctrl + Alt + M
    private void findView() {
        edWeight = findViewById(R.id.ed_weight);
        edHeight = findViewById(R.id.ed_height);
        Button help = findViewById(R.id.help);
        //不用類別寫出一個匿名類別
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Log.d("MainActivity", "onClick:help");
                new AlertDialog.Builder(MainActivity.this).setMessage(R.string.bmi_info)
                        .setPositiveButton(R.string.ok, null).show();
            }
        });
    }

    public void bmi(View view){
        Log.d("MainActivity" , "bmi");
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

        Intent intent = new Intent(this, ResultActivity.class);

        startActivity(intent);
        
//        Toast.makeText(this, getString(R.string.your_bmi_is) + bmi, Toast.LENGTH_LONG).show();
//        // 浮字出來  最後一定要show出來 charSequence 就是 String 的父類別
//        new AlertDialog.Builder(this).setMessage(getString(R.string.your_bmi_is) + bmi)
//                .setTitle("BMI")
//                .setPositiveButton(getString(R.string.ok),null)
//                .setNegativeButton(R.string.clear, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                edWeight.setText("");
//                edHeight.setText("");
//            }
//        }).show();
//        //跳視窗   support為支援，可以向下相容   builder為 alertDialog 專用

    }
}
