package com.kszorin.guestbook.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kszorin.guestbook.R;
import com.kszorin.guestbook.models.Message;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by kszorin on 13.11.2016.
 * Класс, описывающий адаптер списка сообщений.
 */
public class MessageListAdapter extends BaseAdapter {
    Context context;
    List<Message> messages;
    LayoutInflater inflter;

    public MessageListAdapter (Context context, List<Message> messages) {
        this.context = context;
        this.messages = messages;
        inflter = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int i) {
        return messages.get(i);
    }

    @Override
    public long getItemId(int i) {
        return messages.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null)
            view = inflter.inflate(R.layout.message_record, viewGroup, false);
        TextView login = (TextView) view.findViewById(R.id.login_textview);
        TextView entry = (TextView) view.findViewById(R.id.entry_textview);
        ImageView image = (ImageView) view.findViewById(R.id.image_imageview);

        //выводим даннаые в список
        login.setText(messages.get(i).getLogin());
        entry.setText(messages.get(i).getEntry());
        Picasso.with(view.getContext())
                .load(messages.get(i).getImageUrl())
                .placeholder(R.drawable.loading)            //картинка, отображаемая во время загрузки
                .error(R.drawable.error)                    //картинка, если произошла ошибка
                .into(image);
        return view;
    }
}
