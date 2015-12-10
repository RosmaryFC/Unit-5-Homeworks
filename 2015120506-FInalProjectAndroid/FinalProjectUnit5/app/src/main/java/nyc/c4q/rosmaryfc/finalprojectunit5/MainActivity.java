package nyc.c4q.rosmaryfc.finalprojectunit5;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nyc.c4q.rosmaryfc.finalprojectunit5.Interface.MusicService;
import nyc.c4q.rosmaryfc.finalprojectunit5.Model.Music;
import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;


public class MainActivity extends AppCompatActivity {

    EditText searchEt;
    Button searchBtn;
    ListView resultsListView;
    SearchAdapter adapter;
    Spinner mediaSpinner;

    String media;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        media = "all";

        if(!connectInternet()){
            Toast.makeText(this, "Verify your internet connection", Toast.LENGTH_SHORT).show();
            return;
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://itunes.apple.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MusicService service = retrofit.create(MusicService.class);

        Call<List<Music>> call = service.listMusicResponses();
        List<Music> musics = new ArrayList<>();

        try {
            musics = call.execute().body();
        } catch (IOException e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

            e.printStackTrace();
        }

        for(Music music : musics){
            Log.d("MUSIC: ", music.getArtistName() + " " + music.getTrackName() + " " + music.getCollectionName());
        }


//        call.enqueue(new Callback<MusicResponse>() {
//            @Override
//            public void onResponse(Response<MusicResponse> response, Retrofit retrofit) {
//                MusicResponse musicResponse = response.body();
//                Log.d("MUSIC RESPONSE BODY: ", musicResponse.toString());
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });

        //URL url = new URL("https://itunes.apple.com/search?media=" + media + "&term=" + searchTerm);

    }

    public void initializeViews(){
        searchEt = (EditText) findViewById(R.id.search_edit_text);
        searchBtn = (Button) findViewById(R.id.search_button);

//        adapter = new SearchAdapter(getApplicationContext(), R.layout.search_adapter, /* data */);
//        resultsListView = (ListView) findViewById(R.id.results_list_view);
//        resultsListView.setAdapter(adapter);

        mediaSpinner = (Spinner) findViewById(R.id.media_spinner);
//        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.media_array, android.R.layout.simple_spinner_item);
//        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        mediaSpinner.setAdapter(arrayAdapter);

        mediaSpinner.setOnItemSelectedListener(mediaSpinnerListener);
    }

    public AdapterView.OnItemSelectedListener mediaSpinnerListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            media = parent.getItemAtPosition(position).toString().toLowerCase();

            if(media.contains(" ")){
                String[] removeSpace = media.split(" ");
                media = "";
                for (String s : removeSpace){
                    media += s;
                }
            }

            Toast.makeText(parent.getContext(),
                    "OnItemSelectedListener: " + media,
                    Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    public boolean connectInternet(){
        ConnectivityManager connectivityManager = (ConnectivityManager)
                this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnectedOrConnecting()){
            return true;
        }else {
            return false;
        }

    }

}
