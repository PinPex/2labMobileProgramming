package com.example.a1lab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.a1lab.ui.theme._1labTheme

import android.app.Activity
import android.opengl.GLSurfaceView
import android.view.WindowManager

class MainActivity : Activity() {
    private var g: GLSurfaceView? = null
    protected override fun onCreate(savedInstanceState: Bundle?) {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        super.onCreate(savedInstanceState)
        g = GLSurfaceView(this)
        g!!.setEGLConfigChooser(8, 8, 8, 8, 16, 1)
        g!!.setRenderer(MyRenderer(this))
        g!!.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY)
        setContentView(g)
    }

    protected override fun onPause() {
        super.onPause()
        g?.onPause()
    }

    protected override fun onResume() {
        super.onResume()
        g?.onResume()
    }
}