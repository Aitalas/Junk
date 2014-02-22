package junk.main;

import javafx.scene.media.AudioSpectrumListener;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class JunkMediaPlayer implements AudioSpectrumListener {
	Media media;
	MediaPlayer mediaPlayer;
	MediaView mediaView;
	
	double timestamp, duration;
	float[] magnitudes, phases;
	
	public JunkMediaPlayer() {
		media = new Media(JunkMain.MUSIC_SOURCE);
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAudioSpectrumListener(this);
		mediaPlayer.setAutoPlay(false);
		mediaView = new MediaView(mediaPlayer);
	}

	
	
	public Media getMedia() {
		return media;
	}
	
	public MediaPlayer getMediaPlayer() {
		return mediaPlayer;
	}
	
	public MediaView getMediaView() {
		return mediaView;
	}
	
	@Override
	public void spectrumDataUpdate(double timestamp, double duration,
			float[] magnitudes, float[] phases) {
		this.timestamp = timestamp;
		this.duration = duration;
		this.magnitudes = magnitudes;
		this.phases = phases;
	}
	
	
}
