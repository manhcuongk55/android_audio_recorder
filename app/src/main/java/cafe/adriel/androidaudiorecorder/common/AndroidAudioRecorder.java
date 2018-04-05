package cafe.adriel.androidaudiorecorder.common;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Environment;
import android.support.v4.app.Fragment;

import cafe.adriel.androidaudiorecorder.activity.AudioRecorderActivity;
import cafe.adriel.androidaudiorecorder.model.AudioChannel;
import cafe.adriel.androidaudiorecorder.model.AudioSampleRate;
import cafe.adriel.androidaudiorecorder.model.AudioSource;

public class AndroidAudioRecorder {

    public static final String EXTRA_FILE_PATH = "filePath";
    public static final String EXTRA_COLOR = "color";
    public static final String EXTRA_SOURCE = "source";
    public static final String EXTRA_CHANNEL = "channel";
    public static final String EXTRA_SAMPLE_RATE = "sampleRate";
    public static final String EXTRA_AUTO_START = "autoStart";
    public static final String EXTRA_KEEP_DISPLAY_ON = "keepDisplayOn";

    private Activity activity;
    private Fragment fragment;

    private String filePath = Environment.getExternalStorageDirectory() + "/recorded_audio.wav";
    private AudioSource source = AudioSource.MIC;
    private AudioChannel channel = AudioChannel.STEREO;
    private AudioSampleRate sampleRate = AudioSampleRate.HZ_44100;
    private int color = Color.parseColor("#546E7A");
    private int requestCode = 0;
    private boolean autoStart = false;
    private boolean keepDisplayOn = false;
    public static String tvSub;
    public AndroidAudioRecorder(Activity activity) {
        this.activity = activity;
    }

    private AndroidAudioRecorder(Fragment fragment) {
        this.fragment = fragment;
    }


    public static AndroidAudioRecorder with(Fragment fragment) {
        return new AndroidAudioRecorder(fragment);
    }

    public AndroidAudioRecorder setFilePath(String filePath) {
        this.filePath = filePath;
        return this;
    }
    public AndroidAudioRecorder setSub(String sub){
        this.tvSub = sub;
        return this;
    }
    public static String getTvSub(){
        return tvSub;
    }
    public AndroidAudioRecorder setColor(int color) {
        this.color = color;
        return this;
    }

    public AndroidAudioRecorder setRequestCode(int requestCode) {
        this.requestCode = requestCode;
        return this;
    }

    public AndroidAudioRecorder setSource(AudioSource source) {
        this.source = source;
        return this;
    }

    public AndroidAudioRecorder setChannel(AudioChannel channel) {
        this.channel = channel;
        return this;
    }

    public AndroidAudioRecorder setSampleRate(AudioSampleRate sampleRate) {
        this.sampleRate = sampleRate;
        return this;
    }

    public AndroidAudioRecorder setAutoStart(boolean autoStart) {
        this.autoStart = autoStart;
        return this;
    }

    public AndroidAudioRecorder setKeepDisplayOn(boolean keepDisplayOn) {
        this.keepDisplayOn = keepDisplayOn;
        return this;
    }

    public void record() {
        Intent intent = new Intent(activity, AudioRecorderActivity.class);
        intent.putExtra(EXTRA_FILE_PATH, filePath);
        intent.putExtra(EXTRA_COLOR, color);
        intent.putExtra(EXTRA_SOURCE, source);
        intent.putExtra(EXTRA_CHANNEL, channel);
        intent.putExtra(EXTRA_SAMPLE_RATE, sampleRate);
        intent.putExtra(EXTRA_AUTO_START, autoStart);
        intent.putExtra(EXTRA_KEEP_DISPLAY_ON, keepDisplayOn);
        activity.startActivityForResult(intent, requestCode);
    }

    public void recordFromFragment() {
        Intent intent = new Intent(fragment.getActivity(), AudioRecorderActivity.class);
        intent.putExtra(EXTRA_FILE_PATH, filePath);
        intent.putExtra(EXTRA_COLOR, color);
        intent.putExtra(EXTRA_SOURCE, source);
        intent.putExtra(EXTRA_CHANNEL, channel);
        intent.putExtra(EXTRA_SAMPLE_RATE, sampleRate);
        intent.putExtra(EXTRA_AUTO_START, autoStart);
        intent.putExtra(EXTRA_KEEP_DISPLAY_ON, keepDisplayOn);
        fragment.startActivityForResult(intent, requestCode);
    }

}
