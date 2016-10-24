package recycler.xhf.asus.myrecyclerview.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.List;

import recycler.xhf.asus.myrecyclerview.R;
import recycler.xhf.asus.myrecyclerview.adapter.MyAdapter2;
import recycler.xhf.asus.myrecyclerview.bean.Data;
import recycler.xhf.asus.myrecyclerview.util.GetHttpUtils;

/**
 * Created by 王鹏龙 on 2016/10/24.
 */
public class Fragment2 extends Fragment {

    private View v;
    private ListView lv;
    private String path="http://open.qyer.com/qyer/bbs/entry?client_id=qyer_android&client_secret=9fcaae8aefc4f9ac4915";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment2, null);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //获取控件
        lv = (ListView) v.findViewById(R.id.lv);

        //获取数据
        getData();

    }

    public void getData() {

        new AsyncTask<Void,Void,String>(){
            @Override
            protected String doInBackground(Void... params) {
                String str = GetHttpUtils.Getstr(path);
                return str;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

                Gson gson = new Gson();
                Data bean = gson.fromJson(s, Data.class);
                List<Data.DataEntity.ForumListEntity> list = bean.data.forum_list;

                //适配器
                lv.setAdapter(new MyAdapter2(getActivity(), list));
            }
        }.execute();
    }
}
