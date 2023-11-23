@file:Suppress("unused", "UnusedReceiverParameter")

package com.aaliezl.master.tetris.logic.untils

import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy

fun logInit(tag: String? = null) {
    Logger.addLogAdapter(
        AndroidLogAdapter(
            PrettyFormatStrategy.newBuilder()
                .tag(tag)
                .build()
        )
    )
    // 需要申请权限
    // Logger.addLogAdapter(DiskLogAdapter())
}

// 信息级别日志
fun Any.logInfo(tag: String? = null, message: String) {
    if (tag.isNullOrEmpty()) {
        Logger.i("${this::class.java.simpleName}: $message")
    } else {
        Logger.t(tag).i(message)
    }
}

// 调试级别日志
fun Any.logDebug(tag: String? = null, message: String) {
    if (tag.isNullOrEmpty()) {
        Logger.d("${this::class.java.simpleName}: $message")
    } else {
        Logger.t(tag).d(message)
    }
}

// 警告级别日志
fun Any.logWarning(tag: String? = null, message: String) {
    if (tag.isNullOrEmpty()) {
        Logger.w("${this::class.java.simpleName}: $message")
    } else {
        Logger.t(tag).w(message)
    }
}

// 错误级别日志
fun Any.logError(tag: String? = null, message: String, throwable: Throwable? = null) {
    if (tag.isNullOrEmpty()) {
        if (throwable != null) {
            Logger.e(throwable, "${this::class.java.simpleName}: $message")
        } else {
            Logger.e("${this::class.java.simpleName}: $message")
        }
    } else {
        if (throwable != null) {
            Logger.t(tag).e(throwable, message)
        } else {
            Logger.t(tag).e(message)
        }
    }
}

// 详细信息级别日志
fun Any.logVerbose(tag: String? = null, message: String) {
    if (tag.isNullOrEmpty()) {
        Logger.v("${this::class.java.simpleName}: $message")
    } else {
        Logger.t(tag).v(message)
    }
}

// JSON内容日志
fun Any.logJson(tag: String? = null, json: String) {
    if (tag.isNullOrEmpty()) {
        Logger.json(json)
    } else {
        Logger.t(tag).json(json)
    }
}

// XML内容日志
fun Any.logXml(tag: String? = null, xml: String) {
    if (tag.isNullOrEmpty()) {
        Logger.xml(xml)
    } else {
        Logger.t(tag).xml(xml)
    }
}