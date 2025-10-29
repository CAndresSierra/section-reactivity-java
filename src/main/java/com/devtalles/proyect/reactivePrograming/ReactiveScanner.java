package com.devtalles.proyect.reactivePrograming;

import io.reactivex.rxjava3.subjects.PublishSubject;

import java.util.Scanner;

public class ReactiveScanner {
    public static void main(String[] args) {
        PublishSubject<String> inputStream = PublishSubject.create();

        inputStream.subscribe(
                item -> System.out.println("Recibido: " + item.toUpperCase()),
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Finalizando...")
        );

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese cualquier palabra o 'salir' para finalizar la ejecucion");

        while(true){
            String input = sc.nextLine();
            if(input.equalsIgnoreCase("salir")){
                inputStream.onComplete();
                break;
            }

            inputStream.onNext(input);
        }

        sc.close();
    }
}
