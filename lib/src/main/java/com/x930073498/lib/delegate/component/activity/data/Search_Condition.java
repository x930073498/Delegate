package com.x930073498.lib.delegate.component.activity.data;

import android.os.Bundle;
import android.support.annotation.Nullable;

public class Search_Condition {
    public String initialQuery;
    public boolean selectInitialQuery;
    public Bundle appSearchData;
    public boolean globalSearch;

    public Search_Condition(String initialQuery, boolean selectInitialQuery, Bundle appSearchData, boolean globalSearch) {
        this.initialQuery = initialQuery;
        this.selectInitialQuery = selectInitialQuery;
        this.appSearchData = appSearchData;
        this.globalSearch = globalSearch;
    }
}
