// Generated by view binder compiler. Do not edit!
package com.example.app_comedor_unmsm.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.app_comedor_unmsm.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHomeBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button MostrarTicketBoton;

  @NonNull
  public final Button ReservarTicketBoton;

  @NonNull
  public final TextView dishText;

  @NonNull
  public final ConstraintLayout homeFragment;

  @NonNull
  public final ImageView imagePlato;

  @NonNull
  public final ImageView imageUser;

  @NonNull
  public final CardView imgHolder;

  @NonNull
  public final ConstraintLayout layoutContent1;

  @NonNull
  public final ConstraintLayout layoutContent2;

  @NonNull
  public final ConstraintLayout layoutSaludo;

  @NonNull
  public final TextView menuText;

  @NonNull
  public final TextView shift1;

  @NonNull
  public final TextView shift2;

  @NonNull
  public final TextView shift3;

  @NonNull
  public final TextView shiftText;

  @NonNull
  public final TextView textHello;

  @NonNull
  public final TextView textUsername;

  @NonNull
  public final TextView texto;

  private FragmentHomeBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button MostrarTicketBoton, @NonNull Button ReservarTicketBoton,
      @NonNull TextView dishText, @NonNull ConstraintLayout homeFragment,
      @NonNull ImageView imagePlato, @NonNull ImageView imageUser, @NonNull CardView imgHolder,
      @NonNull ConstraintLayout layoutContent1, @NonNull ConstraintLayout layoutContent2,
      @NonNull ConstraintLayout layoutSaludo, @NonNull TextView menuText, @NonNull TextView shift1,
      @NonNull TextView shift2, @NonNull TextView shift3, @NonNull TextView shiftText,
      @NonNull TextView textHello, @NonNull TextView textUsername, @NonNull TextView texto) {
    this.rootView = rootView;
    this.MostrarTicketBoton = MostrarTicketBoton;
    this.ReservarTicketBoton = ReservarTicketBoton;
    this.dishText = dishText;
    this.homeFragment = homeFragment;
    this.imagePlato = imagePlato;
    this.imageUser = imageUser;
    this.imgHolder = imgHolder;
    this.layoutContent1 = layoutContent1;
    this.layoutContent2 = layoutContent2;
    this.layoutSaludo = layoutSaludo;
    this.menuText = menuText;
    this.shift1 = shift1;
    this.shift2 = shift2;
    this.shift3 = shift3;
    this.shiftText = shiftText;
    this.textHello = textHello;
    this.textUsername = textUsername;
    this.texto = texto;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.MostrarTicketBoton;
      Button MostrarTicketBoton = ViewBindings.findChildViewById(rootView, id);
      if (MostrarTicketBoton == null) {
        break missingId;
      }

      id = R.id.ReservarTicketBoton;
      Button ReservarTicketBoton = ViewBindings.findChildViewById(rootView, id);
      if (ReservarTicketBoton == null) {
        break missingId;
      }

      id = R.id.dishText;
      TextView dishText = ViewBindings.findChildViewById(rootView, id);
      if (dishText == null) {
        break missingId;
      }

      ConstraintLayout homeFragment = (ConstraintLayout) rootView;

      id = R.id.imagePlato;
      ImageView imagePlato = ViewBindings.findChildViewById(rootView, id);
      if (imagePlato == null) {
        break missingId;
      }

      id = R.id.imageUser;
      ImageView imageUser = ViewBindings.findChildViewById(rootView, id);
      if (imageUser == null) {
        break missingId;
      }

      id = R.id.imgHolder;
      CardView imgHolder = ViewBindings.findChildViewById(rootView, id);
      if (imgHolder == null) {
        break missingId;
      }

      id = R.id.layoutContent1;
      ConstraintLayout layoutContent1 = ViewBindings.findChildViewById(rootView, id);
      if (layoutContent1 == null) {
        break missingId;
      }

      id = R.id.layoutContent2;
      ConstraintLayout layoutContent2 = ViewBindings.findChildViewById(rootView, id);
      if (layoutContent2 == null) {
        break missingId;
      }

      id = R.id.layoutSaludo;
      ConstraintLayout layoutSaludo = ViewBindings.findChildViewById(rootView, id);
      if (layoutSaludo == null) {
        break missingId;
      }

      id = R.id.menuText;
      TextView menuText = ViewBindings.findChildViewById(rootView, id);
      if (menuText == null) {
        break missingId;
      }

      id = R.id.shift1;
      TextView shift1 = ViewBindings.findChildViewById(rootView, id);
      if (shift1 == null) {
        break missingId;
      }

      id = R.id.shift2;
      TextView shift2 = ViewBindings.findChildViewById(rootView, id);
      if (shift2 == null) {
        break missingId;
      }

      id = R.id.shift3;
      TextView shift3 = ViewBindings.findChildViewById(rootView, id);
      if (shift3 == null) {
        break missingId;
      }

      id = R.id.shiftText;
      TextView shiftText = ViewBindings.findChildViewById(rootView, id);
      if (shiftText == null) {
        break missingId;
      }

      id = R.id.textHello;
      TextView textHello = ViewBindings.findChildViewById(rootView, id);
      if (textHello == null) {
        break missingId;
      }

      id = R.id.textUsername;
      TextView textUsername = ViewBindings.findChildViewById(rootView, id);
      if (textUsername == null) {
        break missingId;
      }

      id = R.id.texto;
      TextView texto = ViewBindings.findChildViewById(rootView, id);
      if (texto == null) {
        break missingId;
      }

      return new FragmentHomeBinding((ConstraintLayout) rootView, MostrarTicketBoton,
          ReservarTicketBoton, dishText, homeFragment, imagePlato, imageUser, imgHolder,
          layoutContent1, layoutContent2, layoutSaludo, menuText, shift1, shift2, shift3, shiftText,
          textHello, textUsername, texto);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
