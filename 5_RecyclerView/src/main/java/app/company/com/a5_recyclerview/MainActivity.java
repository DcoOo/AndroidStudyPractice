package app.company.com.a5_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_list;
    ArrayList<String> data_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_list = (RecyclerView) findViewById(R.id.rv_list);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this, OrientationHelper.VERTICAL,false);
        rv_list.setLayoutManager(layout);
        data_list = new ArrayList();
        data_list.add("张三");
        data_list.add("李四");
        data_list.add("王五");
        MyAdapter adapter = new MyAdapter();
        rv_list.setAdapter(adapter);
    }

    class MyAdapter extends RecyclerView.Adapter<MyHolder>{
        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyHolder myHolder = new MyHolder(LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_list_item,parent,false));
            return myHolder;
        }

        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
            holder.tv.setText(data_list.get(position));
        }

        @Override
        public int getItemCount() {
            return data_list.size();
        }
    }

    class MyHolder extends RecyclerView.ViewHolder{
        public TextView tv;
        public MyHolder(View itemView) {
            super(itemView);
            tv = (TextView)itemView.findViewById(R.id.lv_item_name);
        }
    }
}
