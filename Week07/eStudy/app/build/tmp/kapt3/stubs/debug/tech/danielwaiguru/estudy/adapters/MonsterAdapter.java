package tech.danielwaiguru.estudy.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0015\u0016B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u001b\u0010\u0013\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0000\u00a2\u0006\u0002\b\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Ltech/danielwaiguru/estudy/adapters/MonsterAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ltech/danielwaiguru/estudy/adapters/MonsterAdapter$MonsterViewHolder;", "listener", "Ltech/danielwaiguru/estudy/adapters/MonsterAdapter$MonsterItemClickListener;", "(Ltech/danielwaiguru/estudy/adapters/MonsterAdapter$MonsterItemClickListener;)V", "monsters", "", "Ltech/danielwaiguru/estudy/models/Monster;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "setData$app_debug", "MonsterItemClickListener", "MonsterViewHolder", "app_debug"})
public final class MonsterAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<tech.danielwaiguru.estudy.adapters.MonsterAdapter.MonsterViewHolder> {
    private java.util.List<tech.danielwaiguru.estudy.models.Monster> monsters;
    private final tech.danielwaiguru.estudy.adapters.MonsterAdapter.MonsterItemClickListener listener = null;
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public tech.danielwaiguru.estudy.adapters.MonsterAdapter.MonsterViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    tech.danielwaiguru.estudy.adapters.MonsterAdapter.MonsterViewHolder holder, int position) {
    }
    
    public final void setData$app_debug(@org.jetbrains.annotations.NotNull()
    java.util.List<tech.danielwaiguru.estudy.models.Monster> monsters) {
    }
    
    public MonsterAdapter(@org.jetbrains.annotations.NotNull()
    tech.danielwaiguru.estudy.adapters.MonsterAdapter.MonsterItemClickListener listener) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0013"}, d2 = {"Ltech/danielwaiguru/estudy/adapters/MonsterAdapter$MonsterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Ltech/danielwaiguru/estudy/adapters/MonsterAdapter;Landroid/view/View;)V", "monsterCaption", "Landroid/widget/TextView;", "getMonsterCaption", "()Landroid/widget/TextView;", "monsterImage", "Landroid/widget/ImageView;", "getMonsterImage", "()Landroid/widget/ImageView;", "monsterName", "getMonsterName", "rating", "Landroid/widget/RatingBar;", "getRating", "()Landroid/widget/RatingBar;", "app_debug"})
    public final class MonsterViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView monsterImage = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView monsterName = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView monsterCaption = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.RatingBar rating = null;
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getMonsterImage() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getMonsterName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getMonsterCaption() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.RatingBar getRating() {
            return null;
        }
        
        public MonsterViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Ltech/danielwaiguru/estudy/adapters/MonsterAdapter$MonsterItemClickListener;", "", "onMonsterItemClicked", "", "monster", "Ltech/danielwaiguru/estudy/models/Monster;", "app_debug"})
    public static abstract interface MonsterItemClickListener {
        
        public abstract void onMonsterItemClicked(@org.jetbrains.annotations.NotNull()
        tech.danielwaiguru.estudy.models.Monster monster);
    }
}