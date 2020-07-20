package tech.danielwaiguru.estudy.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Ltech/danielwaiguru/estudy/viewmodels/MonsterViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "allMonsters", "Landroidx/lifecycle/MutableLiveData;", "", "Ltech/danielwaiguru/estudy/models/Monster;", "getAllMonsters", "()Landroidx/lifecycle/MutableLiveData;", "monsterRepository", "Ltech/danielwaiguru/estudy/repositories/MonsterRepository;", "refreshData", "", "app_debug"})
public final class MonsterViewModel extends androidx.lifecycle.AndroidViewModel {
    private final tech.danielwaiguru.estudy.repositories.MonsterRepository monsterRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<tech.danielwaiguru.estudy.models.Monster>> allMonsters = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<tech.danielwaiguru.estudy.models.Monster>> getAllMonsters() {
        return null;
    }
    
    public final void refreshData() {
    }
    
    public MonsterViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
}