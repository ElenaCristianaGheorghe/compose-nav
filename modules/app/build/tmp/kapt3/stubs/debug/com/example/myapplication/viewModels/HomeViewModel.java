package com.example.myapplication.viewModels;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/myapplication/viewModels/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "navigator", "Lcom/example/myapplication/navigation/Navigator;", "(Lcom/example/myapplication/navigation/Navigator;)V", "navigateToAddNewUser", "", "navigateToDetails", "subId", "", "navigateToTestFragment", "app_debug"})
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.myapplication.navigation.Navigator navigator = null;
    
    @javax.inject.Inject
    public HomeViewModel(@org.jetbrains.annotations.NotNull
    com.example.myapplication.navigation.Navigator navigator) {
        super();
    }
    
    public final void navigateToDetails(long subId) {
    }
    
    public final void navigateToAddNewUser() {
    }
    
    public final void navigateToTestFragment() {
    }
}