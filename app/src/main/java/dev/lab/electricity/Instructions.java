package dev.lab.electricity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Instructions extends AppCompatActivity
{
    TextView tvI1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_instructions);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle("Electricity Bill");
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvI1 = findViewById(R.id.tvI1);
        tvI1.setText("◈ Enter the number of units (kWh)\n\n " +
                "◈ Enter the rebate charge amount in the specified filed\n\n" +
                "◈ Click the 'Calculate Bill' button to see the estimated electricity cost.\n\n " +
                "◈ Click the 'Clear' button to reset the input fields.");

    }
}