package recycler.xhf.asus.myrecyclerview.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.google.gson.Gson;

import java.util.List;

import recycler.xhf.asus.myrecyclerview.R;
import recycler.xhf.asus.myrecyclerview.adapter.MyAdapter1;
import recycler.xhf.asus.myrecyclerview.bean.Data;
import recycler.xhf.asus.myrecyclerview.util.GetHttpUtils;

/**
 * Created by 王鹏龙 on 2016/10/24.
 */
public class Fragment1 extends Fragment {

    private View v;
    private GridView gd;
    private String path="http://open.qyer.com/qyer/bbs/entry?client_id=qyer_android&client_secret=9fcaae8aefc4f9ac4915";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment1, null);

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //获取控件
        gd = (GridView) v.findViewById(R.id.gd);

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
                gd.setAdapter(new MyAdapter1(getActivity(), list));
            }
        }.execute();
    }
}
