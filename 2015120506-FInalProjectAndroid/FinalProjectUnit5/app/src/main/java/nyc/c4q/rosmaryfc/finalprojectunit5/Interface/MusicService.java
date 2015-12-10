package nyc.c4q.rosmaryfc.finalprojectunit5.Interface;

import java.util.List;

import nyc.c4q.rosmaryfc.finalprojectunit5.Model.Music;
import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by c4q-rosmary on 12/6/15.
 */
public interface MusicService {
    @GET("/search?media=music&term=beyonce")
    public Call<List<Music>> listMusicResponses();
}
