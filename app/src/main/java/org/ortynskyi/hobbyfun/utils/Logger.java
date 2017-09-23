package org.ortynskyi.hobbyfun.utils;

import android.util.Log;

import org.ortynskyi.hobbyfun.BuildConfig;

/**
 * Logger used to get control over default android logging system
 * by wrapping each method into condition with boolean #DEBUG field
 */
public final class Logger {

    private static final String TAG = "Logger";
    private static final boolean DEBUG = BuildConfig.DEBUG;

    private Logger() {}

    public static void d(String log) {
        if (DEBUG) {
            Log.d(TAG, log);
        }
    }

    public static void e(String log) {
        if (DEBUG) {
            Log.e(TAG, log);
        }
    }

    public static void i(String log) {
        if (DEBUG) {
            Log.i(TAG, log);
        }
    }

    public static void d(String tag, String log) {
        if (DEBUG) {
            Log.d(tag, log);
        }
    }

    public static void e(String tag, String log) {
        if (DEBUG) {
            Log.e(tag, log);
        }
    }

    public static void e(String tag, String log, Throwable t) {
        if (DEBUG) {
            Log.e(tag, log, t);
        }
    }

    public static void i(String tag, String log) {
        if (DEBUG) {
            Log.i(tag, log);
        }
    }
}