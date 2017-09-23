package org.ortynskyi.hobbyfun.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

/**
 * Utils Class used for navigation between activities
 */
public final class Navigator {

    private Navigator() {}

    public static void navigateTo(@NonNull Context context, @NonNull Class className, Bundle bundle) {
        Intent intent = new Intent(context, className);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public static void navigateTo(@NonNull Context context, @NonNull Class className) {
        Intent intent = new Intent(context, className);
        context.startActivity(intent);
    }
}