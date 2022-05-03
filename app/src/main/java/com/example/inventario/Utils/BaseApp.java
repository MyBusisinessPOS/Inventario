package com.example.inventario;

import android.app.Application;
import android.content.Context;

import com.example.inventario.db.DaoHelper;

public class BaseApp extends Application {

    private DaoHelper daoHelper;

    private static BaseApp _INSTANCE = null;

    public static BaseApp getInstance() {
        return _INSTANCE;
    }

    public static BaseApp getInstance(Context context) {
        return (BaseApp) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        _INSTANCE = this;

        daoHelper = DaoHelper.getSingleton();

        /** Inicia el Helper **/
        daoHelper.init(_INSTANCE, "inventario_db");
    }
}
