package neer.com.bmi;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    EditText edit_height, edit_weight;
    Button button_bmicalculte;
    TextView text1,text2;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_height = (EditText) findViewById(R.id.edit_height);
        edit_weight = (EditText) findViewById(R.id.edit_weight);
        findViewById(R.id.button_bmicalculte).setOnClickListener(this);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
    }

@Override
    public void onClick(View v)
{
        view = this.getCurrentFocus();

         if (view != null)
         {
             InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
             imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
         }
         String height = edit_height.getText().toString();
         String weight =edit_weight.getText().toString();


         if(height.equals("")&&weight.equals(""))
         {
             Toast.makeText(getApplicationContext(),"Enter fields",Toast.LENGTH_LONG).show();
         }else
         {
             float heightinint = Float.parseFloat(height);
             float weightinint = Float.parseFloat(weight);


//                     float bmicalculate = (weightinint/(heightinint * heightinint));

             float bmicalculate = (weightinint/ (heightinint * heightinint))*703;

             String bmivalue = String.valueOf(bmicalculate);

             text1.setText("Your BMi Value is:" + bmivalue);


             if(bmicalculate<=18.5)
             {
//
                 text2.setText("UnderWeight");
//                        Toast.makeText(MainActivity.this, Status is:"+String.valueOf(bmicalculate<=18.5", Toast.LENGTH_SHORT).show();
             }
             else if(bmicalculate>18.5 && bmicalculate<=24.9)
             {
                 text2.setText(" your status is : Normal or Healthy ");
//                        Toast.makeText(MainActivity.this, "Normal or Healthy", Toast.LENGTH_SHORT).show();

             }
             else if(bmicalculate>24.9 && bmicalculate<=29.9)
             {
                 text2.setText(" your status is : Overweigt");
//                        Toast.makeText(MainActivity.this, "Overweight", Toast.LENGTH_SHORT).show();

             }
             else
             {

                 text2.setText(" your status is : Obese");
//                        Toast.makeText(MainActivity.this, "Obese", Toast.LENGTH_SHORT).show();

             }




         }


     }
    }

