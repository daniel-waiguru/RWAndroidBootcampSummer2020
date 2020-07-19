package tech.danielwaiguru.estudy.networking;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0017\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0086\bR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Ltech/danielwaiguru/estudy/networking/NetworkStatusChecker;", "", "connectivityManager", "Landroid/net/ConnectivityManager;", "(Landroid/net/ConnectivityManager;)V", "hasInternetConnection", "", "performIfConnectedToInternet", "", "action", "Lkotlin/Function0;", "app_debug"})
public final class NetworkStatusChecker {
    private final android.net.ConnectivityManager connectivityManager = null;
    
    public final void performIfConnectedToInternet(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> action) {
    }
    
    public final boolean hasInternetConnection() {
        return false;
    }
    
    public NetworkStatusChecker(@org.jetbrains.annotations.Nullable()
    android.net.ConnectivityManager connectivityManager) {
        super();
    }
}