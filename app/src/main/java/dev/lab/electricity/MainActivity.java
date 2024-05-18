package dev.lab.electricity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.text.DecimalFormat;
public class MainActivity extends AppCompatActivity
{
    Button btnCalculate, btnClear;
    EditText etkWh, etRebate;
    TextView ElectricityTitle, tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        ElectricityTitle = findViewById(R.id.ElectricityTitle);
        etkWh = findViewById(R.id.etkWh);

        etRebate = findViewById(R.id.etRebate);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnClear = findViewById(R.id.btnClear);
        tvResult = findViewById(R.id.tvResult);



        btnCalculate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                calculateBill();
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                etkWh.setText("");
                etRebate.setText("");
                tvResult.setText("");
            }
        });

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
//        myToolbar.setTitle("Electricity Bill");
        setSupportActionBar(myToolbar);
    }

    private void calculateBill()
    {
        try
        {
            double unitskWh = Double.parseDouble(etkWh.getText().toString());
            double rebatepercentage = Double.parseDouble(etRebate.getText().toString());
            double totalCharges = 0.0;
            if (unitskWh <= 200)
            {
                totalCharges = unitskWh * 0.218;
            }
            else if (unitskWh <= 300)
            {
                totalCharges = 200 * 0.218 + (unitskWh - 200) * 0.334;
            }
            else if (unitskWh <= 600)
            {
                totalCharges = 200 * 0.218 + 100 * 0.334 + (unitskWh - 300) * 0.516;
            }
            else
            {
                totalCharges = 200 * 0.218 + 100 * 0.334 + 300 * 0.516 + (unitskWh - 600) * 0.546;
            }
            double finalCost = totalCharges - (totalCharges * (rebatepercentage / 100));
            tvResult.setText(String.format("Total Charges: RM %.2f\nFinal Cost: RM %.2f", totalCharges, finalCost));
        }
        catch (NumberFormatException e)
        {
            Toast.makeText(this, "Please enter units (kWh) and rebate (%)", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int selected = item.getItemId();
        if (selected == R.id.menuInstructions)
        {
            openInstructionsPage();
            return true;
        }
        else if (selected == R.id.menuAbout)
        {
            openAboutPage();
//            Toast.makeText(this,"about clicked",Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(MainActivity.this,About.class);
//            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void openInstructionsPage()
    {
        Intent intent = new Intent(MainActivity.this, Instructions.class);
        startActivity(intent);
    }
    private void openAboutPage()
    {
        Intent intent = new Intent(MainActivity.this,About.class);
        startActivity(intent);
    }
}