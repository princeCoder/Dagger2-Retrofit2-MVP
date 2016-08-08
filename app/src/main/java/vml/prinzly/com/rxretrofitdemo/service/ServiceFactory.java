package vml.prinzly.com.rxretrofitdemo.service;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by prinzlyngotoum on 8/3/16.
 *
 * Service objects factory
 */
public class ServiceFactory {

    public static Retrofit getAdapter(final String endPoint){
        return   new Retrofit.Builder().baseUrl(endPoint)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) //We need to provide an adapter in case we use Observables/
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static <T> T createRetrofitService(final Class<T> clazz, Retrofit adapter) {
        return adapter.create(clazz);
    }
}
