package com.olivierguillet.horizontalwidget.android;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Gallery;
import android.widget.TextView;

/**
 * @author Olivier Guillet
 * 
 */
public class HorizontalWidgetActivity extends Activity {

    /**
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // gradients plus joli
        //getWindow().setFormat(PixelFormat.RGBA_8888);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_DITHER);

        setContentView(R.layout.main);

        // tableau d'items
        final String[] tabStr = new String[20];
        for (int i = 0; i < 20; i++) {
            tabStr[i] = (new Integer(i + 1)).toString();
        }

        // composant natif Gallery
        // une Gallery est un widget affichant une liste d'items de manière horizontale
        // et positionnant l'élément sélectionné de manière centrée
        Gallery gallery = (Gallery) this.findViewById(R.id.gallery);
        ArrayAdapter<String> arr = new ArrayAdapter<String>(this, R.layout.gallery_item, tabStr);
        gallery.setAdapter(arr);

        gallery.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView parent, View view, int position, long id) {
                TextView txt = (TextView) findViewById(R.id.text);
                txt.setText("Selected : " + tabStr[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub                
            }

        });

    }

}