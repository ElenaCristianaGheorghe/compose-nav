package com.example.myapplication.navigation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0007\b\t\n\u000b\fB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0006\r\u000e\u000f\u0010\u0011\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/example/myapplication/navigation/NavDestination;", "", "destination", "", "(Ljava/lang/String;)V", "getDestination", "()Ljava/lang/String;", "AddNewSub", "Home", "ManageSubscriptions", "SubDetails", "SubscriptionOptions", "TestFragment", "Lcom/example/myapplication/navigation/NavDestination$AddNewSub;", "Lcom/example/myapplication/navigation/NavDestination$Home;", "Lcom/example/myapplication/navigation/NavDestination$ManageSubscriptions;", "Lcom/example/myapplication/navigation/NavDestination$SubDetails;", "Lcom/example/myapplication/navigation/NavDestination$SubscriptionOptions;", "Lcom/example/myapplication/navigation/NavDestination$TestFragment;", "app_debug"})
public abstract class NavDestination {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String destination = null;
    
    private NavDestination(java.lang.String destination) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDestination() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/myapplication/navigation/NavDestination$Home;", "Lcom/example/myapplication/navigation/NavDestination;", "()V", "app_debug"})
    public static final class Home extends com.example.myapplication.navigation.NavDestination {
        @org.jetbrains.annotations.NotNull
        public static final com.example.myapplication.navigation.NavDestination.Home INSTANCE = null;
        
        private Home() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/myapplication/navigation/NavDestination$SubDetails;", "Lcom/example/myapplication/navigation/NavDestination;", "()V", "app_debug"})
    public static final class SubDetails extends com.example.myapplication.navigation.NavDestination {
        @org.jetbrains.annotations.NotNull
        public static final com.example.myapplication.navigation.NavDestination.SubDetails INSTANCE = null;
        
        private SubDetails() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/myapplication/navigation/NavDestination$AddNewSub;", "Lcom/example/myapplication/navigation/NavDestination;", "()V", "app_debug"})
    public static final class AddNewSub extends com.example.myapplication.navigation.NavDestination {
        @org.jetbrains.annotations.NotNull
        public static final com.example.myapplication.navigation.NavDestination.AddNewSub INSTANCE = null;
        
        private AddNewSub() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/myapplication/navigation/NavDestination$SubscriptionOptions;", "Lcom/example/myapplication/navigation/NavDestination;", "()V", "app_debug"})
    public static final class SubscriptionOptions extends com.example.myapplication.navigation.NavDestination {
        @org.jetbrains.annotations.NotNull
        public static final com.example.myapplication.navigation.NavDestination.SubscriptionOptions INSTANCE = null;
        
        private SubscriptionOptions() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/myapplication/navigation/NavDestination$ManageSubscriptions;", "Lcom/example/myapplication/navigation/NavDestination;", "()V", "app_debug"})
    public static final class ManageSubscriptions extends com.example.myapplication.navigation.NavDestination {
        @org.jetbrains.annotations.NotNull
        public static final com.example.myapplication.navigation.NavDestination.ManageSubscriptions INSTANCE = null;
        
        private ManageSubscriptions() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/myapplication/navigation/NavDestination$TestFragment;", "Lcom/example/myapplication/navigation/NavDestination;", "()V", "app_debug"})
    public static final class TestFragment extends com.example.myapplication.navigation.NavDestination {
        @org.jetbrains.annotations.NotNull
        public static final com.example.myapplication.navigation.NavDestination.TestFragment INSTANCE = null;
        
        private TestFragment() {
            super(null);
        }
    }
}