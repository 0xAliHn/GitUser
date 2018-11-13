package com.alihn.gituser.listing;

import android.support.annotation.NonNull;

import com.alihn.gituser.RxSchedulerRule;
import com.alihn.gituser.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class UserListingPresenterImplTest {
    @NonNull
    @Rule
    public RxSchedulerRule rule = new RxSchedulerRule();


    @Mock
    private UserListingInteractor interactor;
    @Mock
    private UserListingView view;

    @NonNull
    private List<User> users = new ArrayList<>(0);

    private UserListingPresenterImpl presenter;

    @Before
    public void setUp() {
        presenter = new UserListingPresenterImpl(interactor);
    }

    @After
    public void teardown() {
        presenter.destroy();
    }

    @Test
    public void shouldBeAbleToDisplayUsers() {
        // given:
        Observable<List<User>> responseObservable = Observable.just(users);
        when(interactor.getUserList(anyInt())).thenReturn(responseObservable);

        // when:
        presenter.setView(view);

        // then:
        verify(view).showUsers(users);
    }

}
