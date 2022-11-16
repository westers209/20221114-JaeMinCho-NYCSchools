package com.example.a20221114_jaemincho_nycschools.di.modules;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.a20221114_jaemincho_nycschools.model.Repository;
import com.example.a20221114_jaemincho_nycschools.viewmodel.SchoolsViewModel;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@Module
@InstallIn(ActivityComponent.class)
public class SchoolsVMProvider{

   @Provides
   public ViewModelProvider.Factory providesViewModel(Repository repository){
      return new ViewModelProvider.Factory() {
         @NonNull
         @Override
         public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new SchoolsViewModel(repository);
         }
      };
   }
}
