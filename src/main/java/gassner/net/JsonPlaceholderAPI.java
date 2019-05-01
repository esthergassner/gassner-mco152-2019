package gassner.net;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface JsonPlaceholderAPI
{
    @GET("/users")
    Observable<UserList> getUserList();

    @GET("/photos")
    Observable<PhotoList> getPhotoList();
}
