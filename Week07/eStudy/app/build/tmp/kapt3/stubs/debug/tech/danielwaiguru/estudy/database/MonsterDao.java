package tech.danielwaiguru.estudy.database;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u001f\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Ltech/danielwaiguru/estudy/database/MonsterDao;", "", "getAllMonsters", "", "Ltech/danielwaiguru/estudy/models/Monster;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertMonster", "", "monster", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface MonsterDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert()
    public abstract java.lang.Object insertMonster(@org.jetbrains.annotations.NotNull()
    java.util.List<tech.danielwaiguru.estudy.models.Monster> monster, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM monsters")
    public abstract java.lang.Object getAllMonsters(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<tech.danielwaiguru.estudy.models.Monster>> p0);
}