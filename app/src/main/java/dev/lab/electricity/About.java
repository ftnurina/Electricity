package dev.lab.electricity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_about);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle("Electricity Bill");
        setSupportActionBar(myToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        TextView tvAbout = findViewById(R.id.tvAbout);
        ImageView ivPassport = findViewById(R.id.ivPassport);
        TextView tvName = findViewById(R.id.tvName);
        TextView tvGroup = findViewById(R.id.tvGroup);
        TextView tvStudentNumber = findViewById(R.id.tvStudentNumber);
        TextView tvSourceCode = findViewById(R.id.tvSourceCode);

        ivPassport.setImageResource(R.drawable.fatin2);
        tvName.setText("Fatin Nurina Binti Jasmee");
        tvStudentNumber.setText("2022783059");
        tvGroup.setText("RCS2515A");
        tvSourceCode.setText("Source Code");

        tvSourceCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the source code link
                String url = "https://github.com/yourusername/yourproject";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

    }
}