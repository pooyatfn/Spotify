package com.example.potify

import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.potify.databinding.FragmentPlayerBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.io.IOException

class PlayerFragment : Fragment() {

    private var binding: FragmentPlayerBinding? = null
    private var mediaPlayer: MediaPlayer? = null
    private var seekBar: SeekBar? = null
    private var audioUrl: String? = null
    private var bottomNav: BottomNavigationView? = null
    private var isRepeat: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        bottomNav = requireActivity().findViewById(R.id.bottomNavigationView)
        bottomNav?.visibility = View.GONE

        binding = FragmentPlayerBinding.inflate(inflater, container, false)

        val songTitle = arguments?.getString("song_title")
        val artistName = arguments?.getString("artist_name")
        val imageUrl = arguments?.getString("image_url")
        audioUrl = arguments?.getString("song_url")

        binding!!.apply {
            Glide.with(root).load(imageUrl).into(image)
            artistNameTextView.text = artistName
            songTitleTextView.text = songTitle
            seekBar = seekbar

            var isShuffle = true
            shuffleImageView.setOnClickListener {
                isShuffle = if (isShuffle) {
                    shuffleImageView.setImageResource(R.drawable.ic_shuffle_fill)
                    false
                } else {
                    shuffleImageView.setImageResource(R.drawable.ic_shuffle)
                    true
                }
            }

            repeatImageView.setOnClickListener {
                isRepeat = if (isRepeat) {
                    repeatImageView.setImageResource(R.drawable.ic_repeat)
                    false
                } else {
                    repeatImageView.setImageResource(R.drawable.ic_repeat_fill)
                    true
                }
            }

            var isLike = false
            likeImageView.setOnClickListener {
                isLike = if (isLike) {
                    likeImageView.setImageResource(R.drawable.ic_like)
                    false
                } else {
                    likeImageView.setImageResource(R.drawable.ic_like_fill)
                    true
                }
            }
        }

        // Initialize MediaPlayer
        mediaPlayer = MediaPlayer()
        mediaPlayer?.setAudioStreamType(AudioManager.STREAM_MUSIC)

        // Initialize SeekBar
        seekBar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer?.seekTo(progress)
                }
                updateStartEndTime()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Do nothing
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Do nothing
            }
        })

        playAudio()

        binding!!.playPauseIcon.setOnClickListener { playPauseAudio() }

        binding!!.backImageView.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding!!.root
    }

    private fun playAudio() {
        try {
            mediaPlayer?.setDataSource(audioUrl)
            mediaPlayer?.prepare()
            mediaPlayer?.start()

            // Set max value of SeekBar to the duration of the audio file
            seekBar?.max = mediaPlayer?.duration ?: 0

            // Update SeekBar progress every 100 milliseconds
            Handler().postDelayed(object : Runnable {
                override fun run() {
                    seekBar?.progress = mediaPlayer?.currentPosition ?: 0
                    Handler().postDelayed(this, 100)
                }
            }, 100)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun playPauseAudio() {
        if (mediaPlayer?.isPlaying == true) {
            mediaPlayer?.pause()
            binding!!.playPauseIcon.setImageResource(R.drawable.ic_play)
        } else {
            mediaPlayer?.start()
            binding!!.playPauseIcon.setImageResource(R.drawable.ic_pause)
        }
    }

    private fun updateStartEndTime() {
        val startTimeTextView = binding!!.startTime
        val endTimeTextView = binding!!.endTime

        startTimeTextView.text = formatTime(mediaPlayer?.currentPosition ?: 0)
        endTimeTextView.text = formatTime(
            mediaPlayer?.duration?.minus(mediaPlayer?.currentPosition!!) ?: 0
        )
        if (endTimeTextView.text == "00:00") {
            if (isRepeat) {
                mediaPlayer?.seekTo(0)
            } else {
                mediaPlayer?.seekTo(0)
                playPauseAudio()
            }
        }
    }

    private fun formatTime(milliseconds: Int): String {
        val minutes = milliseconds / 1000 / 60
        val seconds = (milliseconds / 1000) % 60
        return String.format("%02d:%02d", minutes, seconds)
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
        bottomNav?.visibility = View.VISIBLE
    }

}
