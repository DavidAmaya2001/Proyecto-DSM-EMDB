// Generated by view binder compiler. Do not edit!
package com.example.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.app.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityRegisterScreenBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final FloatingActionButton floatingBtn;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final TextView loginTv;

  @NonNull
  public final EditText mailRegisterTxt;

  @NonNull
  public final EditText nameRegisterTxt;

  @NonNull
  public final EditText pswdComRegisterTxt;

  @NonNull
  public final EditText pswdRegisterTxt;

  @NonNull
  public final EditText secNameRegisterTxt;

  @NonNull
  public final Button signUpBtn;

  @NonNull
  public final TextView textView;

  private ActivityRegisterScreenBinding(@NonNull ConstraintLayout rootView,
      @NonNull FloatingActionButton floatingBtn, @NonNull ImageView imageView,
      @NonNull TextView loginTv, @NonNull EditText mailRegisterTxt,
      @NonNull EditText nameRegisterTxt, @NonNull EditText pswdComRegisterTxt,
      @NonNull EditText pswdRegisterTxt, @NonNull EditText secNameRegisterTxt,
      @NonNull Button signUpBtn, @NonNull TextView textView) {
    this.rootView = rootView;
    this.floatingBtn = floatingBtn;
    this.imageView = imageView;
    this.loginTv = loginTv;
    this.mailRegisterTxt = mailRegisterTxt;
    this.nameRegisterTxt = nameRegisterTxt;
    this.pswdComRegisterTxt = pswdComRegisterTxt;
    this.pswdRegisterTxt = pswdRegisterTxt;
    this.secNameRegisterTxt = secNameRegisterTxt;
    this.signUpBtn = signUpBtn;
    this.textView = textView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityRegisterScreenBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityRegisterScreenBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_register_screen, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityRegisterScreenBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.floatingBtn;
      FloatingActionButton floatingBtn = ViewBindings.findChildViewById(rootView, id);
      if (floatingBtn == null) {
        break missingId;
      }

      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.loginTv;
      TextView loginTv = ViewBindings.findChildViewById(rootView, id);
      if (loginTv == null) {
        break missingId;
      }

      id = R.id.mailRegisterTxt;
      EditText mailRegisterTxt = ViewBindings.findChildViewById(rootView, id);
      if (mailRegisterTxt == null) {
        break missingId;
      }

      id = R.id.nameRegisterTxt;
      EditText nameRegisterTxt = ViewBindings.findChildViewById(rootView, id);
      if (nameRegisterTxt == null) {
        break missingId;
      }

      id = R.id.pswdComRegisterTxt;
      EditText pswdComRegisterTxt = ViewBindings.findChildViewById(rootView, id);
      if (pswdComRegisterTxt == null) {
        break missingId;
      }

      id = R.id.pswdRegisterTxt;
      EditText pswdRegisterTxt = ViewBindings.findChildViewById(rootView, id);
      if (pswdRegisterTxt == null) {
        break missingId;
      }

      id = R.id.secNameRegisterTxt;
      EditText secNameRegisterTxt = ViewBindings.findChildViewById(rootView, id);
      if (secNameRegisterTxt == null) {
        break missingId;
      }

      id = R.id.signUpBtn;
      Button signUpBtn = ViewBindings.findChildViewById(rootView, id);
      if (signUpBtn == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      return new ActivityRegisterScreenBinding((ConstraintLayout) rootView, floatingBtn, imageView,
          loginTv, mailRegisterTxt, nameRegisterTxt, pswdComRegisterTxt, pswdRegisterTxt,
          secNameRegisterTxt, signUpBtn, textView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
