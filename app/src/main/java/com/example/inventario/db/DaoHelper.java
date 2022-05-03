package com.example.inventario.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.inventario.models.DaoMaster;
import com.example.inventario.models.DaoSession;

public class DaoHelper {

    private SQLiteDatabase db;
    private DaoSession daoSession;
    private static DaoHelper daoHelperSingleton;
    private DaoMaster.DevOpenHelper helper;
    private DaoMaster daoMaster;

    private DaoHelper(){
        //Prevent form the reflection api.
        if (daoHelperSingleton != null){
            throw new RuntimeException("Use getSingleton() method to get the single instance of this class.");
        }
    }

    final public void init(final Context context, final String dbName){
        // do this once, for example in your Application class
        helper = new DaoMaster.DevOpenHelper(context, dbName, null);
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    final public static DaoHelper getSingleton(){
        if (daoHelperSingleton == null){
            daoHelperSingleton = new DaoHelper();
        }
        return daoHelperSingleton;
    }

    @Override
    protected Object clone() {
        throw new RuntimeException("Use getSingleton() method to get the single instance of this class.");
    }

    public DaoSession getDaoSession() {
        if(daoSession != null)
            return daoSession;
        return null;
    }
}
