package duong.physicsconstant;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;



import duong.physicsconstant.data.ConstantContract;
import io.github.kexanie.library.MathView;

import static duong.physicsconstant.data.ConstantContract.*;

/**
 * Created by duong on 12/25/2016.
 */

public class CustomAdapter extends CursorAdapter {
    public CustomAdapter(Context context, Cursor cursor){
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return  LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView name = (TextView) view.findViewById(R.id.item_name);
        MathView value = (MathView) view.findViewById(R.id.item_value);


        String nameText = cursor.getString(cursor.getColumnIndex(ClassicalMechanics.COLUMN_NAME));

        String valueText = cursor.getString(cursor.getColumnIndex(ClassicalMechanics.COLUMN_VALUE));



        name.setText(nameText);
        value.setText(valueText);

    }
}
