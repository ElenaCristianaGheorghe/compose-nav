// Generated by data binding compiler. Do not edit!
package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentContainerView;
import com.example.myapplication.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class TestFragmentContainerBinding extends ViewDataBinding {
  @NonNull
  public final FragmentContainerView testFragmentContainerView;

  protected TestFragmentContainerBinding(Object _bindingComponent, View _root, int _localFieldCount,
      FragmentContainerView testFragmentContainerView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.testFragmentContainerView = testFragmentContainerView;
  }

  @NonNull
  public static TestFragmentContainerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.test_fragment_container, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static TestFragmentContainerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<TestFragmentContainerBinding>inflateInternal(inflater, R.layout.test_fragment_container, root, attachToRoot, component);
  }

  @NonNull
  public static TestFragmentContainerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.test_fragment_container, null, false, component)
   */
  @NonNull
  @Deprecated
  public static TestFragmentContainerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<TestFragmentContainerBinding>inflateInternal(inflater, R.layout.test_fragment_container, null, false, component);
  }

  public static TestFragmentContainerBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static TestFragmentContainerBinding bind(@NonNull View view, @Nullable Object component) {
    return (TestFragmentContainerBinding)bind(component, view, R.layout.test_fragment_container);
  }
}
