/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.cellbroadcastreceiver;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

/**
 * The back-end data adapter for {@link CellBroadcastListActivity}.
 */
public class CellBroadcastListAdapter extends CursorAdapter {
    private static final String TAG = "CellBroadcastListAdapter";

    public CellBroadcastListAdapter(Context context, Cursor cursor) {
        super(context, cursor, true);
    }

    /**
     * Makes a new view to hold the data pointed to by cursor.
     * @param context Interface to application's global information
     * @param cursor The cursor from which to get the data. The cursor is already
     * moved to the correct position.
     * @param parent The parent to which the new view is attached to
     * @return the newly created view.
     */
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        BroadcastMessage message = BroadcastMessage.createFromCursor(cursor);

        LayoutInflater factory = LayoutInflater.from(context);
        CellBroadcastListItem listItem = (CellBroadcastListItem) factory.inflate(
                    R.layout.cell_broadcast_list_item, parent, false);

        listItem.bind(message);
        return listItem;
    }

    /**
     * Bind an existing view to the data pointed to by cursor
     * @param view Existing view, returned earlier by newView
     * @param context Interface to application's global information
     * @param cursor The cursor from which to get the data. The cursor is already
     * moved to the correct position.
     */
    public void bindView(View view, Context context, Cursor cursor) {
        BroadcastMessage message = BroadcastMessage.createFromCursor(cursor);
        CellBroadcastListItem listItem = (CellBroadcastListItem) view;
        listItem.bind(message);
    }
}
