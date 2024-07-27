import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.os.IBinder;

public class VolumeChanger extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onStartCommand(Intent intent, int flags, int startId) {
        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int targetVolume = (int) (maxVolume * 0.7);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, targetVolume, 0);
        stopSelf();
    }
}
