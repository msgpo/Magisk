package com.topjohnwu.magisk.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.topjohnwu.magisk.utils.Utils;

/**
 * Receiver for click events on the custom M Quick Settings tile
 */
public final class PrivateBroadcastReceiver extends BroadcastReceiver {
    public static final String ACTION_AUTOROOT = "com.topjohnwu.magisk.CUSTOMTILE_ACTION_AUTOROOT";
    public static final String ACTION_DISABLEROOT = "com.topjohnwu.magisk.CUSTOMTILE_ACTION_DISABLEROOT";
    public static final String ACTION_ENABLEROOT = "com.topjohnwu.magisk.CUSTOMTILE_ACTION_ENABLEROOT";


    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();

        if (ACTION_AUTOROOT.equals(action)) {
            Utils.toggleAutoRoot(true, context);
        }
        if (ACTION_ENABLEROOT.equals(action)) {
            Utils.toggleAutoRoot(false, context);
            Utils.toggleRoot(true);
        }
        if (ACTION_DISABLEROOT.equals(action)) {
            Utils.toggleRoot(false);
        }

        Utils.SetupQuickSettingsTile(context);
    }
}