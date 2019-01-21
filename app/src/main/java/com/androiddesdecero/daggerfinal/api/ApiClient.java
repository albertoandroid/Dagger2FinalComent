package com.androiddesdecero.daggerfinal.api;

import com.androiddesdecero.daggerfinal.model.GitHubRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by albertopalomarrobledo on 5/1/19.
 */

public interface ApiClient {
    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> getReposForUser(@Path("user") String user);
}
