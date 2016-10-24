package recycler.xhf.asus.myrecyclerview.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import recycler.xhf.asus.myrecyclerview.R;
import recycler.xhf.asus.myrecyclerview.bean.Data;

/**
 * Created by 王鹏龙 on 2016/10/24.
 */
public class MyAdapter1 extends BaseAdapter {

    Context context;
    List<Data.DataEntity.ForumListEntity> list;

    public MyAdapter1(Context context, List<Data.DataEntity.ForumListEntity> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.item, null);

        TextView text = (TextView) v.findViewById(R.id.text);

        text.setText(list.get(position).name);
        return v;
    }
}
