package org.ortynskyi.hobbyfun.utils;

import android.support.annotation.NonNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class DateUtils {

    private static final String TAG = "DateUtils";

    public static final String DEFAULT_INPUT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final String DEFAULT_OUTPUT_DATE_FORMAT = "dd MMM HH.mm";
    public static final String DEFAULT_TIME_FORMAT = "HH:mm";

    private DateUtils() {}

    @NonNull
    public static String convertDate(@NonNull final String date,
                                     @NonNull final String inputPattern,
                                     @NonNull final String outputPattern) {
        String formatted = "";
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new SimpleDateFormat(inputPattern, Locale.getDefault()).parse(date));
            formatted = new SimpleDateFormat(outputPattern, Locale.getDefault()).format(calendar.getTime());
        } catch (ParseException e) {
            Logger.e(TAG, "Invalid input or output pattern on convertDate: " + e.getLocalizedMessage());
        }
        return formatted;
    }

    @NonNull
    public static String dateToString(@NonNull final Date date, @NonNull final String dateFormat) {
        return new SimpleDateFormat(dateFormat, Locale.getDefault()).format(date);
    }

    @NonNull
    public static Date stringToDate(@NonNull final String date, @NonNull final String dateFormat) {
        Date parsedDate;
        try {
            parsedDate = new SimpleDateFormat(dateFormat, Locale.getDefault()).parse(date);
        } catch (ParseException e) {
            throw new IllegalStateException("Date parse exception: " + e.getLocalizedMessage());
        }
        return parsedDate;
    }

    @NonNull
    public static String convertToMinutes(final long millis) {
        final long seconds = millis / 1000;
        final long minutes = seconds / 60;
        if (minutes >= 60) {
            final long hours = minutes / 60;
            return String.format(Locale.getDefault(), "%s%s", hours, "h");
        } else {
            return String.format(Locale.getDefault(), "%s%s", minutes, "m");
        }
    }

    public static boolean isToday(@NonNull final Date date) {
        final Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        final Date todayDate = calendar.getTime();
        return todayDate.before(date);
    }
}