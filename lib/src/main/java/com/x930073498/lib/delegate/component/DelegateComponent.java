package com.x930073498.lib.delegate.component;

public interface DelegateComponent {
    <P> void addListener(Event<P> event, Listener<P> listener);

    <P> void removeListener(Listener<P> listener);
}
