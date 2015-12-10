package nyc.c4q.rosmaryfc.finalprojectunit5.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by c4q-rosmary on 12/6/15.
 */
public class MusicResponse {

    List<Music> musics;

    public MusicResponse(){
        musics = new ArrayList<Music>();
    }

    public static MusicResponse parseJSON (String response){
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(response, MusicResponse.class);
    }
}
