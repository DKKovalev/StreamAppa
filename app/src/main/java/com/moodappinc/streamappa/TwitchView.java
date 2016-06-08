package com.moodappinc.streamappa;

/**
 * Created by d.kovalev on 08.06.2016.
 */
public interface TwitchView {
    void showLoadingDialog();

    void showCurrentTopFragment();

    void showTopStreamsByGameFragment();

    void showStreamFragment();
}
