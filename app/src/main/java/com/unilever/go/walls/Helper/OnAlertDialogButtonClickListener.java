package com.unilever.go.walls.Helper;

import android.app.AlertDialog;
import android.view.View;

public interface OnAlertDialogButtonClickListener {
	public void onButtonClick(AlertDialog alertDialog, View v, int which, int popupId);
}