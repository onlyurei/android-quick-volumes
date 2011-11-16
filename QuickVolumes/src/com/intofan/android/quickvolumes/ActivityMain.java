package com.intofan.android.quickvolumes;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class ActivityMain extends Activity {

	private AudioManager audioManager;

	RadioButton radioButtonRingerModeNormal;
	RadioButton radioButtonRingerModeVibrate;
	RadioButton radioButtonRingerModeSilent;
	SeekBar seekBarRingerVolume;
	SeekBar seekBarNotificationVolume;
	SeekBar seekBarSystemVolume;
	SeekBar seekBarAlarmVolume;
	SeekBar seekBarMediaVolume;
	SeekBar seekBarVoiceCallVolume;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		audioManager = (AudioManager) getApplicationContext().getSystemService(
				AUDIO_SERVICE);

		radioButtonRingerModeNormal = (RadioButton) findViewById(R.id.radiobutton_ringer_mode_normal);
		radioButtonRingerModeVibrate = (RadioButton) findViewById(R.id.radiobutton_ringer_mode_vibrate);
		radioButtonRingerModeSilent = (RadioButton) findViewById(R.id.radiobutton_ringer_mode_silent);
		seekBarRingerVolume = (SeekBar) findViewById(R.id.seekbar_ringer_volume);
		seekBarNotificationVolume = (SeekBar) findViewById(R.id.seekbar_notification_volume);
		seekBarSystemVolume = (SeekBar) findViewById(R.id.seekbar_system_volume);
		seekBarAlarmVolume = (SeekBar) findViewById(R.id.seekbar_alarm_volume);
		seekBarMediaVolume = (SeekBar) findViewById(R.id.seekbar_media_volume);
		seekBarVoiceCallVolume = (SeekBar) findViewById(R.id.seekbar_voice_call_volume);

		radioButtonRingerModeNormal.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
				seekBarRingerVolume.setEnabled(true);
				seekBarNotificationVolume.setEnabled(true);
				seekBarSystemVolume.setEnabled(true);
				seekBarRingerVolume.setProgress(audioManager
						.getStreamVolume(AudioManager.STREAM_RING));
				seekBarNotificationVolume.setProgress(audioManager
						.getStreamVolume(AudioManager.STREAM_NOTIFICATION));
				seekBarSystemVolume.setProgress(audioManager
						.getStreamVolume(AudioManager.STREAM_SYSTEM));
			}
		});
		radioButtonRingerModeVibrate.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
				seekBarRingerVolume.setEnabled(false);
				seekBarNotificationVolume.setEnabled(false);
				seekBarSystemVolume.setEnabled(false);
				seekBarRingerVolume.setProgress(audioManager
						.getStreamVolume(AudioManager.STREAM_RING));
				seekBarNotificationVolume.setProgress(audioManager
						.getStreamVolume(AudioManager.STREAM_NOTIFICATION));
				seekBarSystemVolume.setProgress(audioManager
						.getStreamVolume(AudioManager.STREAM_SYSTEM));
			}
		});
		radioButtonRingerModeSilent.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
				seekBarRingerVolume.setEnabled(false);
				seekBarNotificationVolume.setEnabled(false);
				seekBarSystemVolume.setEnabled(false);
				seekBarRingerVolume.setProgress(audioManager
						.getStreamVolume(AudioManager.STREAM_RING));
				seekBarNotificationVolume.setProgress(audioManager
						.getStreamVolume(AudioManager.STREAM_NOTIFICATION));
				seekBarSystemVolume.setProgress(audioManager
						.getStreamVolume(AudioManager.STREAM_SYSTEM));
			}
		});

		seekBarRingerVolume.setMax(audioManager
				.getStreamMaxVolume(AudioManager.STREAM_RING));
		seekBarNotificationVolume.setMax(audioManager
				.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION));
		seekBarSystemVolume.setMax(audioManager
				.getStreamMaxVolume(AudioManager.STREAM_SYSTEM));
		seekBarAlarmVolume.setMax(audioManager
				.getStreamMaxVolume(AudioManager.STREAM_ALARM));
		seekBarMediaVolume.setMax(audioManager
				.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
		seekBarVoiceCallVolume.setMax(audioManager
				.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL));

		seekBarRingerVolume
				.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
					public void onProgressChanged(SeekBar seekBar,
							int progress, boolean fromUser) {
						audioManager.setStreamVolume(AudioManager.STREAM_RING,
								progress, 0);
					}

					public void onStartTrackingTouch(SeekBar seekBar) {
					}

					public void onStopTrackingTouch(SeekBar seekBar) {
					}
				});
		seekBarNotificationVolume
				.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
					public void onProgressChanged(SeekBar seekBar,
							int progress, boolean fromUser) {
						audioManager.setStreamVolume(
								AudioManager.STREAM_NOTIFICATION, progress, 0);
					}

					public void onStartTrackingTouch(SeekBar seekBar) {
					}

					public void onStopTrackingTouch(SeekBar seekBar) {
					}
				});
		seekBarSystemVolume
				.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
					public void onProgressChanged(SeekBar seekBar,
							int progress, boolean fromUser) {
						audioManager.setStreamVolume(
								AudioManager.STREAM_SYSTEM, progress, 0);
					}

					public void onStartTrackingTouch(SeekBar seekBar) {
					}

					public void onStopTrackingTouch(SeekBar seekBar) {
					}
				});
		seekBarAlarmVolume
				.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
					public void onProgressChanged(SeekBar seekBar,
							int progress, boolean fromUser) {
						audioManager.setStreamVolume(AudioManager.STREAM_ALARM,
								progress, 0);
					}

					public void onStartTrackingTouch(SeekBar seekBar) {
					}

					public void onStopTrackingTouch(SeekBar seekBar) {
					}
				});
		seekBarMediaVolume
				.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
					public void onProgressChanged(SeekBar seekBar,
							int progress, boolean fromUser) {
						audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
								progress, 0);
					}

					public void onStartTrackingTouch(SeekBar seekBar) {
					}

					public void onStopTrackingTouch(SeekBar seekBar) {
					}
				});
		seekBarVoiceCallVolume
				.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
					public void onProgressChanged(SeekBar seekBar,
							int progress, boolean fromUser) {
						audioManager.setStreamVolume(
								AudioManager.STREAM_VOICE_CALL, progress, 0);
					}

					public void onStartTrackingTouch(SeekBar seekBar) {
					}

					public void onStopTrackingTouch(SeekBar seekBar) {
					}
				});
	}

	@Override
	public void onResume() {
		super.onResume();
		refresh();
	}

	private void refresh() {
		int ringerMode = audioManager.getRingerMode();
		switch (ringerMode) {
		case AudioManager.RINGER_MODE_NORMAL:
			radioButtonRingerModeNormal.setChecked(true);
			break;
		case AudioManager.RINGER_MODE_VIBRATE:
			radioButtonRingerModeVibrate.setChecked(true);
			break;
		case AudioManager.RINGER_MODE_SILENT:
			radioButtonRingerModeSilent.setChecked(true);
			break;
		}
		if (ringerMode == AudioManager.RINGER_MODE_NORMAL) {
			seekBarRingerVolume.setEnabled(true);
			seekBarNotificationVolume.setEnabled(true);
			seekBarSystemVolume.setEnabled(true);
		} else if (ringerMode == AudioManager.RINGER_MODE_VIBRATE
				|| ringerMode == AudioManager.RINGER_MODE_SILENT) {
			seekBarRingerVolume.setEnabled(false);
			seekBarNotificationVolume.setEnabled(false);
			seekBarSystemVolume.setEnabled(false);
		}
		seekBarRingerVolume.setProgress(audioManager
				.getStreamVolume(AudioManager.STREAM_RING));
		seekBarNotificationVolume.setProgress(audioManager
				.getStreamVolume(AudioManager.STREAM_NOTIFICATION));
		seekBarSystemVolume.setProgress(audioManager
				.getStreamVolume(AudioManager.STREAM_SYSTEM));
		seekBarAlarmVolume.setProgress(audioManager
				.getStreamVolume(AudioManager.STREAM_ALARM));
		seekBarMediaVolume.setProgress(audioManager
				.getStreamVolume(AudioManager.STREAM_MUSIC));
		seekBarVoiceCallVolume.setProgress(audioManager
				.getStreamVolume(AudioManager.STREAM_VOICE_CALL));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_options_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_settings:
			refresh();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}