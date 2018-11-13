package com.alihn.gituser.details;

import android.support.annotation.NonNull;

import com.alihn.gituser.RxSchedulerRule;
import com.alihn.gituser.User;
import com.alihn.gituser.UserDetails;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.net.SocketTimeoutException;

import io.reactivex.Observable;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserDetailsPresenterImplTest {
    @NonNull
    @Rule
    public RxSchedulerRule rule = new RxSchedulerRule();
    @Mock
    UserDetails userDetails;
    @Mock
    User user;
    @Mock
    private UserDetailsView view;
    @Mock
    private UserDetailsInteractor userDetailsInteractor;
    private UserDetailsPresenterImpl userDetailsPresenter;

    @Before
    public void setUp() {
        userDetailsPresenter = new UserDetailsPresenterImpl(userDetailsInteractor);
        userDetailsPresenter.setView(view);
    }

    @After
    public void teardown() {
        userDetailsPresenter.destroy();
    }


    @Test
    public void shouldBeAbleToShowUsers() {
        when(user.getId()).thenReturn(12345);
        Observable<UserDetails> responseObservable = Observable.just(userDetails);
        when(userDetailsInteractor.getUserDetails(user.getId())).thenReturn(responseObservable);

        userDetailsPresenter.userDetails(user);

        verify(view).showDetails(userDetails);
    }

    @Test
    public void shouldFailSilentlyWhenNoUsers() {
        when(user.getId()).thenReturn(12345);
        when(userDetailsInteractor.getUserDetails(user.getId())).thenReturn(Observable.error(new SocketTimeoutException()));

        userDetailsPresenter.userDetails(user);

        verifyZeroInteractions(view);
    }


}
