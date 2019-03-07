package technology.nine.customdialog;

import android.app.Dialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import technology.nine.customdialogbox.CustomAlertDialog;
import technology.nine.customdialogbox.CustomDialogListener;
import technology.nine.customdialogbox.Icon;

public class MainActivity extends AppCompatActivity {
    TextView txClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txClick = findViewById(R.id.txClick);
        txClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomAlertDialog.Builder builder = new CustomAlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.close_circle_outline, Icon.Visible, new CustomDialogListener() {
                    @Override
                    public void onClick(Dialog dialog, Boolean check) {
                        dialog.dismiss();
                        Toast.makeText(getApplicationContext(), check + "", Toast.LENGTH_SHORT).show();

                    }
                })
                        .setTitle("Big Billion Days", 20)
                        .setMessage("Buy any product and get 20% discout up to Rs 5000", 15)
                        .setImage("https://images.unsplash.com/photo-1551801782-9eca6ca77c16?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=668&q=80"
                                , ImageView.ScaleType.FIT_XY)
                        .setNegativeButton("CLOSE", Color.parseColor("#ff6d00"), new CustomDialogListener() {
                            @Override
                            public void onClick(Dialog dialog, Boolean check) {
                                dialog.dismiss();
                                Toast.makeText(getApplicationContext(), check + "", Toast.LENGTH_SHORT).show();
                            }
                        });
                builder.show();

            }
        });
    }
}
