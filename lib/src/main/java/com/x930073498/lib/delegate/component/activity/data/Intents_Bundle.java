package com.x930073498.lib.delegate.component.activity.data;

import android.content.Intent;
import android.os.Bundle;

public class Intents_Bundle {
    public Intent[] intents;

    public Bundle options;

    public Intents_Bundle(Intent[] intents, Bundle options) {
        this.intents = intents;
        this.options = options;
    }
}
