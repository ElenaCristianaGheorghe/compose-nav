package com.example.myapplication.viewModels;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bJ\u0016\u0010\u0018\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000bJ\u0016\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00062\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\f\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u001b"}, d2 = {"Lcom/example/myapplication/viewModels/SubViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/myapplication/data/SubRepository;", "(Lcom/example/myapplication/data/SubRepository;)V", "subsNumberStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "", "getSubsNumberStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "getLatestDetailsBySubId", "", "subId", "(J)Ljava/lang/Long;", "getSubById", "Lcom/example/myapplication/data/SubscriptionEntity;", "id", "getSubs", "", "insertSub", "", "subName", "", "subValidity", "insertSubDetails", "loadLatestDetailsBySubId", "loadPurchasedSubsBySubId", "app_debug"})
public final class SubViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.myapplication.data.SubRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> subsNumberStateFlow = null;
    
    @javax.inject.Inject
    public SubViewModel(@org.jetbrains.annotations.NotNull
    com.example.myapplication.data.SubRepository repository) {
        super();
    }
    
    public final void insertSub(@org.jetbrains.annotations.NotNull
    java.lang.String subName, long subValidity) {
    }
    
    public final void insertSubDetails(long subId, long subValidity) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.myapplication.data.SubscriptionEntity> getSubs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.myapplication.data.SubscriptionEntity getSubById(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Long getLatestDetailsBySubId(long subId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getSubsNumberStateFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> loadPurchasedSubsBySubId(long subId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Long> loadLatestDetailsBySubId(long subId) {
        return null;
    }
}