package tech.danielwaiguru.estudy;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\u0012\u0010\u0019\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006$"}, d2 = {"Ltech/danielwaiguru/estudy/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Ltech/danielwaiguru/estudy/adapters/MonsterAdapter$MonsterItemClickListener;", "()V", "monsterAdapter", "Ltech/danielwaiguru/estudy/adapters/MonsterAdapter;", "getMonsterAdapter", "()Ltech/danielwaiguru/estudy/adapters/MonsterAdapter;", "monsterAdapter$delegate", "Lkotlin/Lazy;", "monsterViewModel", "Ltech/danielwaiguru/estudy/viewmodels/MonsterViewModel;", "getMonsterViewModel", "()Ltech/danielwaiguru/estudy/viewmodels/MonsterViewModel;", "monsterViewModel$delegate", "userPrefsRepository", "Ltech/danielwaiguru/estudy/repositories/UserPrefsRepository;", "getUserPrefsRepository", "()Ltech/danielwaiguru/estudy/repositories/UserPrefsRepository;", "userPrefsRepository$delegate", "initDetailsActivity", "", "monster", "Ltech/danielwaiguru/estudy/models/Monster;", "logoutUser", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onMonsterItemClicked", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity implements tech.danielwaiguru.estudy.adapters.MonsterAdapter.MonsterItemClickListener {
    private final kotlin.Lazy monsterViewModel$delegate = null;
    private final kotlin.Lazy userPrefsRepository$delegate = null;
    private final kotlin.Lazy monsterAdapter$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    private final tech.danielwaiguru.estudy.viewmodels.MonsterViewModel getMonsterViewModel() {
        return null;
    }
    
    private final tech.danielwaiguru.estudy.repositories.UserPrefsRepository getUserPrefsRepository() {
        return null;
    }
    
    private final tech.danielwaiguru.estudy.adapters.MonsterAdapter getMonsterAdapter() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.Nullable()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    private final void logoutUser() {
    }
    
    @java.lang.Override()
    public void onMonsterItemClicked(@org.jetbrains.annotations.NotNull()
    tech.danielwaiguru.estudy.models.Monster monster) {
    }
    
    private final void initDetailsActivity(tech.danielwaiguru.estudy.models.Monster monster) {
    }
    
    public MainActivity() {
        super();
    }
}