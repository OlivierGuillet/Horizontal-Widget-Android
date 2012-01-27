/**
 * 
 */
package com.olivierguillet.horizontalwidget.android.widget;

import java.util.List;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Gallery;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.olivierguillet.horizontalwidget.android.R;

/**
 * @author Olivier Guillet
 * 
 */
public class HorizontalWidget extends LinearLayout {

    private int selectedIndex;
    private List<String> listItems;
    private Gallery gallery;

    public HorizontalWidget(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.widget, this);

        // composant natif Gallery
        // une Gallery est un widget affichant une liste d'items de manière horizontale
        // et positionnant l'élément sélectionné de manière centrée        
        setGallery((Gallery) this.findViewById(R.id.gallery));        
    }
    
    public void initWidget() {
        ArrayAdapter<String> arr = new ArrayAdapter<String>(getContext(), R.layout.gallery_item, getListItems());
        gallery.setAdapter(arr);   
    }
    
    public List<String> getListItems() {
        return listItems;
    }

    public void setListItems(List<String> listItems) {
        this.listItems = listItems;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public Gallery getGallery() {
        return gallery;
    }

    public void setGallery(Gallery gallery) {
        this.gallery = gallery;
    }

}
