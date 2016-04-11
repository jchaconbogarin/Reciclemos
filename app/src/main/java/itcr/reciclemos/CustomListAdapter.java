package itcr.reciclemos;

/**
 * Created by gesab on 3/26/2016.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemName;
    private final Integer[] imageId;

    public CustomListAdapter(Activity context, String[] itemName, Integer[] imageId) {
        super(context, R.layout.custom_list, itemName);
        this.context = context;
        this.itemName = itemName;
        this.imageId = imageId;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.custom_list, null,true);
        TextView txtView = (TextView) rowView.findViewById(R.id.item_TextView);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon_ImageView);
        txtView.setText(itemName[position]);
        imageView.setImageResource(imageId[position]);
        return rowView;
    };
}