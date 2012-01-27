package com.olivierguillet.horizontalwidget.android;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

import com.olivierguillet.horizontalwidget.android.widget.HorizontalWidget;

/**
 * @author Olivier Guillet
 * 
 */
public class HorizontalWidgetActivity extends Activity {

    private List<String> items;
    
    /**
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // liste d'items pour le widget
        items = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            items.add((new Integer(i + 1)).toString());
        }        
        HorizontalWidget hw = (HorizontalWidget) this.findViewById(R.id.hw);
        hw.setListItems(items);
         
        // initialisation de l'adapter
        hw.initWidget();
        
        // listener sur la Gallery
        hw.getGallery().setOnItemSelectedListener(new OnItemSelectedListener() {
    
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateSelected(items.get(position));
            }
    
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub                
            }
    
        });          
    }
    
    public void updateSelected(String text) {
        TextView txt = (TextView) findViewById(R.id.text);
        txt.setText("Selected : " + text);
    }
}