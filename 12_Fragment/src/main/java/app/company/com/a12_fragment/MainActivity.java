package app.company.com.a12_fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import app.company.com.a12_fragment.dummy.WordsContent;

public class MainActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener,DetailsFragment.OnFragmentInteractionListener {
    String id;
    String word;
    String details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onListFragmentInteraction(WordsContent.WordsItem item) {
        Bundle argument = new Bundle();
        argument.putString("id",item.id);
        DetailsFragment fragment = new DetailsFragment();
        fragment.setArguments(argument);
        getFragmentManager().beginTransaction().replace(R.id.fl_details, fragment).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
