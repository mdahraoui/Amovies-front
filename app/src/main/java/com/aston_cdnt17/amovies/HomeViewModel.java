package com.aston_cdnt17.amovies;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    MutableLiveData<Boolean> isAuth = new MutableLiveData<>();

    public MutableLiveData<Boolean> getIsAuth() {
        return isAuth;
    }

    public void login (String email, String pwd){
        new Thread(()->{
            try{
                boolean isOk =  RequestManager.Login(email, pwd);
                isAuth.postValue(isOk);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        ).start();
    }
}
