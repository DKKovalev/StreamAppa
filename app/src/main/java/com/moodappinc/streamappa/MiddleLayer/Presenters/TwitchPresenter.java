package com.moodappinc.streamappa.MiddleLayer.Presenters;

import com.moodappinc.streamappa.TwitchView;

/**
 * Created by d.kovalev on 08.06.2016.
 */
public class TwitchPresenter extends AbstractPresenter<TwitchView> {

    public void showLoadingDialog() {
        if (isViewAttached()) {
            TwitchView twitchView = getView();
            if (twitchView != null) {
                twitchView.showLoadingDialog();
            }
        }
    }

    public void showCurrentTopFragment() {

        if (isViewAttached()) {
            TwitchView twitchView = getView();
            if (twitchView != null) {
                twitchView.showCurrentTopFragment();
            }
        }
    }

    public void showTopStreamsByGame() {
        if (isViewAttached()) {
            TwitchView twitchView = getView();
            if (twitchView != null) {
                twitchView.showTopStreamsByGameFragment();
            }
        }
    }

    public void showStreamFragment() {
        if (isViewAttached()) {
            TwitchView twitchView = getView();
            if (twitchView != null) {
                twitchView.showStreamFragment();
            }
        }
    }
}

