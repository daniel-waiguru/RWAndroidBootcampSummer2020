package tech.danielwaiguru.moviesapp.adapters

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.abs

class LazyLoadingListener(
    private inline val onLastItemReached: () -> Unit
) : RecyclerView.OnScrollListener(){
    private val threshold = 30
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        val manager = recyclerView.layoutManager as GridLayoutManager
        if (abs(dy) > threshold && hasReachedEnd(manager, recyclerView)){
            onLastItemReached()
        }
    }

    private fun hasReachedEnd(manager: GridLayoutManager?, recyclerView: RecyclerView): Boolean {
        val adapter = recyclerView.adapter
        if (manager != null && adapter != null){
            val position = manager.findLastVisibleItemPosition()
            val numItems = adapter.itemCount
            return position >= numItems -5
        }
        return false
    }
}