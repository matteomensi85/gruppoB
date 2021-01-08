package com.example.buttongen_ok;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context ma = this;

        TextInputEditText txtInput = (TextInputEditText)findViewById(R.id.textInput);
        Button btnElabora          = findViewById(R.id.button1);
        LinearLayout llvertcontainer        = findViewById(R.id.layout3);
        LayoutParams params        = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);



        btnElabora.setOnClickListener(new Button.OnClickListener(){

            public Button getNewButton()
            {
                Button nwButt = new Button(ma);
                nwButt.setText(txtInput.getEditableText());
                nwButt.setLayoutParams(params);

                return nwButt;
            }

            public void makeNewRow()
            {
                LinearLayout llhorizontal1 = new LinearLayout(ma);
                llhorizontal1.setOrientation(LinearLayout.HORIZONTAL);//Setting Layout orientation

                llhorizontal1.addView(getNewButton());
                llvertcontainer.addView(llhorizontal1);
            }

            @Override
            public void onClick(View vista)
            {
                int nrighe = llvertcontainer.getChildCount();
                if (nrighe == 0)
                {

                    makeNewRow();
                }
                else if (nrighe > 0)
                {
                    LinearLayout ultimariga = (LinearLayout)llvertcontainer.getChildAt(nrighe-1);

                    if(ultimariga.getChildCount() < 4)
                    {

                        ultimariga.addView(getNewButton());
                    }
                    else
                    {
                        makeNewRow();
                    }
                }
            }

        });


    }


}



/*
package com.example.buttongen_ok;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context ma = this;

        TextInputEditText txtInput = (TextInputEditText)findViewById(R.id.textInput);
        Button btnElabora          = findViewById(R.id.button1);
        LinearLayout llMain        = findViewById(R.id.layout3);
        LayoutParams params        = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        LinearLayout llhorizontal1 = new LinearLayout(ma);
        llhorizontal1.setOrientation(LinearLayout.HORIZONTAL);//Setting Layout orientation
        llMain.addView(llhorizontal1);

        btnElabora.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View vista) {

                Button nwButt = new Button(ma);
                nwButt.setText(txtInput.getEditableText());

                nwButt.setLayoutParams(params);

                llhorizontal1.addView(nwButt);

            }

        });


    }


}
 */
