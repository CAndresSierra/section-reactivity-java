package com.devtalles.proyect.observer;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.Arrays;
import java.util.Objects;

public class ObserverExample01 {
    public static void main(String[] args) {
        Observable<String> courseStream = Observable.fromIterable(Arrays.asList("HTML", "CSS", null, "C#", "C").stream().filter(Objects::nonNull).toList());

        Observer<String> observer = new Observer<>() {
            private Disposable disposable;

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                this.disposable = d;
                System.out.println("Estoy suscrito");
            }

            @Override
            public void onNext(@NonNull String s) {
                if(s.equalsIgnoreCase("c")){
                    disposable.dispose();
                } else{
                    System.out.println("Recibi: " + s);
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("Error: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Fin de la aplication");
            }
        };

        courseStream.subscribe(observer);

    }
}
