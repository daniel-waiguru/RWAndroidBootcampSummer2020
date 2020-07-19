package tech.danielwaiguru.estudy.ui.login;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\nH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0014"}, d2 = {"Ltech/danielwaiguru/estudy/ui/login/LoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "userPrefsRepository", "Ltech/danielwaiguru/estudy/repositories/UserPrefsRepository;", "getUserPrefsRepository", "()Ltech/danielwaiguru/estudy/repositories/UserPrefsRepository;", "userPrefsRepository$delegate", "Lkotlin/Lazy;", "initUi", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRememberMeCheckBoxChecked", "view", "Landroid/view/View;", "userDetailsValidation", "", "userStatus", "app_debug"})
public final class LoginActivity extends androidx.appcompat.app.AppCompatActivity {
    private final kotlin.Lazy userPrefsRepository$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    private final tech.danielwaiguru.estudy.repositories.UserPrefsRepository getUserPrefsRepository() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final boolean userDetailsValidation() {
        return false;
    }
    
    private final void initUi() {
    }
    
    /**
     * checking remember me checkbox state and updating user shared preferences isloggedIn status
     * accordingly
     */
    private final void onRememberMeCheckBoxChecked(android.view.View view) {
    }
    
    /**
     * Get user IsloggedIn status
     */
    private final void userStatus() {
    }
    
    public LoginActivity() {
        super();
    }
}