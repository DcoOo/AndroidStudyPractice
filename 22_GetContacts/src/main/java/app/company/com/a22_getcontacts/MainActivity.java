package app.company.com.a22_getcontacts;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView lv_contacts;
    private SimpleAdapter contacts_adapter;
    private Cursor name_cursor;
    private Cursor number_cursor;
    private ContentResolver resolver;
    private Button btn_get_all;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_contacts = (ListView) findViewById(R.id.lv_contacts);
        resolver = getContentResolver();
        btn_get_all = (Button) findViewById(R.id.btn_get_all);
        final List<Map<String,String>> name_number = new LinkedList<>();
        btn_get_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id;
                String name;
                String number;
                name_cursor = resolver.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
                while(name_cursor.moveToNext()){
                    id = name_cursor.getString(name_cursor.getColumnIndex(ContactsContract.Contacts._ID));
                    name = name_cursor.getString(name_cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                    Log.d("Debug",name);
                    HashMap<String,String> name_map = new HashMap<String, String>();
                    name_map.put("name",name);
                    name_number.add(name_map);
                    number_cursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID +"="+id,null,null);
                    while (number_cursor.moveToNext()){
                        number = number_cursor.getString(number_cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        HashMap<String,String> number_map = new HashMap<String, String>();
                        if (!number.equals("") || number != null){
                            number_map.put("number",number);
                        }else
                            number_map.put("number","空");
                        Log.d("Debug",number);
                        name_number.add(number_map);
                    }
                }
                contacts_adapter = new SimpleAdapter(MainActivity.this,name_number,R.layout.listview_item,new String[]{"name","number"},new int[]{R.id.tv_name,R.id.tv_number});
                lv_contacts.setAdapter(contacts_adapter);
            }
        });
    }


}
