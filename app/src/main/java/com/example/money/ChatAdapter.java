package com.example.money;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by 훈 on 2016-11-10.
 */
public class ChatAdapter extends ArrayAdapter<model> {

    private Context context;
    private int resource;

    private LayoutInflater inflater;

    public ChatAdapter(Context context, int resource) {
        super(context, resource);
        this.context=context;
        this.resource=resource;

        this.inflater=LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //getview 함수는 리스트가 보일 때마다 호출돼서 하나하나 따로 보여지게됨
        if(convertView==null){
            convertView=this.inflater.inflate(this.resource,parent,false);
        }

        TextView tvNickname = (TextView)convertView.findViewById(R.id.pmTv);
        TextView tvMessage = (TextView)convertView.findViewById(R.id.mmTv);

        model model = getItem(position);
        tvNickname.setText(model.getPluseminus());
        tvMessage.setText((model.getMuchmoney()));
        return  convertView;
    }
}
