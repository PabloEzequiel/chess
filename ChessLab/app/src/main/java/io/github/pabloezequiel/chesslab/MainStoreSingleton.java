package io.github.pabloezequiel.chesslab;

import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by Pablo Ezequiel on 29/7/16.
 * <p/>
 * ProbarNoCuestaNada.com
 * <p/>
 * https://github.com/PabloEzequiel
 * https://javaen.blogspot.com
 */
public class MainStoreSingleton {

    public static String TAG = MainStoreSingleton.class.getSimpleName();

    /**
     * Los objetos del MainContent
     */
    class MainContent {


        private SeekBar seekBar;
        private TextView textView;
        private  TextView  textViewLeft;
        private ImageView image;             // Chess Diagram Image
        private  ImageView buttonSolution;    // Icon Question Solution
        private  TextView  chessSolution;

        private  TextView  userSolution_lbl;     // Only for training mode
        private EditText userSolution;        // Only for training mode
        private  ImageView sendMailSolution;    // Icon Send Mail with Solutions


        private AppCompatActivity activity;

        public MainContent(AppCompatActivity activity) {
            this.activity = activity;

            seekBar        = (SeekBar)   activity.findViewById(R.id.seekBar1);
            textViewLeft   = (TextView)  activity.findViewById(R.id.seekBar1_text_left);
            textView       = (TextView)  activity.findViewById(R.id.seekBar1_text);
            image          = (ImageView) activity.findViewById(R.id.chess_board_image);
            buttonSolution = (ImageView) activity.findViewById(R.id.navigation_05_info);
            chessSolution  = (TextView)  activity.findViewById(R.id.chess_solution);



            userSolution_lbl  = (TextView)  activity.findViewById(R.id.chess_txt_mail_label);
            userSolution      = (EditText)  activity.findViewById(R.id.chess_txt_mail);
            sendMailSolution  = (ImageView) activity.findViewById(R.id.send_mail);

        }


        public AppCompatActivity getActivity() {
            return activity;
        }

        public void setActivity(AppCompatActivity activity) {
            this.activity = activity;
        }

        public SeekBar getSeekBar() {
            return seekBar;
        }

        public TextView getTextViewLeft() {
            return textViewLeft;
        }

        public TextView getTextView() {
            return textView;
        }

        public ImageView getImage() {
            return image;
        }

        public ImageView getButtonSolution() {
            return buttonSolution;
        }

        public TextView getChessSolution() {
            return chessSolution;
        }


        // Training Mode

        public TextView  getUserSolution_Label() {
            return userSolution_lbl;
        }

        public EditText  getUserSolution() {
            return userSolution;
        }

        public ImageView getSendMailSolution() {
            return sendMailSolution;
        }
    }

}
