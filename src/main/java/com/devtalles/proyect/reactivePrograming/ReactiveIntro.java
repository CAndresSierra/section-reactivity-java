package com.devtalles.proyect.reactivePrograming;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;

import java.util.Scanner;

public class ReactiveIntro {
    public static void main(String[] args) {

//        //First Example
//        Observable<String> courseStream = Observable.just("HTML", "CSS", "JAVA", "C#");
//
//        courseStream.subscribe(
//                (item) -> System.out.println("Recibido: " + item),
//                (error) -> System.out.println(error.getMessage()),
//                () -> System.out.println("Finalizado")
//        );

        ObservableOnSubscribe subscribe = (emitter) -> {
            Scanner sc = new Scanner(System.in);
            String name;
            while(true){
                System.out.println("Ingrese un nombre o salir");
                name = sc.nextLine();
                if(name.equalsIgnoreCase("salir")){
                    emitter.onComplete();
                    break;
                }
                emitter.onNext(name);
            }
        };

        Observable<String> names = Observable.create(subscribe);

        names.subscribe(
                item -> System.out.println("Name: " + item),
                (error) -> System.out.println(error.getMessage()),
                () -> System.out.println("Finalizando...")
        );


    }
}
