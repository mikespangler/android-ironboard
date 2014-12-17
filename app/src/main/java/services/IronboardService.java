package services;

import models.Announcements;
import models.Progresses;
import models.Schedules;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by spangler on 12/16/14.
 */
public class IronboardService {
    private static final String IRONBOARD_API_URL = "http://ironboard-android.herokuapp.com/api/android/";
    private static final String CLIENT_EMAIL = "spangler.mike@gmail.com";

    public interface ProgressesService {
        @GET("/progresses/{client_email}")
        public void getProgresses(
            @Query("client_email") String client_email,
            Callback<Progresses>callback
        );
    }

    public void loadProgresses(Callback<Progresses> callback){
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(IRONBOARD_API_URL)
                .build();
        ProgressesService service = restAdapter.create(ProgressesService.class);
        service.getProgresses(CLIENT_EMAIL, callback);
    }

    public interface SchedulesService {
        @GET("/daily_schedules/{client_email}")
        public void getSchedules(
            @Query("client_email") String client_email,
            Callback<Schedules>callback
        );
    }

    public void loadSchedules(Callback<Schedules> callback){
        RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint(IRONBOARD_API_URL)
            .build();
        SchedulesService service = restAdapter.create(SchedulesService.class);
        service.getSchedules(CLIENT_EMAIL, callback);
    }

    public interface AnnouncementsService {
        @GET("/announcements/{client_email}")
        public void getAnnouncements(
            @Query("client_email") String client_email,
            Callback<Announcements>callback
        );
    }

    public void loadAnnouncements(Callback<Announcements> callback){
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(IRONBOARD_API_URL)
                .build();
        AnnouncementsService service = restAdapter.create(AnnouncementsService.class);
        service.getAnnouncements(CLIENT_EMAIL, callback);
    }
}
