package com.aaliezl.master.tetris.logic.untils

import android.app.Application
import android.media.AudioManager
import android.media.SoundPool
import com.aaliezl.master.tetris.R

object SoundUtil {
    private lateinit var _context: Application
    private val sp: SoundPool by lazy {
        SoundPool.Builder().setMaxStreams(4).setMaxStreams(AudioManager.STREAM_MUSIC).build()
    }
    private val _map = mutableMapOf<SoundType, Int>()

    fun init(application: Application) {
        _context = application
        Sounds.forEach {
            _map[it] = sp.load(_context, it.res, 1)
        }
    }

    fun release() {
        sp.release()
    }

    fun play(isMute: Boolean, sound: SoundType) {
        if (!isMute) {
            sp.play(requireNotNull(_map[sound]), 1f, 1f, 0, 0, 1f)
        }
    }
}

sealed class SoundType(val res: Int) {
    object Move : SoundType(R.raw.move)
    object Rotate : SoundType(R.raw.rotate)
    object Start : SoundType(R.raw.start)
    object Drop : SoundType(R.raw.drop)
    object Clean : SoundType(R.raw.clean)
}

val Sounds =
    listOf(SoundType.Move, SoundType.Rotate, SoundType.Start, SoundType.Drop, SoundType.Clean)