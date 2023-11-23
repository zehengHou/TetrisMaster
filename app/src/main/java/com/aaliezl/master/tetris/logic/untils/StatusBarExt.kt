package com.aaliezl.master.tetris.logic.untils

import android.app.Activity
import android.graphics.Color
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

private const val TAG = "StatusBarExt"

/**
 * Makes the status bar of the activity immersive.
 */
fun Activity.immersiveStatusBar() {
    // Set window to not fit system windows
    WindowCompat.setDecorFitsSystemWindows(window, false)

    // Get the controller for system bars
    val controller = WindowCompat.getInsetsController(window, window.decorView)
    controller.apply {
        // Set behavior to show transient bars by swipe
        systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

        // Set the status bar color to transparent
        window.statusBarColor = Color.TRANSPARENT

        // Hide the navigation bars
        hide(WindowInsetsCompat.Type.navigationBars())
    }
}

/**
 * Updates the top margin of the navigation container to accommodate the status bar height.
 */
fun Activity.updateNavContainerTopMargin() {
    ViewCompat.setOnApplyWindowInsetsListener(window.decorView) { _, insets ->
        // Get the insets for the status bar
        val statusBarHeight = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top
        logInfo(TAG, "statusBarHeight = $statusBarHeight")
        insets
    }
}
