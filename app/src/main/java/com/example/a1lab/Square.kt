package com.example.a1lab

import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.FloatBuffer
import javax.microedition.khronos.opengles.GL10


class Square {
    private val vertexBuffer // Buffer for vertex-array
            : FloatBuffer
    private val vertices = floatArrayOf( // Vertices for the Square
        -1.0f, -1.0f, 0.0f,  // 0. left-bottom
        1.0f, -1.0f, 0.0f,  // 1. right-bottom
        -1.0f, 1.0f, 0.0f,  // 2. left-top
        1.0f, 1.0f, 0.0f // 3. right-top
    )

    init {
        val byteBuf = ByteBuffer.allocateDirect(vertices.size * 4)
        byteBuf.order(ByteOrder.nativeOrder())
        vertexBuffer = byteBuf.asFloatBuffer()
        vertexBuffer.put(vertices)
        vertexBuffer.position(0)
    }

    fun draw(gl: GL10) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY)
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer)
        gl.glEnable(GL10.GL_BLEND)
        gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA)
        gl.glColor4f(0.9f, 0.7f, 0.7f, 0.9f)
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, vertices.size / 3)
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY)
        gl.glDisable(GL10.GL_BLEND)
    }
}