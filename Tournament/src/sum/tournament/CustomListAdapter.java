package sum.tournament;

import java.util.List;

import sum.model.Tournament;
import android.R.color;
import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter {

    private Context mContext;
    private int id;
    private List <Tournament>items ;

    public CustomListAdapter(Context context, int textViewResourceId , List<Tournament> list ) 
    {
        super(context, textViewResourceId, list);           
        mContext = context;
        id = textViewResourceId;
        items = list ;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent)
    {
        View mView = v ;
        if(mView == null){
            LayoutInflater vi = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = vi.inflate(id, null);
        }

        TextView text = (TextView) mView.findViewById(R.id.textView);

        if(items.get(position) != null )
        {
            text.setTextColor(Color.WHITE);
            text.setText(items.get(position).toString());
            text.setTextSize(20);
            Typeface listType = Typeface.createFromAsset(getContext().getAssets(), "varsity_regular.ttf");
            text.setTypeface(listType);

        }

        return mView;
    }

}
