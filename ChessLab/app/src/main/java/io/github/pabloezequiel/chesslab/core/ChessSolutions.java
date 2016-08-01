package io.github.pabloezequiel.chesslab.core;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pablo Ezequiel on 15/6/16.
 * <p/>
 * ProbarNoCuestaNada.com
 * <p/>
 * https://github.com/PabloEzequiel
 * https://javaen.blogspot.com
 */
public class ChessSolutions {

    public static String TAG = ChessSolutions.class.getSimpleName();


    private static Map<String, String> chessProblems_utf8;

    private ChessSolutions() {}

    /**
     * @return getInstance()
     */
    public static Map getInstance() {

        if( chessProblems_utf8 == null ) {

             chessProblems_utf8 = new HashMap<String, String>();

            init();
        }


        return chessProblems_utf8;
    }

    private static void init() {

        initUTF8();

    }

    private static void initUTF8() {

        Log.d(TAG, "initUTF8(): ");

        /*
                Black
                ♜	♞	♝	♛	♚	♝	♞	♜
                ♟	♟	♟	♟	♟	♟	♟	♟

                ♙	♙	♙	♙	♙	♙	♙	♙
                ♖	♘	♗	♕	♔	♗	♘	♖
                white
        */

        chessProblems_utf8.put("chess_mate1_00000","1. ♖g8#        ");
        chessProblems_utf8.put("chess_mate1_00001","1. ♘d7#        ");
        chessProblems_utf8.put("chess_mate1_00002","1. dxe8=♘#     ");
        chessProblems_utf8.put("chess_mate1_00003","1. fxg8=♘#     ");
        chessProblems_utf8.put("chess_mate1_00004","1. f8=♕#       ");
        chessProblems_utf8.put("chess_mate1_00005","1. ♘g6#        ");
        chessProblems_utf8.put("chess_mate1_00006","1. ♘d6#        ");
        chessProblems_utf8.put("chess_mate1_00007","1. ♖d8#        ");
        chessProblems_utf8.put("chess_mate1_00008","1. f3#         ");

        chessProblems_utf8.put("chess_mate2_00000","1. ♕b8+ ♞xb8 2. ♖f8#        ");
        chessProblems_utf8.put("chess_mate2_00001","1. ♕xa7+ ♚xa7 2. ♖a3#        ");
        chessProblems_utf8.put("chess_mate2_00002","1. ♖xc6+ bxc6 2. ♗a6#        ");
        chessProblems_utf8.put("chess_mate2_00003","1. ♕xc6+ bxc6 2. ♗a6#        ");
        chessProblems_utf8.put("chess_mate2_00004","1. ♘b5+ cxb5 2. ♘b7#        ");
        chessProblems_utf8.put("chess_mate2_00005","1. ♕f6 ♛xf6 2. ♖xe8#        ");
        chessProblems_utf8.put("chess_mate2_00006","1. ♕xf7+ ♚xf7 2. ♗xe6#        ");
        chessProblems_utf8.put("chess_mate2_00007","1. ♕f6 exf6 2. ♖xe8#        ");
        chessProblems_utf8.put("chess_mate2_00008","1. ♕xf8+ ♛xf8 2. ♖xh7#        ");
        chessProblems_utf8.put("chess_mate2_00009","1. ♕g7+ ♞xg7 2. ♘h6#        ");
        chessProblems_utf8.put("chess_mate2_00010","1. ♕e6+ ♞xe6 2. ♘h6#        ");
        chessProblems_utf8.put("chess_mate2_00011","1. ♕h6+ ♚xh6 2. ♗f8#        ");

        chessProblems_utf8.put("chess_mate3_00000","1. ♕g6 fxg6 2. ♖xg7+ ♚f8 3. ♘xg6#        ");
        chessProblems_utf8.put("chess_mate3_00001","1. ♕d8+ ♚xd8 2. ♘c6+ ♚e8 3. ♖d8#        ");
        chessProblems_utf8.put("chess_mate3_00002","1. ♖g6+ fxg6 2. ♕h8+ ♚xh8 3. ♖xf8#        ");
        chessProblems_utf8.put("chess_mate3_00003","1. ♘e7+ ♚h8 2. ♖xh7+ ♚xh7 3. ♖h1#        ");
        chessProblems_utf8.put("chess_mate3_00004","1. ♕h6+ ♝xh6 2. ♘g5+ ♚h8 3. ♖h7#        ");
        chessProblems_utf8.put("chess_mate3_00005","1. ♖h8+ ♝xh8 2. ♕h7+ ♚f8 3. ♕xh8#        ");
        chessProblems_utf8.put("chess_mate3_00006","1. ♘f6+ ♝xf6 2. ♕xg6+ ♝g7 3. ♕h7#        ");
        chessProblems_utf8.put("chess_mate3_00007","1. ♕d8+ ♚xd8 2. ♗g5+ ♚e8 3. ♖d8#        ");
        chessProblems_utf8.put("chess_mate3_00008","1. ♕xh4+ ♚xh4 2. ♖h7+ ♚g5 3. h4#        ");
        chessProblems_utf8.put("chess_mate3_00009","1. ♘xh7+ ♜xh7 2. ♕h6+ ♜xh6 3. ♗xh6#        ");
        chessProblems_utf8.put("chess_mate3_00010","1. ♕xd4 ♞xd4 2. ♘f6+ ♚f8 3. ♗h6#        ");
        chessProblems_utf8.put("chess_mate3_00011","1. ♕h6 ♛xe5 2. ♕xh7+ ♚xh7 3. ♚g2#        ");
        chessProblems_utf8.put("chess_mate3_00012","1. ♘c7+ ♛xc7 2. ♕xf7+ ♝xf7 3. ♗xf7#        ");
        chessProblems_utf8.put("chess_mate3_00013","1. ♕g7+ ♜xg7 2. hxg7+ ♚g8 3. ♖h8#        ");
        chessProblems_utf8.put("chess_mate3_00014","1. ♕xh7+ ♞xh7 2. ♗xh7+ ♚f8 3. ♘g6#        ");
        chessProblems_utf8.put("chess_mate3_00015","1. ♗xb7+ ♚xb7 2. ♕xb5+ ♚c8 3. ♕c6#        ");
        chessProblems_utf8.put("chess_mate3_00016","1. ♖h7+ ♚xh7 2. ♕h2+ ♚g7 3. ♕h6#        ");

        chessProblems_utf8.put("chess_mate4_00000","1. g4+ fxg4+ 2. ♘xg4+ g5 3. ♕e8+ ♛g6 4. ♘f6#        ");
        chessProblems_utf8.put("chess_mate4_00001","1. ♕xh7+ ♚xh7 2. ♖h3+ ♝xh3 3. ♖xh3+ ♚g6 4. ♖h6#     ");
        chessProblems_utf8.put("chess_mate4_00002","1. ♕xe5+ ♞xe5 2. ♗f6+ ♚h6 3. ♗g7+ ♚h5 4. ♖h6#       ");
        chessProblems_utf8.put("chess_mate4_00003","1. ♕d6+ ♚e8 2. ♗d7+ ♚d8 3. ♗xb5+ ♚c8 4. ♗a6#        ");
        chessProblems_utf8.put("chess_mate4_00004","1. ♘g6+ ♚h7 2. ♘f8+ ♚h8 3. ♕h7+ ♜xh7 4. ♘g6#        ");
        chessProblems_utf8.put("chess_mate4_00005","1. ♖xh7+ ♚xh7 2. ♘f8+ ♚g7 3. ♕h7+ ♚xf8 4. ♕f7#      ");
        chessProblems_utf8.put("chess_mate4_00006","1. ♖h7+ ♚xh7 2. ♕e7+ ♜f7 3. ♕xf7+ ♚h6 4. ♕g7#       ");
        chessProblems_utf8.put("chess_mate4_00007","1. ♖xc5+ ♚b6 2. ♕c7+ ♚a7 3. ♖xa5+ Qa6 4. ♗d4#       ");
        chessProblems_utf8.put("chess_mate4_00008","1. ♗h5+ ♞g6 2. ♖xh7 ♜g1+ 3. ♔xg1 ♝xe2 4. ♗xg6#      ");
        chessProblems_utf8.put("chess_mate4_00009","1. ♖f8+ ♞xf8 2. ♕xf8+ ♚e5 3. f4+ ♝xf4 4. gxf4#      ");
        chessProblems_utf8.put("chess_mate4_00010","1. ♘e7+ ♚h8 2. ♘xg6+ Qxg6 3. ♕xf8+ Qg8 4. ♕xg8#     ");
        chessProblems_utf8.put("chess_mate4_00011","1. ♗xh7+ ♚h8 2. ♗g8+ Qh6 3. ♖xh6+ ♝xh6 4. ♕h7#      ");
        chessProblems_utf8.put("chess_mate4_00012","1. ♗f8+ ♜xf8 2. ♖d3 ♝e1 3. ♖h3+ ♝h4 4. ♖xh4#        ");
        chessProblems_utf8.put("chess_mate4_00013","1. ♘g5 ♝xf2+ 2. ♔h1 ♜xa8 3. ♕h7+ ♚f8 4. ♕h8#        ");
        chessProblems_utf8.put("chess_mate4_00014","1. ♖xb8+ ♚a7 2. ♕d4+ ♚xb8 3. ♖e8+ ♚c7 4. ♕d8#       ");
        chessProblems_utf8.put("chess_mate4_00015","1. ♗g5+ ♜f6 2. ♗xf6+ gxf6 3. ♕g7+ ♚e8 4. ♕f7#       ");

        chessProblems_utf8.put("chess_train_001_00000","1. ♖h1#      ");
        chessProblems_utf8.put("chess_train_001_00001","1. ♗a6#      ");
        chessProblems_utf8.put("chess_train_001_00002","1. ♖h1#      ");
        chessProblems_utf8.put("chess_train_001_00003","1. ♖d8#      ");
        chessProblems_utf8.put("chess_train_001_00004","1. ♖g1#      ");
        chessProblems_utf8.put("chess_train_001_00005","1. ♗xh7#     ");
        chessProblems_utf8.put("chess_train_001_00006","1. ♕xf7#     ");
        chessProblems_utf8.put("chess_train_001_00007","1. ♕xh7#     ");
        chessProblems_utf8.put("chess_train_001_00008","1. ♕h5#      ");
        chessProblems_utf8.put("chess_train_001_00009","1. ♖d8#      ");
        chessProblems_utf8.put("chess_train_001_00010","1. ♖e8#      ");
        chessProblems_utf8.put("chess_train_001_00011","1. ♘g6#      ");
        chessProblems_utf8.put("chess_train_001_00012","1. fxg8=♘#   ");
        chessProblems_utf8.put("chess_train_001_00013","1. ♗a6#      ");
        chessProblems_utf8.put("chess_train_001_00014","1. f8=♕#     ");
        chessProblems_utf8.put("chess_train_001_00015","1. ♕c6#      ");
        chessProblems_utf8.put("chess_train_001_00016","1. dxe8=♘#   ");
        chessProblems_utf8.put("chess_train_001_00017","1. ♘d7#      ");

        chessProblems_utf8.put("chess_train_002_00000","1 ... ♞f3#   ");
        chessProblems_utf8.put("chess_train_002_00001","1 ... ♛xc2#   ");
        chessProblems_utf8.put("chess_train_002_00002","1 ... ♝h3+ 2. ♔xh3 ♛f1#   ");
        chessProblems_utf8.put("chess_train_002_00003","1 ... ♞f4+ 2. ♘xf4 ♛h1#   ");
        chessProblems_utf8.put("chess_train_002_00004","1 ... ♜xh3+ 2. gxh3 ♛h2#   ");
        chessProblems_utf8.put("chess_train_002_00005","1 ... ♛xh3+ 2. ♔xh3 ♜h1#   ");
        chessProblems_utf8.put("chess_train_002_00006","1 ... ♛xe4+ 2. ♕xe4 ♜6f2#   ");
        chessProblems_utf8.put("chess_train_002_00007","1 ... ♛g1+ 2. ♔xg1 ♜e1#   ");
        chessProblems_utf8.put("chess_train_002_00008","1 ... ♛g2+ 2. ♔xg2 ♜xg3#   ");
        chessProblems_utf8.put("chess_train_002_00009","1 ... ♜xe2 2. ♕xe2 ♛c3#   ");
        chessProblems_utf8.put("chess_train_002_00010","1 ... ♜a4+ 2. ♗xa4 b4#   ");
        chessProblems_utf8.put("chess_train_002_00011","1 ... ♛g1+ 2. ♖xg1 ♞f2#   ");
        chessProblems_utf8.put("chess_train_002_00012","1 ... ♛h3 2. gxh3 ♞xh3#   ");
        chessProblems_utf8.put("chess_train_002_00013","1 ... ♛f3+ 2. ♘xf3 exf3+ 3. ♔f1 ♜d1#   ");
        chessProblems_utf8.put("chess_train_002_00014","1 ... ♛f1+ 2. ♗g1 ♛f3+ 3. ♗xf3 ♝xf3#   ");
        chessProblems_utf8.put("chess_train_002_00015","1 ... ♝xg5+ 2. ♔xg5 f6+ 3. ♔g6 ♛g4#   ");
        chessProblems_utf8.put("chess_train_002_00016","1 ... ♛g2+ 2. ♕xg2 ♜xe1+ 3. ♕f1 ♜xf1#   ");
        chessProblems_utf8.put("chess_train_002_00017","1 ... ♜c1+ 2. ♔xc1 ♜e1+ 3. ♘xe1 ♛xe1#   ");

    }




    public static String getSolution(String chessProblem) {

        Log.d(TAG, "getSolution("+chessProblem+"): ");

        String solution = (String) ChessSolutions.getInstance().get(chessProblem);

        Log.d(TAG, "solution("+chessProblem+"): " + solution);

        return solution;
    }



}




