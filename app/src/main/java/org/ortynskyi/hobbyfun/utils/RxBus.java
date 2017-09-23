package org.ortynskyi.hobbyfun.utils;

import rx.Observable;
import rx.subjects.PublishSubject;

public final class RxBus {

    private static final RxBus INSTANCE = new RxBus();

    private final PublishSubject<Object> subject = PublishSubject.create();

    private RxBus() {}

    public static RxBus getInstance() {
        return INSTANCE;
    }

    /**
     * Pass any event down to event listeners.
     */
    public void setEvent(Object object) {
        subject.onNext(object);
    }

    /**
     * Subscribe to this Observable. On event, do something
     * e.g. replace a fragment
     */
    public Observable<Object> getEvents() {
        return subject;
    }
}