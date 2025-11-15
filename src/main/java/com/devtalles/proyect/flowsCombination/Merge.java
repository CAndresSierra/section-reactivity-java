package com.devtalles.proyect.flowsCombination;


import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Merge {
    public static void main(String[] args) throws InterruptedException {
//        Observable<String> students = Observable.just("Camilo", "Ana", "Juana", "Fernando")
//                .delay(1, TimeUnit.SECONDS);
//
//        Observable<String> teachers = Observable.just("Prof. Carlos", "Prof. Ana", "Prof. Juana", "Prof. Fernando");
//
//        Observable.merge(students, teachers).subscribe(System.out::println);
//
//        Thread.sleep(2000);

        Observable<String> students = Observable.just("Camilo", "Ana", "Juana", "Fernando")
                .delay(1, TimeUnit.SECONDS);

        Observable<String> teachers = Observable.just("Prof. Carlos", "Prof. Ana", "Prof. Juana", "Prof. Fernando");

        Observable.concat(students, teachers).subscribe(System.out::println);

        Thread.sleep(2000);
    }
}
