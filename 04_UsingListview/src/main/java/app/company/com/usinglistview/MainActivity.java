package app.company.com.usinglistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView lv_list;
    private SimpleAdapter s_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_list = (ListView) findViewById(R.id.lv_list);
        ArrayList<Map<String, String>> list_data = new ArrayList<>();
        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>();
        HashMap<String, String> map3 = new HashMap<>();
        map1.put("name", "张三");
        map1.put("class", "class 1");
        map1.put("studentID", "2014011451");

        map2.put("name", "李四");
        map2.put("class", "class 2");
        map2.put("studentID", "2014011452");

        map3.put("name", "王五");
        map3.put("class", "class 3");
        map3.put("studentID", "2014011453");

        list_data.add(map1);
        //..123
        list_data.add(map2);
        list_data.add(map3);

        s_adapter = new SimpleAdapter(this, list_data, R.layout.layout_list_item, new String[]{"name",
                "class", "studentID"}, new int[]{R.id.lv_item_name, R.id.lv_item_class, R.id.lv_item_studentID});
        lv_list.setAdapter(s_adapter);
    }
}
