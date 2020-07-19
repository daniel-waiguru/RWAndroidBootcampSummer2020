package tech.danielwaiguru.estudy.repositories;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u0015\u001a\u00020\u0016H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u0006\u0010\u0018\u001a\u00020\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Ltech/danielwaiguru/estudy/repositories/MonsterRepository;", "", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "monsterDao", "Ltech/danielwaiguru/estudy/database/MonsterDao;", "monsters", "Landroidx/lifecycle/MutableLiveData;", "", "Ltech/danielwaiguru/estudy/models/Monster;", "getMonsters", "()Landroidx/lifecycle/MutableLiveData;", "networkStatusChecker", "Ltech/danielwaiguru/estudy/networking/NetworkStatusChecker;", "getNetworkStatusChecker", "()Ltech/danielwaiguru/estudy/networking/NetworkStatusChecker;", "networkStatusChecker$delegate", "Lkotlin/Lazy;", "remoteApi", "Ltech/danielwaiguru/estudy/networking/RemoteApi;", "getData", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshData", "app_debug"})
public final class MonsterRepository {
    private final kotlin.Lazy networkStatusChecker$delegate = null;
    private final tech.danielwaiguru.estudy.networking.RemoteApi remoteApi = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<tech.danielwaiguru.estudy.models.Monster>> monsters = null;
    private final tech.danielwaiguru.estudy.database.MonsterDao monsterDao = null;
    
    private final tech.danielwaiguru.estudy.networking.NetworkStatusChecker getNetworkStatusChecker() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<tech.danielwaiguru.estudy.models.Monster>> getMonsters() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    public final java.lang.Object getData(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p0) {
        return null;
    }
    
    public final void refreshData() {
    }
    
    public MonsterRepository(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        super();
    }
}